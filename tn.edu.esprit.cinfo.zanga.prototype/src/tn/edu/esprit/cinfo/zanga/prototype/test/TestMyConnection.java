package tn.edu.esprit.cinfo.zanga.prototype.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import tn.edu.esprit.cinfo.zanga.prototype.domain.User;
import tn.edu.esprit.cinfo.zanga.prototype.utilities.MysqlUtilities;

public class TestMyConnection {
	public static void main(String[] args) {
		Connection connection = MysqlUtilities.giveMeConnectionConfigured();
		try {
			Statement statement = connection.createStatement();
			String sql = "DROP TABLE IF EXISTS `user`; Create table user (id int(10) primary key auto_increment,"
					+ " firstname varchar(50)," + " lastname varchar(50) )";
			statement.executeUpdate(sql);
			User user = new User("Aymen", "Ghoul");
			String sql2 = "insert into `user` (firstname,lastname) values('"
					+ user.getFirstName() + "','" + user.getLastName() + "')";
			statement.execute(sql2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
