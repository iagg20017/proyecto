package com.creativa.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

public abstract class BaseDAO {
	protected DataSource ds;

	public BaseDAO(DataSource ds) {
		super();
		this.ds = ds;
	}
	
	public Connection getConnection() throws SQLException {
		return ds.getConnection();
	}
	
	
}
