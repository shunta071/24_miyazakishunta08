package lesson1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class WordDAO {

	Connection con = null;
	PreparedStatement st = null;

	static String URL = "jdbc:mysql://localhost/testdb?useUnicode=true&characterEncoding=utf8";
	static String USER = "root";
	static String PW = "";

	public int registWord(List<Word> lists){

		int result = 0;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(URL, USER, PW);
			String SQL = "INSERT INTO dictionary VALUES(?,?)";

			for(Word wd : lists){
				st = con.prepareStatement(SQL);
				st.setString(1, wd.getEnglish());
				st.setString(2, wd.getJapanese());
				st.executeUpdate();
				result++;

			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if ( st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if ( con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return result;

	}
	public String getWords() {
		ResultSet rs = null;
		String record = null;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(URL, USER, PW);

			if(con != null){
				System.out.println("繋がりました");
				String SQL = "SELECT COUNT(*) FROM dictionary";

				st = con.prepareStatement(SQL);
				rs = st.executeQuery();
				while(rs.next()) {

				record = rs.getString(1);
			}
			}
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(record);
		return record;
	}
}
