package com.bikleek.springboot.backend.apirest.controllers;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bikleek.springboot.backend.apirest.models.entity.Cliente;
import com.bikleek.springboot.backend.apirest.models.services.IClienteService;

@RestController
@RequestMapping("/api")
public class ClienteRestController {

	
	@Autowired
	private IClienteService clienteService;
	
	@GetMapping("/clientes")
	public List<Cliente> obtenerTodos(){
		return clienteService.findAll();
	}
	
	@PostMapping("/clientes")
	public Cliente crear(@RequestBody Cliente cliente){
		cliente.setFechaCreacion(new Date());
		return clienteService.save(cliente);
	}
	
	@PutMapping("/clientes")
	public Cliente actualizar(@RequestBody Cliente cliente) {
		
		Cliente clienteActual = clienteService.findById(cliente.getId());
		Cliente clienteActualizado = null;
		
		clienteActual.setNombre(cliente.getNombre());
		clienteActual.setApellido(cliente.getApellido());
		clienteActual.setCorreo(cliente.getCorreo());
		clienteActual.setDireccion(cliente.getDireccion());
		clienteActual.setFechaCreacion(new Date());
		
		clienteActualizado = clienteService.save(clienteActual);
		
		return clienteActualizado;
	}
	
//	@DeleteMapping("/clientes")
//	public void eliminar(@RequestBody Cliente cliente) {
//		clienteService.delete(cliente.getId());
//	}
	
	@DeleteMapping("/clientes/{id}")
	public void eliminar(@PathVariable Long id) {
		clienteService.delete(id);
	}
	
}
