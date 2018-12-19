package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {
	private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String URL = "jdbc:sqlserver://localhost:1433;databasename=students";
	private static final String UID = "sa";
	private static final String PWD = "123";
	public Connection getCon() {
			try {
				Class.forName(DRIVER);
				return	DriverManager.getConnection(URL, UID, PWD);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
	}
	public void closeCon(Connection con, PreparedStatement pst, ResultSet rst) {
		
		try {
			if (rst != null) {
				rst.close();
		}
		if (pst != null) {
			pst.close();
		}
		if (con != null) {
			con.close();
		}
		rst= null;
		pst = null;
		con = null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}