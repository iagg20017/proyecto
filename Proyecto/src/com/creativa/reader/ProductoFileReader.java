package com.creativa.reader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.creativa.model.Producto;

public class ProductoFileReader extends SimpleFileReader {
	private List<Producto> productos;

	public ProductoFileReader(String path) {
		super(path);
		productos = new ArrayList<Producto>();
	}

	public ProductoFileReader(File file) {
		super(file);
		productos = new ArrayList<Producto>();
		}
	@Override
	public void read() {
		// TODO Auto-generated method stub
		super.read();
		for(String linea : getLineas()){
			String[] data = linea.split(";");
			productos.add(new Producto(
					data[0],
					data[1],
					Double.parseDouble(data[2]),
					Integer.parseInt(data[3])
					));
		}	
	}
	
	public List<Producto> getProductos(){
		return productos;
	}
	

}
