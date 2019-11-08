package service.impl;


import java.util.List;

import dao.impl.AccountDaoJdbcImpl;
import dao.prototype.IAccountDao;
import entity.Account;
/**
 * AccountService业务实现类
 * 注意事务的应用：模拟银行业务中的转账功能的实现
 */
import service.prototype.IAccountService;
import util.DruidUtil2;
import util.Pager;


public class AccountServiceDaoImpl  implements IAccountService{
	private IAccountDao actDao   = new AccountDaoJdbcImpl();

	@Override
	public void transfer(Account from, Account to, double money) {
		/*//1.建立数据库连接
		Connection con = DruidUtil2.getConnection();
		//2.开启事务  
		try {
			con.setAutoCommit(false);//把自动提交关闭，改为手动提交
			
			//业务操作，（把连个账号的钱在内存中先更改，然后持久化到数据库中就可以了，）
			//1.利用面向对象的思想变更两个账户的余额。
*/			
		//1.内存中变更对象的余额
		if(from.getBalance()<money){
				System.out.println("你还转毛线，钱不够");
				return;
			}
			from.setBalance(from.getBalance()-money);
			to.setBalance(to.getBalance()+money);
			//2.利用Dao把变更后的余额持久化
			actDao.modify(from);
			actDao.modify(to);
			
			DruidUtil2.close();
	}
			
			
		/*	//3.提交事务
			con.commit();   //提价事务
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();   //回滚事务
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			DruidUtil2.close(null, con);
		}  
	}*/

	@Override
	public Account searchAccount(int id) {
		return actDao.find(id);   //业务逻辑简单，直接调用Dao来实现
	}


	@Override
	public List<Account> listAccounts(int pageNo, int pageSize) {
		//依赖于Dao实现分页
		int totalItems = actDao.totalItems();  //条目数
		int pageNum = (totalItems + pageSize -1)/pageSize;  //总页数
		if(pageNo >= pageNum)pageNo = pageNum;  //控制最大页码
		if(pageSize == Integer.MAX_VALUE)   //暂时这么写
			return actDao.findAll();
		return actDao.find((pageNo-1)*pageSize,pageSize);
	}


	@Override
	public Pager<Account> listPaged(int pageNo, int pageSize) { //依赖于Dao实现分页
		int totalItems = actDao.totalItems();   //条目数
		int pageNum = (totalItems+pageSize -1)/pageSize;  //总页数
		if(pageNo>=pageNum)pageNo = pageNum; //控制最大页码
		Pager<Account> pager = actDao.findPaged((pageNo-1)*pageSize,pageSize);
		pager.setTotal(pageNum);
		return pager;
	}
}
/*
 *   1. accountService实现：是直接写的JDBC代码来是实现的
 *   2. accountDao来实现该操作：
 *         IAccountDao :  
 *            void  modify(xxx);   //-- 修改账户的方法
 *         AccountServiceDaoImpl{
 *               private IAccountDao actDao;
 *               void transfer(xxx){
 *               	//-- 利用的actDao来实现转账功能
 *               }
 *         }
 *   3. 第一：
 *   		业务层的代码尽量不要出现持久层的代码 (封装：让Dao去干应该干的事情，持久化的事情)
 *      第二：让大家理解数据库连接和事务的概念
 *             一次事务建立在一次数据库的连接基础上   
 *      第三：过滤器     
 *      要求：
 *         （1）. 分工明确：让Dao层只数据处理，让业务只负责业务， 
 *               只不过有些通用的处理代码在业务层和Dao层
 *               事务            
 *          原理： 数据库连接类，利用线程池的技术
 *               DruidUtil2 : ThreadLocal.get() ----  Connection 
 *                            ThreadLocal.get(key) ---- key 当前线程的ID   
 *           //-- 页面     
 *   4. 分页：
 *       必须拿到总的条目数   (1) 优化   (2) 和展示层有关系 total条目数必须的拿到                           
 */

