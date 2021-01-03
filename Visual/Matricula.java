package Visual;

import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Utils.UserInterfaceSuport;

public class Matricula extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Matricula frame = new Matricula();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	

	public Matricula() throws HeadlessException {
		super();
		// TODO Auto-generated constructor stub
		Initialize();
	}



	/**
	 * Create the frame.
	 */
	private void Initialize() {
		setTitle("UNAPEC VIRTUAL");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Matricula.class.getResource("/img/Apec.png")));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setResizable(false);	
		setBounds(100, 100, 897, 605);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);		
		
		JButton btnSalir = new JButton("");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Matricula.this.setVisible(false);
				Main m = new Main();
				m.setVisible(true);
			}
		});
		btnSalir.setIcon(new ImageIcon(Matricula.class.getResource("/img/Salir.png")));
		btnSalir.setBounds(676, 23, 50, 23);
		contentPane.add(btnSalir);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new MatriculaEnLinea().setVisible(true);
				Matricula.this.setVisible(false);
			}
		});
		button.setToolTipText("MATRICULESE EN L\u00CDNEA");
		button.setIcon(new ImageIcon(Matricula.class.getResource("/img/Matricula.png")));
		button.setBounds(73, 76, 219, 55);
		contentPane.add(button);
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Matricula.class.getResource("/img/Virtual.jpg")));
		label.setBounds(0, 0, 894, 577);
		contentPane.add(label);
		UserInterfaceSuport.centerComponent(Matricula.this);
	}
}
