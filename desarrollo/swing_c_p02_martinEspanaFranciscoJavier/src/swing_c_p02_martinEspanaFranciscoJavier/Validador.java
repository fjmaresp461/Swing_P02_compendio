/**
 * 	Validador.java
 *	17 nov 2023 0:38:04
 *	@author Francisco Javier Martin España
 */
package swing_c_p02_martinEspanaFranciscoJavier;

import javax.swing.JOptionPane;


/**
 * Esta clase se encarga de validar los datos introducidos en los paneles de arrendador e inmueble.
 *
 */

public class Validador {
	
	/**
	 * Metodo para validar el panel del arrendador.
	 * Comprueba si alguno de los campos está vacío y si los datos introducidos en los campos de texto son válidos.
	 * Muestra mensaje de error si hay algun fallo o algun campo esta vacio.
	 *
	 * @param panelArrendador el panel del arrendador
	 * @return true, si esta todo ok
	 */
   
    public static boolean validarPanelArrendador(PanelArrendador panelArrendador) {
    	
        // Creamos patrones para dni, telefono, nombre y apellido(No son patrones exactos)
    	String patronDNI = "\\d{8}[A-HJ-NP-TV-Za-hj-np-tv-z]";
        String patronTelefono = "[6-9][0-9]{8}";
        String patronNombreApellido = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]*$";

        // Comprobamos si alguno de los campos esta vacio
        if (panelArrendador.txtNombre.getText().trim().isEmpty()
                || panelArrendador.txtApellidos.getText().trim().isEmpty()
                || panelArrendador.txtDNI.getText().trim().isEmpty()
                || panelArrendador.txtTelefono.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, rellena todos los campos.", "Algun campo vacio",
                    JOptionPane.WARNING_MESSAGE);
            return false;
        } 
        // Comprobamos con el patron si el dni es valido
        else if (!panelArrendador.txtDNI.getText().trim().matches(patronDNI)) {
            JOptionPane.showMessageDialog(null, "Por favor, introduce un DNI que tenga 8 numeros y una letra.", "DNI inválido",
                    JOptionPane.WARNING_MESSAGE);
            return false;
        } 
        // Comprobamos con el patron si el  telefono es valido
        else if (!panelArrendador.txtTelefono.getText().trim().matches(patronTelefono)) {
            JOptionPane.showMessageDialog(null, "Por favor, introduce un número de teléfono que empiece por 6 o 7 o 9.",
                    "Teléfono inválido", JOptionPane.WARNING_MESSAGE);
            return false;
        } 
        // Comprobamos  con el patron si el nombre o nombres es valido
        else if (!panelArrendador.txtNombre.getText().trim().matches(patronNombreApellido)) {
            JOptionPane.showMessageDialog(null, "Por favor, introduce un nombre que empiece por una letra.", "Nombre inválido",
                    JOptionPane.WARNING_MESSAGE);
            return false;
        } 
        // Comprobamos con el patron si el o los apellidos son validos
        else if (!panelArrendador.txtApellidos.getText().trim().matches(patronNombreApellido)) {
            JOptionPane.showMessageDialog(null, "Por favor, introduce un apellido que empiece por una letra.",
                    "Apellido inválido", JOptionPane.WARNING_MESSAGE);
            return false;
        } 
        
        // Si esta todo ok, true
        else {
            return true;
        }
    }
    
    /**
	 * Metodo para validar el panel del inmueble.
	 * Comprueba si alguno de los campos está vacio y si los datos introducidos en los campos de texto son validos.
	 * Muestra mensaje de error si hay algun fallo o algun campo esta vacio.
	 *
	 * @param panelInmueble el panel del inmueble
	 * @return true, si esta todo ok
	 */
    public static boolean validarPanelInmueble(PanelInmueble panelInmueble) {
    	
        // Comprobamos si la direccion esta vacia
        if (panelInmueble.textFieldDireccion.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, introduce una dirección.", "Dirección vacía", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        // Comprobamos si se ha seleccionado una provincia
        if (panelInmueble.comboBoxProvincia.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Por favor, selecciona una provincia.", "Provincia no seleccionada", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        // Comprobamos si se han seleccionado huespedes
        if (panelInmueble.spinnerHuespedes.getValue() == null) {
            JOptionPane.showMessageDialog(null, "Por favor, selecciona un número de huéspedes.", "Número de huéspedes no seleccionados", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        // Comprobamos si se han seleccionado numero de dormitorios
        if (panelInmueble.spinnerDormitorios.getValue() == null) {
            JOptionPane.showMessageDialog(null, "Por favor, selecciona un número de dormitorios.", "Número de dormitorios no seleccionados", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        // Comprobamos si se han seleccionado numero de baños
        if (panelInmueble.spinnerBanos.getValue() == null) {
            JOptionPane.showMessageDialog(null, "Por favor, selecciona un número de baños.", "Número de baños no seleccionados", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        // Comprobamos si se han seleccionado numero de camas
        if (panelInmueble.spinnerCamas.getValue() == null) {
            JOptionPane.showMessageDialog(null, "Por favor, selecciona un número de camas.", "Número de camas no seleccionados", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        // Si esta todo ok, true
        return true;
    }
}
	
	

