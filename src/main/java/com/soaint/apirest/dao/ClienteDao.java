package com.soaint.apirest.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.soaint.apirest.modelo.Cliente;

public interface ClienteDao extends PagingAndSortingRepository<Cliente, Long> {

}
