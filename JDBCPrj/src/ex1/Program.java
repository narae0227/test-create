package ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class Program {

	public static void main(String[] args) throws Exception {
		String url = "jdbc:oracle:thin:@localhost:1521/XE";
		String sql = "SELECT * FROM NOTICE";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "PRJ_MR","1234");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next()) {
			int id = rs.getInt("ID");
			String title = rs.getString("title"); // 컬럼명은 대문자인지, 소문자인지 따로 구분하지 않는다.
			String writerId = rs.getString("WRITER_ID");
			Date regDate = rs.getDate("REGDATE");
			String content = rs.getString("CONTENT");
			int hit = rs.getInt("HIT");
			
			System.out.printf("id : %d, title : %s, writerid : %s, content : %s, regdate : %s, hit : %d\n", id, title, writerId, content, regDate, hit);
		}
		
		rs.close(); 
		st.close();
		con.close();
		
	}

}
