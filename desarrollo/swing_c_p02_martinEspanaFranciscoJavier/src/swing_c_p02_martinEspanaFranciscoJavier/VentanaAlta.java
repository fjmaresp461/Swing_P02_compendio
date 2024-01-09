/**
 * 	VentanaAlta.java
 *	15 nov 2023 13:00:33
 *	@author Francisco Javier Martin España
 */
package swing_c_p02_martinEspanaFranciscoJavier;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

/**
 *Se muestran los paneles(arrendador, inmueble, imagenes y datos).Y botones.
 */
public class VentanaAlta extends JDialog implements ActionListener {

	/** La pantalla. */
	Toolkit pantalla;

	/** La imagen. */
	Image imagen;

	/** El icono. */
	ImageIcon icono;

	/** El panel del titulo. */
	PanelTitulo panelTitulo;

	/** El panel del arrendador. */
	PanelArrendador panelArrendador;

	/** El panel del inmueble. */
	PanelInmueble panelInmueble;

	/** El panel de datos. */
	PanelDatos panelDatos;

	/** El panel de imagenes. */
	PanelImagenes panelImagenes;

	/** El boton de imprimir. */
	JButton btnImprimir;

	/** El boton de nuevo. */
	JButton btnNuevo;

	/** El boton de guardar. */
	JButton btnGuardar;

	/** El panel de botones. */
	JPanel panelBotones;

	/** El panel izquierdo. */
	JPanel panelIzquierda;

	/** El icono de imprimir. */
	ImageIcon iconoImprimir;

	/** El icono de nuevo. */
	ImageIcon iconoNuevo;

	/** El icono de guardar. */
	ImageIcon iconoGuardar;

	/** El panel central. */
	JPanel panelCentral;

	/** El progreso. */
	Progreso progreso;

	/** La barra de progreso. */
	JProgressBar progressBar;

	/**
	 * Constructor de VentanaAlta. Crea una nueva ventana con paneles para recoger
	 * los datos de los paneles. Crea botones para imprimir, limpiar y guardar los
	 * datos.
	 *
	 * @param ventana La ventana principal
	 * @param modal   el modo(true o false)
	 */

