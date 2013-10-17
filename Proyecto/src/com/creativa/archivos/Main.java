package com.creativa.archivos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;

import com.creativa.dao.ProductoDAO;
import com.creativa.db.datasource.DatasourceFactory;
import com.creativa.model.Producto;
import com.creativa.reader.ProductoFileReader;

public class Main {
	private static ProductoDAO productoDAO;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String path = "C:\\Users\\marvin.galdamez\\Documents\\productos.txt";
		ProductoFileReader file = new ProductoFileReader(path);
		file.read();
		productoDAO = new ProductoDAO(DatasourceFactory.dataSource);
		try {
			List<Producto> lista = productoDAO.findAll(0, 10);
			
			 for(int i = 0;i<lista.size();i++){
		            System.out.println(lista.get(i));
		}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		  /*
				 for(Producto p: file.getProductos()){
					
					 p.setCodigoProducto(p.getCodigoProducto());
					 p.setNombreProducto(p.getNombreProducto());
					 p.setPrecioProducto(p.getPrecioProducto());
					 p.setCantidadDeProducto(p.getCantidadDeProducto());
					 try {
						productoDAO.insert(p);
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
					
					 
					}*/
				 

	}
	

}
