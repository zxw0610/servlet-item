package dao.impl;

import java.util.List;

import dao.prototype.IUserDao;
import entity.User;


/**
 * UserDao实现类
 * 采用JDBC的实现方法
 * @author Administrator
 */
public class UserDaoJdbcImpl implements IUserDao{

	@Override
	public void save(User u) {
		
		
	}

	@Override
	public void delete(int id) {
		
		
	}

	@Override
	public void modify(User u) {
		
		
	}

	@Override
	public User find(int id) {
		
		return null;
	}

	@Override
	public List<User> findAll() {
		
		return null;
	}
	
	/*@Override
	public void save(User u) {
		Connection con = DruidUtil.getConnection();
		String sql = "INSERT INTO t_use VALUES(1,'周小伟'，'123456',20,'1998-01-06');";
		Statement stmt;
		try {
			stmt = con.createStatement();
			stmt.execute(sql);
			DruidUtil.close(stmt, con);
		} catch (SQLException e) {
			System.out.println("添加数据失败");
		}
	}

	@Override
	public void delete(int id) {
		Connection con = DruidUtil.getConnection();
		String sql = "DELETE FROM t_use WHERE name = '史路文'";
		Statement stmt;
		try {
			stmt = con.createStatement();
			stmt.execute(sql);
			DruidUtil.close(stmt, con);
		} catch (SQLException e) {
			System.out.println("删除数据失败");
		}
		
		
	}

	@Override
	public void modify(User u) {
		Connection con = DruidUtil.getConnection();
		String sql = "ALTER table t_use MODIFY sex INT";
		Statement stmt;
		try {
			stmt = con.createStatement();
			stmt.execute(sql);
			DruidUtil.close(stmt, con);
		} catch (SQLException e) {
			System.out.println("修改数据失败");
		}
		
		
	}

	@Override
	public User find(int id) {
		Connection con =DruidUtil.getConnection();
		String sql ="SELECT name from t_use where age =20";
		Statement stmt;
		try {
			stmt = con.createStatement();
			stmt.execute(sql);
			DruidUtil.close(stmt, con);
		} catch (SQLException e) {
			System.out.println("查找数据失败");
		}
		
		return null;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}


	public List<User> findAll() {
		Connection con = DruidUtil.getConnection();
		String sql = "select * from t_use;";
		Statement stmt; 
		ResultSet rs = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			DruidUtil.close(rs,stmt, con);	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		List<User> list = new ArrayList();
		try {
			while(rs.next()) {
				User u = new User(rs.getInt("id"), rs.getString("name"), rs.getString("pwd"), rs.getInt("age"), rs.getDate("brith"));
				list.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}	*/
}
