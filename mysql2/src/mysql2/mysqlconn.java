package mysql2;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class mysqlconn {

	public static void connn(String[] args) throws ClassNotFoundException, SQLException {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/rms";
		String user ="zhangxi";
		String password ="zhangxi123";
		String sql = "select * from t_alarm_code";
		//������������
		Class.forName(driver);
		java.sql.Connection connection =  DriverManager.getConnection(url, user, password);
		if(!connection.isClosed())
			System.out.println("mysql connection established");
		//statement   ����ִ��sql���
		Statement statement = (Statement) connection.createStatement();
		ResultSet rSet = statement.executeQuery(sql);
		System.out.println(rSet);
		while (rSet.next()) {
			String b = null;			
			b = rSet.getString("alarm_name");
			System.out.println(b);
		
			
		}
		rSet.close();
		connection.close();
	}

}
