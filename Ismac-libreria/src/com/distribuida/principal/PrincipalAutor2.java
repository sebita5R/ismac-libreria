package com.distribuida.principal;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.distribuida.dao.AutorDAO;
import com.distribuida.entities.Autor;

import javassist.ClassPath;

public class PrincipalAutor2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Patron IoC inverción de control
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		AutorDAO autorDAO = context.getBean("autorDAOImpl2", AutorDAO.class);
		
		
		//CRUD : CREATE, READ, UPDATE, DELETE
		
		//add
		Autor autor = new Autor(0,"123456789","juan","taipe","av. por ahi","0987654321","jtapie@correo.com");
		//autorDAO.add(autor);
		
		
		Autor autor2 = new Autor(56,"1234567892","juan2","taipe2","av. por ahi2","09876543221","jtapie@correo.com");
		//autorDAO.add(autor2);
		
		autorDAO.dell(56);
		
		//System.out.println("*********************DEL*************************"+autorDAO.findOne(39));
		
		autorDAO.findALL().forEach(item ->{System.out.println(item.toString());});
		
				
		context.close();
//
	}

}
