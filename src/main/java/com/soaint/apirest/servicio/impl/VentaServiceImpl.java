package com.soaint.apirest.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soaint.apirest.dao.VentaDao;
import com.soaint.apirest.dao.VentaDetalleDao;
import com.soaint.apirest.modelo.Venta;
import com.soaint.apirest.modelo.VentaDetalle;
import com.soaint.apirest.servicio.VentaService;

@Service
public class VentaServiceImpl  implements VentaService{

	@Autowired
	VentaDao ventaDao;
	
	@Autowired
	VentaDetalleDao ventaDetalleDao;
	
	@Override
	public Venta guardarVenta(Venta venta) {
		
		List<VentaDetalle> ventaDetalles = venta.getVentaDetalles();
		Venta ventaRepositorio = ventaDao.save(venta);
		
		for (VentaDetalle ventaDetalle : ventaDetalles) {
			ventaDetalle.setVenta(venta);
			ventaDetalleDao.save(ventaDetalle);
		}
		
		return ventaRepositorio;
	}

	@Override
	public Venta obtenerVenta(Long id) {
		// TODO Auto-generated method stub
		return ventaDao.findById(id).orElse(null);
	}

	@Override
	public List<Venta> listarVentas() {
		// TODO Auto-generated method stub
		return (List<Venta>) ventaDao.findAll();
	}

}
