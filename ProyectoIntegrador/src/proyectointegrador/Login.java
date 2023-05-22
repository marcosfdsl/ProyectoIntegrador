package proyectointegrador;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import javax.swing.table.*;

import java.sql.*;

public class Login extends JFrame {

	private JPanel lamina1;
	private JTextField txtUsuario;
	private JPasswordField txtContrasena;
	private JPanel interfaz;
	private JPanel panelRankings;
	private JPanel panelLuchadores;
	private JPanel panelEventos;
	private JPanel panelApuestas;
	private JTable tablaPesoPluma;
	private JPanel rankingPesoPluma;
	private JPanel rankingPesoMosca;
	private JPanel rankingPesoLigero;
	private JPanel rankingPesoMedio;
	private JPanel rankingPesoPesado;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;
	private JTable table_4;
	private JPasswordField txtRegistroContrasena;
	private JTextField txtRegistroNombre;
	private JPanel registrarse;
	private JPanel login;
	private JPasswordField txtRegistroConfirmarContrasena;
	private JPasswordField txtRegistroMail;
	private JLabel aviso;
	private JLabel accesoDenegado;

	static Connection miConexion;
	static Statement miStatement;
	static ResultSet miResultset;

	public static void main(String[] args) {

		Login frame = new Login();
		frame.setVisible(true);
	}