	public VentanaAlta(VentanaPrincipal ventana, boolean modal) {
		super(ventana, modal);

		// Asignamos un border layout a la ventana y un título, el tamaño de la ventana
		// lo definimos con toolkit para que ocupe toda la pantalla, en mi caso le he
		// restado el alto para que se vea la barra de tareas
		this.setLayout(new BorderLayout());
		this.setTitle("Alta de pisos");
		pantalla = Toolkit.getDefaultToolkit();
		this.setSize(pantalla.getScreenSize().width, pantalla.getScreenSize().height - 40);
		this.getContentPane().setBackground(Color.decode("#FFFFF5"));
		// Asignamos un icono a la ventana
		icono = new ImageIcon(getClass().getResource("/recursos/icono_alta.png"));
		imagen = icono.getImage();
		this.setIconImage(imagen);

		// Creamos los tres botones y usamos un metodo creado en la clase que engloba
		// varios metodos para limpiar el boton y añadimos actionlistener de paso
		btnImprimir = new JButton();
		btnImprimir.setToolTipText("Imprimir datos");
		btnNuevo = new JButton();
		btnNuevo.setToolTipText("Limpiar formulario");
		btnGuardar = new JButton();
		btnGuardar.setToolTipText("Guardar registro");
		limpiar(btnNuevo);
		limpiar(btnGuardar);
		limpiar(btnImprimir);

		// Asignamos iconos a los botones y le damos tamaño.
		ImageIcon iconoNuevo = new ImageIcon(new ImageIcon(getClass().getResource("/recursos/icono_nuevo.png"))
				.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
		btnNuevo.setIcon(iconoNuevo);

		ImageIcon iconoGuardar = new ImageIcon(new ImageIcon(getClass().getResource("/recursos/icono_guardar.png"))
				.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
		btnGuardar.setIcon(iconoGuardar);

		ImageIcon iconoImprimir = new ImageIcon(new ImageIcon(getClass().getResource("/recursos/icono_imprimir.png"))
				.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
		btnImprimir.setIcon(iconoImprimir);

		// Creamos un nuevo panel para los botones y añadimos los botones al panel
		panelBotones = new JPanel();
		panelBotones.setOpaque(false);
		panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.X_AXIS));
		panelBotones.add(btnNuevo);
		panelBotones.add(btnGuardar);
		panelBotones.add(btnImprimir);

		// Añadimos al panel izquierda el panel arrendador y el panel botones y le damos
		// un norte y sur para colocarlo como queremos

		// Añadimos los paneles
		panelArrendador = new PanelArrendador();

		panelTitulo = new PanelTitulo();
		panelInmueble = new PanelInmueble();
		panelDatos = new PanelDatos();
		panelImagenes = new PanelImagenes();

		// Creamos un panel central donde iran a la izquierda el panelInmuebles y a la
		// derecha, panelImagenes,
		panelCentral = new JPanel(new GridLayout(1, 1));
		panelCentral.add(panelInmueble);
		panelCentral.add(panelImagenes, new BoxLayout(panelImagenes, BoxLayout.Y_AXIS));

		// Instanciamos el progressBar y lo implementamos
		progreso = new Progreso(15, panelArrendador, panelInmueble, panelImagenes);

		// Inicializamos la progressBar

		progreso.inicializarProgressBar();

		JPanel panelProgressBar = new JPanel();
		panelProgressBar.setLayout(new BoxLayout(panelProgressBar, BoxLayout.Y_AXIS));
		panelProgressBar.add(Box.createVerticalGlue());
		panelProgressBar.add(progreso.getProgressBar());
		panelIzquierda = new JPanel(new BorderLayout());

		panelIzquierda.add(panelArrendador, BorderLayout.NORTH);
		panelIzquierda.add(panelProgressBar, BorderLayout.CENTER);
		panelIzquierda.add(panelBotones, BorderLayout.SOUTH);

		// Agregamos los paneles a la ventana
		this.add(panelTitulo, BorderLayout.NORTH);
		this.add(panelIzquierda, BorderLayout.WEST);
		this.add(panelCentral, BorderLayout.CENTER);
		this.add(panelDatos, BorderLayout.EAST);
		// Visible a true
		this.setVisible(true);

		// Queda antiestetico, pero necesito hacer aqui un dateformat para la salida
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
		String fechaFormateada = formatoFecha.format(panelInmueble.spinnerFechaAlta.getValue());

	}

	public VentanaAlta() {

	}

	/**
	 * Método que se ejecuta cuando se realiza una acción. El boton imprimir: Crea
	 * un objeto de la clase EnviarTexto y llama al metodo enviar. El botón nuevo:
	 * Llama al metodo resetearCampos. El botón guardar:Si los datos son correctos ,
	 * muestra un mensaje
	 * 
	 * @param e el evento
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// Si pulsamos en boton imprimir
		if (e.getSource() == btnImprimir) {

			// Creamos un objeto texto de la clase texto, pasandole los paneles como
			// parametros
			EnviarDatos datos = new EnviarDatos(panelArrendador, panelInmueble, panelDatos, panelImagenes);

			// Usamos el metodo enviar
			datos.enviar();
		}

		// Si el boton pulsado es boton nuevo, llamamos al metodo resetear campos
		if (e.getSource() == btnNuevo) {
			this.resetearCampos();
		}

		// Si pulsamos el boton guardar y esta todo ok
		if (e.getSource() == btnGuardar && (Validador.validarPanelArrendador(panelArrendador)
				&& Validador.validarPanelInmueble(panelInmueble))) {
			JOptionPane.showMessageDialog(null, "Registro guardado.", "Todo correcto", JOptionPane.INFORMATION_MESSAGE);

		}
	}

	/**
	 * Método para resetear los campos. Los textos los ponemos en blanco, los
	 * spinners y comboboxes en 0, y el checkbox en false.
	 */
	private void resetearCampos() {
		panelArrendador.txtNombre.setText("");
		panelArrendador.txtNombre.requestFocus();
		panelArrendador.txtApellidos.setText("");
		panelArrendador.txtDNI.setText("");
		panelArrendador.txtTelefono.setText("");
		panelInmueble.textFieldDireccion.setText("");
		panelInmueble.comboBoxProvincia.setSelectedIndex(0);
		panelInmueble.spinnerFechaAlta.setValue(new Date());
		panelInmueble.spinnerHuespedes.setValue(0);
		panelInmueble.spinnerDormitorios.setValue(0);
		panelInmueble.spinnerBanos.setValue(0);
		panelInmueble.spinnerCamas.setValue(0);
		panelInmueble.checkBoxNinos.setSelected(false);
		panelInmueble.spinnerEdadNinos.setValue(0);
		for (JLabel label : panelImagenes.listaImagenes) {
			label.setIcon(null);
		}

		// borramos tambien los datos de panelDatos
		panelDatos.textoArrendador.setText("");
		panelDatos.textoInmueble.setText("");
		JPanel contenedorImagenes = panelDatos.getContenedorImagenes();
		contenedorImagenes.removeAll();
		contenedorImagenes.revalidate();
		contenedorImagenes.repaint();

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
}