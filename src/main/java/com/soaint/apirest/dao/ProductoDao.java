package com.soaint.apirest.dao;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.soaint.apirest.modelo.Producto;
public interface ProductoDao extends PagingAndSortingRepository<Producto, Long>{

}
