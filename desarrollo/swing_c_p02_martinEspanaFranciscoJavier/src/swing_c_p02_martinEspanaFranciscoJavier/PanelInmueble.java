/**
 * 	PanelInmueble.java
 *	15 nov 2023 13:39:59
 *	@author Francisco Javier Martin España
 */
package swing_c_p02_martinEspanaFranciscoJavier;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.MatteBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * En esta clase recogemos los datos del inmueble.
 */
public class PanelInmueble extends JPanel implements ActionListener, ChangeListener {

	/** La etiqueta del titulo. */
	JLabel labelTitulo;

	/** El campo de texto para la direccion. */
	JTextField textFieldDireccion;

	/** El combo box para la provincia. */
	JComboBox<String> comboBoxProvincia;

	/** El spinner para la fecha de alta. */
	JSpinner spinnerFechaAlta;
	
	/** La fecha final. */
	JLabel fechaFinal = new JLabel("");

	/** El spinner para el numero de huéspedes. */
	JSpinner spinnerHuespedes;

	/** El spinner para el numero de dormitorios. */
	JSpinner spinnerDormitorios;

	/** El spinner para el numero de baños. */
	JSpinner spinnerBanos;

	/** El spinner para el numero de camas. */
	JSpinner spinnerCamas;

	/** Los tipos de cama. */
	String[] tiposCama = { "Simple", "Doble", "Sofá cama" };
	
	/** 4 comboboxes tipo cama. */
	JComboBox<String> comboBoxTipoCama1, comboBoxTipoCama2, comboBoxTipoCama3, comboBoxTipoCama4;
	
	/** El panel de pestañas. */
	JTabbedPane tabbedPane;
	
	/** El checkbox  niños. */
	JCheckBox checkBoxNinos;

	/** El spinner para la edad de los niños. */
	JSpinner spinnerEdadNinos;

	/** La etiqueta para los extras. */
	JLabel labelExtras;

	/** Las provincias. */
	String[] provincias = { "Elige una provincia", "A Coruña", "Álava", "Albacete", "Alicante", "Almería", "Asturias",
			"Ávila", "Badajoz", "Barcelona", "Burgos", "Cáceres", "Cádiz", "Cantabria", "Castellón", "Ciudad Real",
			"Córdoba", "Cuenca", "Girona", "Granada", "Guadalajara", "Guipúzcoa", "Huelva", "Huesca", "Islas Baleares",
			"Jaén", "La Rioja", "Las Palmas", "León", "Lleida", "Lugo", "Madrid", "Málaga", "Murcia", "Navarra",
			"Ourense", "Palencia", "Pontevedra", "Salamanca", "Santa Cruz de Tenerife", "Segovia", "Sevilla", "Soria",
			"Tarragona", "Teruel", "Toledo", "Valencia", "Valladolid", "Vizcaya", "Zamora", "Zaragoza" };

	/** La etiqueta del precio. */
	JLabel labelPrecio;

	/** El panel de elementos. */
	JPanel panelElementos;

	/** El precio. */
	int precio;

	/**
	 * Constructor panel inmuenle.
	 * Inicializamos y colocamos los elementos al panel.
	 */
	public PanelInmueble() {

		// Le damos un gridbaglayout y unos constraints.
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(12, 0, 11, 0);

		c.gridy = 0;

		// Creamos el titulo y lo añadimos al panel que ira arriba
		labelTitulo = new JLabel("Datos del Inmueble");
		labelTitulo.setFont(new Font("Arial", 0, 24));
		labelTitulo.setForeground(Color.decode("#EE6F57"));

		panelElementos = new JPanel(new GridBagLayout());

		// He usado createVerticalStrut para cuadrar un poco el layout
		c.gridy = 1;
		panelElementos.add(Box.createVerticalStrut(0), c);

		// Campo direccion
		c.gridy = 2;
		panelElementos.add(new JLabel("Dirección"), c);
		textFieldDireccion = new JTextField(20);
		c.gridx = 1;
		panelElementos.add(textFieldDireccion, c);

		// Campo provincia
		c.gridx = 0;
		c.gridy = 3;
		panelElementos.add(new JLabel("Provincia"), c);
		comboBoxProvincia = new JComboBox<>(provincias);
		c.gridx = 1;
		panelElementos.add(comboBoxProvincia, c);

		// Campo fecha de alta
		c.gridx = 0;
		c.gridy = 4;
		panelElementos.add(new JLabel("Fecha de alta"), c);
		spinnerFechaAlta = new JSpinner(new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_MONTH));
		JSpinner.DateEditor editor = new JSpinner.DateEditor(spinnerFechaAlta, "dd/MM/yyyy");
		spinnerFechaAlta.setEditor(editor);
		spinnerFechaAlta.addChangeListener(this);
		c.gridx = 1;
		panelElementos.add(spinnerFechaAlta, c);

		// Campo fecha final de disponibilidad
		c.gridx = 0;
		c.gridy = 5;
		panelElementos.add(new JLabel("Fecha final de disponibilidad"), c);
		c.gridx = 1;
		panelElementos.add(fechaFinal, c);

