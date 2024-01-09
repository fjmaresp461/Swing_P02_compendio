/**
 * 	Progreso.java
 *	20 nov 2023 18:54:05
 *	@author Francisco Javier Martin España
 */
package swing_c_p02_martinEspanaFranciscoJavier;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JProgressBar;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


/**
 *Se encarga de crear y dar funcionalidad a un jprogressbar.
 */

public class Progreso {

	/** La barra de progreso. */
	JProgressBar progressBar;

	/** El panel del arrendador. */
	PanelArrendador panelArrendador;

	/** El panel del inmueble. */
	PanelInmueble panelInmueble;

	/** El panel de imágenes. */
	PanelImagenes panelImagenes;

	/**
	 * Constructor Progreso.
	 *
	 * @param maximo          el valor maximo de la barra
	 * @param panelArrendador el panel del arrendador
	 * @param panelInmueble   el panel del inmueble
	 * @param panelImagenes   el panel de imágenes
	 */
	Progreso(int maximo, PanelArrendador panelArrendador, PanelInmueble panelInmueble, PanelImagenes panelImagenes) {

		this.panelArrendador = panelArrendador;
		this.panelInmueble = panelInmueble;

		// Creamos la progerssBar
		progressBar = new JProgressBar(0, maximo);
		progressBar.setValue(0);
		progressBar.setStringPainted(true);
	}

	/**
	 * Metodo inicializar progressBar. Establecemos tamaño, color y registramos los
	 * campos de los distintos paneles.
	 */
	public void inicializarProgressBar() {

		// Registramos los campos de panel arrendador
		registrarCampo(panelArrendador.txtNombre);
		registrarCampo(panelArrendador.txtApellidos);
		registrarCampo(panelArrendador.txtDNI);
		registrarCampo(panelArrendador.txtTelefono);

		// Registramos los campos de panel inmueble
		registrarCampo(panelInmueble.textFieldDireccion);
		registrarComboBox(panelInmueble.comboBoxProvincia);
		registrarSpinner(panelInmueble.spinnerHuespedes);
		registrarSpinner(panelInmueble.spinnerDormitorios);
		registrarSpinner(panelInmueble.spinnerBanos);
		registrarSpinner(panelInmueble.spinnerCamas);
		registrarComboBox(panelInmueble.comboBoxTipoCama1);
		registrarComboBox(panelInmueble.comboBoxTipoCama2);
		registrarComboBox(panelInmueble.comboBoxTipoCama3);
		registrarComboBox(panelInmueble.comboBoxTipoCama4);
		registrarCheckBox(panelInmueble.checkBoxNinos);
		registrarSpinner(panelInmueble.spinnerEdadNinos);

		// Cambiamos el color de la barra de progreso
		progressBar.setForeground(Color.decode("#EE6F57"));

		// Cambiamos el color de fondo de la barra de progreso
		progressBar.setBackground(Color.WHITE);
		progressBar.setToolTipText("Progreso de introducción de datos");

		// Obtienemos el tamaño del panel contenedor para poner la barra
		Dimension panelSize = progressBar.getSize();

		// Damos tamaño y altura a la progressBar
		this.getProgressBar().setPreferredSize(new Dimension(panelSize.width, 15));

		// Le damos un borde a la barra
		progressBar.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		// No queremos que se vean numeros ni letras
		progressBar.setStringPainted(false);
	}

	/**
	 * Obtiene la barra de progreso.
	 *
	 * @return la barra de progreso
	 */
	JProgressBar getProgressBar() {
		return progressBar;
	}

	/**
	 * Metodo registrar campo.
	 * Acttualizamos la barra cuando se introduce texto.
	 *
	 * @param campo el campo de texto 
	 */
	void registrarCampo(JTextField campo) {
		campo.getDocument().addDocumentListener(new DocumentListener() {
			public void insertUpdate(DocumentEvent e) {
				actualizarProgressBar();
			}

			public void removeUpdate(DocumentEvent e) {
				actualizarProgressBar();
			}

			public void changedUpdate(DocumentEvent e) {
				actualizarProgressBar();
			}
		});
	}

	/**
	 * metodo registrar combo box
	 *
	 * @param comboBox the combo box
	 */
	void registrarComboBox(JComboBox<String> comboBox) {
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarProgressBar();
			}
		});
	}

	/**
	 * Metodo registrar check box.
	 *
	 * @param checkBox the check box
	 */
	void registrarCheckBox(JCheckBox checkBox) {
		checkBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				actualizarProgressBar();
			}
		});
	}

	/**
	 * Metodo registrar spinner.
	 *
	 * @param spinner the spinner
	 */
	void registrarSpinner(JSpinner spinner) {
		spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				actualizarProgressBar();
			}
		});
	}

	/**
	 * Metodo actualizar progress bar.
	 */
	void actualizarProgressBar() {
		int valor = 0;

		if (!panelArrendador.txtNombre.getText().trim().isEmpty())
			valor++;
		if (!panelArrendador.txtApellidos.getText().trim().isEmpty())
			valor++;
		if (!panelArrendador.txtDNI.getText().trim().isEmpty())
			valor++;
		if (!panelArrendador.txtTelefono.getText().trim().isEmpty())
			valor++;
		if (!panelInmueble.textFieldDireccion.getText().trim().isEmpty())
			valor++;
		if (panelInmueble.comboBoxProvincia.getSelectedIndex() != 0)
			valor++;
		if ((Integer) panelInmueble.spinnerHuespedes.getValue() > 0)
			valor++;
		if ((Integer) panelInmueble.spinnerDormitorios.getValue() > 0)
			valor++;
		if ((Integer) panelInmueble.spinnerBanos.getValue() > 0)
			valor++;
		if ((Integer) panelInmueble.spinnerCamas.getValue() > 0)
			valor++;
		if (panelInmueble.comboBoxTipoCama1.getSelectedIndex() != 0)
			valor++;
		if (panelInmueble.comboBoxTipoCama2.getSelectedIndex() != 0)
			valor++;
		if (panelInmueble.comboBoxTipoCama3.getSelectedIndex() != 0)
			valor++;
		if (panelInmueble.comboBoxTipoCama4.getSelectedIndex() != 0)
			valor++;

		// Incrementa el valor si se ha seleccionado la opción de niños y se ha
		// seleccionado una edad, si marcamos el checkbox, debemos poner la edad
		if (panelInmueble.checkBoxNinos.isSelected()) {

			valor++;

			progressBar.setMaximum(12);
		} else {

			progressBar.setMaximum(11);
		}

		// Actualizamos el valor del JProgressBar
		progressBar.setValue(valor);

	}

}
