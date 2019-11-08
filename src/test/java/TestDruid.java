import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import util.DruidUtil;


/**
 * 测试连接池工具类
 * @author Administrator
 *
 */
public class TestDruid {
	public static void main(String[] args) throws SQLException {
		//1.获取连接对象
		Connection con = DruidUtil.getConnection();
		//2.定义sql语句
		String sql = "create table student(id int,name varchar(20))";
		//3.获取语句对象
		Statement stmt = con.createStatement();
		//4.执行SQL语句
		stmt.execute(sql);
		//5.释放资源
		DruidUtil.close(stmt, con);
	}
}
