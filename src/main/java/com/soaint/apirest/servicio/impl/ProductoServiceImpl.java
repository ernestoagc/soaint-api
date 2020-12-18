package com.soaint.apirest.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.soaint.apirest.dao.ProductoDao;
import com.soaint.apirest.modelo.Producto;
import com.soaint.apirest.servicio.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService {	
	
	@Autowired
	ProductoDao productoDao;
	
	@Override
	public List<Producto> listarProductos() {
		return (List<Producto>) productoDao.findAll();
	}

	@Override
	public Page<Producto> listarProductosPaginado(Pageable pageable) {
		// TODO Auto-generated method stub
		return productoDao.findAll(pageable);
	}

	@Override
	public Producto guardarProducto(Producto producto) {
		Producto productoRepositorio =  productoDao.save(producto);
		return productoRepositorio;
	}



	@Override
	public boolean eliminarProducto(Long id) {
		
		try {
			productoDao.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public Producto obtenerProducto(Long id) {
		// TODO Auto-generated method stub
		return productoDao.findById(id).orElse(null);
	}

}
