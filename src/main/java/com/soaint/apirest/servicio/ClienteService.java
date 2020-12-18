package com.soaint.apirest.servicio;

import com.soaint.apirest.modelo.Cliente;

public interface ClienteService {

	public Cliente guardarCliente(Cliente cliente);
	public Cliente obtenerCliente(Long id);
}
