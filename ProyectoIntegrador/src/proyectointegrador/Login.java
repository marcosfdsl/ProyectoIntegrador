package proyectointegrador;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import javax.swing.table.*;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Login extends JFrame {

	private JPanel lamina1;
	private JTextField txtUsuario;
	private JPasswordField txtContrasena;
	private JPanel interfaz;
	private JPanel panelRankings;
	private JPanel panelLuchadores;
	private JPanel panelEventos;
	private JPanel panelApuestas;
	private JPanel rankingPesoPluma;
	private JPanel rankingPesoMosca;
	private JPanel rankingPesoLigero;
	private JPanel rankingPesoMedio;
	private JPanel rankingPesoPesado;
	private JTextField txtRegistroUsuario;
	private JPanel registrarse;
	private JPanel login;
	private JPasswordField txtRegistroConfirmarContrasena;
	private JTextField txtRegistroMail;
	private JLabel aviso;
	private JLabel accesoDenegado;

	static Connection miConexion;
	static Statement miStatement;
	static ResultSet miResultset;
	private int cuenta1 = 0;
	private int cuenta2 = 0;
	private int cuenta3 = 0;
	private int cuenta4 = 0;
	private JTextField txtRegistroNombre;

	public static void main(String[] args) {

		Login frame = new Login();
		frame.setVisible(true);
	}

	public Login() {
		try {
			miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/ufc_db", "root", "");
			miStatement = miConexion.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 60, 1000, 600);
		lamina1 = new JPanel();
		lamina1.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(lamina1);
		lamina1.setLayout(null);
		final String usuario = "a";
		final String contrasena = "a";

		interfaz = new JPanel();
		interfaz.setBounds(0, 0, 986, 563);
		interfaz.setVisible(false);

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

		JLabel Contrasena_1 = new JLabel("Contraseña:");
		Contrasena_1.setForeground(Color.RED);
		Contrasena_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		Contrasena_1.setBounds(83, 165, 222, 42);
		registrarse.add(Contrasena_1);

		JPasswordField txtRegistroContrasena_1 = new JPasswordField();
		txtRegistroContrasena_1.setBounds(83, 203, 222, 19);
		registrarse.add(txtRegistroContrasena_1);

		JLabel Usuario_1 = new JLabel("Nombre de usuario:");
		Usuario_1.setForeground(Color.RED);
		Usuario_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		Usuario_1.setBounds(83, 53, 222, 36);
		registrarse.add(Usuario_1);

		txtRegistroUsuario = new JTextField();
		txtRegistroUsuario.setColumns(10);
		txtRegistroUsuario.setBounds(83, 91, 222, 19);
		registrarse.add(txtRegistroUsuario);

		txtRegistroConfirmarContrasena = new JPasswordField();
		txtRegistroConfirmarContrasena.setBounds(83, 256, 222, 19);
		registrarse.add(txtRegistroConfirmarContrasena);

		JButton btnRegistrarse_1 = new JButton("Registrarse");
		btnRegistrarse_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int errores = 0;
				String regex = "^[\\w!#$%&'+/=?`{|}~^-]+(?:\\.[\\w!#$%&'+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}";
				Pattern pattern = Pattern.compile(regex);
				Matcher matcher = pattern.matcher(txtRegistroMail.getText());
				aviso.setVisible(true);
				if (txtRegistroUsuario.getText().trim().length() < 5) {

					if (cuenta1 == 0) {
						aviso.setText("Nombre muy corto");
						cuenta1++;
					} else {
						aviso.setText("Nombre muy corto x" + cuenta1);
						cuenta1++;
					}
					errores++;
				} else if (!(String.valueOf(txtRegistroContrasena_1.getPassword())
						.equals(String.valueOf(txtRegistroConfirmarContrasena.getPassword())))) {
					if (cuenta2 == 0) {
						aviso.setText("Las contraseñas no son iguales");
						cuenta2++;
					} else {
						aviso.setText("Las contraseñas no son iguales x" + cuenta2);
						cuenta2++;
					}
					errores++;
				} else if (txtRegistroContrasena_1.getPassword().length < 6
						|| txtRegistroConfirmarContrasena.getPassword().length < 6) {
					if (cuenta3 == 0) {
						aviso.setText("Contraseña muy corta");
						cuenta3++;
					} else {
						aviso.setText("Contraseña muy corta x" + cuenta3);
						cuenta3++;
					}
					errores++;
				} else if (matcher.matches() == false) {
					if (cuenta4 == 0) {
						aviso.setText("Email no permitido");
						cuenta4++;
					} else {
						aviso.setText("Email no permitido x" + cuenta4);
						cuenta4++;
					}
					errores++;
				}

				if (errores == 0) {
					Statement st7;
					try {
						st7 = miConexion.createStatement();
						st7.executeUpdate("INSERT INTO usuario (NombreUsuario, Nombre, Contrasena, Email, Monto) VALUES ('" + txtRegistroUsuario.getText() + "', '" + txtRegistroNombre.getText() + "', '" + txtRegistroContrasena_1.getText() + "', '" + txtRegistroMail.getText() + "', 0)");
					} catch (SQLException e1) {
						e1.printStackTrace();
					}

					registrarse.setVisible(false);
					login.setVisible(true);
					
					//AQUI SE TIENE Q HACER VISIBLE EL JPANEL DE "CUENTA CREADA CORRECTAMENTE"
				}

			}
		});
		btnRegistrarse_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRegistrarse_1.setBackground(Color.RED);
		btnRegistrarse_1.setBounds(47, 370, 140, 33);
		registrarse.add(btnRegistrarse_1);

		JLabel Contrasena_1_1 = new JLabel("Confirmar contraseña:");
		Contrasena_1_1.setForeground(Color.RED);
		Contrasena_1_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		Contrasena_1_1.setBounds(83, 219, 251, 42);
		registrarse.add(Contrasena_1_1);

		JLabel Contrasena_1_2 = new JLabel("Email:");
		Contrasena_1_2.setForeground(Color.RED);
		Contrasena_1_2.setFont(new Font("Tahoma", Font.PLAIN, 23));
		Contrasena_1_2.setBounds(83, 272, 222, 42);
		registrarse.add(Contrasena_1_2);

		aviso = new JLabel("aviso", SwingConstants.CENTER);
		aviso.setForeground(Color.RED);
		aviso.setFont(new Font("Stencil", Font.PLAIN, 20));
		aviso.setBounds(0, 337, 389, 31);
		registrarse.add(aviso);
		aviso.setVisible(false);

		txtRegistroMail = new JTextField();
		txtRegistroMail.setColumns(10);
		txtRegistroMail.setBounds(83, 311, 222, 19);
		registrarse.add(txtRegistroMail);

		JLabel Usuario_1_1 = new JLabel("Nombre completo:");
		Usuario_1_1.setForeground(Color.RED);
		Usuario_1_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		Usuario_1_1.setBounds(83, 110, 222, 36);
		registrarse.add(Usuario_1_1);

		txtRegistroNombre = new JTextField();
		txtRegistroNombre.setColumns(10);
		txtRegistroNombre.setBounds(83, 148, 222, 19);
		registrarse.add(txtRegistroNombre);
		
		JButton btnVolverLogin = new JButton("Login");
		btnVolverLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrarse.setVisible(false);
				login.setVisible(true);
			}
		});
		btnVolverLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnVolverLogin.setBackground(Color.RED);
		btnVolverLogin.setBounds(203, 370, 140, 33);
		registrarse.add(btnVolverLogin);

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
		lamina1.add(interfaz);
		lamina1.add(interfaz);

		interfaz.setLayout(null);

		panelRankings = new JPanel();
		panelRankings.setBackground(new Color(192, 192, 192));
		panelRankings.setBounds(0, 20, 986, 543);
		interfaz.add(panelRankings);
		panelRankings.setLayout(null);

		// PESO PLUMA

		rankingPesoPluma = new JPanel();
		rankingPesoPluma.setBounds(277, 41, 431, 471);
		panelRankings.add(rankingPesoPluma);
		rankingPesoPluma.setLayout(null);
		rankingPesoPluma.setVisible(false);

		JLabel lblNewLabel_6 = new JLabel("Peso Pluma");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_6.setBounds(152, 0, 126, 33);
		rankingPesoPluma.add(lblNewLabel_6);

		JTable tablaPesoPluma;
		ResultSetModeloTabla2 modelo2 = null;
		Statement st2;

		try {
			st2 = miConexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs2 = st2.executeQuery(
					"SELECT RANKING, NOMBRE FROM LUCHADOR WHERE DIVISION = 'PESO PLUMA' ORDER BY RANKING");

			modelo2 = new ResultSetModeloTabla2(rs2);
			tablaPesoPluma = new JTable(modelo2);
			JScrollPane scroll2 = new JScrollPane(tablaPesoPluma);
			scroll2.setBounds(50, 150, 330, 186);

			rankingPesoPluma.add(scroll2);
			validate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		// PESO MOSCA

		rankingPesoMosca = new JPanel();
		rankingPesoMosca.setBounds(277, 41, 431, 471);
		panelRankings.add(rankingPesoMosca);
		rankingPesoMosca.setLayout(null);
		rankingPesoMosca.setVisible(false);

		JLabel lblNewLabel_6_1 = new JLabel("Peso Mosca");
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_6_1.setBounds(152, 0, 126, 33);
		rankingPesoMosca.add(lblNewLabel_6_1);

		JTable tablaPesoMosca;
		modelo2 = null;
		Statement st3;

		try {
			st3 = miConexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs3 = st3.executeQuery(
					"SELECT RANKING, NOMBRE FROM LUCHADOR WHERE DIVISION = 'PESO MOSCA' ORDER BY RANKING");

			modelo2 = new ResultSetModeloTabla2(rs3);
			tablaPesoMosca = new JTable(modelo2);
			JScrollPane scroll3 = new JScrollPane(tablaPesoMosca);
			scroll3.setBounds(50, 150, 330, 186);

			rankingPesoMosca.add(scroll3);
			validate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		// PESO LIGERO

		rankingPesoLigero = new JPanel();
		rankingPesoLigero.setBounds(277, 41, 431, 471);
		panelRankings.add(rankingPesoLigero);
		rankingPesoLigero.setLayout(null);
		rankingPesoLigero.setVisible(false);

		JLabel lblNewLabel_6_2 = new JLabel("Peso Ligero");
		lblNewLabel_6_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_6_2.setBounds(152, 0, 126, 33);
		rankingPesoLigero.add(lblNewLabel_6_2);

		JTable tablaPesoLigero;
		modelo2 = null;
		Statement st4;

		try {
			st4 = miConexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs4 = st4.executeQuery(
					"SELECT RANKING, NOMBRE FROM LUCHADOR WHERE DIVISION = 'PESO LIGERO' ORDER BY RANKING");

			modelo2 = new ResultSetModeloTabla2(rs4);
			tablaPesoLigero = new JTable(modelo2);
			JScrollPane scroll4 = new JScrollPane(tablaPesoLigero);
			scroll4.setBounds(50, 150, 330, 186);

			rankingPesoLigero.add(scroll4);
			validate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		// PESO MEDIO

		rankingPesoMedio = new JPanel();
		rankingPesoMedio.setBounds(277, 41, 431, 471);
		panelRankings.add(rankingPesoMedio);
		rankingPesoMedio.setLayout(null);
		rankingPesoMedio.setVisible(false);

		JLabel lblNewLabel_6_3 = new JLabel("Peso Medio");
		lblNewLabel_6_3.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_6_3.setBounds(152, 0, 126, 33);
		rankingPesoMedio.add(lblNewLabel_6_3);

		JTable tablaPesoMedio;
		modelo2 = null;
		Statement st5;

		try {
			st5 = miConexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs5 = st5.executeQuery(
					"SELECT RANKING, NOMBRE FROM LUCHADOR WHERE DIVISION = 'PESO MEDIO' ORDER BY RANKING");

			modelo2 = new ResultSetModeloTabla2(rs5);
			tablaPesoMedio = new JTable(modelo2);
			JScrollPane scroll5 = new JScrollPane(tablaPesoMedio);
			scroll5.setBounds(50, 150, 330, 186);

			rankingPesoMedio.add(scroll5);
			validate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		// PESO PESADO

		rankingPesoPesado = new JPanel();
		rankingPesoPesado.setBounds(277, 41, 431, 471);
		panelRankings.add(rankingPesoPesado);
		rankingPesoPesado.setLayout(null);
		rankingPesoPesado.setVisible(false);

		JLabel lblNewLabel_6_4 = new JLabel("Peso Pesado");
		lblNewLabel_6_4.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_6_4.setBounds(139, 0, 153, 33);
		rankingPesoPesado.add(lblNewLabel_6_4);

		JTable tablaPesoPesado;
		modelo2 = null;
		Statement st6;

		try {
			st6 = miConexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs6 = st6.executeQuery(
					"SELECT RANKING, NOMBRE FROM LUCHADOR WHERE DIVISION = 'PESO PESADO' ORDER BY RANKING");

			modelo2 = new ResultSetModeloTabla2(rs6);
			tablaPesoPesado = new JTable(modelo2);
			JScrollPane scroll6 = new JScrollPane(tablaPesoPesado);
			scroll6.setBounds(50, 150, 330, 186);

			rankingPesoPesado.add(scroll6);
			validate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		panelLuchadores = new JPanel();
		panelLuchadores.setLayout(new BorderLayout());
		panelLuchadores.setBackground(new Color(255, 0, 0));
		panelLuchadores.setBounds(0, 20, 986, 543);
		interfaz.add(panelLuchadores);

		JTable tablaLuchadores;
		ResultSetModeloTabla modelo = null;
		Statement st1;

		try {
			st1 = miConexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs1 = st1.executeQuery("SELECT * FROM LUCHADOR");

			modelo = new ResultSetModeloTabla(rs1);
			tablaLuchadores = new JTable(modelo);
			JScrollPane scroll1 = new JScrollPane(tablaLuchadores);

			panelLuchadores.add(scroll1, BorderLayout.CENTER);
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
					panelLuchadores.setVisible(false);
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
					panelLuchadores.setVisible(false);
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
					panelLuchadores.setVisible(false);
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
					panelLuchadores.setVisible(false);
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
					panelLuchadores.setVisible(false);
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

class ResultSetModeloTabla2 extends AbstractTableModel {

	private ResultSet rsRegistros;
	private ResultSetMetaData rsMeta;

	public ResultSetModeloTabla2(ResultSet rs) {
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
		String[] nombres = { "Ranking", "Nombre" };
		return nombres[c];
	}

}