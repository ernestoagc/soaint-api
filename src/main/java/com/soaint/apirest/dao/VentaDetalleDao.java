package com.soaint.apirest.dao;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.soaint.apirest.modelo.VentaDetalle;
public interface VentaDetalleDao extends PagingAndSortingRepository<VentaDetalle, Long> {

}
