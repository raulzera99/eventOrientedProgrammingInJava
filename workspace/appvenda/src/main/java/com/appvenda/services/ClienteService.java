package com.appvenda.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import com.appvenda.config.Page;
import com.appvenda.dao.ClienteDAO;
import com.appvenda.models.Cliente;
import com.appvenda.persistence.DataBaseConnection;

public class ClienteService {
	
	@PersistenceContext(unitName = "appvenda")
	private final EntityManager em;
	
	private ClienteDAO dao;
	
	private EntityTransaction tx;
	

	public ClienteService() {
		em = DataBaseConnection.getConnection().getEntityManager();
		dao = new ClienteDAO(em);
	}

	public void salvarCliente(Cliente cliente) {
		tx = getEm().getTransaction();
		
		try {
			getTx().begin();
			getDao().salvarCliente(cliente);
			getTx().commit();
		}
		catch(Exception e) {
			e.printStackTrace();
			if(getTx().isActive()) {
				getTx().rollback();
			}
		}finally {
			getEm().close();
		}
		
	}
	
	public Cliente alterarCliente(Cliente cliente) {
		
		tx = getEm().getTransaction();
		
		try {
			getTx().begin();
			Cliente clienteAtual = getDao().alterarCliente(cliente);
			getTx().commit();
			return clienteAtual;
		}
		catch(Exception e) {
			e.printStackTrace();
			if(getTx().isActive()) {
				getTx().rollback();
			}
		}finally {
			getEm().close();
		}
		
		return null;
	}
	
	public void excluirCliente(Long id) {
		tx = getEm().getTransaction();
		
		try {
			getTx().begin();
			getDao().excluirCliente(id);
			getTx().commit();
		}
		catch(Exception e) {
			e.printStackTrace();
			if(getTx().isActive()) {
				getTx().rollback();
			}
		}finally {
			getEm().close();
		}
	}
	
	public Cliente consultaClienteId(Long id) {
		Cliente cliente = new Cliente();
		cliente = dao.consultaClienteId(id);
		return cliente;
	}
	
	public List<Cliente> listaCliente(){
		return dao.listaClientes();
	}
	
	public List<Cliente> listaClienteNome(){
		return null;
	}

	public EntityManager getEm() {
		return em;
	}

	public EntityTransaction getTx() {
		return tx;
	}

	public ClienteDAO getDao() {
		return dao;
	}

	public Page<Cliente> listaPaginada(int paginaAtual, int tamanhoPagina) {
		
		return dao.listaPaginada(paginaAtual, tamanhoPagina);
	}
	
	
	
}
