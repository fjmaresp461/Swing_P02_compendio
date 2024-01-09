/**
 * 	PanelDatos.java
 *	15 nov 2023 13:40:30
 *	@author Francisco Javier Martin España
 */
package swing_c_p02_martinEspanaFranciscoJavier;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

/**
 * Mostrara los datos introducidos de los demas paneles .
 */
public class PanelDatos extends JPanel {

	/** El texto arrendador. */
	JTextArea textoArrendador;

	/** El texto inmueble. */
	JTextArea textoInmueble;

	/** El titulo arrendador. */
	JLabel tituloArrendador;

	/** El titulo inmueble. */
	JLabel tituloInmueble;

	/** El titulo imagenes. */
	JLabel tituloImagenes;

	/** El panel imagenes. */
	JPanel panelImagenes;

	/**
	 * Constructor Panel Datos donde recibimos los datos desde ventana alta y los
	 * colocaremos en differentes pestañas.
	 */
	private static JPanel contenedorImagenes;

	public PanelDatos() {
		this.setLayout(new BorderLayout());
		JTabbedPane tabbedPane = new JTabbedPane();

		// Panel Arrendador, le damos formato
		JPanel panelArrendador = new JPanel(new BorderLayout());

		tituloArrendador = new JLabel("   Datos del Arrendador   ");
		tituloArrendador.setFont(new Font("Arial", 0, 24));
		tituloArrendador.setForeground(Color.decode("#EE6F57"));
		panelArrendador.add(tituloArrendador, BorderLayout.NORTH);

		// Text area donde copiaremos los datos del arrendador
		textoArrendador = new JTextArea();
		textoArrendador.setOpaque(false);
		textoArrendador.setFont(new Font("Arial", 0, 18));
		panelArrendador.setSize(200, 1);
		panelArrendador.add(textoArrendador, BorderLayout.CENTER);
		tabbedPane.addTab("Arrendador", panelArrendador);

		// Panel Inmueble, le damos titulo
		JPanel panelInmueble = new JPanel(new BorderLayout());
		tituloInmueble = new JLabel("   Datos del Inmueble   ");
		tituloInmueble.setFont(new Font("Arial", 0, 24));
		tituloInmueble.setForeground(Color.decode("#EE6F57"));
		// Añadimos al tabbed pane y le ponemos titulo

		panelInmueble.add(tituloInmueble, BorderLayout.NORTH);

		// Text area donde copiaremos los datos del inmueble
		textoInmueble = new JTextArea();
		textoInmueble.setOpaque(false);
		textoInmueble.setFont(new Font("Arial", 0, 18));
		panelInmueble.add(textoInmueble, BorderLayout.CENTER);

		// Añadimos al tabbed pane y le ponemos titulo
		tabbedPane.addTab("Inmueble", panelInmueble);

		// Panel para las imágenes
		JPanel panelImagenes = new JPanel(new BorderLayout());

		// Título para el panel de imágenes
		JLabel tituloImagenes = new JLabel("   Imágenes de la vivienda   ");
		tituloImagenes.setFont(new Font("Arial", 0, 24));
		tituloImagenes.setForeground(Color.decode("#EE6F57"));

		// Añadimos el título al panel de imágenes
		panelImagenes.add(tituloImagenes, BorderLayout.NORTH);

		// JPanel vacío que contendrá las imágenes, le damos un gridLayout
		contenedorImagenes = new JPanel(new GridLayout(3, 1));
		panelImagenes.add(contenedorImagenes, BorderLayout.CENTER);

		// Añadimos el panel de imágenes al JTabbedPane y damos un color a las letras de
		// las pestañas
		tabbedPane.addTab("Imágenes", panelImagenes);
		tabbedPane.setForeground(Color.decode("#1F3C88"));

		// Añadimos el tabbedPane al panel
		this.add(tabbedPane, BorderLayout.CENTER);

		// Visible a true
		this.setVisible(true);
	}

	/**
	 * Metodo  getContenedorImagenes, para que se pueda acceder al panel
	 * desde fuera
	 * 
	 * @return contenedorImagenes
	 */
	public static JPanel getContenedorImagenes() {

		return contenedorImagenes;
	}

}