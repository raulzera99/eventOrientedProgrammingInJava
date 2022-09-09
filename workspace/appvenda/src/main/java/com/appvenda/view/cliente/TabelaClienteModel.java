package com.appvenda.view.cliente;

import java.util.ArrayList;
import java.util.List;

import com.appvenda.models.Cliente;
import com.appvenda.view.table.JTableModel;

@SuppressWarnings("serial")
public class TabelaClienteModel extends JTableModel<Cliente>{
	private List<Cliente> tabela;
	
	private final String coluna[] = {"Código","Nome", "Endereço", "Bairro", "CEP", "Email", "Telefone", "Idade"};
	
	private final Integer tamanhoCampo[] = {};
	
	
	public TabelaClienteModel() {
		tabela = new ArrayList<Cliente>();
		setColuna(coluna);
	}
	
	public TabelaClienteModel(List<Cliente> tabela) {
		super(tabela);
		this.tabela = tabela;
		setColuna(coluna);
	}
	
	@Override
	public Object getValueAt(int linha, int coluna) {
		Cliente cliente = tabela.get(linha);
		switch(coluna) {
			case 0:{
				return cliente.getId();
			}
			case 1:{
				return cliente.getNome();
			}
			case 2:{
				return cliente.getEndereco();
			}
			case 3:{
				return cliente.getBairro();
			}
			case 4:{
				return cliente.getCep();
			}
			case 5:{
				return cliente.getEmail();
			}
			case 6:{
				return cliente.getTelefone();
			}
			case 7:{
				return cliente.getIdade();
			}
			default:
				return null;
			
		}
		
	}
	
	@Override
	public Class<?> getColumnClass(int coluna){
		switch (coluna) {
			case 0:{
				return Long.class;
			}
			case 1:{
				return String.class;
			}
			case 2:{
				return String.class;
			}
			case 3:{
				return String.class;
			}
			case 4:{
				return String.class;
			}
			case 5:{
				return String.class;
			}
			case 6:{
				return String.class;
			}
			case 7:{
				return Integer.class;
			}
			default:
				return null;
		}
	}
	
	public Cliente getCliente(int index) {
		return getTabela().get(index);
	}
	
	public void salvarCliente(Cliente cliente) {
		getTabela().add(cliente);
		fireTableRowsInserted(getRowCount()-1, getColumnCount()-1);
	}
	
	public void alterarCliente(Cliente cliente, int index) {
		getTabela().set(index, cliente);
		fireTableRowsUpdated(index, index);
	}
	
	public void removerCliente(int index) {
		getTabela().remove(index);
		fireTableRowsDeleted(index, index);
	}
	
	public void removeAll() {
		getTabela().clear();
		fireTableDataChanged();
	}

	public List<Cliente> getTabela() {
		return tabela;
	}

	public void setTabela(List<Cliente> tabela) {
		this.tabela = tabela;
	}

	public String[] getColuna() {
		return coluna;
	}

	public Integer[] getTamanhoCampo() {
		return tamanhoCampo;
	}
	
	
	
}
