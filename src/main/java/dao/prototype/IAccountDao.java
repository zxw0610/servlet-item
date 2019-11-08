package dao.prototype;

import java.sql.Connection;
import java.util.List;

import entity.Account;
import util.Pager;


/**
 * IAccountDao
 * @author Administrator
 *
 */
public interface IAccountDao {
	//连接参数化
	void modify(Account act, Connection con);  //为了确保事务的原子性
	
	//根据id查询账号的用法
	Account find(int id);
	
	//在写修改方法
	void modify(Account act);
	List<Account>findAll();
	
	//你这么返回的是数据，但是我们要做分页光数据是不够的
	List<Account> find(int offset,int pageSize);   //0  int的最大值  Integer.MaxValue
	Pager<Account>findPaged(int offest,int pageSize);
	int totalItems();  //获取总条目数

}
