package com.creativa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import com.creativa.model.Producto;

public class ProductoDAO extends BaseDAO {

	public ProductoDAO(DataSource ds) {
		super(ds);
	}
	
	public void insert(Producto producto) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		StringBuilder sql = new StringBuilder();
		int pos = 1;
		sql.append(" INSERT ")
		   .append(" INTO PRODUCTOS_TARDE ")
		   .append("   ( ")
		   .append("     CODIGO_PRODUCTO, ")
		   .append("     NOMBRE_PRODUCTO, ")
		   .append("     PRECIO_PRODUCTO, ")
		   .append("     CANTIDAD_DE_PRODUCTO ")
		   .append("   ) ")
		   .append("   VALUES ")
		   .append("   ( ")
		   .append("     ?, ")//1
		   .append("     ?, ")//2
		   .append("     ?, ")//3
		   .append("     ? ")//4
		   .append("   ) ");
		try {
			con = getConnection();
			ps = con.prepareStatement(sql.toString());
			if(producto.getCodigoProducto() == null) {
				ps.setNull(pos++, Types.VARCHAR);
			} else {
				ps.setString(pos++, producto.getCodigoProducto());
			}
			if(producto.getNombreProducto() == null) {
				ps.setNull(pos++, Types.VARCHAR);
			} else {
				ps.setString(pos++, producto.getNombreProducto());
			}
		
				ps.setDouble(pos++, producto.getPrecioProducto());
			
				ps.setInt(pos++, producto.getCantidadDeProducto());
			
			
			ps.executeUpdate();
		} catch (SQLException e) {
			throw e;
		} finally {
			if(ps != null) {
				ps.close();
			}
			if(con != null) {
				con.close();
			}
		}
	}
	
	public void update(Producto producto) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		StringBuilder sql = new StringBuilder();
		int pos = 1;
		sql.append(" UPDATE CLIENTE ")
		   .append("    SET DUI_CLIENTE = ? ")
		   .append("      , NOMBRE_CLIENTE = ? ")
		   .append("      , APELLIDO_CLIENTE =? ")
		   .append("      , DIRECCION_CLIENTE = ? ")
		   .append("      , TELEFONO_CLIENTE  = ? ")
		   .append("      , FECHA_NAC_CLIENTE = ? ")
		   .append("  WHERE CODIGO_CLIENTE  = ? ");
		try {
			con = getConnection();
			ps = con.prepareStatement(sql.toString());
			
			
			if(producto.getNombreProducto() == null) {
				ps.setNull(pos++, Types.VARCHAR);
			} else {
				ps.setString(pos++, producto.getNombreProducto());
			}
			if(producto.getPrecioProducto() == 0) {
				ps.setNull(pos++, Types.DOUBLE);
			} else {
				ps.setDouble(pos++, producto.getPrecioProducto());
			}
			if(producto.getCantidadDeProducto() == 0) {
				ps.setNull(pos++, Types.INTEGER);
			} else {
				ps.setInt(pos++, producto.getCantidadDeProducto());
			}
			
			ps.setString(pos++, producto.getCodigoProducto());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			throw e;
		} finally {
			if(ps != null) {
				ps.close();
			}
			if(con != null) {
				con.close();
			}
		}
	}
	
	public void delete(Long key) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		StringBuilder sql = new StringBuilder();
		int pos = 1;
		sql.append(" DELETE FROM CLIENTE ")
		   .append("  WHERE CODIGO_CLIENTE  = ? ");
		try {
			con = getConnection();
			ps = con.prepareStatement(sql.toString());
			ps.setLong(pos++, key);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw e;
		} finally {
			if(ps != null) {
				ps.close();
			}
			if(con != null) {
				con.close();
			}
		}
	}
	
	public List<Producto> findAll(int first, int size) throws SQLException {
		List<Producto> l = new ArrayList<Producto>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT * ")
		   .append(" FROM ( ")
		   .append("      SELECT ROWNUM ROW_NUM, SUB.* ")
		   .append("       FROM ( ")
		   .append("             SELECT * FROM PRODUCTOS_TARDE ORDER BY CODIGO_PRODUCTO ")
		   .append("            ) SUB ")
		   .append("       WHERE ROWNUM <= ? ")
		   .append("   ) ")
		   .append("   WHERE ROW_NUM > ? ");
		try {
			con = getConnection();
			ps = con.prepareStatement(sql.toString(),ResultSet.TYPE_SCROLL_INSENSITIVE
					,ResultSet.CONCUR_UPDATABLE);
			ps.setFetchSize(size);
			ps.setMaxRows(size);
			ps.setInt(1, ((size*first) + size));
			ps.setInt(2, size*first);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				l.add(new Producto(rs.getString("CODIGO_PRODUCTO")
						, rs.getString("NOMBRE_PRODUCTO")
						, rs.getDouble("PRECIO_PRODUCTO")
						, rs.getInt("CANTIDAD_DE_PRODUCTO")
						));
			}
		} catch (SQLException e) {
			throw e;
		} finally {
			if(rs != null) {
				rs.close();
			}
			if(ps != null) {
				ps.close();
			}
			if(con != null) {
				con.close();
			}
		}
		return l;
	}
	
}
