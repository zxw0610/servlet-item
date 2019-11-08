package dao.impl;
/**
 * AccountDao实现
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.prototype.IAccountDao;
import entity.Account;
import util.DruidUtil;
import util.DruidUtil2;
import util.Pager;

public class AccountDaoJdbcImpl implements IAccountDao{

	@Override
	public void modify(Account act, Connection con) {
		String sql = "update account set balance=?where id = ?";
		try {
			if(act!= null){
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setDouble(1,act. getBalance());
				ps.setInt(2,act.getId());
				ps.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	public Account find(int id) {
		Connection con = DruidUtil.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		Account act = null;
		String sql = "select * from account where id = "+id;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			rs.next();
						
			act = new Account();
			act.setId(rs.getInt(1));
			act.setName(rs.getString(2));;
			act.setBalance(rs.getDouble(3));
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DruidUtil.close(rs,stmt, con);
		}
		return act;
	}

	@Override
	public void modify(Account act) {
		Connection con = DruidUtil2.getConnection();
		String sql = "update account set balance=? where id = ?";
		try {
			if(act != null){
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setDouble(1,act. getBalance());
				ps.setInt(2,act.getId());
				ps.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
	}

	@Override
	public List<Account> find(int offset, int pageSize) {
		Connection con = DruidUtil2.getConnection();
		String sql = "select * from account  limit ?,?";
		List<Account> acts = new ArrayList<Account>();
		try {
			//1.获取总条目数
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, offset);
			ps.setInt(2, pageSize);
			ResultSet rs =ps.executeQuery();
			while(rs.next()){
				Account act = new Account();
				act.setId(rs.getInt(1));
				act.setName(rs.getString(2));
				act.setBalance(rs.getDouble(3));
				acts.add(act);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DruidUtil2.close();
		}
		return acts;
	}

	@Override
	public List<Account> findAll() {
		return find(0,Integer.MAX_VALUE);
	}
	
	@Override
	public int totalItems() {
		Connection con = DruidUtil2.getConnection();
		String sql = "select count(*) from account";
		int total = 0;
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			total = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DruidUtil2.close();
		}
		return total;
	}
	
	
	
	
	@Override
	public Pager<Account> findPaged(int offset, int pageSize) {
		Pager<Account> pager = new Pager<Account>();
		pager.setData(find(offset,pageSize));
		return pager;
	}

}
/*
 * 线程池ThreadLocal（相当于Map来看）： 它其实就是一个集合，或者你可以把它理解为一个Map<key,value>
 *        特殊在它里面的key是不用你去设置的， 它的key默认是该线程ID。
 * java不是多进程的，它是多线程的。
 * servlet是多线程的。Tomcat是多线程的
 * 它的值可以放任何对象  
 * 
 */
