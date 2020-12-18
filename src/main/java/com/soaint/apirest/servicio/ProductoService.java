package com.soaint.apirest.servicio;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.soaint.apirest.modelo.Producto;

public interface ProductoService {
	
	public List<Producto> listarProductos(); 		
	public Page<Producto> listarProductosPaginado(Pageable pageable);
	public Producto guardarProducto(Producto producto);
	public boolean eliminarProducto(Long id);
	public Producto obtenerProducto(Long id);
	

}
