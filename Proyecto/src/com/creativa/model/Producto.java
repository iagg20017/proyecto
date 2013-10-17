package com.creativa.model;

public class Producto {
	
	private String codigoProducto;
	private String nombreProducto;
	private double precioProducto;
	private int cantidadDeProducto;
	
	public Producto(){
		
	}
	
	public Producto(String codigoProducto, String nombreProducto,
			double precioProducto, int cantidadDeProducto) {
		super();
		this.codigoProducto = codigoProducto;
		this.nombreProducto = nombreProducto;
		this.precioProducto = precioProducto;
		this.cantidadDeProducto = cantidadDeProducto;
	}

	public String getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public double getPrecioProducto() {
		return precioProducto;
	}

	public void setPrecioProducto(double precioProducto) {
		this.precioProducto = precioProducto;
	}

	public int getCantidadDeProducto() {
		return cantidadDeProducto;
	}

	public void setCantidadDeProducto(int cantidadDeProducto) {
		this.cantidadDeProducto = cantidadDeProducto;
	}
	
	

}
