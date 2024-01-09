/**
 * 	PanelArrendador.java
 *	15 nov 2023 13:39:32
 *	@author Francisco Javier Martin España
 */
package swing_c_p02_martinEspanaFranciscoJavier;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.ParseException;
import javax.swing.Box;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;



/**
 * Esta clase es un panel que recoge los datos personales del arrendador.
 * 
 */
public class PanelArrendador extends JPanel {
	
	/** El campo de texto para el nombre. */
	JTextField txtNombre;
	
	/** El campo de texto para los apellidos. */
	JTextField txtApellidos;
	
	/** El campo de texto formateado para el DNI. */
	JFormattedTextField txtDNI;
	
	/** El campo de texto formateado para el teléfono. */
	JFormattedTextField txtTelefono;
	
	/** El filtro para el numero de teléfono. */
	MaskFormatter filtroTelefono;
	
	/** El filtro para el DNI. */
	MaskFormatter filtroDNI;
	
	/** Las restricciones para el gridbaglayout. */
	GridBagConstraints c;
	
	/** La etiqueta del titulo. */
	JLabel labelTitulo;

	/**
	 * Constructor panel arrendador, donde añadimos los campos y lo colocamos
	 */
	public PanelArrendador() {

		this.setLayout(new GridBagLayout());

		// creamos un constraint y usamos fill horizontal para darle un aspecto más
		// uniforme
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets= new Insets(10,0,0,0);
		

		// Creamos campos de texto nombre y apellidos
		txtNombre = new JTextField(20);
		txtApellidos = new JTextField(20);
		
		//Aplicamos los maskformatter a telefono y dni y lo añadimos a los campos de texto
		try {
			filtroTelefono = new MaskFormatter("#########");
			txtTelefono = new JFormattedTextField(filtroTelefono);
			txtTelefono.setFocusLostBehavior(JFormattedTextField.COMMIT);
			filtroDNI = new MaskFormatter("########U");
			txtDNI = new JFormattedTextField(filtroDNI);
			txtDNI.setFocusLostBehavior(JFormattedTextField.COMMIT);
		} catch (ParseException e) {

			System.out.println(e.getMessage());
		}

		// Le damos un aspecto al titulo
		labelTitulo = new JLabel("Datos del arrendador");
		labelTitulo.setFont(new Font("Arial",0, 24));
		labelTitulo.setForeground(Color.decode("#EE6F57"));

		// Añadimos los componentes, usando createverticalStrut, porque en grid no
		// funcionan los glue
		c.gridy = 0;
		this.add(Box.createVerticalStrut(10), c);
		c.gridy = 1;
		this.add(labelTitulo, c);
		c.gridy = 3;
		this.add(new JLabel("Nombre"), c);
		c.gridy = 4;
		this.add(txtNombre, c);
		c.gridy = 5;
		this.add(new JLabel("Apellidos"), c);
		c.gridy = 6;
		this.add(txtApellidos, c);
		c.gridy = 7;
		this.add(new JLabel("DNI"), c);
		c.gridy = 8;
		this.add(txtDNI, c);
		c.gridy = 9;
		this.add(new JLabel("Teléfono"), c);
		c.gridy = 10;
		this.add(txtTelefono, c);
		
		
		// Agrego un borde vacio para hacer padding
       this.setBorder(new EmptyBorder(0, 10, 0, 10));
		
		//Visible a true
		this.setVisible(true);
	}

}