	public Login() {
		try {
			miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/ufc_db", "root", "");
			miStatement = miConexion.createStatement();
			miResultset = miStatement.executeQuery("SELECT Nombre FROM luchador WHERE division = 'Peso Pluma'");
			while (miResultset.next()) {
				// tablaPesoPluma.addRowSelectionInterval(1, miResultset.getString("Nombre"));

			}
			miResultset.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		lamina1 = new JPanel();
		lamina1.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(lamina1);
		lamina1.setLayout(null);
		final String usuario = "a";
		final String contrasena = "a";

		interfaz = new JPanel();
		interfaz.setBounds(0, 0, 986, 563);
		interfaz.setVisible(false);

		login = new JPanel();
		login.setBorder(new LineBorder(new Color(255, 0, 0)));
		login.setBackground(new Color(0, 0, 0));
		login.setBounds(298, 35, 389, 354);
		lamina1.add(login);
		login.setLayout(null);

		JPanel titulo = new JPanel();
		titulo.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		titulo.setBackground(new Color(255, 0, 0));
		titulo.setBounds(83, 10, 222, 54);
		login.add(titulo);

		JLabel labelTitulo2_1 = new JLabel("UFC DATABASE");
		labelTitulo2_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		titulo.add(labelTitulo2_1);
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			int cuenta = 0;

			public void actionPerformed(ActionEvent e) {
				if (txtUsuario.getText().equals(usuario)
						&& String.valueOf(txtContrasena.getPassword()).equals(contrasena)) {

					lamina1.setVisible(false);
					interfaz.setVisible(true);
					panelLuchadores.setVisible(true);

					setContentPane(interfaz);

				} else {
					accesoDenegado.setVisible(true);
					if (!(cuenta == 3)) {
						cuenta++;
						accesoDenegado.setText("Acceso denegado, intentos restantes: " + (4 - cuenta));
					} else
						System.exit(0);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(125, 269, 141, 37);
		login.add(btnNewButton);

		JLabel Contrasena = new JLabel("Contraseña:", SwingConstants.CENTER);
		Contrasena.setForeground(Color.red);
		Contrasena.setBounds(105, 161, 178, 42);
		login.add(Contrasena);
		Contrasena.setFont(new Font("Tahoma", Font.PLAIN, 23));

		txtContrasena = new JPasswordField();
		txtContrasena.setBounds(105, 213, 178, 19);
		login.add(txtContrasena);

		JLabel Usuario = new JLabel("Usuario:", SwingConstants.CENTER);
		Usuario.setBounds(105, 86, 178, 36);
		login.add(Usuario);
		Usuario.setForeground(Color.red);
		Usuario.setFont(new Font("Tahoma", Font.PLAIN, 23));

		txtUsuario = new JTextField();
		txtUsuario.setBounds(105, 132, 178, 19);
		login.add(txtUsuario);
		txtUsuario.setColumns(10);

		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login.setVisible(false);
				registrarse.setVisible(true);

			}
		});
		btnRegistrarse.setBounds(125, 311, 141, 33);
		login.add(btnRegistrarse);
		btnRegistrarse.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRegistrarse.setBackground(Color.RED);

		accesoDenegado = new JLabel("Acceso denegado", SwingConstants.CENTER);
		accesoDenegado.setForeground(Color.red);
		accesoDenegado.setBounds(68, 240, 253, 19);
		login.add(accesoDenegado);
		accesoDenegado.setVisible(false);

		registrarse = new JPanel();
		registrarse.setLayout(null);
		registrarse.setBorder(new LineBorder(new Color(255, 0, 0)));
		registrarse.setBackground(Color.BLACK);
		registrarse.setBounds(298, 35, 389, 421);
		lamina1.add(registrarse);
		registrarse.setVisible(false);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBackground(Color.RED);
		panel_1.setBounds(83, 10, 222, 43);
		registrarse.add(panel_1);

		JLabel labelTitulo = new JLabel("UFC DATABASE");
		labelTitulo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel_1.add(labelTitulo);

		JLabel Contrasena_1 = new JLabel("Contraseña:", SwingConstants.CENTER);
		Contrasena_1.setForeground(Color.RED);
		Contrasena_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		Contrasena_1.setBounds(83, 139, 222, 42);
		registrarse.add(Contrasena_1);

		txtRegistroContrasena = new JPasswordField();
		txtRegistroContrasena.setBounds(83, 176, 222, 19);
		registrarse.add(txtRegistroContrasena);

		JLabel Usuario_1 = new JLabel("Nombre de usuario:", SwingConstants.CENTER);
		Usuario_1.setForeground(Color.RED);
		Usuario_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		Usuario_1.setBounds(83, 76, 222, 36);
		registrarse.add(Usuario_1);

		txtRegistroNombre = new JTextField();
		txtRegistroNombre.setColumns(10);
		txtRegistroNombre.setBounds(83, 110, 222, 19);
		registrarse.add(txtRegistroNombre);

		JButton btnRegistrarse_1 = new JButton("Registrarse");
		btnRegistrarse_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtRegistroNombre.getText().trim().length() < 5) {
					aviso.setVisible(true);
					aviso.setText("Nombre muy corto, minimo 5 caracteres");
				} else {
					registrarse.setVisible(false);
					login.setVisible(true);
				}
			}
		});
		btnRegistrarse_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRegistrarse_1.setBackground(Color.RED);
		btnRegistrarse_1.setBounds(127, 378, 137, 33);
		registrarse.add(btnRegistrarse_1);

		JLabel Contrasena_1_1 = new JLabel("Confirmar contraseña:", SwingConstants.CENTER);
		Contrasena_1_1.setForeground(Color.RED);
		Contrasena_1_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		Contrasena_1_1.setBounds(10, 197, 369, 42);
		registrarse.add(Contrasena_1_1);

		txtRegistroConfirmarContrasena = new JPasswordField();
		txtRegistroConfirmarContrasena.setBounds(83, 239, 222, 19);
		registrarse.add(txtRegistroConfirmarContrasena);

		JLabel Contrasena_1_2 = new JLabel("Email:", SwingConstants.CENTER);
		Contrasena_1_2.setForeground(Color.RED);
		Contrasena_1_2.setFont(new Font("Tahoma", Font.PLAIN, 23));
		Contrasena_1_2.setBounds(83, 258, 222, 42);
		registrarse.add(Contrasena_1_2);

		txtRegistroMail = new JPasswordField();
		txtRegistroMail.setBounds(83, 294, 222, 19);
		registrarse.add(txtRegistroMail);

		aviso = new JLabel("New label", SwingConstants.CENTER);
		aviso.setForeground(Color.RED);
		aviso.setFont(new Font("Stencil", Font.PLAIN, 20));
		aviso.setBounds(23, 337, 343, 31);
		registrarse.add(aviso);
		aviso.setVisible(false);
		lamina1.add(interfaz);

		interfaz.setLayout(null);

		panelLuchadores = new JPanel();
		panelLuchadores.setLayout(new BorderLayout());
		panelLuchadores.setBackground(new Color(255, 0, 0));
		panelLuchadores.setBounds(0, 20, 986, 543);
		interfaz.add(panelLuchadores);

		JTable tabla;
		ResultSetModeloTabla modelo = null;
		Statement st;

		try {
			st = miConexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			miResultset = st.executeQuery("SELECT * FROM LUCHADOR");

			modelo = new ResultSetModeloTabla(miResultset);
			tabla = new JTable(modelo);
			JScrollPane scroll = new JScrollPane(tabla);

			panelLuchadores.add(scroll, BorderLayout.CENTER);
			validate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		panelLuchadores.setVisible(false);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1000, 22);
		interfaz.add(menuBar);

		JMenu menuRankings = new JMenu("Rankings");
		menuBar.add(menuRankings);

		JMenuItem menuPesoPluma = new JMenuItem("Peso Pluma");
		menuPesoPluma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (panelLuchadores.isVisible() == true) {
					panelRankings.setVisible(false);
				}
				if (panelEventos.isVisible() == true) {
					panelEventos.setVisible(false);
				}
				if (panelApuestas.isVisible() == true) {
					panelApuestas.setVisible(false);
				}
				if (rankingPesoMosca.isVisible() == true) {
					rankingPesoMosca.setVisible(false);
				}
				if (rankingPesoLigero.isVisible() == true) {
					rankingPesoLigero.setVisible(false);
				}
				if (rankingPesoMedio.isVisible() == true) {
					rankingPesoMedio.setVisible(false);
				}
				if (rankingPesoPesado.isVisible() == true) {
					rankingPesoPesado.setVisible(false);
				}
				panelRankings.setVisible(true);
				rankingPesoPluma.setVisible(true);
				menuPesoPluma.setSelected(false);

			}
		});
		menuRankings.add(menuPesoPluma);

		JMenuItem menuPesoMosca = new JMenuItem("Peso Mosca");
		menuPesoMosca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (panelLuchadores.isVisible() == true) {
					panelRankings.setVisible(false);
				}
				if (panelEventos.isVisible() == true) {
					panelEventos.setVisible(false);
				}
				if (panelApuestas.isVisible() == true) {
					panelApuestas.setVisible(false);
				}
				if (rankingPesoPluma.isVisible() == true) {
					rankingPesoPluma.setVisible(false);
				}
				if (rankingPesoLigero.isVisible() == true) {
					rankingPesoLigero.setVisible(false);
				}
				if (rankingPesoMedio.isVisible() == true) {
					rankingPesoMedio.setVisible(false);
				}
				if (rankingPesoPesado.isVisible() == true) {
					rankingPesoPesado.setVisible(false);
				}
				panelRankings.setVisible(true);
				rankingPesoMosca.setVisible(true);
				menuPesoMosca.setSelected(false);
			}
		});
		menuRankings.add(menuPesoMosca);

		JMenuItem menuPesoLigero = new JMenuItem("Peso Ligero");
		menuPesoLigero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (panelLuchadores.isVisible() == true) {
					panelRankings.setVisible(false);
				}
				if (panelEventos.isVisible() == true) {
					panelEventos.setVisible(false);
				}
				if (panelApuestas.isVisible() == true) {
					panelApuestas.setVisible(false);
				}
				if (rankingPesoPluma.isVisible() == true) {
					rankingPesoPluma.setVisible(false);
				}
				if (rankingPesoMosca.isVisible() == true) {
					rankingPesoMosca.setVisible(false);
				}
				if (rankingPesoMedio.isVisible() == true) {
					rankingPesoMedio.setVisible(false);
				}
				if (rankingPesoPesado.isVisible() == true) {
					rankingPesoPesado.setVisible(false);
				}
				panelRankings.setVisible(true);
				rankingPesoLigero.setVisible(true);
				menuPesoLigero.setSelected(false);
			}
		});
		menuRankings.add(menuPesoLigero);

		JMenuItem menuPesoMedio = new JMenuItem("Peso Medio");
		menuPesoMedio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (panelLuchadores.isVisible() == true) {
					panelRankings.setVisible(false);
				}
				if (panelEventos.isVisible() == true) {
					panelEventos.setVisible(false);
				}
				if (panelApuestas.isVisible() == true) {
					panelApuestas.setVisible(false);
				}
				if (rankingPesoPluma.isVisible() == true) {
					rankingPesoPluma.setVisible(false);
				}
				if (rankingPesoMosca.isVisible() == true) {
					rankingPesoMosca.setVisible(false);
				}
				if (rankingPesoLigero.isVisible() == true) {
					rankingPesoLigero.setVisible(false);
				}
				if (rankingPesoPesado.isVisible() == true) {
					rankingPesoPesado.setVisible(false);
				}
				panelRankings.setVisible(true);
				rankingPesoMedio.setVisible(true);
				menuPesoMedio.setSelected(false);
			}
		});
		menuRankings.add(menuPesoMedio);

		JMenuItem menuPesoPesado = new JMenuItem("Peso Pesado");
		menuPesoPesado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (panelLuchadores.isVisible() == true) {
					panelRankings.setVisible(false);
				}
				if (panelEventos.isVisible() == true) {
					panelEventos.setVisible(false);
				}
				if (panelApuestas.isVisible() == true) {
					panelApuestas.setVisible(false);
				}
				if (rankingPesoPluma.isVisible() == true) {
					rankingPesoPluma.setVisible(false);
				}
				if (rankingPesoMosca.isVisible() == true) {
					rankingPesoMosca.setVisible(false);
				}
				if (rankingPesoLigero.isVisible() == true) {
					rankingPesoLigero.setVisible(false);
				}
				if (rankingPesoMedio.isVisible() == true) {
					rankingPesoMedio.setVisible(false);
				}
				panelRankings.setVisible(true);
				rankingPesoPesado.setVisible(true);
				menuPesoPesado.setSelected(false);
			}
		});
		menuRankings.add(menuPesoPesado);

		JMenu menuLuchadores = new JMenu("Luchadores");
		menuLuchadores.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (panelRankings.isVisible() == true) {
					panelRankings.setVisible(false);
				}
				if (panelEventos.isVisible() == true) {
					panelEventos.setVisible(false);
				}
				if (panelApuestas.isVisible() == true) {
					panelApuestas.setVisible(false);
				}
				panelLuchadores.setVisible(true);
				menuLuchadores.setSelected(false);
			}
		});
		menuBar.add(menuLuchadores);

		JMenu menuEventos = new JMenu("Eventos");
		menuEventos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (panelRankings.isVisible() == true) {
					panelRankings.setVisible(false);
				}
				if (panelLuchadores.isVisible() == true) {
					panelLuchadores.setVisible(false);
				}
				if (panelApuestas.isVisible() == true) {
					panelApuestas.setVisible(false);
				}
				panelEventos.setVisible(true);
				menuEventos.setSelected(false);
			}
		});
		menuBar.add(menuEventos);

		JMenu menuApuestas = new JMenu("Apuestas");
		menuApuestas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (panelRankings.isVisible() == true) {
					panelRankings.setVisible(false);
				}
				if (panelLuchadores.isVisible() == true) {
					panelLuchadores.setVisible(false);
				}
				if (panelEventos.isVisible() == true) {
					panelEventos.setVisible(false);
				}
				panelApuestas.setVisible(true);
				menuApuestas.setSelected(false);
			}
		});
		menuBar.add(menuApuestas);

		panelRankings = new JPanel();
		panelRankings.setBackground(new Color(192, 192, 192));
		panelRankings.setBounds(0, 20, 986, 543);
		interfaz.add(panelRankings);
		panelRankings.setLayout(null);

		rankingPesoPluma = new JPanel();
		rankingPesoPluma.setBounds(277, 41, 431, 471);
		panelRankings.add(rankingPesoPluma);
		rankingPesoPluma.setLayout(null);
		rankingPesoPluma.setVisible(false);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 150, 330, 186);
		rankingPesoPluma.add(scrollPane);

		tablaPesoPluma = new JTable();
		tablaPesoPluma.setModel(new DefaultTableModel(
				new Object[][] { { 1, null }, { 2, null }, { 3, null }, { 4, null }, { 5, null }, { 6, null },
						{ 7, null }, { 8, null }, { 9, null }, { 10, null }, },
				new String[] { "Posicion", "Nombre Luchador" }));
		scrollPane.setViewportView(tablaPesoPluma);

		JLabel lblNewLabel_5 = new JLabel("IMAGEN");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblNewLabel_5.setBounds(153, 43, 126, 64);
		rankingPesoPluma.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Peso Pluma");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_6.setBounds(152, 0, 126, 33);
		rankingPesoPluma.add(lblNewLabel_6);

		rankingPesoMosca = new JPanel();
		rankingPesoMosca.setBounds(277, 41, 431, 471);
		panelRankings.add(rankingPesoMosca);
		rankingPesoMosca.setLayout(null);

		JLabel lblNewLabel_6_1 = new JLabel("Peso Mosca");
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_6_1.setBounds(152, 0, 126, 33);
		rankingPesoMosca.add(lblNewLabel_6_1);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 330, 186);
		rankingPesoMosca.add(scrollPane_1);

		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
				new Object[][] { { null, null }, { null, null }, { null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null }, { null, null }, { null, null }, },
				new String[] { "New column", "New column" }));
		table_1.setBounds(0, 0, 328, 160);
		rankingPesoMosca.add(table_1);
		rankingPesoMosca.setVisible(false);

		rankingPesoLigero = new JPanel();
		rankingPesoLigero.setBounds(277, 41, 431, 471);
		panelRankings.add(rankingPesoLigero);
		rankingPesoLigero.setLayout(null);

		JLabel lblNewLabel_6_2 = new JLabel("Peso Ligero");
		lblNewLabel_6_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_6_2.setBounds(152, 0, 126, 33);
		rankingPesoLigero.add(lblNewLabel_6_2);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(0, 0, 330, 186);
		rankingPesoLigero.add(scrollPane_2);

		table_2 = new JTable();
		table_2.setBounds(0, 0, 328, 160);
		rankingPesoLigero.add(table_2);
		rankingPesoLigero.setVisible(false);

		rankingPesoMedio = new JPanel();
		rankingPesoMedio.setBounds(277, 41, 431, 471);
		panelRankings.add(rankingPesoMedio);
		rankingPesoMedio.setLayout(null);

		JLabel lblNewLabel_6_3 = new JLabel("Peso Medio");
		lblNewLabel_6_3.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_6_3.setBounds(152, 0, 126, 33);
		rankingPesoMedio.add(lblNewLabel_6_3);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(0, 0, 330, 186);
		rankingPesoMedio.add(scrollPane_3);

		table_3 = new JTable();
		table_3.setBounds(0, 0, 328, 160);
		rankingPesoMedio.add(table_3);
		rankingPesoMedio.setVisible(false);

		rankingPesoPesado = new JPanel();
		rankingPesoPesado.setBounds(277, 41, 431, 471);
		panelRankings.add(rankingPesoPesado);
		rankingPesoPesado.setLayout(null);

		JLabel lblNewLabel_6_4 = new JLabel("Peso Pesado");
		lblNewLabel_6_4.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_6_4.setBounds(139, 0, 153, 33);
		rankingPesoPesado.add(lblNewLabel_6_4);

		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(0, 0, 330, 186);
		rankingPesoPesado.add(scrollPane_4);

		table_4 = new JTable();
		table_4.setBounds(0, 0, 328, 160);
		rankingPesoPesado.add(table_4);
		panelRankings.setVisible(false);

		panelEventos = new JPanel();
		panelEventos.setLayout(null);
		panelEventos.setBackground(new Color(0, 255, 0));
		panelEventos.setBounds(0, 20, 986, 543);
		interfaz.add(panelEventos);

		JLabel lblNewLabel_2 = new JLabel("Eventos");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel_2.setBounds(414, 168, 158, 50);
		panelEventos.add(lblNewLabel_2);

		panelApuestas = new JPanel();
		panelApuestas.setLayout(null);
		panelApuestas.setBackground(new Color(128, 0, 255));
		panelApuestas.setBounds(0, 20, 986, 543);
		interfaz.add(panelApuestas);

		JLabel lblNewLabel_4 = new JLabel("Apuestas");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 47));
		lblNewLabel_4.setBounds(397, 120, 192, 112);
		panelApuestas.add(lblNewLabel_4);
		panelApuestas.setVisible(false);
		panelEventos.setVisible(false);

	}
}

class ResultSetModeloTabla extends AbstractTableModel {

	private ResultSet rsRegistros;
	private ResultSetMetaData rsMeta;

	public ResultSetModeloTabla(ResultSet rs) {
		this.rsRegistros = rs;
		try {
			this.rsMeta = rsRegistros.getMetaData();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int getRowCount() {
		try {
			rsRegistros.last();
			return rsRegistros.getRow();

		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int getColumnCount() {
		try {
			return rsMeta.getColumnCount();

		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		try {
			rsRegistros.absolute(rowIndex + 1);
			return rsRegistros.getObject(columnIndex + 1);

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public String getColumnName(int c) {
		String[] nombres = { "Nombre", "Apodo", "Edad", "Altura", "Peso", "División", "Ranking", "Title Holder",
				"Victorias", "Derrotas", "Empates", "KO", "Sumisiones" };
		return nombres[c];
	}

}