		// Campo numero de huespedes
		c.gridx = 0;
		c.gridy = 6;
		panelElementos.add(new JLabel("Número de huéspedes"), c);
		spinnerHuespedes = new JSpinner(new SpinnerNumberModel(0, 0, 8, 1));
		c.gridx = 1;
		panelElementos.add(spinnerHuespedes, c);

		// Campo numero de dormitorios
		c.gridx = 0;
		c.gridy = 7;
		panelElementos.add(new JLabel("Número de dormitorios"), c);
		spinnerDormitorios = new JSpinner(new SpinnerNumberModel(0, 0, 4, 1));
		c.gridx = 1;
		panelElementos.add(spinnerDormitorios, c);

		// Campo numero de baños
		c.gridx = 0;
		c.gridy = 8;
		panelElementos.add(new JLabel("Número de baños"), c);
		spinnerBanos = new JSpinner(new SpinnerNumberModel(0, 0, 2, 1));
		c.gridx = 1;
		spinnerBanos.addChangeListener(this);
		panelElementos.add(spinnerBanos, c);

		// Campo numero de camas
		c.gridx = 0;
		c.gridy = 9;
		panelElementos.add(new JLabel("Número de camas"), c);
		spinnerCamas = new JSpinner(new SpinnerNumberModel(0, 0, 4, 1));
		c.gridx = 1;
		spinnerCamas.addChangeListener(this);
		panelElementos.add(spinnerCamas, c);

		// Campo tipo de camas
		// Creamos un JTabbedPane para los JComboBoxes para que no ocupen demasiado
		tabbedPane = new JTabbedPane();

		// Le damos un poco de formato
		tabbedPane.setForeground(Color.decode("#1F3C88"));
		tabbedPane.setPreferredSize(new Dimension(tabbedPane.getPreferredSize().width, 50));

		// Creamos los 4 comboboxes tipo cama, el primero lo dejamos enable=false
		comboBoxTipoCama1 = new JComboBox<>(tiposCama);
		comboBoxTipoCama1.addActionListener(this);
		tabbedPane.addTab("Cama 1", comboBoxTipoCama1);
		comboBoxTipoCama1.setEnabled(false);

		comboBoxTipoCama2 = new JComboBox<>(tiposCama);
		comboBoxTipoCama2.addActionListener(this);
		tabbedPane.addTab("Cama 2", comboBoxTipoCama2);

		comboBoxTipoCama3 = new JComboBox<>(tiposCama);
		comboBoxTipoCama3.addActionListener(this);
		tabbedPane.addTab("Cama 3", comboBoxTipoCama3);

		comboBoxTipoCama4 = new JComboBox<>(tiposCama);
		comboBoxTipoCama4.addActionListener(this);
		tabbedPane.addTab("Cama 4", comboBoxTipoCama4);

		// Añadimos el tabbedpane al panel inmueble, ocupando 2 columnas, y los dejamos disabled con el bucle for
		c.gridx = 0;
		c.gridy = 10;
		c.gridwidth = 2; 
		panelElementos.add(tabbedPane, c);
		for (int i = 0; i < 4; i++) {
			tabbedPane.setEnabledAt(i, false);
		}

		// ponemos el gridwith a 1 de nuevo para que el resto de los campos sigan igual
		c.gridwidth = 1;

		// Campo niños
		c.gridx = 0;
		c.gridy = 14;
		panelElementos.add(new JLabel("¿Niños?"), c);
		checkBoxNinos = new JCheckBox();
		c.gridx = 1;
		checkBoxNinos.addActionListener(this);
		panelElementos.add(checkBoxNinos, c);

		// Campo edad de niños
		c.gridx = 0;
		c.gridy = 15;
		panelElementos.add(new JLabel("Edad de niños"), c);
		spinnerEdadNinos = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
		spinnerEdadNinos.addChangeListener(this);
		spinnerEdadNinos.setEnabled(false);
		c.gridx = 1;
		panelElementos.add(spinnerEdadNinos, c);

		// Campo extras para niños
		c.gridx = 0;
		c.gridy = 16;
		panelElementos.add(new JLabel("Extras Niños"), c);
		labelExtras = new JLabel();
		labelExtras.setEnabled(false);
		c.gridx = 1;
		panelElementos.add(labelExtras, c);

		// Campo precio minimo
		c.gridx = 0;
		c.gridy = 17;
		panelElementos.add(new JLabel("Precio Mínimo"), c);

		c.gridx = 1;
		labelPrecio = new JLabel("0 €");
		panelElementos.add(labelPrecio, c);
		// Añadimos un verticalStrut para darle espacio y el titulo y elementos
		this.add(Box.createVerticalStrut(30));
		this.add(labelTitulo, c);
		this.add(panelElementos, c);

		// Añadimos un borde a izquierda y derecha para separar paneles
		this.setBorder(new MatteBorder(0, 2, 0, 1, Color.decode("#070D59")));

