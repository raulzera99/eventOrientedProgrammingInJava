package com.appvenda.view;

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

public class VendasView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2848604308078518244L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VendasView frame = new VendasView();
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
	public VendasView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		dataBaseConnection();
		//salvarCliente();
		//alterarCliente();
		//excluirCliente();
		//consultarCliente();
		listarClientes();
	}

	private void excluirCliente() {
		ClienteService clienteService = new ClienteService();
		Long id = 1L;
		
		Cliente cliente = new Cliente();
		
		cliente = clienteService.consultaClienteId(id);
		
		System.out.println(cliente.toString());
		
		clienteService.excluirCliente(cliente.getId());
		
		
		
	}

	public void salvarCliente() {
		ClienteService clienteService = new ClienteService();
		Cliente cliente = new Cliente();
		
		cliente.setNome("Raul Prado Dantas 1");
		cliente.setEndereco("Rua Dr Jorge Ayub");
		cliente.setBairro("Seja feliz");
		cliente.setIdade(20);
		cliente.setEmail("r.dantas@aluno.ifs.edu.br");
		cliente.setCep("17.125-002");
		cliente.setTelefone("(14)98803-7621");
		
		clienteService.salvarCliente(cliente);
		
	}
	
	public void alterarCliente() {
		ClienteService clienteService = new ClienteService();
		Cliente cliente = new Cliente();
		Cliente clienteCadastrado = new Cliente();
		
		clienteCadastrado = clienteService.consultaClienteId(1L);
		
		//System.out.println(clienteCadastrado.toString());
		
		cliente.setId(clienteCadastrado.getId());
		cliente.setNome(clienteCadastrado.getNome());
		cliente.setEndereco(clienteCadastrado.getEndereco());
		cliente.setBairro(clienteCadastrado.getBairro());
		cliente.setIdade(clienteCadastrado.getIdade());
		cliente.setEmail(clienteCadastrado.getEmail());
		cliente.setCep(clienteCadastrado.getCep());
		cliente.setTelefone(clienteCadastrado.getTelefone());
		
		System.out.println(clienteCadastrado.toString());
		
		cliente.setNome("Flaubert Dantas de Oliveira");
		
		clienteService.alterarCliente(cliente);
		
		
	}
	
	public void consultarCliente() {
		ClienteService clienteService = new ClienteService();
		Cliente cliente = new Cliente();
		
		Long id = 2L;
		
		cliente = clienteService.consultaClienteId(id);
		
		System.out.println(cliente.toString());
		
	}
	
	public void listarClientes() {
		ClienteService clienteService = new ClienteService();
		//Cliente cliente = new Cliente();
		List<Cliente> clientes = new ArrayList<Cliente>();
		
		clientes = clienteService.listaCliente();
		
		for (Cliente cliente: clientes) {
			System.out.println(cliente.toString());
		}
	}
	
	public void dataBaseConnection() {
		System.out.println("Connecting database on VendasView");
		UserService userService = new UserService();
		userService.showDataBaseConnection();
	}
	
}
