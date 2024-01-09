/**
 * 	PanelImagenes.java
 *	16 nov 2023 17:23:35
 *	@author Francisco Javier Martin España
 */
package swing_c_p02_martinEspanaFranciscoJavier;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

/**
 * Esta clase permite seleccionar archivos para cargarlos en el panel y mostrarlos.
 */
public class PanelImagenes extends JPanel implements ActionListener {

	/** La etiqueta del titulo. */
	JLabel labelTitulo;

	/** El boton para cargar imagenes. */
	JButton btnCargar;

	/** El boton para eliminar imagenes. */
	JButton btnEliminar;

	/** El panel para los botones. */
	JPanel panelBotones;

	/** La lista de imagenes. */
	ArrayList<JLabel> listaImagenes;

	/**
	 * Constructor panel imagenes.
	 * Cargamos las imagenes y las colocamos en el panel
	 */
	public PanelImagenes() {

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		listaImagenes = new ArrayList<JLabel>();

		// Añadimos un titulo
		labelTitulo = new JLabel("Imagenes de la vivienda");
		labelTitulo.setFont(new Font("Arial", 0, 24));
		labelTitulo.setForeground(Color.decode("#EE6F57"));

		// Creamos los dos botones y usamos un metodo creado en la clase que engloba
		// varios metodos para limpiar el boton
		btnCargar = new JButton();
		btnCargar.setToolTipText("Cargar una imagen");
		btnEliminar = new JButton();
		btnEliminar.setToolTipText("Elimina la última imagen subida");
		limpiar(btnCargar);
		limpiar(btnEliminar);

		// Asignamos iconos a los botonesy le damos un tamaño

		ImageIcon iconoCargar = new ImageIcon(new ImageIcon(getClass().getResource("/recursos/icono_cargar.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
		btnCargar.setIcon(iconoCargar);
		ImageIcon iconoEliminar = new ImageIcon(new ImageIcon(getClass().getResource("/recursos/icono_eliminar.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
		btnEliminar.setIcon(iconoEliminar);
		// Cargamos los botones en un panel y lo alineamos
		panelBotones = new JPanel();
		panelBotones.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panelBotones.add(btnCargar);
		panelBotones.add(btnEliminar);

		// Agregamos un vertical strut para darle espacio, y añadimos el titulo y los
		// botones
		this.add(Box.createVerticalStrut(30));
		this.add(labelTitulo);
		this.add(panelBotones);

		// Añadimos un borde lateral para separar el panel
		this.setBorder(new MatteBorder(0, 1, 0, 2, Color.decode("#070D59")));

		// Visible a true
		this.setVisible(true);
	}

	/**
	 * Metodo que se ejecuta cuando se realiza una acción.
	 * El boton cargar: usuario carga una imagen desde un JFileChooser.
	 * Imagen nula (no es una imagen): muestra un mensaje de error.
	 * El boton eliminar: si la lista de imagenes no esta vacia, elimina la ultima imagen.
	 *
	 * @param e el evento de acción
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		// Si la acción es del botón cargar
		if (e.getSource() == btnCargar) {

			// Creamos un selector de archivos
			JFileChooser fileChooser = new JFileChooser();

			// Establecemos la ruta por defecto
			fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir") + "../"));

			// Si el usuario selecciona un archivo
			if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				try {

					// Leemos el archivo como imagen
					Image imagen = ImageIO.read(fileChooser.getSelectedFile());

					// Si la imagen no es nula(es una imagen)
					if (imagen != null) {

						// Creamos un icono con la imagen y le damos un tamaño
						ImageIcon icono = new ImageIcon(
								imagen.getScaledInstance(280, 210, java.awt.Image.SCALE_SMOOTH));

						// Creamos una etiqueta con el icono y la añadimos al panel y a la listaImagenes
						JLabel etiquetaImagen = new JLabel(icono);
						this.add(etiquetaImagen);
						listaImagenes.add(etiquetaImagen);

						// Actualizamos el panel
						this.revalidate();
						this.repaint();
					} else {

						// Si la imagen es nula, (no es una imagen) mostramos un mensaje de error
						JOptionPane.showMessageDialog(this, "Por favor, selecciona una imágen válida.",
								"Imágen no válida", JOptionPane.WARNING_MESSAGE);
					}
				} catch (IOException ex) {

				}
			}

			// Si pulsamos eliminar y la listaimagenes esta vacia
		} else if (e.getSource() == btnEliminar && !listaImagenes.isEmpty()) {

			// Borramos la ultima imagen de la lista
			JLabel ultimaImagen = listaImagenes.remove(listaImagenes.size() - 1);
			this.remove(ultimaImagen);

			// Actualizamos el panel
			this.revalidate();
			this.repaint();
		}
	}

	/**
	 * Metodo limpiar que elimina borde y relleno y que además añade un
	 * actionlistener.
	 *
	 * @param boton el boton
	 */
	public void limpiar(JButton boton) {
		boton.setContentAreaFilled(false);
		boton.setBorderPainted(false);
		boton.addActionListener(this);
	}

	/**
	 * Obtiene la  lista imagenes.
	 *
	 * @return la lista imagenes
	 */
	public ArrayList<JLabel> getListaImagenes() {

		return this.listaImagenes;
	}
}