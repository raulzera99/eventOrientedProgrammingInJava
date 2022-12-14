package com.appvenda.view.cliente;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.appvenda.models.Cliente;
import com.appvenda.services.ClienteService;
import com.appvenda.services.UserService;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClientesView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2848604308078518244L;
	private JPanel contentPane;
	private JTextField textNome;
	private JTextField txtEndereco;
	private JTextField txtBairro;
	private JTextField txtCep;
	private JTextField txtEmail;
	private JTextField txtTelefone;
	private JTextField txtIdade;
	
	private JButton btnCancelar;
	private JButton btnSalvar;
	
	private ClienteService clienteService;
	private Cliente cliente;
	
	private Long idCliente = 0L;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientesView frame = new ClientesView();
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
	public ClientesView() {
		initComponents();
		eventHandler();
		consultarCliente();
	}	

	private void initComponents() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 482, 482);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setForeground(Color.WHITE);
		panel.setBounds(10, 11, 446, 289);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Verdana", Font.BOLD, 11));
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setBounds(23, 27, 46, 14);
		panel.add(lblNome);
		
		textNome = new JTextField();
		textNome.setBorder(null);
		textNome.setBounds(79, 25, 212, 20);
		panel.add(textNome);
		textNome.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBorder(new LineBorder(new Color(0, 0, 0)));
		separator.setBounds(79, 45, 212, 2);
		panel.add(separator);
		
		JLabel lblEndereco = new JLabel("Endere??o:");
		lblEndereco.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEndereco.setFont(new Font("Verdana", Font.BOLD, 11));
		lblEndereco.setBounds(0, 69, 69, 14);
		panel.add(lblEndereco);
		
		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		txtEndereco.setBorder(null);
		txtEndereco.setBounds(79, 61, 212, 20);
		panel.add(txtEndereco);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		separator_1.setBounds(79, 81, 212, 2);
		panel.add(separator_1);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBairro.setFont(new Font("Verdana", Font.BOLD, 11));
		lblBairro.setBounds(0, 102, 69, 14);
		panel.add(lblBairro);
		
		txtBairro = new JTextField();
		txtBairro.setColumns(10);
		txtBairro.setBorder(null);
		txtBairro.setBounds(79, 94, 212, 20);
		panel.add(txtBairro);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		separator_1_1.setBounds(79, 114, 212, 2);
		panel.add(separator_1_1);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCep.setFont(new Font("Verdana", Font.BOLD, 11));
		lblCep.setBounds(0, 135, 69, 14);
		panel.add(lblCep);
		
		txtCep = new JTextField();
		txtCep.setColumns(10);
		txtCep.setBorder(null);
		txtCep.setBounds(79, 127, 212, 20);
		panel.add(txtCep);
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		separator_1_2.setBounds(79, 147, 212, 2);
		panel.add(separator_1_2);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setFont(new Font("Verdana", Font.BOLD, 11));
		lblEmail.setBounds(0, 168, 69, 14);
		panel.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBorder(null);
		txtEmail.setBounds(79, 160, 212, 20);
		panel.add(txtEmail);
		
		JSeparator separator_1_3 = new JSeparator();
		separator_1_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		separator_1_3.setBounds(79, 180, 212, 2);
		panel.add(separator_1_3);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefone.setFont(new Font("Verdana", Font.BOLD, 11));
		lblTelefone.setBounds(0, 201, 69, 14);
		panel.add(lblTelefone);
		
		txtTelefone = new JTextField();
		txtTelefone.setColumns(10);
		txtTelefone.setBorder(null);
		txtTelefone.setBounds(79, 193, 212, 20);
		panel.add(txtTelefone);
		
		JSeparator separator_1_4 = new JSeparator();
		separator_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		separator_1_4.setBounds(79, 213, 212, 2);
		panel.add(separator_1_4);
		
		JLabel lblIdade = new JLabel("Idade:");
		lblIdade.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIdade.setFont(new Font("Verdana", Font.BOLD, 11));
		lblIdade.setBounds(0, 234, 69, 14);
		panel.add(lblIdade);
		
		txtIdade = new JTextField();
		txtIdade.setColumns(10);
		txtIdade.setBorder(null);
		txtIdade.setBounds(79, 226, 212, 20);
		panel.add(txtIdade);
		
		JSeparator separator_1_5 = new JSeparator();
		separator_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		separator_1_5.setBounds(79, 246, 212, 2);
		panel.add(separator_1_5);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GREEN);
		panel_1.setBounds(10, 302, 446, 130);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Verdana", Font.BOLD, 15));
		btnSalvar.setBounds(54, 43, 102, 63);
		panel_1.add(btnSalvar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Verdana", Font.BOLD, 15));
		btnCancelar.setBounds(282, 43, 113, 63);
		panel_1.add(btnCancelar);
		dataBaseConnection();
	}
	
	private void eventHandler() {
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(idCliente == 0L) {
					salvarCliente();
				}
				else {
					alterarCliente();
				}

			}
		});
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
	
	// Rotinas para manuten????o de cadastro
	
	private void excluirCliente() {
		clienteService = getClienteService();
		cliente = getCliente();
		
		clienteService.excluirCliente(idCliente);
		
		limparCampos();
		
	}

	public void salvarCliente() {
		clienteService = getClienteService();
		cliente = getCliente();
		
		setClienteFromView();
		
		clienteService.salvarCliente(cliente);
		limparCampos();
		
	}


	
	public void alterarCliente() {
		clienteService = getClienteService();
		cliente = getCliente();
		
		cliente.setId(idCliente);
		setClienteFromView();
		
		clienteService.alterarCliente(cliente);
		limparCampos();
		
	}
	
	
	
	public void consultarCliente() {
		clienteService = getClienteService();
		cliente = getCliente();
		
		Long id = 3L;
		
		cliente = clienteService.consultaClienteId(id);
		
		getClienteFromDataBase();
	}

	
	
	public void listarClientes() {
		ClienteService clienteService = new ClienteService();
		List<Cliente> clientes = new ArrayList<Cliente>();
		
		clientes = clienteService.listaCliente();
		
		for (Cliente cliente: clientes) {
			System.out.println(cliente.toString());
		}
	}
	
	public void dataBaseConnection() {
		System.out.println("Connecting database on ClientsView");
		UserService userService = new UserService();
		userService.showDataBaseConnection();
	}
	
	public void limparCampos() {
		idCliente = 0L;
		textNome.setText("");
		txtEndereco.setText("");
		txtBairro.setText("");
		txtCep.setText("");
		txtEmail.setText("");
		txtTelefone.setText("");
		txtIdade.setText("");
	}
	
	private void setClienteFromView() {
		cliente.setNome(textNome.getText());
		cliente.setEndereco(txtEndereco.getText());
		cliente.setBairro(txtBairro.getText());
		cliente.setIdade(Integer.parseInt(txtIdade.getText()));
		cliente.setEmail(txtEmail.getText());
		cliente.setCep(txtCep.getText());
		cliente.setTelefone(txtTelefone.getText());
	}
	
	private void getClienteFromDataBase() {
		idCliente = cliente.getId();
		
		textNome.setText(cliente.getNome());
		txtEndereco.setText(cliente.getEndereco());
		txtBairro.setText(cliente.getBairro());
		txtCep.setText(cliente.getCep());
		txtEmail.setText(cliente.getEmail());
		txtTelefone.setText(cliente.getTelefone());
		txtIdade.setText(String.valueOf(cliente.getIdade()));
	}
	
	public Cliente getCliente() {
		return new Cliente();
	}
	
	public ClienteService getClienteService() {
		return new ClienteService();
	}
}
