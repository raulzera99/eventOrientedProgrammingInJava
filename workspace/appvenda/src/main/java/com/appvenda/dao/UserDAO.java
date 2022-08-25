package com.appvenda.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.appvenda.models.User;

public class UserDAO {
	private EntityManager em;
	
	public UserDAO (EntityManager em) {
		this.em = em;
	}
	
	public void saveUser (User user) {
		System.out.println("Saving on dataBase the user: "+user.toString());
	}
	
	public void salvarUser(User user) {
		getEm().persist(user);
	}
	
	public User alterarUser(User user) {
		return getEm().merge(user);
	}
	
	public void excluirUser(Integer id) {
		User user = consultaUserId(id);
		getEm().remove(user);
	}

	private User consultaUserId(Integer id) {
		
		return getEm().find(User.class, id);
	}
	
	public List<User> listaUser(){
		List<User> users = new ArrayList<User>();
		
		TypedQuery<User> query = getEm().createQuery("SELECT u FROM User u", User.class);
		
		users = query.getResultList();
		
		return users;
	}
	
	public List<User> listaUserNome (String nome){
		List<User> users = new ArrayList<User>();
		
		TypedQuery<User> query = getEm().createQuery("SELECT u FROM User u WHERE u.username =:nome", User.class);
		
		query.setParameter("nome", nome);
		
		users = query.getResultList();
		
		return users;
	}
	
	public EntityManager getEm() {
		return em;
	}
}
