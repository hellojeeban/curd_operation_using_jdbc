package cricketscore_gfg_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class CricketScore {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gfg_db_jdbc", "root", "Guddu@1234");

		Statement st = con.createStatement();
		boolean flag = true;
		Scanner in = new Scanner(System.in);
		while (flag) {
			System.out.println("1. Add Data to deta base\"\r\n" + "	  \"2. Display Data\"\r\n"
					+ "	  \"3. Delete Data\"\r\n" + "	  \"4. Modify Data\"\r\n" + "	  \"5. Exit");

			int n = in.nextInt();
			switch (n) {
			case 1: {
				System.out.println("Enter id");
				int id = in.nextInt();
				System.out.println("Enter name");
				String name = in.next();
				System.out.println("Enter run");
				int run = in.nextInt();
				System.out.println("Enter ball");
				int ball = in.nextInt();
				String sql = "INSERT INTO scoreboard values(" + id + ",+'" + name + "'," + run + "," + ball + ")";
				st.execute(sql);
				break;
			}
			case 2: {
				String sql = "SELECT * FROM scoreboard";

				st.execute(sql);

				ResultSet rs = st.getResultSet();
				System.out.println("---------------------------------------------------------------");
				System.out.println("id\t|name\t|run\t|ball\t");
				while (rs.next()) {
					int id = rs.getInt(1);
					String name = rs.getString(2);
					int run = rs.getInt(3);
					int ball = rs.getInt(4);

					System.out.println(id + "\t|" + name + "\t|" + run + "\t|" + ball);
				}
				System.out.println("---------------------------------------------------------------");
				break;
			}
			case 3: {
				System.out.println("Enter id");
				int id = in.nextInt();
				String sql = "DELETE FROM scoreboard WHERE id=" + id;
				st.execute(sql);
				break;
			}
			case 4: {
				System.out.println("Enter id");
				int id = in.nextInt();
				System.out.println("Enter run");
				int run = in.nextInt();
				System.out.println("Enter ball");
				int ball = in.nextInt();
				String sql = "UPDATE scoreboard SET run = " + run + ",ball = " + ball + " WHERE id = " + id;
				st.execute(sql);
				break;
			}
			case 5: {
				flag = false;
				con.close();
				break;
			}
			default: {
				System.out.println("---------- Wrong input ----------");
			}
			}
		}
	}

}
