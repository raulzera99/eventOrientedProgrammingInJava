package com.appvenda.view.cliente;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.appvenda.config.Page;
import com.appvenda.models.Cliente;
import com.appvenda.services.ClienteService;
import com.appvenda.view.table.RenderTable;

public class TabelaCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNomePesquisa;
	private JTable tabelaCliente;
	
	private TabelaClienteModel model;
	private Page<Cliente> page;
	private ClienteService clienteService;
	
	private int linha = 0;
	private int coluna = 0;
	private int tamanhoPagina = 10;
	private int paginaAtual = 0;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TabelaCliente frame = new TabelaCliente();
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
	public TabelaCliente() {
		initComponents();
		evenHandler();
		iniciarTabela();
	}

	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelTabela = new JPanel();
		panelTabela.setBounds(10, 110, 764, 361);
		contentPane.add(panelTabela);
		panelTabela.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 744, 339);
		panelTabela.add(scrollPane);
		
		JScrollPane scrollPanelCliente = new JScrollPane();
		scrollPane.setViewportView(scrollPanelCliente);
		
		tabelaCliente = new JTable();
		scrollPanelCliente.setViewportView(tabelaCliente);
		
		JPanel panelPesquisa = new JPanel();
		panelPesquisa.setBounds(10, 11, 764, 88);
		contentPane.add(panelPesquisa);
		panelPesquisa.setLayout(null);
		
		JLabel lblPesquisa = new JLabel("Nome:");
		lblPesquisa.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblPesquisa.setBounds(10, 11, 54, 14);
		panelPesquisa.add(lblPesquisa);
		
		txtNomePesquisa = new JTextField();
		txtNomePesquisa.setFont(new Font("Verdana", Font.PLAIN, 15));
		txtNomePesquisa.setBounds(74, 11, 544, 20);
		panelPesquisa.add(txtNomePesquisa);
		txtNomePesquisa.setColumns(10);
		
		JButton btnPesquisa = new JButton("Pesquisar");
		btnPesquisa.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnPesquisa.setBounds(649, 10, 89, 23);
		panelPesquisa.add(btnPesquisa);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdd.setFont(new Font("Verdana", Font.BOLD, 15));
		btnAdd.setBounds(20, 482, 105, 68);
		contentPane.add(btnAdd);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUpdate.setFont(new Font("Verdana", Font.BOLD, 15));
		btnUpdate.setBounds(135, 482, 105, 68);
		contentPane.add(btnUpdate);
		
		JButton btnRemove = new JButton("Remover");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRemove.setFont(new Font("Verdana", Font.BOLD, 15));
		btnRemove.setBounds(250, 482, 129, 68);
		contentPane.add(btnRemove);
		
		JButton btnConsulta = new JButton("Consultar");
		btnConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnConsulta.setFont(new Font("Verdana", Font.BOLD, 15));
		btnConsulta.setBounds(389, 482, 129, 68);
		contentPane.add(btnConsulta);
	}
	
	
	private void evenHandler() {
		
		
	}
	
	public void iniciarTabela() {
		listarCliente();
		
		System.out.println(page.getContent().size());
		
		model = new TabelaClienteModel(page.getContent());
		tabelaCliente.setModel(model);
		
		model.fireTableDataChanged();
		
		RenderTable render = new RenderTable();
		for(int coluna = 0; coluna < model.getColumnCount(); coluna++) {
			tabelaCliente.setDefaultRenderer(model.getColumnClass(coluna), render);
		}
		
	}
	
	private void listarCliente() {
		clienteService = getClienteService();
		page = clienteService.listaPaginada(paginaAtual, tamanhoPagina);
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public void setContentPane(JPanel contentPane) {
		this.contentPane = contentPane;
	}

	public JTextField getTxtNomePesquisa() {
		return txtNomePesquisa;
	}

	public void setTxtNomePesquisa(JTextField txtNomePesquisa) {
		this.txtNomePesquisa = txtNomePesquisa;
	}

	public JTable getTabelaCliente() {
		return tabelaCliente;
	}

	public void setTabelaCliente(JTable tabelaCliente) {
		this.tabelaCliente = tabelaCliente;
	}

	public TabelaClienteModel getModel() {
		return model;
	}

	public void setModel(TabelaClienteModel model) {
		this.model = model;
	}

	public int getLinha() {
		return linha;
	}

	public void setLinha(int linha) {
		this.linha = linha;
	}

	public int getColuna() {
		return coluna;
	}

	public void setColuna(int coluna) {
		this.coluna = coluna;
	}

	public int getTamanhoPagina() {
		return tamanhoPagina;
	}

	public void setTamanhoPagina(int tamanhoPagina) {
		this.tamanhoPagina = tamanhoPagina;
	}

	public int getPaginaAtual() {
		return paginaAtual;
	}

	public void setPaginaAtual(int paginaAtual) {
		this.paginaAtual = paginaAtual;
	}

	public Page<Cliente> getPage() {
		return page;
	}

	public void setPage(Page<Cliente> page) {
		this.page = page;
	}

	public ClienteService getClienteService() {
		return new ClienteService();
	}

	public void setClienteService(ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	
	
}
