package com.soaint.apirest.modelo;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ForeignKey;


@Entity
@Table(name="DetalleVenta")
public class VentaDetalle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idDetalleVenta")
    Long id;

    @ManyToOne
    @JoinColumn(name = "idVenta")
    Venta venta;

    @ManyToOne
    @JoinColumn(name = "idProducto")
    Producto producto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

    

}
