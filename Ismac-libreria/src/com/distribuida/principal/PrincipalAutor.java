package com.distribuida.principal;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.distribuida.dao.AutorDAO;
import com.distribuida.entities.Autor;



public class PrincipalAutor {

	public static void main(String[] args) {
	// TODO Auto-generated method stub
		
		//Patron IoC inverción de control
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		AutorDAO AutorDAO = context.getBean("autorDAOImpl", AutorDAO.class);
		
		
		List<Autor> clientes= AutorDAO.findALL();
		
		clientes.forEach(item ->{
			System.out.println(item.toString());	
		});
			
		
		
		
		context.close();


	}

}
