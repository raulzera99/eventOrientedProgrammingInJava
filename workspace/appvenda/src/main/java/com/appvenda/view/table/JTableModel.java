package com.appvenda.view.table;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public abstract class JTableModel<T> extends AbstractTableModel{
	
	protected List<T> tabela;
	protected String coluna[];
	
	public JTableModel () {tabela = new ArrayList<T>();}
	
	public JTableModel(List<T> tabela) {
		this.tabela = tabela;
	}
	
	
	public int getRowCount() {
		return tabela.size();
	}

	public int getColumnCount() {
		return coluna.length;
	}

	public T getValueAt(int linha) {
		return tabela.get(linha);
	}
	
	public T setValueAt(int linha, T objeto) {
		return tabela.set(linha, objeto);
	}
	
	public List<T> getTabela() {
		return tabela;
	}

	public void setTabela(List<T> tabela) {
		this.tabela = tabela;
	}

	public String[] getColuna() {
		return coluna;
	}

	public void setColuna(String[] coluna) {
		this.coluna = coluna;
	}
	
	public Object getValueAt(int rowIndex, int columnIndex) {
		return null;
	}
	
}
