package com.soaint.apirest.servicio;

import java.util.List;

import com.soaint.apirest.modelo.Venta;

public interface VentaService {

	public Venta guardarVenta(Venta venta);
	
	public Venta obtenerVenta(Long id);
	
	public List<Venta> listarVentas();
}