		// visible a true
		setVisible(true);
	}

	/**
	 * Método que se ejecuta cuando se realiza una acción.
	 * Si marcamos el checkbox niños, habilitamos el jspinner
	 *
	 * @param e el evento 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == checkBoxNinos) {

			// Si el checkbox esta marcado habilitamos el spiner y el JLabel extras y
			// viceversa
			if (checkBoxNinos.isSelected()) {
				spinnerEdadNinos.setEnabled(true);
				labelExtras.setEnabled(true);
			} else {
				spinnerEdadNinos.setEnabled(false);
				labelExtras.setEnabled(false);
			}
		}

		// LLamamos al metodo creado
		calcularPrecio();
	}

	/**
	 * Metodo que se ejecuta cuando cambia el estado de un componente.
	 * El spinner edad de los niños: dependiendo de la edad, actualiza la   etiqueta  extras.
	 * El spinner fecha de alta: mostramos la fecha final +1 año.
	 * El spinner numero de camas: Dependiendo del numero, habilita o deshabilita las pestañas.
	 *
	 * @param el evento
	 */
	@Override
	public void stateChanged(ChangeEvent e) {

		if (e.getSource() == spinnerEdadNinos) {

			// Si el checkbox esta seleccionado
			if (checkBoxNinos.isSelected()) {

				// Obtenemos la edad de los niños del spinner
				int edadNinos = (Integer) spinnerEdadNinos.getValue();

				// Si la edad esta entre 0 y 3, escribimos cuna y actualizamos precio
				if (edadNinos >= 0 && edadNinos <= 3) {
					labelExtras.setText("Cuna");
					precio += 12;
				}
				// Si la edad esta entre 4 y 10, escribimos cama supletoria pequeña y
				// actualizamos precio
				else if (edadNinos >= 4 && edadNinos <= 10) {
					labelExtras.setText("Cama supletoria pequeña");
					precio += 12;
				}
			} else {
				// Si no esta seleccionada, borramos
				labelExtras.setText("");
			}
		}

		else if (e.getSource() == spinnerFechaAlta) {

			// Pasamos a variable Date el valor del spinner
			Date fecha = (Date) spinnerFechaAlta.getValue();

			// Pasamos la variable fecha a variavle tipo calendar para sumar un año
			Calendar cal = Calendar.getInstance();
			cal.setTime(fecha);

			// Sumamos un año a la fecha
			cal.add(Calendar.YEAR, 1);

			// Volvemos a pasar a variable fecha la fecha modificada(es necesario para
			// darle formato)
			fecha = cal.getTime();

			// Creamos un formato y lo añadimos por ultimo al JLabel
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			String fechaFormateada = formato.format(fecha);
			fechaFinal.setText(fechaFormateada);
		} else if (e.getSource() == spinnerCamas) {

			// Obtenemos el número de camas seleccionadas
			int numCamas = (Integer) spinnerCamas.getValue();

			// Habilitamos o deshabilitamos los tabbedpane dependiendo del numero elegido
			for (int i = 0; i < 4; i++) {

				boolean enabled = i < numCamas;
				tabbedPane.setEnabledAt(i, enabled);

				// Cuando elegimos 1 cama, el combobox1 se pone enable, para el primer combobox,
				// ya que el resto es indiferente, porque no se vera si la pestaña esyá disable
				if (i == 1) {
					comboBoxTipoCama1.setEnabled(true);
				}
			}
			//Si por lo que sea, ponemos a 0 el jspinner, lo dejamos false
			if (numCamas == 0) {
				comboBoxTipoCama1.setEnabled(false);
			}
		}

		// LLamamos al metodo creado
		calcularPrecio();
	}

	/**
	 * Metodo para calcular el precio dependiendo de diversos factores.
	 */
	private void calcularPrecio() {
		precio = 0;

		// Extraigo del spinner directamente el numero de camas
		int numCamas = (Integer) spinnerCamas.getValue();

		// Multiplico el numero de camas por la cantidad según el tipo de cama
		for (int i = 0; i < numCamas; i++) {
			String tipoCama;
			switch (i) {
			case 0:
				tipoCama = (String) comboBoxTipoCama1.getSelectedItem();
				break;
			case 1:
				tipoCama = (String) comboBoxTipoCama2.getSelectedItem();
				break;
			case 2:
				tipoCama = (String) comboBoxTipoCama3.getSelectedItem();
				break;
			case 3:
				tipoCama = (String) comboBoxTipoCama4.getSelectedItem();
				break;
			default:
				tipoCama = "Elige un tipo de cama";
			}
			if (tipoCama.equals("Doble")) {
				precio += 20;
			} else if (tipoCama.equals("Sofá cama")) {
				precio += 15;
			} else { // cama simple
				precio += 15;
			}
		}

		// Extraemos del spinner baños y multiplicamos por su precio
		int numBanos = (Integer) spinnerBanos.getValue();
		precio += numBanos * 25;

		// Si niños esta seleccionado, sumamos
		if (checkBoxNinos.isSelected()) {
			precio += 12;
		}

		// Actualizamos la etiqueta del precio
		labelPrecio.setText(precio + " €");
	
	}

}
