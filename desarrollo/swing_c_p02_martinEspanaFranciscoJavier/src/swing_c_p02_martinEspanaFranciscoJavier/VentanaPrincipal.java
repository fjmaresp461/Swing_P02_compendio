/**
 * 	Ventana.java
 *	15 nov 2023 10:58:14
 *	@author Francisco Javier Martin España
 */
package swing_c_p02_martinEspanaFranciscoJavier;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;


/**
 * Clase que inicia el programa, inicia una ventana con menu y botones.
 */
public class VentanaPrincipal extends JFrame implements ActionListener {

	/** Las restricciones. */
	GridBagConstraints constraints;

	/** La pantalla. */
	Toolkit pantalla;

	/** El icono. */
	ImageIcon icono;

	/** La imagen. */
	Image imagen;

	/** La barra. */
	JMenuBar barra;

	/** El archivo. */
	JMenu archivo;

	/** El registro. */
	JMenu registro;

	/** La ayuda. */
	JMenu ayuda;

	/** Salir. */
	JMenuItem salir;

	/** Alta pisos. */
	JMenuItem altaPisos;

	/** Baja pisos. */
	JMenuItem bajaPisos;

	/** Acerca de. */
	JMenuItem acercaDe;

	/** Botón alta pisos. */
	JButton btnAltaPisos;

	/** Botón baja pisos. */
	JButton btnBajaPisos;

	/** Icono alta. */
	ImageIcon iconoAlta;

	/** Icono baja. */
	ImageIcon iconoBaja;

	/** El panel. */
	BoxLayout panel;

	/** La ventana principal. */
	VentanaPrincipal ventanaPrincipal;

	/** La ventana. */
	VentanaAlta ventana;
	/**
	 * Constructor  VentanaPrincipal.
	 * Inicializamos la ventana y añadimos menus y botones.
	 */
	public VentanaPrincipal() {

		// Bloque con titulo, tamaño, posicion e icono, y constraints para los botones
		super("Gestión Apartamentos Turísticos Frank");
		this.setLayout(new GridBagLayout());
		constraints = new GridBagConstraints();
		constraints.insets = new Insets(0, 50, 0, 50);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		pantalla = Toolkit.getDefaultToolkit();
		this.getContentPane().setBackground(Color.decode("#F6F5F5"));

		// Tamaño, posicion y color de la ventana
		this.setSize(pantalla.getScreenSize().width / 2, pantalla.getScreenSize().height / 2);
		this.setLocation(pantalla.getScreenSize().width / 4, pantalla.getScreenSize().height / 4);
	//	this.getContentPane().setBackground(Color.decode("#F4BF96"));

		// Icono de la ventana
		icono = new ImageIcon(getClass().getResource("/recursos/icono_gaft.png"));
		this.setIconImage(icono.getImage());

		// Iniciamos JMenuBar, JMenu (añadimos mnemotecnicos con alt y aceleradores con
		// ctrl)y JMenuItems(añadimos listeners)
		barra = new JMenuBar();


		archivo = new JMenu("Archivo");
		archivo.setMnemonic('A');

		registro = new JMenu("Registro");
		registro.setMnemonic('E');

		ayuda = new JMenu("Ayuda");
		ayuda.setMnemonic('Y');

		salir = new JMenuItem("Salir");
		salir.addActionListener(this);

		altaPisos = new JMenuItem("Alta de pisos");
		altaPisos.addActionListener(this);
		altaPisos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK));

		bajaPisos = new JMenuItem("Baja de pisos");
		bajaPisos.addActionListener(this);
		bajaPisos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_DOWN_MASK));

		acercaDe = new JMenuItem("Acerca de");
		acercaDe.addActionListener(this);

		// Añadimos los JMenuItems a JMenu y de JMenu a JMenuBar
		archivo.add(salir);

		registro.add(altaPisos);
		registro.add(bajaPisos);

		ayuda.add(acercaDe);

		barra.add(archivo);
		barra.add(registro);
		barra.add(ayuda);

		// Creamos los dos botones y usamos un metodo que he creado en la clase que
		// engloba
		// varios metodos para limpiar el boton
		btnAltaPisos = new JButton();
		btnAltaPisos.setToolTipText("Alta de un inmueble");
		btnBajaPisos = new JButton();
		btnBajaPisos.setToolTipText("Baja de un inmueble");
		limpiar(btnAltaPisos);
		limpiar(btnBajaPisos);

		// Asignamos iconos a los botones( hago el new imageicon para ahorrar algunas
		// lineas)
		btnAltaPisos.setIcon(new ImageIcon(getClass().getResource("/recursos/icono_alta.png")));
		btnBajaPisos.setIcon(new ImageIcon(getClass().getResource("/recursos/icono_baja.png")));

		// Añadimos los botones a la ventana, aplicando los constraints que defini antes
		this.add(btnAltaPisos, constraints);
		this.add(btnBajaPisos, constraints);

		// Añadimos la barra de menu a la ventana
		this.setJMenuBar(barra);

		// Visible a true
		this.setVisible(true);

	}

	/**
	 * Método que se ejecuta cuando se realiza una acción. 
	 * Menu salir: Cierra el programa. 
	 * Menu alta pisos o boton alta: Crea una instancia de ventana alta. 
	 * Menu baja pisos o boton baja: Mostramos mensaje.
	 * Menu acerca de: Mostramos mensaje.
	 * @param e el evento
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == salir) {
			this.dispose();
		} else if (e.getSource() == altaPisos || e.getSource() == btnAltaPisos) {

			// Instanciamos la ventana, mandando como parametros la ventana principal y
			// modal a true
			ventana = new VentanaAlta(ventanaPrincipal, true);
		} else if (e.getSource() == bajaPisos || e.getSource() == btnBajaPisos) {

			// Mostramos mensaje al pulsar bajapisos desde el boton o el menu
			JOptionPane.showMessageDialog(this, "Esta opción no está desarrollada aún", "INFORMACION",
					JOptionPane.INFORMATION_MESSAGE);
		} else if (e.getSource() == acercaDe) {

			// Mostramos mensaje al pulsar acerca de, desde el menu
			JOptionPane.showMessageDialog(this,
					"Aplicación inmobiliaria desarrollada por:\n Francisco Javier Martín España\n\n Derechos reservados",
					"Acerca de esta aplicación", JOptionPane.INFORMATION_MESSAGE);

		}

	}

	/**
	 * Establece la ventana principal.
	 *
	 * @param ventana la nueva ventana principal
	 */
	// Enviamos una instancia de la ventana principal
	public void setVentanaPrincipal(VentanaPrincipal ventana) {
		ventanaPrincipal = ventana;
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
