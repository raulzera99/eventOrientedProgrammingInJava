package com.appvenda.view.cliente;

import java.util.ArrayList;
import java.util.List;

import com.appvenda.models.Cliente;
import com.appvenda.view.table.JTableModel;

@SuppressWarnings("serial")
public class TabelaClienteModel extends JTableModel<Cliente>{
	public TabelaClienteModel() {
		tabela = new ArrayList<Cliente>();
	}
	
	public TabelaClienteModel(List<Cliente> tabela) {
		super(tabela);
		this.tabela = tabela;
		
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
	
	private List<Cliente> tabela;
	
	private final String coluna[] = {"Código","Nome", "Endereço", "Bairro", "CEP", "Email", "Telefone", "Idade"};
	
	private final Integer tamanhoCampo[] = {};
	
	
}
