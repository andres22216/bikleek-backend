package com.bikleek.springboot.backend.apirest.models.services;

import java.util.List;

import com.bikleek.springboot.backend.apirest.models.entity.Cliente;

public interface IClienteService {

	public Cliente save(Cliente cliente);
	public void delete(Long id);
	public List<Cliente> findAll();
	public Cliente findById(Long id); 
}
