package proyectointegrador;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import javax.swing.table.*;
import java.sql.*;
import java.util.regex.*;

public class Login extends JFrame implements ActionListener {

	static Connection miConexion;
	static Statement miStatement;
	static ResultSet miResultset;

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
	private int cuenta1 = 0;
	private int cuenta2 = 0;
	private int cuenta3 = 0;
	private int cuenta4 = 0;
	private JTextField txtRegistroNombre;
	private JLabel mensajeUsuarioCreado;
	private JPanel bienvenida;
	private String usuarioApuestas;
	private JComboBox comboApuesta;
	private JLabel lblUsuarioApuestas;
	private JLabel lblMontoApuestas;
	private JComboBox comboApuestaGanador;
	private JTextField importeApuesta;
	private JButton botonApuesta;

	public static void main(String[] args) {

		Login frame = new Login();
		frame.setVisible(true);
	}

	public Login() {
		try {
			miConexion = DriverManager.getConnection("jdbc:mysql://10.1.200.97:3306/prueba", "marcos", "1234");
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

		interfaz = new JPanel();
		interfaz.setBounds(0, 0, 986, 563);
		interfaz.setVisible(false);

		bienvenida = new JPanel();
		bienvenida.setBounds(0, 21, 986, 542);
		lamina1.add(bienvenida);
		bienvenida.setLayout(null);
		bienvenida.setVisible(false);

		JLabel imagenBienvenida = new JLabel("");
		imagenBienvenida.setIcon(new ImageIcon(Login.class.getResource("/proyectointegrador/LOGO.png")));
		imagenBienvenida.setBounds(0, 0, 1000, 600);
		bienvenida.add(imagenBienvenida);
		lamina1.add(interfaz);
		lamina1.add(interfaz);

		interfaz.setLayout(null);

		panelApuestas = new JPanel();
		panelApuestas.setLayout(null);
		panelApuestas.setBounds(0, 20, 986, 543);
		interfaz.add(panelApuestas);
		
		lblUsuarioApuestas = new JLabel("Usuario: ");
		lblMontoApuestas = new JLabel("Monto: ");

		JLabel eligePelea = new JLabel("Elige una pelea no realizada:");
		eligePelea.setFont(new Font("Tahoma", Font.BOLD, 20));
		eligePelea.setBounds(16, 50, 322, 60);
		panelApuestas.add(eligePelea);
		panelApuestas.setVisible(false);
		
		JLabel eligeGanador = new JLabel("Elige un ganador de la pelea:");
		eligeGanador.setFont(new Font("Tahoma", Font.BOLD, 20));
		eligeGanador.setBounds(16, 140, 322, 60);
		panelApuestas.add(eligeGanador);
		panelApuestas.setVisible(false);

		JLabel eligeImporte = new JLabel("Introduce el importe:");
		eligeImporte.setFont(new Font("Tahoma", Font.BOLD, 20));
		eligeImporte.setBounds(16, 210, 322, 60);
		panelApuestas.add(eligeImporte);
		panelApuestas.setVisible(false);

		eligeImporte.setBounds(16, 230, 322, 60);
		panelApuestas.add(eligeImporte);
		panelApuestas.setVisible(false);
		
		comboApuesta = new JComboBox();
		comboApuesta.setBounds(16, 100, 280, 21);
		panelApuestas.add(comboApuesta);

		Statement stComboApuesta;

		comboApuestaGanador = new JComboBox();
		comboApuestaGanador.setBounds(16, 190, 280, 21);
		panelApuestas.add(comboApuestaGanador);
		
		importeApuesta = new JTextField();
		importeApuesta.setBounds(16, 280, 280, 21);
		panelApuestas.add(importeApuesta);
		
		botonApuesta = new JButton("Apostar");
		botonApuesta.setFont(new Font("Tahoma", Font.BOLD, 16));
		botonApuesta.setBounds(16, 330, 120, 40);
		panelApuestas.add(botonApuesta);
		botonApuesta.addActionListener(this);

		try {
		    stComboApuesta = miConexion.createStatement();
		    ResultSet comboApuestaLuchadores = stComboApuesta.executeQuery("SELECT CODIGOPELEA, LUCHADOR1, LUCHADOR2 FROM PELEA WHERE REALIZADA = 0");
		    
		    while (comboApuestaLuchadores.next()) {
		        String codigoPelea = comboApuestaLuchadores.getString("CODIGOPELEA");
		        String luchador1 = comboApuestaLuchadores.getString("LUCHADOR1");
		        String luchador2 = comboApuestaLuchadores.getString("LUCHADOR2");
		        comboApuesta.addItem(codigoPelea + " | " + luchador1 + " - " + luchador2);
		    }

		    comboApuestaLuchadores.close();
		    stComboApuesta.close();
		} catch (SQLException e) {
		    e.printStackTrace();
		}

		// Agregar un ActionListener a comboApuesta para actualizar comboApuestaGanador
		comboApuesta.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent event) {
		        try {
		            // Limpiar los elementos anteriores en comboApuestaGanador
		            comboApuestaGanador.removeAllItems();

		            // Obtener la opción seleccionada en comboApuesta
		            String selectedPelea = comboApuesta.getSelectedItem().toString();
		            String codigoPelea = selectedPelea.split(" \\| ")[0];

		            // Obtener los luchadores de la pelea seleccionada
		            Statement stComboApuestaGanador = miConexion.createStatement();
		            ResultSet rsComboApuestaGanador = stComboApuestaGanador.executeQuery("SELECT LUCHADOR1, LUCHADOR2 FROM PELEA WHERE CODIGOPELEA = " + codigoPelea);
		            while (rsComboApuestaGanador.next()) {
		                comboApuestaGanador.addItem(rsComboApuestaGanador.getString("LUCHADOR1"));
		                comboApuestaGanador.addItem(rsComboApuestaGanador.getString("LUCHADOR2"));
		            }

		            stComboApuestaGanador.close();
		            rsComboApuestaGanador.close();
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
		});

		
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
		lblNewLabel_6.setBounds(152, 50, 126, 33);
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
		lblNewLabel_6_1.setBounds(152, 50, 126, 33);
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
		lblNewLabel_6_2.setBounds(152, 50, 126, 33);
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
		lblNewLabel_6_3.setBounds(152, 50, 126, 33);
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
		lblNewLabel_6_4.setBounds(139, 50, 153, 33);
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
		menuBar.setBounds(0, 0, 986, 22);
		interfaz.add(menuBar);

		JMenu menuRankings = new JMenu("Rankings");
		menuBar.add(menuRankings);

		JMenuItem menuPesoPluma = new JMenuItem("Peso Pluma");
		menuPesoPluma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bienvenida.setVisible(false);
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
				bienvenida.setVisible(false);
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
				bienvenida.setVisible(false);
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
				bienvenida.setVisible(false);
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
				bienvenida.setVisible(false);
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
				bienvenida.setVisible(false);
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
				bienvenida.setVisible(false);
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

				lblUsuarioApuestas.setText("Usuario: " + usuarioApuestas);
				lblUsuarioApuestas.setFont(new Font("Tahoma", Font.PLAIN, 16));
				lblUsuarioApuestas.setBounds(16, 4, 241, 57);
				panelApuestas.add(lblUsuarioApuestas);

				PreparedStatement ps;
				try {
					ps = miConexion.prepareStatement("SELECT Monto FROM usuario WHERE NombreUsuario = ?");
					ps.setString(1, usuarioApuestas);
					ResultSet rs = ps.executeQuery();

					while (rs.next()) {
						lblMontoApuestas.setText("Monto: " + rs.getString("Monto") + "€");
						lblMontoApuestas.setFont(new Font("Tahoma", Font.PLAIN, 16));
						lblMontoApuestas.setBounds(850, 4, 241, 57);
						panelApuestas.add(lblMontoApuestas);
					}

					rs.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				bienvenida.setVisible(false);
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

		JMenu menuLogout = new JMenu("Logout");
		menuLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				bienvenida.setVisible(false);
				txtUsuario.setText("");
				txtContrasena.setText("");
				interfaz.setVisible(false);
				login.setVisible(true);

				lblUsuarioApuestas.setText("Usuario: ");
				lblMontoApuestas.setText("Monto: ");

			}
		});
		menuBar.add(Box.createHorizontalGlue());
		menuBar.add(menuLogout);

		panelEventos = new JPanel();
		panelEventos.setLayout(null);
		panelEventos.setBackground(new Color(0, 255, 0));
		panelEventos.setBounds(0, 20, 986, 543);
		interfaz.add(panelEventos);

		JLabel lblNewLabel_2 = new JLabel("Eventos");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel_2.setBounds(414, 168, 158, 50);
		panelEventos.add(lblNewLabel_2);

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
				mensajeUsuarioCreado.setVisible(false);
				int errores = 0;
				String regex = "^[\\w!#$%&'+/=?`{|}^-]+(?:\\.[\\w!#$%&'+/=?`{|}^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}";
				Pattern pattern = Pattern.compile(regex);
				Matcher matcher = pattern.matcher(txtRegistroMail.getText());

				if (txtRegistroUsuario.getText().trim().length() < 5) {
					aviso.setVisible(true);
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
					aviso.setVisible(true);
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
					aviso.setVisible(true);
					if (cuenta3 == 0) {
						aviso.setText("Contraseña muy corta");
						cuenta3++;
					} else {
						aviso.setText("Contraseña muy corta x" + cuenta3);
						cuenta3++;
					}
					errores++;
				} else if (matcher.matches() == false) {
					aviso.setVisible(true);
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
					aviso.setVisible(false);
					Statement st7;
					try {
						st7 = miConexion.createStatement();
						st7.executeUpdate(
								"INSERT INTO usuario (NombreUsuario, Nombre, Contrasena, Email, Monto) VALUES ('"
										+ txtRegistroUsuario.getText() + "', '" + txtRegistroNombre.getText() + "', '"
										+ txtRegistroContrasena_1.getText() + "', '" + txtRegistroMail.getText()
										+ "', 50)");
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					mensajeUsuarioCreado.setVisible(true);
					registrarse.setVisible(false);
					login.setVisible(true);

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
				txtUsuario.setText("");
				txtContrasena.setText("");
				txtRegistroUsuario.setText("");
				txtRegistroNombre.setText("");
				txtRegistroContrasena_1.setText("");
				txtRegistroConfirmarContrasena.setText("");
				txtRegistroMail.setText("");
				cuenta1 = 0;
				cuenta2 = 0;
				cuenta3 = 0;
				cuenta4 = 0;
				aviso.setVisible(false);
				registrarse.setVisible(false);
				login.setVisible(true);
				mensajeUsuarioCreado.setVisible(false);
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
		titulo.setBounds(83, 10, 222, 43);
		login.add(titulo);

		JLabel labelTitulo2_1 = new JLabel("UFC DATABASE");
		labelTitulo2_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		titulo.add(labelTitulo2_1);
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String sql = "SELECT * FROM usuario WHERE NombreUsuario = ? AND Contrasena = ?";
				PreparedStatement statement = null;
				try {
					statement = miConexion.prepareStatement(sql);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				try {
					statement.setString(1, txtUsuario.getText());
					statement.setString(2, txtContrasena.getText());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				ResultSet resultSet = null;
				try {
					resultSet = statement.executeQuery();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

				try {
					if (resultSet.next()) {
						usuarioApuestas = txtUsuario.getText();
						login.setVisible(false);
						interfaz.setVisible(true);
						bienvenida.setVisible(true);
					} else {
						accesoDenegado.setText("Usuario o contraseña incorrectos");
						accesoDenegado.setVisible(true);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

				try {
					resultSet.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				try {
					statement.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
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

		mensajeUsuarioCreado = new JLabel("Usuario registrado con exito", SwingConstants.CENTER);
		mensajeUsuarioCreado.setForeground(Color.GREEN);
		mensajeUsuarioCreado.setFont(new Font("Tahoma", Font.PLAIN, 20));
		mensajeUsuarioCreado.setBounds(68, 63, 253, 25);
		login.add(mensajeUsuarioCreado);
		mensajeUsuarioCreado.setVisible(false);
		accesoDenegado.setVisible(false);
		panelEventos.setVisible(false);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (importeApuesta.getText().equals("//SELECT MONTO FROM USUARIO WHERE NOMBREUSUARIO = usuarioApuestas")) {
			// MOSTRAR ERROR DE MONTO
		}

		else {
			// GANADOR RANDOM
			// PELEA PASA DE NO REALIZADA A REALIZADA
			// SE INTRODUCEN VALORES EN GANADOR Y PERDEDOR
			
			/*
			if (GANADOR RANDOM = GANADOR SELECCIONADO) {
				// SE SUMA AL MONTO DEL USUARIO importeApuesta
			}
			
			else {
				// SE RESTA AL MONTO DEL USUARIO importeApuesta
			}
			*/
		}
		
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