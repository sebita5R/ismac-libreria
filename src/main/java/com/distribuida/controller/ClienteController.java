package com.distribuida.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
  
import com.distribuida.dao.ClienteDAO;
import com.distribuida.entities.Cliente;

@Controller
@RequestMapping("/clientes")     //path Principal 
public class ClienteController {
	
	//JSP - Java server Page, son las paginas web ded tecnologias java
	
	@Autowired
	private ClienteDAO clienteDAO;
	
	@GetMapping("/findAll")      // path secundario
	public String findAll(Model  model) {
		
		//try {
			
			List<Cliente> clientes = clienteDAO.findAll();
			model.addAttribute("clientes",clientes);    //EJ : Clave = KeyClientes , valor = clientes
			
			
			return "listar-clientes";  //nombre del formulario EJ.listar-clientes.html o listar-clientes.jsp
			
//		} catch (Exception e) {
	// TODO: handle exception
//			e.printStackTrace();
//	   }
	}
	
	
	@GetMapping("/findOne")
	public String findOne(@RequestParam("idCliente")@Nullable Integer idCliente
			             ,@RequestParam("opcion")@Nullable Integer opcion
			             ,Model model
			 
			) {
	//	try {
			if(idCliente !=null) {
				Cliente cliente = clienteDAO.findOne(idCliente);
				model.addAttribute("cliente", cliente);
			}
			
			if(opcion == 1) return "add-clientes";  //Actualizacion 
			else return "del-clientes";             //Eliminación
			
	//	} catch (Exception e) {
		// TODO: handle exception
	//	}
		
		
	}
	
	@PostMapping("/add")
	public String add(@RequestParam("idCliente") @Nullable Integer idCliente
			      ,@RequestParam("cedula") @Nullable String cedula
			      ,@RequestParam("nombre") @Nullable String nombre
			      ,@RequestParam("apellido") @Nullable String apellido
			      ,@RequestParam("direccion") @Nullable String direccion
			      ,@RequestParam("telefono") @Nullable String telefono
			      ,@RequestParam("correo") @Nullable String correo
			      ,Model model
			) {
		
	//	try {
			if(idCliente == null) {
				Cliente cliente = new Cliente(0, cedula, nombre, apellido, direccion, telefono, correo);
				clienteDAO.add(cliente);
				
			}else {
				Cliente cliente = new Cliente(idCliente, cedula, nombre, apellido, direccion, telefono, correo);
				clienteDAO.up(cliente);
			
	//	} catch (Exception e) {
		// TODO: handle exception
	//	}
		
		
			
		}
		
		return "redirect:/clientes/findAll";    //ir a formulario web por path o url.
	}
	
	@GetMapping("/del")
	public String del(@RequestParam("idCliente") @Nullable Integer idCliente) {
		
		//try {
			
			clienteDAO.del(idCliente);
			
			return "redirect:/clientes/findAll";
			
	//	} catch (Exception e) {
			// TODO: handle exception
	//	}
		

		
	}

}
