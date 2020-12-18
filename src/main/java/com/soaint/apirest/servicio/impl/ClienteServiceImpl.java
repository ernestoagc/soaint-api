package com.soaint.apirest.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soaint.apirest.dao.ClienteDao;
import com.soaint.apirest.modelo.Cliente;
import com.soaint.apirest.servicio.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	ClienteDao clienteDao;

	@Override
	public Cliente guardarCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		return clienteDao.save(cliente);
	}

	@Override
	public Cliente obtenerCliente(Long id) {
		// TODO Auto-generated method stub
		return clienteDao.findById(id).orElse(null);
	}

}
