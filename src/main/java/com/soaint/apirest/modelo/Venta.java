package com.soaint.apirest.modelo;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ForeignKey;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="Venta")
public class Venta {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idVenta")
	private Long id;
	
	@JsonIgnoreProperties(value={"hibernateLazyInitializer" ,"handler"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idCliente")
	private Cliente cliente;
	
	@Column(name="fecha")
	private Date fecha;
	
	@OneToMany(mappedBy = "venta", fetch = FetchType.LAZY)
	@JsonIgnoreProperties(value={"venta","hibernateLazyInitializer" ,"handler"})
    List<VentaDetalle> ventaDetalles;
	
	@PrePersist 
	public void prePersist(){
		this.fecha=new Date();
	}
	
	public Venta() {
		this.ventaDetalles = new ArrayList<VentaDetalle>();
	}
	
	public void addVentaDetalle(VentaDetalle ventaDetalle) {
		this.ventaDetalles.add(ventaDetalle);
	}

	/*
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="Detalle_Venta",joinColumns = @JoinColumn(name="idVenta"),inverseJoinColumns = @JoinColumn(name="idProducto"),foreignKey = @ForeignKey(name = "idDetalleVenta") )
	private List<Producto> productos;*/
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public List<VentaDetalle> getVentaDetalles() {
		return ventaDetalles;
	}

	public void setVentaDetalles(List<VentaDetalle> ventaDetalles) {
		this.ventaDetalles = ventaDetalles;
	}

	
	
	
}
