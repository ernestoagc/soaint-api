package com.soaint.apirest.dao;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.soaint.apirest.modelo.Venta;
public interface VentaDao extends PagingAndSortingRepository<Venta, Long>{

}
