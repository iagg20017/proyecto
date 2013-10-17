package com.creativa.db.datasource;

import java.sql.SQLException;

import javax.sql.DataSource;

import oracle.jdbc.pool.OracleDataSource;

public class DatasourceFactory {
	
	public static DataSource dataSource;
	
	static {
		OracleDataSource oracleDataSource;
		try {
			oracleDataSource = new OracleDataSource();
			oracleDataSource.setDriverType("thin");
			oracleDataSource.setServerName("WS2008R264-ORA");
			oracleDataSource.setPortNumber(1521);
			oracleDataSource.setDatabaseName("ORA11DB");
			oracleDataSource.setUser("curso01");
			oracleDataSource.setPassword("curso01");
			dataSource = oracleDataSource;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
