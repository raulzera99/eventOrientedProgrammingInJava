package com.appvenda.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.appvenda.config.Page;
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

	public Page<Cliente> listaPaginada(int paginaAtual, int tamanhoPagina) {
		List<Cliente> listaCliente = new ArrayList<Cliente>();
		Page<Cliente> page = new Page<Cliente>();
		TypedQuery<Cliente> query = getEm()
				.createQuery("SELECT c FROM Cliente c", Cliente.class);
		
		listaCliente = query.setFirstResult(paginaAtual)
				.setMaxResults(tamanhoPagina)
				.getResultList();
		
		page.setContent(listaCliente);
		page.setPage(paginaAtual);
		page.setPageSize(tamanhoPagina);
		page.setTotalRecords(count().intValue());
		page.setTotalPage((count().intValue())/tamanhoPagina);
		
		return page;
	}
	
	public Long count() {
		TypedQuery<Long> query = getEm()
				.createQuery("SELECT COUNT(c) FROM Cliente c", Long.class);
		Long total = query.getSingleResult();
		return total;
	}

}
