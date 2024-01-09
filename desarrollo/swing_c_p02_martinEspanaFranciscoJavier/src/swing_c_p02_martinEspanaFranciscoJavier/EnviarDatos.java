/**
 * 	EnviarTexto.java
 *	24 nov 2023 21:05:52
 *	@author Francisco Javier Martin España
 */
package swing_c_p02_martinEspanaFranciscoJavier;

import java.text.SimpleDateFormat;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;


/**
 * Enviara todos los datos ingresados del arrendador, inmueble y las imagenes al paneldatos.
 */
public class EnviarDatos {
    
    /** El panel del arrendador. */
    private PanelArrendador panelArrendador;
    
    /** El panel del inmueble. */
    private PanelInmueble panelInmueble;
    
    /** El panel de datos. */
    private PanelDatos panelDatos;
    
    /** El panel de imágenes. */
    private PanelImagenes panelImagenes;

    /**
	 * Crea una nueva instancia de EnviarTexto.
	 *
	 * @param panelArrendador el panel del arrendador
	 * @param panelInmueble   el panel del inmueble
	 * @param panelDatos      el panel de datos
	 * @param panelImagenes   el panel de imágenes
	 */
    public EnviarDatos(PanelArrendador panelArrendador, PanelInmueble panelInmueble, PanelDatos panelDatos,PanelImagenes panelImagenes) {
        this.panelArrendador = panelArrendador;
        this.panelInmueble = panelInmueble;
        this.panelDatos = panelDatos;
        this.panelImagenes = panelImagenes;
    }

    /**
	 * metodo enviar, enviará los datos.
	 */
    public void enviar() {
        // Usamos dos metodos validar de una clase Validador y entonces vamos asignando
        // los valores al panel de la clase panelDatos, le damos un poco de formato.
        if (Validador.validarPanelArrendador(panelArrendador) && (Validador.validarPanelInmueble(panelInmueble))) {
            // Queda antiestetico, pero necesito hacer aqui un dateformat para dar formato a
            // la fecha
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            String fechaFormateada = formatoFecha.format(panelInmueble.spinnerFechaAlta.getValue());

            // Creamos el textAreaArrendador y le añadimos los resultados
            JTextPane textAreaArrendador = new JTextPane();
            textAreaArrendador.setEditable(false);
            textAreaArrendador.setText("\n"+
                    "Nombre: " + panelArrendador.txtNombre.getText() + "\n" + "\n"+
                    "Apellidos: "+ panelArrendador.txtApellidos.getText() + "\n" + "\n"+
                    "DNI: " + panelArrendador.txtDNI.getText()+ "\n" + "\n"+
                    "Teléfono: " + panelArrendador.txtTelefono.getText() + "\n");
            
            panelDatos.textoArrendador.setText(textAreaArrendador.getText());
        
            
            
            // Creamos el textAreaInmueble y le añadimos los resultados
            JTextPane textAreaInmueble = new JTextPane();
            textAreaInmueble.setEditable(false);

            textAreaInmueble.setText("\n"+
                "Direccion: " + panelInmueble.textFieldDireccion.getText() + "\n"+"\n"+
                "Provincia: " + panelInmueble.comboBoxProvincia.getSelectedItem().toString() + "\n"+ "\n"+
                "Fecha de alta: " + fechaFormateada + "\n" + "\n" +
                "Fecha final disponibilidad: "+ panelInmueble.fechaFinal.getText() + "\n" + "\n"+    
                "Numero de huéspedes: "+ panelInmueble.spinnerHuespedes.getValue() + "\n" + "\n"+                
                "Numero de dormitorios: "+ panelInmueble.spinnerDormitorios.getValue() + "\n" + "\n"+                        
                "Numero de baños: "+ panelInmueble.spinnerBanos.getValue() + "\n" + "\n"+                        
                "Numero de camas: "+ panelInmueble.spinnerCamas.getValue() + ":\n" );

            int numCamas = (Integer) panelInmueble.spinnerCamas.getValue();
            for (int i = 0; i < numCamas; i++) {
                // Añadimos el tipo de cama dependiendo de la cama en cuetion
                String tipoCama;
                switch (i) {
                    case 0:
                        tipoCama = (String) panelInmueble.comboBoxTipoCama1.getSelectedItem();
                        break;
                    case 1:
                        tipoCama = (String) panelInmueble.comboBoxTipoCama2.getSelectedItem();
                        break;
                    case 2:
                        tipoCama = (String) panelInmueble.comboBoxTipoCama3.getSelectedItem();
                        break;
                    case 3:
                        tipoCama = (String) panelInmueble.comboBoxTipoCama4.getSelectedItem();
                        break;
                    default:
                        tipoCama = "Elige un tipo de cama";
                }
                // Concatenamos el texto
                textAreaInmueble.setText(textAreaInmueble.getText() + "Cama " + (i + 1) + ": "+ tipoCama + "\n" );
            }

            // concatenamos el texto
            textAreaInmueble.setText(textAreaInmueble.getText() + "\n" +
            
                // Operador ternario que si se cumple, en este caso, se añadirian lo extras
                "¿Niños?: "+ (panelInmueble.checkBoxNinos.isSelected()? 
                "Sí" + "\n" + "\n"+
                "Extras Niños: " + panelInmueble.labelExtras.getText(): 
                "No"));

            panelDatos.textoInmueble.setText(textAreaInmueble.getText());

            // Creamos el panel contenedor imagenes que será el panel de la clase panelDatos
            JPanel contenedorImagenes = PanelDatos.getContenedorImagenes();


			// Iteramos sobre la lista de jlabel lista imagenes y asignamos a un jlabel cada
            // imagen
            for (JLabel label : panelImagenes.getListaImagenes()) {
                JLabel copiaLabel = new JLabel();
                copiaLabel.setIcon(label.getIcon());

                // añadimos al contenedorImagenes(de panelDatos)
                contenedorImagenes.add(copiaLabel);
            }

            // Actualizamos contenedorImagenes
            contenedorImagenes.revalidate();
            contenedorImagenes.repaint();
        }
    }
}
