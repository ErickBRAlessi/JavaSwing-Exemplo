package br.java.erickbruno.swing;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

import br.java.erickbruno.listener.ClienteListener;
import br.java.erickbruno.listener.PedidoListener;
import br.java.erickbruno.listener.PrecoListener;
import br.java.erickbruno.model.Circulo;
import br.java.erickbruno.model.Cliente;
import br.java.erickbruno.model.Forma;
import br.java.erickbruno.model.Material;
import br.java.erickbruno.model.Pedido;
import br.java.erickbruno.model.Quadrado;
import br.java.erickbruno.model.Tapete;
import br.java.erickbruno.model.Triangulo;

public class TelaPrincipal {

	private JFrame frame;
	private JTextField nomeInput;
	private JTextField sobreNomeInput;
	private JTextField cpfInput;
	private JTable tableClientes;
	private JTextField cpfPedidosInput;
	private JTextField nomeOutputPedidos;
	private JTextField sobreNomeOutputPedidos;
	private JPanel panelPedidos;
	private JTextField areaPedidos;
	private JTextField medida0Input;
	private JTextField medida1Input;
	private JTable pedidosTable;
	private JFormattedTextField outputTotal;
	private JTextField precoInOut;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ClienteListener clienteListener = new ClienteListener();
		PedidoListener pedidoListener = new PedidoListener();
		PrecoListener precoListener = new PrecoListener();
		JComboBox comboBoxForma = new JComboBox();
		JComboBox comboBoxMaterial = new JComboBox();

		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));

		JTabbedPane lblPrecoTitle = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(lblPrecoTitle);

		JPanel panelCliente = new JPanel();
		lblPrecoTitle.addTab("CLIENTE", null, panelCliente, null);
		GridBagLayout gbl_panelCliente = new GridBagLayout();
		gbl_panelCliente.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panelCliente.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panelCliente.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panelCliente.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panelCliente.setLayout(gbl_panelCliente);

		JLabel label = new JLabel("CLIENTE");
		label.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 2;
		gbc_label.gridy = 0;
		panelCliente.add(label, gbc_label);

		JLabel lblNomeCliente = new JLabel("NOME");
		lblNomeCliente.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNomeCliente = new GridBagConstraints();
		gbc_lblNomeCliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblNomeCliente.gridx = 0;
		gbc_lblNomeCliente.gridy = 1;
		panelCliente.add(lblNomeCliente, gbc_lblNomeCliente);

		nomeInput = new JTextField();
		GridBagConstraints gbc_nomeInput = new GridBagConstraints();
		gbc_nomeInput.gridwidth = 7;
		gbc_nomeInput.insets = new Insets(0, 0, 5, 0);
		gbc_nomeInput.fill = GridBagConstraints.HORIZONTAL;
		gbc_nomeInput.gridx = 1;
		gbc_nomeInput.gridy = 1;
		panelCliente.add(nomeInput, gbc_nomeInput);
		nomeInput.setColumns(10);

		JLabel lblSobreNome = new JLabel("SOBRE NOME");
		lblSobreNome.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblSobreNome = new GridBagConstraints();
		gbc_lblSobreNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblSobreNome.gridx = 0;
		gbc_lblSobreNome.gridy = 2;
		panelCliente.add(lblSobreNome, gbc_lblSobreNome);

		sobreNomeInput = new JTextField();
		sobreNomeInput.setColumns(10);
		GridBagConstraints gbc_sobreNomeInput = new GridBagConstraints();
		gbc_sobreNomeInput.gridwidth = 7;
		gbc_sobreNomeInput.insets = new Insets(0, 0, 5, 0);
		gbc_sobreNomeInput.fill = GridBagConstraints.HORIZONTAL;
		gbc_sobreNomeInput.gridx = 1;
		gbc_sobreNomeInput.gridy = 2;
		panelCliente.add(sobreNomeInput, gbc_sobreNomeInput);

		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblCpf = new GridBagConstraints();
		gbc_lblCpf.insets = new Insets(0, 0, 5, 5);
		gbc_lblCpf.gridx = 0;
		gbc_lblCpf.gridy = 3;
		panelCliente.add(lblCpf, gbc_lblCpf);

		cpfInput = new JTextField();
		GridBagConstraints gbc_cpfInput = new GridBagConstraints();
		gbc_cpfInput.gridwidth = 7;
		gbc_cpfInput.insets = new Insets(0, 0, 5, 0);
		gbc_cpfInput.fill = GridBagConstraints.HORIZONTAL;
		gbc_cpfInput.gridx = 1;
		gbc_cpfInput.gridy = 3;
		panelCliente.add(cpfInput, gbc_cpfInput);
		cpfInput.setColumns(10);

		JButton btnNovo = new JButton("NOVO");
		btnNovo.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					clienteListener.salvarCliente(nomeInput.getText(), sobreNomeInput.getText(),
							new BigInteger(cpfInput.getText()));
					atualizaTabelaClientes(clienteListener);
				} catch (Exception e) {

				}
			}
		});

		GridBagConstraints gbc_btnNovo = new GridBagConstraints();
		gbc_btnNovo.insets = new Insets(0, 0, 5, 5);
		gbc_btnNovo.gridx = 1;
		gbc_btnNovo.gridy = 4;
		panelCliente.add(btnNovo, gbc_btnNovo);

		JButton btnPesquisar = new JButton("PESQUISAR");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				filtrarTabelaClientes(clienteListener);
			}
		});

		btnPesquisar.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_btnPesquisar = new GridBagConstraints();
		gbc_btnPesquisar.insets = new Insets(0, 0, 5, 5);
		gbc_btnPesquisar.gridx = 2;
		gbc_btnPesquisar.gridy = 4;
		panelCliente.add(btnPesquisar, gbc_btnPesquisar);

		JButton btnAtualizar = new JButton("ATUALIZAR");
		btnAtualizar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				alterarTabelaClientes(clienteListener);
			}

		});
		GridBagConstraints gbc_btnAtualizar = new GridBagConstraints();
		gbc_btnAtualizar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAtualizar.gridx = 3;
		gbc_btnAtualizar.gridy = 4;
		panelCliente.add(btnAtualizar, gbc_btnAtualizar);

		JButton btnDeletar = new JButton("DELETAR");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				deletarCliente(clienteListener);
			}
		});
		btnDeletar.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_btnDeletar = new GridBagConstraints();
		gbc_btnDeletar.insets = new Insets(0, 0, 5, 5);
		gbc_btnDeletar.gridx = 4;
		gbc_btnDeletar.gridy = 4;
		panelCliente.add(btnDeletar, gbc_btnDeletar);

		JPanel listaClientesPanel = new JPanel();
		GridBagConstraints gbc_listaClientesPanel = new GridBagConstraints();
		gbc_listaClientesPanel.anchor = GridBagConstraints.SOUTH;
		gbc_listaClientesPanel.gridwidth = 8;
		gbc_listaClientesPanel.fill = GridBagConstraints.HORIZONTAL;
		gbc_listaClientesPanel.gridx = 0;
		gbc_listaClientesPanel.gridy = 6;
		panelCliente.add(listaClientesPanel, gbc_listaClientesPanel);

		tableClientes = new JTable();
		tableClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableClientes.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tableClientes.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tableClientes.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null }, },
				new String[] { "Nome", "SobreNome", "CPF" }));
		atualizaTabelaClientes(clienteListener);
		tableClientes.setBackground(Color.WHITE);
		GroupLayout gl_listaClientesPanel = new GroupLayout(listaClientesPanel);
		gl_listaClientesPanel.setHorizontalGroup(gl_listaClientesPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_listaClientesPanel.createSequentialGroup().addGap(77)
						.addComponent(tableClientes, GroupLayout.PREFERRED_SIZE, 655, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(47, Short.MAX_VALUE)));
		gl_listaClientesPanel.setVerticalGroup(gl_listaClientesPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_listaClientesPanel
						.createSequentialGroup().addContainerGap().addComponent(tableClientes,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(70, Short.MAX_VALUE)));
		listaClientesPanel.setLayout(gl_listaClientesPanel);

		panelPedidos = new JPanel();
		lblPrecoTitle.addTab("PEDIDOS", null, panelPedidos, null);
		GridBagLayout gbl_panelPedidos = new GridBagLayout();
		gbl_panelPedidos.columnWidths = new int[] { 0, 4, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panelPedidos.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panelPedidos.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panelPedidos.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panelPedidos.setLayout(gbl_panelPedidos);

		JLabel lblCliente = new JLabel("CLIENTE");
		lblCliente.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblCliente = new GridBagConstraints();
		gbc_lblCliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblCliente.gridx = 5;
		gbc_lblCliente.gridy = 0;
		panelPedidos.add(lblCliente, gbc_lblCliente);

		JLabel lblCpfPedidos = new JLabel("CPF");
		lblCpfPedidos.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblCpfPedidos = new GridBagConstraints();
		gbc_lblCpfPedidos.insets = new Insets(0, 0, 5, 5);
		gbc_lblCpfPedidos.gridx = 1;
		gbc_lblCpfPedidos.gridy = 2;
		panelPedidos.add(lblCpfPedidos, gbc_lblCpfPedidos);

		cpfPedidosInput = new JTextField();
		cpfPedidosInput.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				consultarClientePedidos(clienteListener);
				atualizarListaPedidos(pedidoListener);
			}
		});
		GridBagConstraints gbc_cpfPedidosInput = new GridBagConstraints();
		gbc_cpfPedidosInput.gridwidth = 5;
		gbc_cpfPedidosInput.insets = new Insets(0, 0, 5, 0);
		gbc_cpfPedidosInput.fill = GridBagConstraints.HORIZONTAL;
		gbc_cpfPedidosInput.gridx = 3;
		gbc_cpfPedidosInput.gridy = 2;
		panelPedidos.add(cpfPedidosInput, gbc_cpfPedidosInput);
		cpfPedidosInput.setColumns(10);

		JLabel lblNomePedidos = new JLabel("NOME");
		lblNomePedidos.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNomePedidos = new GridBagConstraints();
		gbc_lblNomePedidos.insets = new Insets(0, 0, 5, 5);
		gbc_lblNomePedidos.gridx = 1;
		gbc_lblNomePedidos.gridy = 3;
		panelPedidos.add(lblNomePedidos, gbc_lblNomePedidos);

		nomeOutputPedidos = new JTextField();
		nomeOutputPedidos.setEditable(false);
		GridBagConstraints gbc_nomeOutputPedidos = new GridBagConstraints();
		gbc_nomeOutputPedidos.gridwidth = 5;
		gbc_nomeOutputPedidos.insets = new Insets(0, 0, 5, 0);
		gbc_nomeOutputPedidos.fill = GridBagConstraints.HORIZONTAL;
		gbc_nomeOutputPedidos.gridx = 3;
		gbc_nomeOutputPedidos.gridy = 3;
		panelPedidos.add(nomeOutputPedidos, gbc_nomeOutputPedidos);
		nomeOutputPedidos.setColumns(10);

		JLabel lblSobreNomePedidos = new JLabel("SOBRE NOME");
		lblSobreNomePedidos.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblSobreNomePedidos = new GridBagConstraints();
		gbc_lblSobreNomePedidos.insets = new Insets(0, 0, 5, 5);
		gbc_lblSobreNomePedidos.gridx = 1;
		gbc_lblSobreNomePedidos.gridy = 4;
		panelPedidos.add(lblSobreNomePedidos, gbc_lblSobreNomePedidos);

		sobreNomeOutputPedidos = new JTextField();
		sobreNomeOutputPedidos.setEditable(false);
		GridBagConstraints gbc_sobreNomeOutputPedidos = new GridBagConstraints();
		gbc_sobreNomeOutputPedidos.gridwidth = 5;
		gbc_sobreNomeOutputPedidos.insets = new Insets(0, 0, 5, 0);
		gbc_sobreNomeOutputPedidos.fill = GridBagConstraints.HORIZONTAL;
		gbc_sobreNomeOutputPedidos.gridx = 3;
		gbc_sobreNomeOutputPedidos.gridy = 4;
		panelPedidos.add(sobreNomeOutputPedidos, gbc_sobreNomeOutputPedidos);
		sobreNomeOutputPedidos.setColumns(10);

		JButton btnPesquisarPedidos = new JButton("PESQUISAR");
		btnPesquisarPedidos.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnPesquisarPedidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				consultarClientePedidos(clienteListener);
				atualizarListaPedidos(pedidoListener);
			}
		});
		GridBagConstraints gbc_btnPesquisarPedidos = new GridBagConstraints();
		gbc_btnPesquisarPedidos.insets = new Insets(0, 0, 5, 5);
		gbc_btnPesquisarPedidos.gridx = 5;
		gbc_btnPesquisarPedidos.gridy = 5;
		panelPedidos.add(btnPesquisarPedidos, gbc_btnPesquisarPedidos);

		JLabel lblPedidos = new JLabel("PEDIDOS");
		lblPedidos.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblPedidos = new GridBagConstraints();
		gbc_lblPedidos.insets = new Insets(0, 0, 5, 5);
		gbc_lblPedidos.gridx = 5;
		gbc_lblPedidos.gridy = 7;
		panelPedidos.add(lblPedidos, gbc_lblPedidos);

		JLabel lblFormaPedidos = new JLabel("FORMA");
		lblFormaPedidos.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblFormaPedidos = new GridBagConstraints();
		gbc_lblFormaPedidos.insets = new Insets(0, 0, 5, 5);
		gbc_lblFormaPedidos.gridx = 1;
		gbc_lblFormaPedidos.gridy = 8;
		panelPedidos.add(lblFormaPedidos, gbc_lblFormaPedidos);

		JLabel lblNewLabel_1 = new JLabel("MATERIAL");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 9;
		panelPedidos.add(lblNewLabel_1, gbc_lblNewLabel_1);

		comboBoxMaterial.setFont(new Font("Tahoma", Font.BOLD, 15));
		comboBoxMaterial.setModel(new DefaultComboBoxModel(new String[] { "NORMAL", "PREMIUM", "LUXO" }));
		GridBagConstraints gbc_comboBoxMaterial = new GridBagConstraints();
		gbc_comboBoxMaterial.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxMaterial.gridwidth = 5;
		gbc_comboBoxMaterial.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxMaterial.gridx = 3;
		gbc_comboBoxMaterial.gridy = 9;
		panelPedidos.add(comboBoxMaterial, gbc_comboBoxMaterial);

		JLabel lblMedida0 = new JLabel("LARGURA");
		lblMedida0.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblMedida0 = new GridBagConstraints();
		gbc_lblMedida0.insets = new Insets(0, 0, 5, 5);
		gbc_lblMedida0.gridx = 1;
		gbc_lblMedida0.gridy = 10;
		panelPedidos.add(lblMedida0, gbc_lblMedida0);

		medida0Input = new JTextField();
		medida0Input.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				atualizarAreaMedida0(comboBoxForma);
			}

		});
		medida0Input.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_medida0Input = new GridBagConstraints();
		gbc_medida0Input.gridwidth = 5;
		gbc_medida0Input.insets = new Insets(0, 0, 5, 0);
		gbc_medida0Input.fill = GridBagConstraints.HORIZONTAL;
		gbc_medida0Input.gridx = 3;
		gbc_medida0Input.gridy = 10;
		panelPedidos.add(medida0Input, gbc_medida0Input);
		medida0Input.setColumns(10);

		JLabel lblMedida1 = new JLabel("ALTURA");
		lblMedida1.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblMedida1 = new GridBagConstraints();
		gbc_lblMedida1.insets = new Insets(0, 0, 5, 5);
		gbc_lblMedida1.gridx = 1;
		gbc_lblMedida1.gridy = 11;
		panelPedidos.add(lblMedida1, gbc_lblMedida1);

		medida1Input = new JTextField();
		medida1Input.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				atualizarAreaMedida1(comboBoxForma);
			}
		});
		medida1Input.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_medida1Input = new GridBagConstraints();
		gbc_medida1Input.gridwidth = 5;
		gbc_medida1Input.insets = new Insets(0, 0, 5, 0);
		gbc_medida1Input.fill = GridBagConstraints.HORIZONTAL;
		gbc_medida1Input.gridx = 3;
		gbc_medida1Input.gridy = 11;
		panelPedidos.add(medida1Input, gbc_medida1Input);
		medida1Input.setColumns(10);

		JLabel lblArea = new JLabel("AREA");
		lblArea.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblArea = new GridBagConstraints();
		gbc_lblArea.insets = new Insets(0, 0, 5, 5);
		gbc_lblArea.gridx = 1;
		gbc_lblArea.gridy = 12;
		panelPedidos.add(lblArea, gbc_lblArea);

		areaPedidos = new JTextField();

		areaPedidos.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				// atualiza apertando enter
				if (arg0.getKeyCode() == 10) {
					atualizarMedidaPedido(comboBoxForma);
				} else {
					areaPedidos.addFocusListener(new FocusAdapter() {
						@Override
						public void focusLost(FocusEvent e) {
							atualizarAreaMedida0(comboBoxForma);
							atualizarAreaMedida1(comboBoxForma);
						}
					});
				}
			}
		});
		areaPedidos.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_areaPedidos = new GridBagConstraints();
		gbc_areaPedidos.insets = new Insets(0, 0, 5, 0);
		gbc_areaPedidos.gridwidth = 5;
		gbc_areaPedidos.fill = GridBagConstraints.HORIZONTAL;
		gbc_areaPedidos.gridx = 3;
		gbc_areaPedidos.gridy = 12;
		panelPedidos.add(areaPedidos, gbc_areaPedidos);
		areaPedidos.setColumns(10);

		comboBoxForma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				atualizarTemplateMedidasPedidos(lblMedida0, lblMedida1, comboBoxForma);
			}
		});
		comboBoxForma.setFont(new Font("Tahoma", Font.BOLD, 15));
		comboBoxForma.setModel(new DefaultComboBoxModel(new String[] { "RETANGULAR", "CIRCULAR", "TRIANGULAR" }));
		GridBagConstraints gbc_comboBoxForma = new GridBagConstraints();
		gbc_comboBoxForma.gridwidth = 5;
		gbc_comboBoxForma.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxForma.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxForma.gridx = 3;
		gbc_comboBoxForma.gridy = 8;
		panelPedidos.add(comboBoxForma, gbc_comboBoxForma);

		JButton btnExcluirProduto = new JButton("EXCLUIR PRODUTO");
		btnExcluirProduto.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnExcluirProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				removePedido(pedidoListener);
			}
		});

		GridBagConstraints gbc_btnExcluirProduto = new GridBagConstraints();
		gbc_btnExcluirProduto.insets = new Insets(0, 0, 5, 5);
		gbc_btnExcluirProduto.gridx = 5;
		gbc_btnExcluirProduto.gridy = 13;
		panelPedidos.add(btnExcluirProduto, gbc_btnExcluirProduto);

		JButton btnIncluirProduto = new JButton("INCLUIR PRODUTO");
		btnIncluirProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				incluirTapetePedido(pedidoListener, comboBoxForma);
			}

			private void incluirTapetePedido(PedidoListener pedidoListener, JComboBox comboBoxForma) {
				atualizarListaPedidos(pedidoListener);
				List<Double> tamanhos = new ArrayList<Double>();
				tamanhos.add(Double.parseDouble(medida0Input.getText()));
				if (!medida1Input.getText().equals("")) {
					tamanhos.add(Double.parseDouble(medida1Input.getText()));
				}
				List<Tapete> tapetes = new ArrayList<Tapete>();
				if (comboBoxForma.getModel().getSelectedItem().equals("CIRCULAR")) {
					try {
						Forma formaC = new Circulo(tamanhos);	
						tapetes.add(new Tapete(formaC, getMaterialComboBoxPedido(comboBoxMaterial, precoListener)));
						pedidoListener.salvarPedido(tapetes, new BigInteger(cpfPedidosInput.getText()));
					} catch (Exception e1) {
						System.out.println(e1.getMessage());
					}
				}
				if (comboBoxForma.getModel().getSelectedItem().equals("RETANGULAR")) {
					try {
						Forma formaQ = new Quadrado(tamanhos);
						Material materialC = getMaterialComboBoxPedido(comboBoxMaterial, precoListener);
						tapetes.add(new Tapete(formaQ, materialC));
						pedidoListener.salvarPedido(tapetes, new BigInteger(cpfPedidosInput.getText()));
					} catch (Exception e1) {
						System.out.println(e1.getMessage());

					}
				}
				if (comboBoxForma.getModel().getSelectedItem().equals("TRIANGULAR")) {
					try {
						Forma formaT = new Triangulo(tamanhos);
						tapetes.add(new Tapete(formaT, getMaterialComboBoxPedido(comboBoxMaterial, precoListener)));
						pedidoListener.salvarPedido(tapetes, new BigInteger(cpfPedidosInput.getText()));
					} catch (Exception e1) {
						System.out.println(e1.getMessage());
					}
				}
				atualizarListaPedidos(pedidoListener);
			}
		});
		btnIncluirProduto.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_btnIncluirProduto = new GridBagConstraints();
		gbc_btnIncluirProduto.insets = new Insets(0, 0, 5, 0);
		gbc_btnIncluirProduto.gridx = 7;
		gbc_btnIncluirProduto.gridy = 13;
		panelPedidos.add(btnIncluirProduto, gbc_btnIncluirProduto);

		pedidosTable = new JTable();
		pedidosTable.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pedidosTable
				.setModel(new DefaultTableModel(
						new Object[][] { { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null }, },
						new String[] { "FORMA", "MATERIAL", "AREA", "PRECO" }));

		GridBagConstraints gbc_pedidosTable = new GridBagConstraints();
		gbc_pedidosTable.gridheight = 3;
		gbc_pedidosTable.gridwidth = 5;
		gbc_pedidosTable.insets = new Insets(0, 0, 5, 0);
		gbc_pedidosTable.fill = GridBagConstraints.BOTH;
		gbc_pedidosTable.gridx = 3;
		gbc_pedidosTable.gridy = 14;
		panelPedidos.add(pedidosTable, gbc_pedidosTable);

		JLabel lblTotal = new JLabel("TOTAL");
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints lblTotalPedido = new GridBagConstraints();
		lblTotalPedido.insets = new Insets(0, 0, 5, 5);
		lblTotalPedido.gridx = 5;
		lblTotalPedido.gridy = 17;
		panelPedidos.add(lblTotal, lblTotalPedido);

		outputTotal = new JFormattedTextField();
		outputTotal.setFont(new Font("Tahoma", Font.BOLD, 15));
		outputTotal.setEditable(false);
		GridBagConstraints gbc_outputTotal = new GridBagConstraints();
		gbc_outputTotal.insets = new Insets(0, 0, 5, 0);
		gbc_outputTotal.fill = GridBagConstraints.HORIZONTAL;
		gbc_outputTotal.gridx = 7;
		gbc_outputTotal.gridy = 17;
		panelPedidos.add(outputTotal, gbc_outputTotal);

		JPanel panelPreco = new JPanel();
		lblPrecoTitle.addTab("PRE\u00C7O", null, panelPreco, null);
		GridBagLayout gbl_panelPreco = new GridBagLayout();
		gbl_panelPreco.columnWidths = new int[] { 0, 4, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panelPreco.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panelPreco.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panelPreco.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panelPreco.setLayout(gbl_panelPreco);

		JLabel lblPrecos = new JLabel("PRE\u00C7OS");
		lblPrecos.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblPrecos = new GridBagConstraints();
		gbc_lblPrecos.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrecos.gridx = 3;
		gbc_lblPrecos.gridy = 0;
		panelPreco.add(lblPrecos, gbc_lblPrecos);

		JLabel materialPrecos = new JLabel("MATERIAL");
		materialPrecos.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_materialPrecos = new GridBagConstraints();
		gbc_materialPrecos.insets = new Insets(0, 0, 5, 5);
		gbc_materialPrecos.gridx = 1;
		gbc_materialPrecos.gridy = 2;
		panelPreco.add(materialPrecos, gbc_materialPrecos);

		JComboBox materialComboBoxPrecoPedido = new JComboBox();
		materialComboBoxPrecoPedido.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				atualizarCampoPrecoMaterial(precoListener, materialComboBoxPrecoPedido);
			}			
		});
		materialComboBoxPrecoPedido.setModel(new DefaultComboBoxModel(new String[] { "NORMAL", "PREMIUM", "LUXO" }));
		materialComboBoxPrecoPedido.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_materialComboBoxPrecoPedido = new GridBagConstraints();
		gbc_materialComboBoxPrecoPedido.fill = GridBagConstraints.HORIZONTAL;
		gbc_materialComboBoxPrecoPedido.gridwidth = 5;
		gbc_materialComboBoxPrecoPedido.insets = new Insets(0, 0, 5, 0);
		gbc_materialComboBoxPrecoPedido.gridx = 3;
		gbc_materialComboBoxPrecoPedido.gridy = 2;
		panelPreco.add(materialComboBoxPrecoPedido, gbc_materialComboBoxPrecoPedido);

		JLabel lblPreco = new JLabel("PRE\u00C7O");
		lblPreco.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblPreco = new GridBagConstraints();
		gbc_lblPreco.insets = new Insets(0, 0, 5, 5);
		gbc_lblPreco.gridx = 1;
		gbc_lblPreco.gridy = 3;
		panelPreco.add(lblPreco, gbc_lblPreco);

		precoInOut = new JTextField();
		precoInOut.setFont(new Font("Tahoma", Font.BOLD, 15));
		precoInOut.setColumns(10);
		GridBagConstraints gbc_precoInOut = new GridBagConstraints();
		gbc_precoInOut.fill = GridBagConstraints.HORIZONTAL;
		gbc_precoInOut.gridwidth = 5;
		gbc_precoInOut.insets = new Insets(0, 0, 5, 0);
		gbc_precoInOut.gridx = 3;
		gbc_precoInOut.gridy = 3;
		panelPreco.add(precoInOut, gbc_precoInOut);
		
		//traz carregado o preco
		atualizarCampoPrecoMaterial(precoListener, materialComboBoxPrecoPedido);

		JButton btnSalvarPreco = new JButton("SALVAR");
		btnSalvarPreco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				salvarPrecoMaterial(precoListener, materialComboBoxPrecoPedido);
			}
		});
		btnSalvarPreco.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_btnSalvarPreco = new GridBagConstraints();
		gbc_btnSalvarPreco.insets = new Insets(0, 0, 5, 5);
		gbc_btnSalvarPreco.gridx = 3;
		gbc_btnSalvarPreco.gridy = 5;
		panelPreco.add(btnSalvarPreco, gbc_btnSalvarPreco);

	}

	private void atualizaTabelaClientes(ClienteListener clienteListener) {
		List<Cliente> listaClientes = clienteListener.getClienteDAO();
		nomeInput.setText("");
		sobreNomeInput.setText("");
		cpfInput.setText("");
		for (int i = 0; i < tableClientes.getRowCount(); i++) {
			tableClientes.getModel().setValueAt("", i, 0);
			tableClientes.getModel().setValueAt("", i, 1);
			tableClientes.getModel().setValueAt("", i, 2);
		}
		for (int i = 0; i < listaClientes.size(); i++) {
			tableClientes.getModel().setValueAt(listaClientes.get(i).getNome(), i, 0);
			tableClientes.getModel().setValueAt(listaClientes.get(i).getSobreNome(), i, 1);
			tableClientes.getModel().setValueAt(listaClientes.get(i).getCpf(), i, 2);
		}
	}

	private void filtrarTabelaClientes(ClienteListener clienteListener) {
		List<Cliente> listaClientes = clienteListener.getClienteDAO();
		for (int i = 0; i < tableClientes.getRowCount(); i++) {
			tableClientes.getModel().setValueAt("", i, 0);
			tableClientes.getModel().setValueAt("", i, 1);
			tableClientes.getModel().setValueAt("", i, 2);
		}
		if (!nomeInput.getText().equals("") || !sobreNomeInput.getText().equals("")) {
			int j = 0;
			for (int i = 0; i < listaClientes.size(); i++) {
				if ((listaClientes.get(i).getNome().contains(nomeInput.getText().toUpperCase().trim()))
						&& (listaClientes.get(i).getSobreNome()
								.contains(sobreNomeInput.getText().toUpperCase().trim()))) {
					tableClientes.getModel().setValueAt(listaClientes.get(i).getNome(), j, 0);
					tableClientes.getModel().setValueAt(listaClientes.get(i).getSobreNome(), j, 1);
					tableClientes.getModel().setValueAt(listaClientes.get(i).getCpf(), j, 2);
					j++;
				}
			}
		} else {
			atualizaTabelaClientes(clienteListener);
		}

	}

	private void deletarCliente(ClienteListener clienteListener) {
		try {
			int rowIndex = tableClientes.getSelectedRow();
			BigInteger CPF = (BigInteger) tableClientes.getModel().getValueAt(rowIndex, 2);
			clienteListener.removerCliente(CPF);
			atualizaTabelaClientes(clienteListener);
		} catch (Exception e) {
		}
		;
	}

	private void alterarTabelaClientes(ClienteListener clienteListener) {
		for (int i = 0; i < tableClientes.getRowCount(); i++) {
			if (!tableClientes.getModel().getValueAt(i, 2).equals("")) {
				try {
					BigInteger CPF = (BigInteger) tableClientes.getModel().getValueAt(i, 2);
					String nome = ((String) tableClientes.getModel().getValueAt(i, 0));
					String sobreNome = ((String) tableClientes.getModel().getValueAt(i, 1));
					clienteListener.salvarCliente(nome, sobreNome, CPF);

				} catch (Exception e) {
				}
			}
		}
		atualizaTabelaClientes(clienteListener);
	}

	private void consultarClientePedidos(ClienteListener clienteListener) {
		if (!cpfPedidosInput.getText().equals("")) {
			Cliente clienteAux = clienteListener.consultarCliente(new BigInteger(cpfPedidosInput.getText()));
			if (clienteAux != null) {
				nomeOutputPedidos.setText(clienteAux.getNome());
				sobreNomeOutputPedidos.setText(clienteAux.getSobreNome());
			} else {
				nomeOutputPedidos.setText("CPF não Encontrado");
				sobreNomeOutputPedidos.setText("CPF não Encontrado");
			}
		}
	}

	private void atualizarTemplateMedidasPedidos(JLabel lblMedida0, JLabel lblMedida1, JComboBox comboBox) {
		if (comboBox.getModel().getSelectedItem().equals("CIRCULAR")) {
			lblMedida0.setText("RAIO");
			lblMedida1.setVisible(false);
			medida1Input.setVisible(false);
		} else if (comboBox.getModel().getSelectedItem().equals("RETANGULAR")) {
			lblMedida0.setText("LARGURA");
			lblMedida1.setVisible(true);
			medida1Input.setVisible(true);
		} else if (comboBox.getModel().getSelectedItem().equals("TRIANGULAR")) {
			lblMedida0.setText("BASE");
			lblMedida1.setVisible(true);
			medida1Input.setVisible(true);
		}
		;
	}

	private void atualizarMedidaPedido(JComboBox comboBoxForma) {
		if (comboBoxForma.getModel().getSelectedItem().equals("CIRCULAR")) {
			try {
				medida0Input
						.setText(Double.toString((Math.sqrt((Double.parseDouble(areaPedidos.getText()) / Math.PI)))));
			} catch (Exception e1) {

			}
		}
		if (comboBoxForma.getModel().getSelectedItem().equals("RETANGULAR")) {
			try {
				medida0Input.setText(Double.toString((Math.sqrt((Double.parseDouble(areaPedidos.getText()))))));
				medida1Input.setText(Double.toString((Math.sqrt((Double.parseDouble(areaPedidos.getText()))))));
			} catch (Exception e1) {

			}
		}
		if (comboBoxForma.getModel().getSelectedItem().equals("TRIANGULAR")) {
			try {
				medida0Input.setText(Double.toString((Math.sqrt((Double.parseDouble(areaPedidos.getText()))* 2))));
				medida1Input.setText(Double.toString((Math.sqrt((Double.parseDouble(areaPedidos.getText()))* 2))));
			} catch (Exception e1) {

			}
		}
	}

	private void atualizarAreaMedida0(JComboBox comboBoxForma) {
		if (comboBoxForma.getModel().getSelectedItem().equals("CIRCULAR")) {
			try {
				areaPedidos
						.setText(Double.toString((Math.pow(Double.parseDouble(medida0Input.getText()), 2) * Math.PI)));
			} catch (Exception e1) {

			}
		}
		if (comboBoxForma.getModel().getSelectedItem().equals("RETANGULAR")) {
			if (!medida1Input.getText().equals("")) {
				try {
					areaPedidos.setText(Double.toString((Double.parseDouble(medida0Input.getText())
							* (Double.parseDouble(medida1Input.getText())))));
				} catch (Exception e1) {

				}
			}
		}
		if (comboBoxForma.getModel().getSelectedItem().equals("TRIANGULAR")) {
			try {
				if (!medida1Input.getText().equals("")) {
					areaPedidos.setText(Double.toString(
							(Double.parseDouble(medida0Input.getText()) * (Double.parseDouble(medida1Input.getText())))
									/ 2));
				}
			} catch (Exception e1) {

			}
		}
	}

	private void atualizarAreaMedida1(JComboBox comboBoxForma) {
		if (comboBoxForma.getModel().getSelectedItem().equals("RETANGULAR")) {
			if (!medida0Input.getText().equals("")) {
				try {
					areaPedidos.setText(Double.toString((Double.parseDouble(medida0Input.getText())
							* (Double.parseDouble(medida1Input.getText())))));
				} catch (Exception e1) {

				}
			}
		}
		if (comboBoxForma.getModel().getSelectedItem().equals("TRIANGULAR")) {
			try {
				if (!medida0Input.getText().equals("")) {
					areaPedidos.setText(Double.toString(
							(Double.parseDouble(medida0Input.getText()) * (Double.parseDouble(medida1Input.getText())))
									/ 2));
				}
			} catch (Exception e1) {

			}
		}
	}

	private void atualizarListaPedidos(PedidoListener pedidoListener) {
		Pedido pedido = null;
		if (pedidoListener.consultarPedidos(new BigInteger(cpfPedidosInput.getText())) != null) {
			pedido = pedidoListener.consultarPedidos(new BigInteger(cpfPedidosInput.getText()));
			System.out.println(new BigInteger(cpfPedidosInput.getText()));
			System.out.println(pedido.getCPF());
		} else {
			System.out.println("Pedido não encontrado");
		}
		for (int i = 0; i < pedidosTable.getRowCount(); i++) {
			pedidosTable.getModel().setValueAt("", i, 0);
			pedidosTable.getModel().setValueAt("", i, 1);
			pedidosTable.getModel().setValueAt("", i, 2);
			pedidosTable.getModel().setValueAt("", i, 3);
		}
		if (pedido != null) {
			System.out.println(pedido);
			for (int i = 0; i < pedido.getProdutos().size(); i++) {
				pedidosTable.getModel().setValueAt(
						pedido.getProdutos().get(i).getForma().getClass().getSimpleName().toUpperCase(), i, 0);
				pedidosTable.getModel().setValueAt(pedido.getProdutos().get(i).getMaterial().getMaterialName(), i, 1);
				pedidosTable.getModel().setValueAt(pedido.getProdutos().get(i).area(), i, 2);
				pedidosTable.getModel().setValueAt(pedido.getProdutos().get(i).precoTapete(), i, 3);
			}
			outputTotal.setText(String.valueOf(pedido.totalPedido()));
		}
	}

	private void removePedido(PedidoListener pedidoListener) {
		try {
			int rowIndex = pedidosTable.getSelectedRow();
			pedidoListener.removerPedido(new BigInteger(cpfPedidosInput.getText()), rowIndex);
			atualizarListaPedidos(pedidoListener);
		} catch (Exception e) {
		}
		;
	}
	
	private Material getMaterialComboBoxPedido(JComboBox comboBoxMaterial, PrecoListener precoListener){
		if(comboBoxMaterial.getModel().getSelectedItem().equals("NORMAL")){
			return precoListener.consultarMaterial(0);
		} else if(comboBoxMaterial.getModel().getSelectedItem().equals("PREMIUM")) {
			return precoListener.consultarMaterial(1);
		} else if(comboBoxMaterial.getModel().getSelectedItem().equals("LUXO")){
			return precoListener.consultarMaterial(2);
		} else return null;
	}
	
	private void salvarPrecoMaterial(PrecoListener precoListener, JComboBox materialComboBoxPrecoPedido) {
		if (materialComboBoxPrecoPedido.getModel().getSelectedItem().equals("NORMAL")) {
			try {
				precoListener.salvarMaterial(0, Double.parseDouble(precoInOut.getText()));
			} catch (Exception e1) {
				System.out.println(e1.getMessage());
			}
		}
		if (materialComboBoxPrecoPedido.getModel().getSelectedItem().equals("PREMIUM")) {
			try {
				precoListener.salvarMaterial(1, Double.parseDouble(precoInOut.getText()));
			} catch (Exception e1) {
				System.out.println(e1.getMessage());
			}
		}
		if (materialComboBoxPrecoPedido.getModel().getSelectedItem().equals("LUXO")) {
			try {
				precoListener.salvarMaterial(2, Double.parseDouble(precoInOut.getText()));
			} catch (Exception e1) {
				System.out.println(e1.getMessage());
			}
		}
	}
	
	private void atualizarCampoPrecoMaterial(PrecoListener precoListener,
			JComboBox materialComboBoxPrecoPedido) {
		if (materialComboBoxPrecoPedido.getModel().getSelectedItem().equals("NORMAL")) {
			try {
				precoInOut.setText(precoListener.consultarMaterial(0).getPreco().toString());
			} catch (Exception e1) {
				System.out.println(e1.getMessage());
			}
		}
		if (materialComboBoxPrecoPedido.getModel().getSelectedItem().equals("PREMIUM")) {
			try {
				precoInOut.setText(precoListener.consultarMaterial(1).getPreco().toString());
			} catch (Exception e1) {
				System.out.println(e1.getMessage());
			}
		}
		if (materialComboBoxPrecoPedido.getModel().getSelectedItem().equals("LUXO")) {
			try {
				precoInOut.setText(precoListener.consultarMaterial(2).getPreco().toString());
			} catch (Exception e1) {
				System.out.println(e1.getMessage());
			}
		}
	}
}
