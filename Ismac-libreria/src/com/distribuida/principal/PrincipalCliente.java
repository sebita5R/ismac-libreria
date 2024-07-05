package com.distribuida.principal;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.distribuida.dao.ClienteDAO;
import com.distribuida.entities.Cliente;

import javassist.ClassPath;

public class PrincipalCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Patron IoC inverción de control
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		ClienteDAO clienteDAO = context.getBean("clienteDAOimpll", ClienteDAO.class);
		
		
		//CRUD : CREATE, READ, UPDATE, DELETE
		
		//add
		Cliente cliente = new Cliente(0,"123456789","juan","taipe","av. por ahi","0987654321","jtapie@correo.com");
		clienteDAO.add(cliente);
		
		
		Cliente cliente2 = new Cliente(1,"1234567892","juan2","taipe2","av. por ahi2","09876543221","jtapie@correo.com");
		//clienteDAO.add(cliente);
		
		clienteDAO.dell(1);
		
		System.out.println("*********************DEL*************************"+clienteDAO.findOne(1));
		
		clienteDAO.findALL().forEach(item ->{System.out.print(item.toString());});
		
		
		
		
		//List<Cliente> clientes= clienteDAO.findALL();
		
	//	clientes.forEach(item ->{
		//	System.out.println(item.toString());	
	//	});
			clienteDAO.findALL().forEach(item ->{System.out.print(item.toString());});
		
		
			
		context.close();

	}

}
