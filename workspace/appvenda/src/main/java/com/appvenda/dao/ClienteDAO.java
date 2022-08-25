package com.appvenda.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.appvenda.models.Cliente;

public class ClienteDAO {
	private EntityManager em;

	public ClienteDAO(EntityManager em) {
		this.em = em;
	}

	public void salvarCliente(Cliente cliente) {
		getEm().persist(cliente);
	}
	
	public Cliente alterarCliente(Cliente cliente) {
		return getEm().merge(cliente);
	}
	
	public void excluirCliente(Long id) {
		Cliente cliente = consultaClienteId(id);
		getEm().remove(cliente);
	}
	
	public Cliente consultaClienteId(Long id) {
		Cliente clienteConsultado = new Cliente();
		clienteConsultado = getEm().find(Cliente.class, id);
		return clienteConsultado;
	}
	
	public List<Cliente> listaClientes(){
		
		List<Cliente> clientes = new ArrayList<Cliente>();
		
		//Query query = getEm()
		//		.createQuery("SELECT c FROM Cliente c");
		
		TypedQuery<Cliente> query = getEm().createQuery("SELECT c FROM Cliente c", Cliente.class);
		
		
		clientes = query.getResultList();
		
		
		return clientes;
	}
	
	public List<Cliente> listaClienteNome(String nome){
		List<Cliente> clientes = new ArrayList<Cliente>();
		
		TypedQuery<Cliente> query = getEm().createQuery("SELECT c FROM Cliente c WHERE c.nome =:nome", Cliente.class);
		
		query.setParameter("nome", nome);
		
		clientes = query.getResultList();
		
		
		return clientes;
	}

	public EntityManager getEm() {
		return em;
	}

}
