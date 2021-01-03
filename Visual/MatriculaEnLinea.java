package Visual;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumn;

import test.DefaultCellRenderer;
import List.AsigList;
import List.ClaseList;
import Model.Asignatura;
import Model.Clase;
import Utils.CurrentUser;
import Utils.FormatoTabla;
import Utils.FormatoTablaAsignaturas;
import Utils.TableModel;
import Utils.UserInterfaceSuport;

public class MatriculaEnLinea extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel labelCIF;
	private JLabel labelName;
	private JTable tableAsignaturas;
	private JTable table_1;
	private JLabel labelAsignatura;
	private JLabel labelCodigo;
	private JLabel labelCréditos;
	private JLabel labelFisica1;
	private JLabel labelFisica2;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MatriculaEnLinea frame = new MatriculaEnLinea();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MatriculaEnLinea() {
		setTitle("MATR\u00CDCULA EN L\u00CDNEA");
		this.addWindowListener(new java.awt.event.WindowAdapter() {   
			public void windowClosed(java.awt.event.WindowEvent e) {    
				getOwner().dispose();
			}
			public void windowOpened(java.awt.event.WindowEvent e) {
				labelCIF.setText(CurrentUser.getCurrentUser().getSessionUser().getMatricula());		
				labelName.setText(CurrentUser.getCurrentUser().getSessionUser().getNombre());
				TableModel defaultTableModel = new TableModel();
				ArrayList<Object> columnDataCampus = new ArrayList<Object>();
				ArrayList<Object> columnDataAula = new ArrayList<Object>();
				ArrayList<Object> columnDataGrupo = new ArrayList<Object>();
				ArrayList<Object> columnDataLunes = new ArrayList<Object>();
				ArrayList<Object> columnDataMartes = new ArrayList<Object>();
				ArrayList<Object> columnDataMiercoles = new ArrayList<Object>();
				ArrayList<Object> columnDataJueves = new ArrayList<Object>();
				ArrayList<Object> columnDataViernes = new ArrayList<Object>();
				ArrayList<Object> columnDataSabado = new ArrayList<Object>();
				ArrayList<Object> columnDataDomingo = new ArrayList<Object>();
				ArrayList<Object> columnDataProfesor = new ArrayList<Object>();
				ArrayList<Object> columnDataSeleccionar = new ArrayList<Object>();
				defaultTableModel.addColumn("CAMPUS", columnDataCampus.toArray());
				defaultTableModel.addColumn("AULA",columnDataAula.toArray());
				defaultTableModel.addColumn("GRUPO",columnDataGrupo.toArray());
				defaultTableModel.addColumn("L",columnDataLunes.toArray());
				defaultTableModel.addColumn("K",columnDataMartes.toArray());
				defaultTableModel.addColumn("M",columnDataMiercoles.toArray());
				defaultTableModel.addColumn("J",columnDataJueves.toArray());
				defaultTableModel.addColumn("V",columnDataViernes.toArray());
				defaultTableModel.addColumn("S",columnDataSabado.toArray());
				defaultTableModel.addColumn("D",columnDataDomingo.toArray());
				defaultTableModel.addColumn("PROF.",columnDataProfesor.toArray());
				defaultTableModel.addColumn("MATRICULAR",columnDataSeleccionar.toArray());
				table_1.setModel(defaultTableModel);
				TableColumn columnaProfesor = table_1.getColumn("PROF.");
				columnaProfesor.setMinWidth(70);	
				columnaProfesor.setMaxWidth(70);
				columnaProfesor.setPreferredWidth(70);
				
				TableColumn columnaGrupo = table_1.getColumn("GRUPO");
				columnaGrupo.setMinWidth(50);	
				columnaGrupo.setMaxWidth(50);
				columnaGrupo.setPreferredWidth(50);
				
				TableColumn columnaMatricular = table_1.getColumn("MATRICULAR");
				columnaMatricular.setMinWidth(90);	
				columnaMatricular.setMaxWidth(90);
				columnaMatricular.setPreferredWidth(90);
				
				TableColumn columnaCAmpus = table_1.getColumn("CAMPUS");
				columnaCAmpus.setMinWidth(70);	
				columnaCAmpus.setMaxWidth(70);
				columnaCAmpus.setPreferredWidth(70);
				
				
				
				}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(MatriculaEnLinea.class.getResource("/img/Apec.png")));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setResizable(false);	
		setBounds(100, 100, 981, 707);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSalir = new JButton("");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MatriculaEnLinea.this.setVisible(false);
				Main m = new Main();
				m.setVisible(true);
			}
		});
		btnSalir.setIcon(new ImageIcon(Matricula.class.getResource("/img/Salir.png")));
		btnSalir.setBounds(660, 31, 50, 23);
		contentPane.add(btnSalir);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MatriculaEnLinea.this.setVisible(false);
				Matricula m = new Matricula();
				m.setVisible(true);
			}
		});
		button.setIcon(new ImageIcon(MatriculaEnLinea.class.getResource("/img/Inicio.png")));
		button.setBounds(39, 73, 230, 29);
		contentPane.add(button);		
		contentPane.add(LabelCIF());
		contentPane.add(LabelName());
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 279, 300, 346);
		contentPane.add(scrollPane);
		
		tableAsignaturas = new JTable();
		scrollPane.setViewportView(tableAsignaturas);
		tableAsignaturas.getTableHeader().setEnabled(false);
		try {
			TablaAsignaturas(tableAsignaturas);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		tableAsignaturas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int fila=tableAsignaturas.rowAtPoint(arg0.getPoint());
				//int columna=tableAsignaturas.columnAtPoint(arg0.getPoint());	
				int pos = tableAsignaturas.getSelectedRow();
				Asignatura asig= AsigList.getAsignaturas().get(pos);
				labelAsignatura.setText(asig.getDescripcionAsig());
				labelCodigo.setText(asig.getCodigo());
				labelCréditos.setText(String.valueOf(asig.getCreditos()));
				if(asig.getCodigo().equals("ING701")){
					if(tableAsignaturas.getModel().getValueAt(fila, 1).equals(asig.getCodigo())){
						if(tableAsignaturas.getModel().getValueAt(fila, 3).equals("INSCRITA")){
							if(labelFisica1.getText().length()!=0){
				    TablaClases(table_1,ClaseList.getClasesDeFisica1());	
							}
							if(labelFisica2.getText().length()!=0){
					TablaClases(table_1,ClaseList.getClasesDeFisica3());	
					}
				}else{
				    TablaClases(table_1,ClaseList.getClasesDeFisica());	
					}
				}
				}
				
				if(asig.getCodigo().equals("MAT127")){
					if(tableAsignaturas.getModel().getValueAt(fila, 1).equals(asig.getCodigo())){
						if(tableAsignaturas.getModel().getValueAt(fila, 3).equals("INSCRITA")){
				TablaClases(table_1,ClaseList.getClasesDeMatematica1());	
						}else{
				TablaClases(table_1,ClaseList.getClasesDeMatematica());	
					}
				}
				}
				
				if(asig.getCodigo().equals("INF111")){
					if(tableAsignaturas.getModel().getValueAt(fila, 1).equals(asig.getCodigo())){
						if(tableAsignaturas.getModel().getValueAt(fila, 3).equals("INSCRITA")){
				TablaClases(table_1,ClaseList.getClasesDeProgramacion1());	
						}else{
				TablaClases(table_1,ClaseList.getClasesDeProgramacion());	
					}
				}
					}
				
				if(asig.getCodigo().equals("ADM120")){
					if(tableAsignaturas.getModel().getValueAt(fila, 1).equals(asig.getCodigo())){
						if(tableAsignaturas.getModel().getValueAt(fila, 3).equals("INSCRITA")){
				TablaClases(table_1,ClaseList.getClasesDeLiderazgo1());	
						}else{
				TablaClases(table_1,ClaseList.getClasesDeLiderazgo());	
					}
				}
					}
				
				}
		});
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(340, 292, 598, 333);
		contentPane.add(scrollPane_1);		
		
		//Trabajo con la Tabla de las Clases
		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
                     if(ExisteClase(ClaseList.getClasesDeFisica())==true && ExisteClase(ClaseList.getClasesDeMatematica())==true){					 
						int fila=table_1.rowAtPoint(e.getPoint());
						int columna=table_1.columnAtPoint(e.getPoint());			 
					    int pos = table_1.getSelectedRow();	
					    //Se verifica que la segunda fila no se seleccione
					    if(pos!=1){
					    	//se verifica la Materia Fisica I
					    if(labelCodigo.getText().equalsIgnoreCase("ING701")){
						Clase c = ClaseList.getClasesDeFisica().get(pos);	
						  if(table_1.getModel().getColumnName(columna).equals("MATRICULAR") && table_1.getModel().getValueAt(fila, 2).equals(c.getGrupo())){	
								if(table_1.getModel().getValueAt(fila, columna).equals(true)){	
									if(table_1.getModel().getValueAt(fila, 2).equals("43013")){
										if(!tableAsignaturas.getModel().getValueAt(2, 3).equals("INSCRITA")){
										if(labelFisica2.getText().length()==0 && labelFisica1.getText().length()==0){
											JOptionPane.showMessageDialog(MatriculaEnLinea.this, "Clase Inscrita Satisfactoriamente", "Información", JOptionPane.INFORMATION_MESSAGE);
											tableAsignaturas.getModel().setValueAt("INSCRITA", 0, 3);
											labelFisica1.setText(c.getGrupo());
										}
										 if(labelFisica2.getText().length()!=0 && labelFisica1.getText().length()==0){
											 JOptionPane.showMessageDialog(MatriculaEnLinea.this, "Usted está inscrito en otra Clase de esta Materia, debe eliminar primero su selección anterior", "ERROR", JOptionPane.ERROR_MESSAGE);
											 table_1.getModel().setValueAt(false, fila, columna);
										 }
									}else{
										    JOptionPane.showMessageDialog(MatriculaEnLinea.this, "Existe concurrencia de Horario con INF111: PROGRAMACIÓN ORIENTADA A OBJETOS", "ERROR", JOptionPane.ERROR_MESSAGE);
											table_1.getModel().setValueAt(false, fila, columna);
											}
									}
									if(table_1.getModel().getValueAt(fila, 2).equals("234")){
										if(!tableAsignaturas.getModel().getValueAt(2, 3).equals("INSCRITA")){
										if(labelFisica2.getText().length()==0 && labelFisica1.getText().length()==0){
											JOptionPane.showMessageDialog(MatriculaEnLinea.this, "Clase Inscrita Satisfactoriamente", "Información", JOptionPane.INFORMATION_MESSAGE);
											tableAsignaturas.getModel().setValueAt("INSCRITA", 0, 3);
											labelFisica2.setText(c.getGrupo());
										}
										 if(labelFisica2.getText().length()==0 && labelFisica1.getText().length()!=0){
											 JOptionPane.showMessageDialog(MatriculaEnLinea.this, "Usted está inscrito en otra Clase de esta Materia, debe eliminar primero su selección anterior", "ERROR", JOptionPane.ERROR_MESSAGE);
											 table_1.getModel().setValueAt(false, fila, columna);
										 }
									}else{
									    JOptionPane.showMessageDialog(MatriculaEnLinea.this, "Existe concurrencia de Horario con INF111: PROGRAMACIÓN ORIENTADA A OBJETOS", "ERROR", JOptionPane.ERROR_MESSAGE);
										table_1.getModel().setValueAt(false, fila, columna);
										}
									}
									}else{
									JOptionPane.showMessageDialog(MatriculaEnLinea.this, "Clase Retirada Satisfactoriamente", "Información", JOptionPane.INFORMATION_MESSAGE);	
									tableAsignaturas.getModel().setValueAt("", 0, 3);
									labelFisica2.setText("");
									labelFisica1.setText("");		
									}					
						}
					    }
						 
					    
					    // Verifiando la MAteria Matematica 
						if(labelCodigo.getText().equalsIgnoreCase("MAT127")){
					    	Clase c=ClaseList.getClasesDeMatematica().get(pos);
					    	if(table_1.getModel().getColumnName(columna).equals("MATRICULAR") && table_1.getModel().getValueAt(fila, 2).equals(c.getGrupo())){				    
								if(table_1.getModel().getValueAt(fila, columna).equals(true)){
									JOptionPane.showMessageDialog(MatriculaEnLinea.this, "Clase Inscrita Satisfactoriamente", "Información", JOptionPane.INFORMATION_MESSAGE);
									tableAsignaturas.getModel().setValueAt("INSCRITA", 1, 3);									
								}else{
									JOptionPane.showMessageDialog(MatriculaEnLinea.this, "Clase Retirada Satisfactoriamente", "Información", JOptionPane.INFORMATION_MESSAGE);	
									tableAsignaturas.getModel().setValueAt("", 1, 3);
									}					
						}	
					    }
					    
						
						//Verifianado la MAteria Programacion
					    if(labelCodigo.getText().equalsIgnoreCase("INF111")){
					    	Clase c=ClaseList.getClasesDeProgramacion().get(pos);
					    	if(table_1.getModel().getColumnName(columna).equals("MATRICULAR") && table_1.getModel().getValueAt(fila, 2).equals(c.getGrupo())){				    
								if(table_1.getModel().getValueAt(fila, columna).equals(true)){	
									if(!tableAsignaturas.getModel().getValueAt(0, 3).equals("INSCRITA")){
									JOptionPane.showMessageDialog(MatriculaEnLinea.this, "Clase Inscrita Satisfactoriamente", "Información", JOptionPane.INFORMATION_MESSAGE);
									tableAsignaturas.getModel().setValueAt("INSCRITA", 2, 3);
									}else{
											JOptionPane.showMessageDialog(MatriculaEnLinea.this, "Existe concurrencia de Horario con ING701: FÍSICA I Y LABORATORIO", "ERROR", JOptionPane.ERROR_MESSAGE);
											table_1.getModel().setValueAt(false, fila, columna);										
									}
								}else{
									JOptionPane.showMessageDialog(MatriculaEnLinea.this, "Clase Retirada Satisfactoriamente", "Información", JOptionPane.INFORMATION_MESSAGE);	
									tableAsignaturas.getModel().setValueAt("", 2, 3);
								}					
						}	
					    }
					    
					    
					    //verificnado la MAteria Liderazgo
					    if(labelCodigo.getText().equalsIgnoreCase("ADM120")){
					    	Clase c=ClaseList.getClasesDeLiderazgo().get(pos);
					    	if(table_1.getModel().getColumnName(columna).equals("MATRICULAR") && table_1.getModel().getValueAt(fila, 2).equals(c.getGrupo())){				    
								if(table_1.getModel().getValueAt(fila, columna).equals(true)){							
									JOptionPane.showMessageDialog(MatriculaEnLinea.this, "Clase Inscrita Satisfactoriamente", "Información", JOptionPane.INFORMATION_MESSAGE);
									tableAsignaturas.getModel().setValueAt("INSCRITA", 3, 3);
								}else{
									JOptionPane.showMessageDialog(MatriculaEnLinea.this, "Clase Retirada Satisfactoriamente", "Información", JOptionPane.INFORMATION_MESSAGE);	
									tableAsignaturas.getModel().setValueAt("", 3, 3);
								}					
						}	
					    }
					    
					    }else{
					    	JOptionPane.showMessageDialog(MatriculaEnLinea.this, "Grupo sin Cupo", "Información", JOptionPane.ERROR_MESSAGE);	
					    	table_1.getModel().setValueAt(false, 1, 11);
					    }		
						
                     }
					}
				});
	
		scrollPane_1.setViewportView(table_1);	
		table_1.getTableHeader().setEnabled(false);
		
		
		contentPane.add(LabelCreditos());
		
		contentPane.add(LAbelAsignatura());	
		contentPane.add(LabelCodigo());
		
		JLabel lblCdigo = new JLabel("C\u00D3DIGO:");
		lblCdigo.setForeground(Color.WHITE);
		lblCdigo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCdigo.setBounds(355, 254, 55, 38);
		contentPane.add(lblCdigo);
		
		JLabel lblAsignatura = new JLabel("ASIGNATURA:");
		lblAsignatura.setForeground(Color.WHITE);
		lblAsignatura.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAsignatura.setBounds(505, 254, 83, 38);
		contentPane.add(lblAsignatura);
		
		JLabel lblCrditos = new JLabel("CR\u00C9DITOS:");
		lblCrditos.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCrditos.setForeground(Color.WHITE);
		lblCrditos.setBounds(785, 254, 63, 38);
		contentPane.add(lblCrditos);
		
		
		contentPane.add(LabelFisica());
		
		
		contentPane.add(LabelFisica1());
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MatriculaEnLinea.class.getResource("/img/MatriculaEnLinea.jpg")));
		lblNewLabel.setBounds(0, 0, 976, 679);
		contentPane.add(lblNewLabel);
		UserInterfaceSuport.centerComponent(MatriculaEnLinea.this);
	}
	
	private JLabel LabelFisica(){
		if(labelFisica1==null){
			labelFisica1 = new JLabel("");
			labelFisica1.setBounds(779, 42, 109, 45);
		}
		return labelFisica1;
	}
	
	private JLabel LabelFisica1(){
		if(labelFisica2==null){
			labelFisica2 = new JLabel("");
			labelFisica2.setBounds(639, 65, 109, 45);
		}
		return labelFisica2;
	}
	
	private JLabel LAbelAsignatura(){
		if(labelAsignatura==null){
		labelAsignatura = new JLabel("");
		labelAsignatura.setForeground(Color.WHITE);
		labelAsignatura.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelAsignatura.setBounds(589, 254, 178, 38);
		}
		return labelAsignatura;
	}
	
	private JLabel LabelCodigo(){
		if(labelCodigo==null){
			labelCodigo = new JLabel("");
			labelCodigo.setForeground(Color.WHITE);
			labelCodigo.setFont(new Font("Tahoma", Font.BOLD, 11));
			labelCodigo.setBounds(408, 254, 73, 38);
		}
		return labelCodigo;
	}
	
	
	private JLabel LabelCIF(){
		if(labelCIF==null){
			labelCIF = new JLabel("");
			labelCIF.setForeground(Color.WHITE);
			labelCIF.setFont(new Font("Tahoma", Font.BOLD, 11));
			labelCIF.setBounds(355, 91, 73, 18);
		}
		return labelCIF;
	}
	
	private JLabel LabelName(){
		if(labelName==null){
			labelName = new JLabel("");
			labelName.setForeground(Color.WHITE);
			labelName.setFont(new Font("Tahoma", Font.BOLD, 11));
			labelName.setBounds(505, 91, 190, 18);
			}
		return labelName;
	}
	
	private JLabel LabelCreditos(){
		if(labelCréditos==null){
			labelCréditos = new JLabel();
			labelCréditos.setForeground(Color.WHITE);
			labelCréditos.setFont(new Font("Tahoma", Font.BOLD, 11));
			labelCréditos.setBounds(858, 254, 63, 38);
		}
		return labelCréditos;
	}
	
	private void TablaAsignaturas(JTable table) throws ClassNotFoundException, SQLException{
		TableModel defaultTableModel = new TableModel();
		LinkedList<Asignatura> asignaturas= new LinkedList<Asignatura>();
		asignaturas = AsigList.getAsignaturas();
		ArrayList<Object> columnDataCuatrimestre = new ArrayList<Object>();
		ArrayList<Object> columnDataCodigo = new ArrayList<Object>();
		ArrayList<Object> columnDataAsignaturas = new ArrayList<Object>();
		ArrayList<Object> columnDataEstado = new ArrayList<Object>();
		for(int i=0;i<asignaturas.size();i++){
			columnDataCuatrimestre.add(asignaturas.get(i).getCuatrimestre());
			columnDataCodigo.add(asignaturas.get(i).getCodigo());
			columnDataAsignaturas.add(asignaturas.get(i).getDescripcionAsig());
			columnDataEstado.add(asignaturas.get(i).getEstado());
		}
		defaultTableModel.setRowCount(asignaturas.size());
		defaultTableModel.addColumn("CUATRI.", columnDataCuatrimestre.toArray());
		defaultTableModel.addColumn("CÓD.",columnDataCodigo.toArray());
		defaultTableModel.addColumn("ASIG.",columnDataAsignaturas.toArray());
		defaultTableModel.addColumn("ESTADO",columnDataEstado.toArray());
		
		table.setModel(defaultTableModel);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setDefaultRenderer (Object.class, new FormatoTabla());
		table.setRowHeight(60);		
		
		
		TableColumn columnaCuatrimestre = table.getColumn("CUATRI.");
		columnaCuatrimestre.setMinWidth(50);
		columnaCuatrimestre.setMaxWidth(50);
		columnaCuatrimestre.setPreferredWidth(50);
		
		TableColumn columnaCodigo = table.getColumn("CÓD.");
		columnaCodigo.setMinWidth(60);
		columnaCodigo.setMaxWidth(60);
		columnaCodigo.setPreferredWidth(60);
		
		TableColumn columnaAsignatura = table.getColumn("ASIG.");
		columnaAsignatura.setMinWidth(120);	
		columnaAsignatura.setMaxWidth(120);
		columnaAsignatura.setPreferredWidth(120);
		
	}
	
	private void TablaClases(JTable table, LinkedList<Clase> clases){		
		TableModel defaultTableModel = new TableModel();
	    ArrayList<Object> columnDataCampus = new ArrayList<Object>();
		ArrayList<Object> columnDataAula = new ArrayList<Object>();
		ArrayList<Object> columnDataGrupo = new ArrayList<Object>();
		ArrayList<Object> columnDataLunes = new ArrayList<Object>();
		ArrayList<Object> columnDataMartes = new ArrayList<Object>();
		ArrayList<Object> columnDataMiercoles = new ArrayList<Object>();
		ArrayList<Object> columnDataJueves = new ArrayList<Object>();
		ArrayList<Object> columnDataViernes = new ArrayList<Object>();
		ArrayList<Object> columnDataSabado = new ArrayList<Object>();
		ArrayList<Object> columnDataDomingo = new ArrayList<Object>();
		ArrayList<Object> columnDataProfesor = new ArrayList<Object>();
		ArrayList<Object> columnDataSeleccionar = new ArrayList<Object>();
		for(int i=0;i<clases.size();i++){
			columnDataCampus.add(clases.get(i).getCampus());
			columnDataAula.add(clases.get(i).getAula());
			columnDataGrupo.add(clases.get(i).getGrupo());
			columnDataProfesor.add(clases.get(i).getNombreProfesor());
			if(clases.get(i).isSeleccion()==true){
				columnDataSeleccionar.add(true);
			}else{
				columnDataSeleccionar.add(false);
			}
			if(clases.get(i).getGrupo().equals("43013")){				
			for(int j = 0; j<clases.get(i).DaysListFisica1().size();j++){
				if(clases.get(i).DaysListFisica1().get(j).getDescripción().equals("Lunes")){
					if(clases.get(i).DaysListFisica1().get(j).getHoraInicio()!=0){
					columnDataLunes.add("<html>"+clases.get(i).DaysListFisica1().get(j).getHoraInicio()+":00"+"<br>"+clases.get(i).DaysListFisica1().get(j).getHoraFinal()+":00"+"</htmal>");
				}else{
					columnDataLunes.add(null);
					}
				}
				if(clases.get(i).DaysListFisica1().get(j).getDescripción().equals("Martes")){
					if(clases.get(i).DaysListFisica1().get(j).getHoraInicio()!=0){
					columnDataMartes.add("<html>"+clases.get(i).DaysListFisica1().get(j).getHoraInicio()+":00"+"<br>"+clases.get(i).DaysListFisica1().get(j).getHoraFinal()+":00"+"</htmal>");
					}else{
						columnDataMartes.add(null);
					}
				}
				if(clases.get(i).DaysListFisica1().get(j).getDescripción().equals("Miércoles")){
					if(clases.get(i).DaysListFisica1().get(j).getHoraInicio()!=0){
					columnDataMiercoles.add("<html>"+clases.get(i).DaysListFisica1().get(j).getHoraInicio()+":00"+"<br>"+clases.get(i).DaysListFisica1().get(j).getHoraFinal()+":00"+"</htmal>");
					}else{
						columnDataMiercoles.add(null);
					}
				}
				if(clases.get(i).DaysListFisica1().get(j).getDescripción().equals("Jueves")){
					if(clases.get(i).DaysListFisica1().get(j).getHoraInicio()!=0){
					columnDataJueves.add("<html>"+clases.get(i).DaysListFisica1().get(j).getHoraInicio()+":00"+"<br>"+clases.get(i).DaysListFisica1().get(j).getHoraFinal()+":00"+"</htmal>");
					}else{
						columnDataJueves.add(null);
					}
				}
				if(clases.get(i).DaysListFisica1().get(j).getDescripción().equals("Viernes")){
					if(clases.get(i).DaysListFisica1().get(j).getHoraInicio()!=0){
					columnDataViernes.add("<html>"+clases.get(i).DaysListFisica1().get(j).getHoraInicio()+":00"+"<br>"+clases.get(i).DaysListFisica1().get(j).getHoraFinal()+":00"+"</htmal>");
					}else{
						columnDataViernes.add(null);
					}
				}
				if(clases.get(i).DaysListFisica1().get(j).getDescripción().equals("Sábado")){
					if(clases.get(i).DaysListFisica1().get(j).getHoraInicio()!=0){
					columnDataSabado.add("<html>"+clases.get(i).DaysListFisica1().get(j).getHoraInicio()+":00"+"<br>"+clases.get(i).DaysListFisica1().get(j).getHoraFinal()+":00"+"</htmal>");
					}else{
						columnDataSabado.add(null);
					}
				}
				if(clases.get(i).DaysListFisica1().get(j).getDescripción().equals("Domingo")){
					if(clases.get(i).DaysListFisica1().get(j).getHoraInicio()!=0){
					columnDataDomingo.add("<html>"+clases.get(i).DaysListFisica1().get(j).getHoraInicio()+":00"+"<br>"+clases.get(i).DaysListFisica1().get(j).getHoraFinal()+":00"+"</htmal>");
					}else{
						columnDataDomingo.add(null);
					}
				}
			
			}
		}
			
			if(clases.get(i).getGrupo().equals("2")){
				for(int j = 0; j<clases.get(i).DaysListFisica2().size();j++){
					if(clases.get(i).DaysListFisica2().get(j).getDescripción().equals("Lunes")){
						if(clases.get(i).DaysListFisica2().get(j).getHoraInicio()!=0){
						columnDataLunes.add("<html>"+clases.get(i).DaysListFisica2().get(j).getHoraInicio()+":00"+"<br>"+clases.get(i).DaysListFisica2().get(j).getHoraFinal()+":00"+"</htmal>");
					}else{
						columnDataLunes.add(null);
						}
					}
					if(clases.get(i).DaysListFisica2().get(j).getDescripción().equals("Martes")){
						if(clases.get(i).DaysListFisica2().get(j).getHoraInicio()!=0){
						columnDataMartes.add("<html>"+clases.get(i).DaysListFisica2().get(j).getHoraInicio()+":00"+"<br>"+clases.get(i).DaysListFisica2().get(j).getHoraFinal()+":00"+"</htmal>");
						}else{
							columnDataMartes.add(null);
						}
					}
					if(clases.get(i).DaysListFisica2().get(j).getDescripción().equals("Miércoles")){
						if(clases.get(i).DaysListFisica2().get(j).getHoraInicio()!=0){
						columnDataMiercoles.add("<html>"+clases.get(i).DaysListFisica2().get(j).getHoraInicio()+":00"+"<br>"+clases.get(i).DaysListFisica2().get(j).getHoraFinal()+":00"+"</htmal>");
						}else{
							columnDataMiercoles.add(null);
						}
					}
					if(clases.get(i).DaysListFisica2().get(j).getDescripción().equals("Jueves")){
						if(clases.get(i).DaysListFisica2().get(j).getHoraInicio()!=0){
						columnDataJueves.add("<html>"+clases.get(i).DaysListFisica2().get(j).getHoraInicio()+":00"+"<br>"+clases.get(i).DaysListFisica2().get(j).getHoraFinal()+":00"+"</htmal>");
						}else{
							columnDataJueves.add(null);
						}
					}
					if(clases.get(i).DaysListFisica2().get(j).getDescripción().equals("Viernes")){
						if(clases.get(i).DaysListFisica2().get(j).getHoraInicio()!=0){
						columnDataViernes.add("<html>"+clases.get(i).DaysListFisica2().get(j).getHoraInicio()+":00"+"<br>"+clases.get(i).DaysListFisica2().get(j).getHoraFinal()+":00"+"</htmal>");
						}else{
							columnDataViernes.add(null);
						}
					}
					if(clases.get(i).DaysListFisica2().get(j).getDescripción().equals("Sábado")){
						if(clases.get(i).DaysListFisica2().get(j).getHoraInicio()!=0){
						columnDataSabado.add("<html>"+clases.get(i).DaysListFisica2().get(j).getHoraInicio()+":00"+"<br>"+clases.get(i).DaysListFisica2().get(j).getHoraFinal()+":00"+"</htmal>");
						}else{
							columnDataSabado.add(null);
						}
					}
					if(clases.get(i).DaysListFisica2().get(j).getDescripción().equals("Domingo")){
						if(clases.get(i).DaysListFisica2().get(j).getHoraInicio()!=0){
						columnDataDomingo.add("<html>"+clases.get(i).DaysListFisica2().get(j).getHoraInicio()+":00"+"<br>"+clases.get(i).DaysListFisica2().get(j).getHoraFinal()+":00"+"</htmal>");
						}else{
							columnDataDomingo.add(null);
						}
					}
				
				}
			}
			
			if(clases.get(i).getGrupo().equals("202")){
				for(int j = 0; j<clases.get(i).DaysListLiderazgo2().size();j++){
					if(clases.get(i).DaysListLiderazgo2().get(j).getDescripción().equals("Lunes")){
						if(clases.get(i).DaysListLiderazgo2().get(j).getHoraInicio()!=0){
						columnDataLunes.add("<html>"+clases.get(i).DaysListLiderazgo2().get(j).getHoraInicio()+":00"+"<br>"+clases.get(i).DaysListLiderazgo2().get(j).getHoraFinal()+":00"+"</htmal>");
					}else{
						columnDataLunes.add(null);
						}
					}
					if(clases.get(i).DaysListLiderazgo2().get(j).getDescripción().equals("Martes")){
						if(clases.get(i).DaysListLiderazgo2().get(j).getHoraInicio()!=0){
						columnDataMartes.add("<html>"+clases.get(i).DaysListLiderazgo2().get(j).getHoraInicio()+":00"+"<br>"+clases.get(i).DaysListLiderazgo2().get(j).getHoraFinal()+":00"+"</htmal>");
						}else{
							columnDataMartes.add(null);
						}
					}
					if(clases.get(i).DaysListLiderazgo2().get(j).getDescripción().equals("Miércoles")){
						if(clases.get(i).DaysListLiderazgo2().get(j).getHoraInicio()!=0){
						columnDataMiercoles.add("<html>"+clases.get(i).DaysListLiderazgo2().get(j).getHoraInicio()+":00"+"<br>"+clases.get(i).DaysListLiderazgo2().get(j).getHoraFinal()+":00"+"</htmal>");
						}else{
							columnDataMiercoles.add(null);
						}
					}
					if(clases.get(i).DaysListLiderazgo2().get(j).getDescripción().equals("Jueves")){
						if(clases.get(i).DaysListLiderazgo2().get(j).getHoraInicio()!=0){
						columnDataJueves.add("<html>"+clases.get(i).DaysListLiderazgo2().get(j).getHoraInicio()+":00"+"<br>"+clases.get(i).DaysListLiderazgo2().get(j).getHoraFinal()+":00"+"</htmal>");
						}else{
							columnDataJueves.add(null);
						}
					}
					if(clases.get(i).DaysListLiderazgo2().get(j).getDescripción().equals("Viernes")){
						if(clases.get(i).DaysListLiderazgo2().get(j).getHoraInicio()!=0){
						columnDataViernes.add("<html>"+clases.get(i).DaysListLiderazgo2().get(j).getHoraInicio()+":00"+"<br>"+clases.get(i).DaysListLiderazgo2().get(j).getHoraFinal()+":00"+"</htmal>");
						}else{
							columnDataViernes.add(null);
						}
					}
					if(clases.get(i).DaysListLiderazgo2().get(j).getDescripción().equals("Sábado")){
						if(clases.get(i).DaysListLiderazgo2().get(j).getHoraInicio()!=0){
						columnDataSabado.add("<html>"+clases.get(i).DaysListLiderazgo2().get(j).getHoraInicio()+":00"+"<br>"+clases.get(i).DaysListLiderazgo2().get(j).getHoraFinal()+":00"+"</htmal>");
						}else{
							columnDataSabado.add(null);
						}
					}
					if(clases.get(i).DaysListLiderazgo2().get(j).getDescripción().equals("Domingo")){
						if(clases.get(i).DaysListLiderazgo2().get(j).getHoraInicio()!=0){
						columnDataDomingo.add("<html>"+clases.get(i).DaysListLiderazgo2().get(j).getHoraInicio()+":00"+"<br>"+clases.get(i).DaysListLiderazgo2().get(j).getHoraFinal()+":00"+"</htmal>");
						}else{
							columnDataDomingo.add(null);
						}
					}
				
				}
			}
			
			if(clases.get(i).getGrupo().equals("2013")){
				for(int j = 0; j<clases.get(i).DaysListLiderazgo1().size();j++){
					if(clases.get(i).DaysListLiderazgo1().get(j).getDescripción().equals("Lunes")){
						if(clases.get(i).DaysListLiderazgo1().get(j).getHoraInicio()!=0){
						columnDataLunes.add("<html>"+clases.get(i).DaysListLiderazgo1().get(j).getHoraInicio()+":00"+"<br>"+clases.get(i).DaysListLiderazgo1().get(j).getHoraFinal()+":00"+"</htmal>");
					}else{
						columnDataLunes.add(null);
						}
					}
					if(clases.get(i).DaysListLiderazgo1().get(j).getDescripción().equals("Martes")){
						if(clases.get(i).DaysListLiderazgo1().get(j).getHoraInicio()!=0){
						columnDataMartes.add("<html>"+clases.get(i).DaysListLiderazgo1().get(j).getHoraInicio()+":00"+"<br>"+clases.get(i).DaysListLiderazgo1().get(j).getHoraFinal()+":00"+"</htmal>");
						}else{
							columnDataMartes.add(null);
						}
					}
					if(clases.get(i).DaysListLiderazgo1().get(j).getDescripción().equals("Miércoles")){
						if(clases.get(i).DaysListLiderazgo1().get(j).getHoraInicio()!=0){
						columnDataMiercoles.add("<html>"+clases.get(i).DaysListLiderazgo1().get(j).getHoraInicio()+":00"+"<br>"+clases.get(i).DaysListLiderazgo1().get(j).getHoraFinal()+":00"+"</htmal>");
						}else{
							columnDataMiercoles.add(null);
						}
					}
					if(clases.get(i).DaysListLiderazgo1().get(j).getDescripción().equals("Jueves")){
						if(clases.get(i).DaysListLiderazgo1().get(j).getHoraInicio()!=0){
						columnDataJueves.add("<html>"+clases.get(i).DaysListLiderazgo1().get(j).getHoraInicio()+":00"+"<br>"+clases.get(i).DaysListLiderazgo1().get(j).getHoraFinal()+":00"+"</htmal>");
						}else{
							columnDataJueves.add(null);
						}
					}
					if(clases.get(i).DaysListLiderazgo1().get(j).getDescripción().equals("Viernes")){
						if(clases.get(i).DaysListLiderazgo1().get(j).getHoraInicio()!=0){
						columnDataViernes.add("<html>"+clases.get(i).DaysListLiderazgo1().get(j).getHoraInicio()+":00"+"<br>"+clases.get(i).DaysListLiderazgo1().get(j).getHoraFinal()+":00"+"</htmal>");
						}else{
							columnDataViernes.add(null);
						}
					}
					if(clases.get(i).DaysListLiderazgo1().get(j).getDescripción().equals("Sábado")){
						if(clases.get(i).DaysListLiderazgo1().get(j).getHoraInicio()!=0){
						columnDataSabado.add("<html>"+clases.get(i).DaysListLiderazgo1().get(j).getHoraInicio()+":00"+"<br>"+clases.get(i).DaysListLiderazgo1().get(j).getHoraFinal()+":00"+"</htmal>");
						}else{
							columnDataSabado.add(null);
						}
					}
					if(clases.get(i).DaysListLiderazgo1().get(j).getDescripción().equals("Domingo")){
						if(clases.get(i).DaysListLiderazgo1().get(j).getHoraInicio()!=0){
						columnDataDomingo.add("<html>"+clases.get(i).DaysListLiderazgo1().get(j).getHoraInicio()+":00"+"<br>"+clases.get(i).DaysListLiderazgo1().get(j).getHoraFinal()+":00"+"</htmal>");
						}else{
							columnDataDomingo.add(null);
						}
					}
				
				}
			}
			if(clases.get(i).getGrupo().equals("20")){
				for(int j = 0; j<clases.get(i).DaysListProgramacion1().size();j++){
					if(clases.get(i).DaysListProgramacion1().get(j).getDescripción().equals("Lunes")){
						if(clases.get(i).DaysListProgramacion1().get(j).getHoraInicio()!=0){
						columnDataLunes.add("<html>"+clases.get(i).DaysListProgramacion1().get(j).getHoraInicio()+":00"+"<br>"+clases.get(i).DaysListProgramacion1().get(j).getHoraFinal()+":00"+"</htmal>");
					}else{
						columnDataLunes.add(null);
						}
					}
					if(clases.get(i).DaysListProgramacion1().get(j).getDescripción().equals("Martes")){
						if(clases.get(i).DaysListProgramacion1().get(j).getHoraInicio()!=0){
						columnDataMartes.add("<html>"+clases.get(i).DaysListProgramacion1().get(j).getHoraInicio()+":00"+"<br>"+clases.get(i).DaysListProgramacion1().get(j).getHoraFinal()+":00"+"</htmal>");
						}else{
							columnDataMartes.add(null);
						}
					}
					if(clases.get(i).DaysListProgramacion1().get(j).getDescripción().equals("Miércoles")){
						if(clases.get(i).DaysListProgramacion1().get(j).getHoraInicio()!=0){
						columnDataMiercoles.add("<html>"+clases.get(i).DaysListProgramacion1().get(j).getHoraInicio()+":00"+"<br>"+clases.get(i).DaysListProgramacion1().get(j).getHoraFinal()+":00"+"</htmal>");
						}else{
							columnDataMiercoles.add(null);
						}
					}
					if(clases.get(i).DaysListProgramacion1().get(j).getDescripción().equals("Jueves")){
						if(clases.get(i).DaysListProgramacion1().get(j).getHoraInicio()!=0){
						columnDataJueves.add("<html>"+clases.get(i).DaysListProgramacion1().get(j).getHoraInicio()+":00"+"<br>"+clases.get(i).DaysListProgramacion1().get(j).getHoraFinal()+":00"+"</htmal>");
						}else{
							columnDataJueves.add(null);
						}
					}
					if(clases.get(i).DaysListProgramacion1().get(j).getDescripción().equals("Viernes")){
						if(clases.get(i).DaysListProgramacion1().get(j).getHoraInicio()!=0){
						columnDataViernes.add("<html>"+clases.get(i).DaysListProgramacion1().get(j).getHoraInicio()+":00"+"<br>"+clases.get(i).DaysListProgramacion1().get(j).getHoraFinal()+":00"+"</htmal>");
						}else{
							columnDataViernes.add(null);
						}
					}
					if(clases.get(i).DaysListProgramacion1().get(j).getDescripción().equals("Sábado")){
						if(clases.get(i).DaysListProgramacion1().get(j).getHoraInicio()!=0){
						columnDataSabado.add("<html>"+clases.get(i).DaysListProgramacion1().get(j).getHoraInicio()+":00"+"<br>"+clases.get(i).DaysListProgramacion1().get(j).getHoraFinal()+":00"+"</htmal>");
						}else{
							columnDataSabado.add(null);
						}
					}
					if(clases.get(i).DaysListProgramacion1().get(j).getDescripción().equals("Domingo")){
						if(clases.get(i).DaysListProgramacion1().get(j).getHoraInicio()!=0){
						columnDataDomingo.add("<html>"+clases.get(i).DaysListProgramacion1().get(j).getHoraInicio()+":00"+"<br>"+clases.get(i).DaysListProgramacion1().get(j).getHoraFinal()+":00"+"</htmal>");
						}else{
							columnDataDomingo.add(null);
						}
					}
				
				}
			}
			
			if(clases.get(i).getGrupo().equals("1201")){
				for(int j = 0; j<clases.get(i).DaysListProgramacion().size();j++){
					if(clases.get(i).DaysListProgramacion().get(j).getDescripción().equals("Lunes")){
						if(clases.get(i).DaysListProgramacion().get(j).getHoraInicio()!=0){
						columnDataLunes.add("<html>"+clases.get(i).DaysListProgramacion().get(j).getHoraInicio()+":00"+"<br>"+clases.get(i).DaysListProgramacion().get(j).getHoraFinal()+":00"+"</htmal>");
					}else{
						columnDataLunes.add(null);
						}
					}
					if(clases.get(i).DaysListProgramacion().get(j).getDescripción().equals("Martes")){
						if(clases.get(i).DaysListProgramacion().get(j).getHoraInicio()!=0){
						columnDataMartes.add("<html>"+clases.get(i).DaysListProgramacion().get(j).getHoraInicio()+":00"+"<br>"+clases.get(i).DaysListProgramacion().get(j).getHoraFinal()+":00"+"</htmal>");
						}else{
							columnDataMartes.add(null);
						}
					}
					if(clases.get(i).DaysListProgramacion().get(j).getDescripción().equals("Miércoles")){
						if(clases.get(i).DaysListProgramacion().get(j).getHoraInicio()!=0){
						columnDataMiercoles.add("<html>"+clases.get(i).DaysListProgramacion().get(j).getHoraInicio()+":00"+"<br>"+clases.get(i).DaysListProgramacion().get(j).getHoraFinal()+":00"+"</htmal>");
						}else{
							columnDataMiercoles.add(null);
						}
					}
					if(clases.get(i).DaysListProgramacion().get(j).getDescripción().equals("Jueves")){
						if(clases.get(i).DaysListProgramacion().get(j).getHoraInicio()!=0){
						columnDataJueves.add("<html>"+clases.get(i).DaysListProgramacion().get(j).getHoraInicio()+":00"+"<br>"+clases.get(i).DaysListProgramacion().get(j).getHoraFinal()+":00"+"</htmal>");
						}else{
							columnDataJueves.add(null);
						}
					}
					if(clases.get(i).DaysListProgramacion().get(j).getDescripción().equals("Viernes")){
						if(clases.get(i).DaysListProgramacion().get(j).getHoraInicio()!=0){
						columnDataViernes.add("<html>"+clases.get(i).DaysListProgramacion().get(j).getHoraInicio()+":00"+"<br>"+clases.get(i).DaysListProgramacion().get(j).getHoraFinal()+":00"+"</htmal>");
						}else{
							columnDataViernes.add(null);
						}
					}
					if(clases.get(i).DaysListProgramacion().get(j).getDescripción().equals("Sábado")){
						if(clases.get(i).DaysListProgramacion().get(j).getHoraInicio()!=0){
						columnDataSabado.add("<html>"+clases.get(i).DaysListProgramacion().get(j).getHoraInicio()+":00"+"<br>"+clases.get(i).DaysListProgramacion().get(j).getHoraFinal()+":00"+"</htmal>");
						}else{
							columnDataSabado.add(null);
						}
					}
					if(clases.get(i).DaysListProgramacion().get(j).getDescripción().equals("Domingo")){
						if(clases.get(i).DaysListProgramacion().get(j).getHoraInicio()!=0){
						columnDataDomingo.add("<html>"+clases.get(i).DaysListProgramacion().get(j).getHoraInicio()+":00"+"<br>"+clases.get(i).DaysListProgramacion().get(j).getHoraFinal()+":00"+"</htmal>");
						}else{
							columnDataDomingo.add(null);
						}
					}
				
				}
			}
			
			if(clases.get(i).getGrupo().equals("234")){
				for(int j = 0; j<clases.get(i).DaysListFisica3().size();j++){
					if(clases.get(i).DaysListFisica3().get(j).getDescripción().equals("Lunes")){
						if(clases.get(i).DaysListFisica3().get(j).getHoraInicio()!=0){
						columnDataLunes.add("<html>"+clases.get(i).DaysListFisica3().get(j).getHoraInicio()+":00"+"<br>"+clases.get(i).DaysListFisica3().get(j).getHoraFinal()+":00"+"</htmal>");
					}else{
						columnDataLunes.add(null);
						}
					}
					if(clases.get(i).DaysListFisica3().get(j).getDescripción().equals("Martes")){
						if(clases.get(i).DaysListFisica3().get(j).getHoraInicio()!=0){
						columnDataMartes.add("<html>"+clases.get(i).DaysListFisica3().get(j).getHoraInicio()+":00"+"<br>"+clases.get(i).DaysListFisica3().get(j).getHoraFinal()+":00"+"</htmal>");
						}else{
							columnDataMartes.add(null);
						}
					}
					if(clases.get(i).DaysListFisica3().get(j).getDescripción().equals("Miércoles")){
						if(clases.get(i).DaysListFisica3().get(j).getHoraInicio()!=0){
						columnDataMiercoles.add("<html>"+clases.get(i).DaysListFisica3().get(j).getHoraInicio()+":00"+"<br>"+clases.get(i).DaysListFisica3().get(j).getHoraFinal()+":00"+"</htmal>");
						}else{
							columnDataMiercoles.add(null);
						}
					}
					if(clases.get(i).DaysListFisica3().get(j).getDescripción().equals("Jueves")){
						if(clases.get(i).DaysListFisica3().get(j).getHoraInicio()!=0){
						columnDataJueves.add("<html>"+clases.get(i).DaysListFisica3().get(j).getHoraInicio()+":00"+"<br>"+clases.get(i).DaysListFisica3().get(j).getHoraFinal()+":00"+"</htmal>");
						}else{
							columnDataJueves.add(null);
						}
					}
					if(clases.get(i).DaysListFisica3().get(j).getDescripción().equals("Viernes")){
						if(clases.get(i).DaysListFisica3().get(j).getHoraInicio()!=0){
						columnDataViernes.add("<html>"+clases.get(i).DaysListFisica3().get(j).getHoraInicio()+":00"+"<br>"+clases.get(i).DaysListFisica3().get(j).getHoraFinal()+":00"+"</htmal>");
						}else{
							columnDataViernes.add(null);
						}
					}
					if(clases.get(i).DaysListFisica3().get(j).getDescripción().equals("Sábado")){
						if(clases.get(i).DaysListFisica3().get(j).getHoraInicio()!=0){
						columnDataSabado.add("<html>"+clases.get(i).DaysListFisica3().get(j).getHoraInicio()+":00"+"<br>"+clases.get(i).DaysListFisica3().get(j).getHoraFinal()+":00"+"</htmal>");
						}else{
							columnDataSabado.add(null);
						}
					}
					if(clases.get(i).DaysListFisica3().get(j).getDescripción().equals("Domingo")){
						if(clases.get(i).DaysListFisica3().get(j).getHoraInicio()!=0){
						columnDataDomingo.add("<html>"+clases.get(i).DaysListFisica3().get(j).getHoraInicio()+":00"+"<br>"+clases.get(i).DaysListFisica3().get(j).getHoraFinal()+":00"+"</htmal>");
						}else{
							columnDataDomingo.add(null);
						}
					}
				
				}
			}
			
			if(clases.get(i).getGrupo().equals("12013")){
				for(int j = 0; j<clases.get(i).DaysListMatematica1().size();j++){
					if(clases.get(i).DaysListMatematica1().get(j).getDescripción().equals("Lunes")){
						if(clases.get(i).DaysListMatematica1().get(j).getHoraInicio()!=0){
						columnDataLunes.add("<html>"+clases.get(i).DaysListMatematica1().get(j).getHoraInicio()+":00"+"<br>"+clases.get(i).DaysListMatematica1().get(j).getHoraFinal()+":00"+"</htmal>");
					}else{
						columnDataLunes.add(null);
						}
					}
					if(clases.get(i).DaysListMatematica1().get(j).getDescripción().equals("Martes")){
						if(clases.get(i).DaysListMatematica1().get(j).getHoraInicio()!=0){
						columnDataMartes.add("<html>"+clases.get(i).DaysListMatematica1().get(j).getHoraInicio()+":00"+"<br>"+clases.get(i).DaysListMatematica1().get(j).getHoraFinal()+":00"+"</htmal>");
						}else{
							columnDataMartes.add(null);
						}
					}
					if(clases.get(i).DaysListMatematica1().get(j).getDescripción().equals("Miércoles")){
						if(clases.get(i).DaysListMatematica1().get(j).getHoraInicio()!=0){
						columnDataMiercoles.add("<html>"+clases.get(i).DaysListMatematica1().get(j).getHoraInicio()+":00"+"<br>"+clases.get(i).DaysListMatematica1().get(j).getHoraFinal()+":00"+"</htmal>");
						}else{
							columnDataMiercoles.add(null);
						}
					}
					if(clases.get(i).DaysListMatematica1().get(j).getDescripción().equals("Jueves")){
						if(clases.get(i).DaysListMatematica1().get(j).getHoraInicio()!=0){
						columnDataJueves.add("<html>"+clases.get(i).DaysListMatematica1().get(j).getHoraInicio()+":00"+"<br>"+clases.get(i).DaysListMatematica1().get(j).getHoraFinal()+":00"+"</htmal>");
						}else{
							columnDataJueves.add(null);
						}
					}
					if(clases.get(i).DaysListMatematica1().get(j).getDescripción().equals("Viernes")){
						if(clases.get(i).DaysListMatematica1().get(j).getHoraInicio()!=0){
						columnDataViernes.add("<html>"+clases.get(i).DaysListMatematica1().get(j).getHoraInicio()+":00"+"<br>"+clases.get(i).DaysListMatematica1().get(j).getHoraFinal()+":00"+"</htmal>");
						}else{
							columnDataViernes.add(null);
						}
					}
					if(clases.get(i).DaysListMatematica1().get(j).getDescripción().equals("Sábado")){
						if(clases.get(i).DaysListMatematica1().get(j).getHoraInicio()!=0){
						columnDataSabado.add("<html>"+clases.get(i).DaysListMatematica1().get(j).getHoraInicio()+":00"+"<br>"+clases.get(i).DaysListMatematica1().get(j).getHoraFinal()+":00"+"</htmal>");
						}else{
							columnDataSabado.add(null);
						}
					}
					if(clases.get(i).DaysListMatematica1().get(j).getDescripción().equals("Domingo")){
						if(clases.get(i).DaysListMatematica1().get(j).getHoraInicio()!=0){
						columnDataDomingo.add("<html>"+clases.get(i).DaysListMatematica1().get(j).getHoraInicio()+":00"+"<br>"+clases.get(i).DaysListMatematica1().get(j).getHoraFinal()+":00"+"</htmal>");
						}else{
							columnDataDomingo.add(null);
						}
					}
				
				
				}
			}
			
			if(clases.get(i).getGrupo().equals("2023")){
				for(int j = 0; j<clases.get(i).DaysListMatematica2().size();j++){
					if(clases.get(i).DaysListMatematica2().get(j).getDescripción().equals("Lunes")){
						if(clases.get(i).DaysListMatematica2().get(j).getHoraInicio()!=0){
						columnDataLunes.add("<html>"+clases.get(i).DaysListMatematica2().get(j).getHoraInicio()+":00"+"<br>"+clases.get(i).DaysListMatematica2().get(j).getHoraFinal()+":00"+"</htmal>");
					}else{
						columnDataLunes.add(null);
						}
					}
					if(clases.get(i).DaysListMatematica2().get(j).getDescripción().equals("Martes")){
						if(clases.get(i).DaysListMatematica2().get(j).getHoraInicio()!=0){
						columnDataMartes.add("<html>"+clases.get(i).DaysListMatematica2().get(j).getHoraInicio()+":00"+"<br>"+clases.get(i).DaysListMatematica2().get(j).getHoraFinal()+":00"+"</htmal>");
						}else{
							columnDataMartes.add(null);
						}
					}
					if(clases.get(i).DaysListMatematica2().get(j).getDescripción().equals("Miércoles")){
						if(clases.get(i).DaysListMatematica2().get(j).getHoraInicio()!=0){
						columnDataMiercoles.add("<html>"+clases.get(i).DaysListMatematica2().get(j).getHoraInicio()+":00"+"<br>"+clases.get(i).DaysListMatematica2().get(j).getHoraFinal()+":00"+"</htmal>");
						}else{
							columnDataMiercoles.add(null);
						}
					}
					if(clases.get(i).DaysListMatematica2().get(j).getDescripción().equals("Jueves")){
						if(clases.get(i).DaysListMatematica2().get(j).getHoraInicio()!=0){
						columnDataJueves.add("<html>"+clases.get(i).DaysListMatematica2().get(j).getHoraInicio()+":00"+"<br>"+clases.get(i).DaysListMatematica2().get(j).getHoraFinal()+":00"+"</htmal>");
						}else{
							columnDataJueves.add(null);
						}
					}
					if(clases.get(i).DaysListMatematica2().get(j).getDescripción().equals("Viernes")){
						if(clases.get(i).DaysListMatematica2().get(j).getHoraInicio()!=0){
						columnDataViernes.add("<html>"+clases.get(i).DaysListMatematica2().get(j).getHoraInicio()+":00"+"<br>"+clases.get(i).DaysListMatematica2().get(j).getHoraFinal()+":00"+"</htmal>");
						}else{
							columnDataViernes.add(null);
						}
					}
					if(clases.get(i).DaysListMatematica2().get(j).getDescripción().equals("Sábado")){
						if(clases.get(i).DaysListMatematica2().get(j).getHoraInicio()!=0){
						columnDataSabado.add("<html>"+clases.get(i).DaysListMatematica2().get(j).getHoraInicio()+":00"+"<br>"+clases.get(i).DaysListMatematica2().get(j).getHoraFinal()+":00"+"</htmal>");
						}else{
							columnDataSabado.add(null);
						}
					}
					if(clases.get(i).DaysListMatematica2().get(j).getDescripción().equals("Domingo")){
						if(clases.get(i).DaysListMatematica2().get(j).getHoraInicio()!=0){
						columnDataDomingo.add("<html>"+clases.get(i).DaysListMatematica2().get(j).getHoraInicio()+":00"+"<br>"+clases.get(i).DaysListMatematica2().get(j).getHoraFinal()+":00"+"</htmal>");
						}else{
							columnDataDomingo.add(null);
						}
					}
				
				
				}
			}		
		}
			defaultTableModel.setRowCount(clases.size());
			defaultTableModel.addColumn("CAMPUS", columnDataCampus.toArray());
			defaultTableModel.addColumn("AULA",columnDataAula.toArray());
			defaultTableModel.addColumn("GRUPO",columnDataGrupo.toArray());
			defaultTableModel.addColumn("L",columnDataLunes.toArray());
			defaultTableModel.addColumn("K",columnDataMartes.toArray());
			defaultTableModel.addColumn("M",columnDataMiercoles.toArray());
			defaultTableModel.addColumn("J",columnDataJueves.toArray());
			defaultTableModel.addColumn("V",columnDataViernes.toArray());
			defaultTableModel.addColumn("S",columnDataSabado.toArray());
			defaultTableModel.addColumn("D",columnDataDomingo.toArray());
			defaultTableModel.addColumn("PROF.",columnDataProfesor.toArray());
			defaultTableModel.addColumn("MATRICULAR",columnDataSeleccionar.toArray());
			table.setModel(defaultTableModel);
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table.setDefaultRenderer (Object.class, new FormatoTablaAsignaturas());
			table.setRowHeight(80);	
			
			PonerCheckBox(table, table.getColumnModel().getColumn(11));
			
			TableColumn columnaProfesor = table.getColumn("PROF.");
			columnaProfesor.setMinWidth(70);	
			columnaProfesor.setMaxWidth(70);
			columnaProfesor.setPreferredWidth(70);
			
			TableColumn columnaGrupo = table.getColumn("GRUPO");
			columnaGrupo.setMinWidth(50);	
			columnaGrupo.setMaxWidth(50);
			columnaGrupo.setPreferredWidth(50);
			
			TableColumn columnaMatricular = table.getColumn("MATRICULAR");
			columnaMatricular.setMinWidth(90);	
			columnaMatricular.setMaxWidth(90);
			columnaMatricular.setPreferredWidth(90);
			
			TableColumn columnaCAmpus = table.getColumn("CAMPUS");
			columnaCAmpus.setMinWidth(70);	
			columnaCAmpus.setMaxWidth(70);
			columnaCAmpus.setPreferredWidth(70);	
	}
	
	
	public void PonerCheckBox(JTable tabla, TableColumn columna){
		JCheckBox combo= new JCheckBox();
		columna.setCellEditor(new DefaultCellEditor(combo));
		columna.setCellRenderer(new DefaultCellRenderer(combo));
	}
	
	public boolean ExisteClase(LinkedList<Clase> clases){
		boolean yes=false;
		for(Clase c: clases){
			if(c.isSeleccion()==false){
				yes=true;
			}
		}
		return yes;
	}
	
	public Asignatura BuscarAsignatura(String codigo){
		Asignatura a = new Asignatura();
		boolean found=false;
		LinkedList<Asignatura> asignaturas = new LinkedList<Asignatura>();
		asignaturas = AsigList.ListaAsig();
		Iterator<Asignatura> it = asignaturas.iterator();
		while(it.hasNext() && !found){
			Asignatura asig = it.next();
			if(asig.getCodigo().equalsIgnoreCase(codigo)){
				found = true;
				a=asig;
			}			
		}
		return a;
	}
	}
