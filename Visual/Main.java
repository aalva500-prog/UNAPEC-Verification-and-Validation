package Visual;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import List.UsersList;
import Model.Usuario;
import Utils.CurrentUser;
import Utils.LimiteJTextField;
import Utils.UserInterfaceSuport;
import Utils.Validate;


public class Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldCIF;
	private JPasswordField textFieldClave;
	private JButton ButtonAceptar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {					
					Main frame = new Main();
					frame.setVisible(true);
					} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}	

	public Main() throws HeadlessException {
		super();
		// TODO Auto-generated constructor stub
		Initialize();
	}

	/**
	 * Create the frame.
	 */
	private void Initialize() {
		setFont(new Font("Dialog", Font.BOLD, 12));
		setTitle("UNAPEC VIRTUAL");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/img/Apec.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);		
		setBounds(100, 100, 889, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(PaswordField());	
		contentPane.add(TextFieldMatricula());
		contentPane.add(ButtonAceptar());
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Main.class.getResource("/img/UnapecVirtual.jpg")));
		label.setBounds(0, 0, 883, 454);
		contentPane.add(label);
		UserInterfaceSuport.centerComponent(Main.this);
	}
	
	
	private JTextField TextFieldMatricula(){
		if(textFieldCIF==null){
			textFieldCIF = new JTextField();
			textFieldCIF.setFont(new Font("Tahoma", Font.BOLD, 11));
			textFieldCIF.setBounds(566, 156, 129, 25);
			textFieldCIF.setColumns(10);
			Validate.validateDigit(textFieldCIF);
			textFieldCIF.setDocument(new LimiteJTextField(20));
		}
		return textFieldCIF;
	}
	
	
	private JPasswordField PaswordField(){
		if(textFieldClave==null){
			 textFieldClave = new JPasswordField();
				textFieldClave.setFont(new Font("Tahoma", Font.BOLD, 11));
				textFieldClave.setColumns(10);
				textFieldClave.setBounds(566, 185, 129, 25);
				textFieldClave.setDocument(new LimiteJTextField(20));
				textFieldClave.addKeyListener(new java.awt.event.KeyAdapter() {
					public void keyPressed(java.awt.event.KeyEvent e) {
						if(e.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER){
							ButtonAceptar.doClick();
						}
					}
				});
		}
		return textFieldClave;
	}
	
	
	//En este botón se verifica si el usuario se puede autenticar en el sistema
	private JButton ButtonAceptar(){
		if(ButtonAceptar==null){
		ButtonAceptar = new JButton();
		ButtonAceptar.setText("Aceptar");
		ButtonAceptar.setFont(new Font("Tahoma", Font.BOLD, 11));
		ButtonAceptar.setBounds(606, 249, 89, 25);
		ButtonAceptar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				//Primero se verifican que estén todos los campos requeridos
				if(textFieldCIF.getText().length()!=0 && textFieldClave.getText().length()!=0){
				boolean found=false;
				int ID=0;
				LinkedList<Usuario> usuarios = UsersList.getUsuarios();
				Iterator<Usuario> it = usuarios.iterator();
				while(!found && it.hasNext()){
					Usuario user=it.next();
					//verifar si los datos coinciden con la base de datos
					if(user.getMatricula().equals(textFieldCIF.getText()) && user.getClave().equals(textFieldClave.getText())){
						found=true;
						ID=user.getIsUsuario();
						Matricula.main(null);// llamando a la interfaz Matricula
						Main.this.setVisible(false);
						//Creamos un nuevo usuario y se lo pasamos a la Clase CurrentUser, la cual nos va a mantener al usuario en el sistema
						Usuario usuario = new Usuario(user.getIdUsuario(),user.getMatricula(),user.getClave(),user.getNombre());
						CurrentUser.getCurrentUser().setSessionUser(usuario);
					}
				}	
				if(ID==0){					
						JOptionPane.showMessageDialog(Main.this, "El usuario no cumple los requisitos para realizar el ingreso a la Aplicación ó su Pin (clave) es incorrecto. Verifique!", "Error", JOptionPane.ERROR_MESSAGE);
						textFieldClave.setText("");
				}
				}else{
					JOptionPane.showMessageDialog(Main.this, "Los siguientes campos son requeridos: -Número CIF y -Clave (PIN)", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
	}
		return ButtonAceptar;
	}
}
