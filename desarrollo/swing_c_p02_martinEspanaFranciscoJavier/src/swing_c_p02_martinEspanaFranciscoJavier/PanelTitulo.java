/**
 * 	PanelTitulo.java
 *	15 nov 2023 13:39:10
 *	@author Francisco Javier Martin España
 */
package swing_c_p02_martinEspanaFranciscoJavier;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Esta clase  muestra el titulo de la empresa con una imagen.
 */

public class PanelTitulo extends JPanel {

	/** La ventana */
	VentanaAlta ventana;

	/**
	 * Constructor panel titulo.
	 * Cargamos el titulo y lo colocamos.
	 */
	public PanelTitulo() {
		Toolkit	pantalla = Toolkit.getDefaultToolkit();
	ImageIcon icono = new ImageIcon(getClass().getResource("/recursos/imagen_titulo.png"));

		// Redimensionamos el icono,cogemos el ancho de la ventana

	int ancho = (int)(pantalla.getScreenSize().getWidth());
	Image imagenEscalada = icono.getImage().getScaledInstance(icono.getIconWidth(), 65, Image.SCALE_SMOOTH);
	icono = new ImageIcon(imagenEscalada);

		// Creamos el titulo del nombre de la empresa
		JLabel titulo = new JLabel(icono);

		// Añadimos el titulo al panel
		this.add(titulo);

		// Damos un borde con un color
		this.setBorder(BorderFactory.createLineBorder(Color.decode("#1F3C88"), 5));

		// Visible a true
		this.setVisible(true);
	}
}
