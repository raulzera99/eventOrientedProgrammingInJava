package com.appvenda.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.appvenda.models.User;
import com.appvenda.services.UserService;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class ClientsView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientsView frame = new ClientsView();
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
	public ClientsView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 464, 312);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 438, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 263, Short.MAX_VALUE)
		);
		contentPane.setLayout(gl_contentPane);
		dataBaseConnection();
		saveUser();
	}
	
	private void saveUser() {
		User user = new User();
		user.setUsername("Raul Prado Dantas");
		user.setEmail("r.dantas@aluno.ifsp.edu.br");
		user.setPassword("12345");
		user.setConfirm("12345");
		user.setActive(true);
		
		UserService userService = new UserService();
		
		userService.saveUser(user);
		
	}

	public void dataBaseConnection() {
		System.out.println("Connecting database on ClientsView");
		UserService userService = new UserService();
		userService.showDataBaseConnection();
	}
}
