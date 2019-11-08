import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dao.impl.AccountDaoJdbcImpl;
import dao.prototype.IAccountDao;
import entity.Account;
import util.DruidUtil;

/**
 * AccountDao单元测试
 * 标注
 * @author Administrator
 *
 */
public class AccountDaoTest {
	private IAccountDao actDao = new AccountDaoJdbcImpl();
	@Before
	public void before(){
		System.out.println("前面");
	}
	
	@Test  //单元测试方法，一个方法代表一个单元测试
	public void testFindAccount(){
		Account act = new AccountDaoJdbcImpl().find(1);
		System.out.println(act);
	} 
	 
	@Test  //单元测试方法
	public void testModifyAccount(){
		//1.查找到某个账号
		IAccountDao actDao = new AccountDaoJdbcImpl();
		Account act = actDao.find(1);
		act.setBalance(1000);
		
		//2.修改账号的余额
		actDao.modify(act,DruidUtil.getConnection());	
	}
	@Test
	public void testFind(){
		//1.查询所有账户
		List<Account>acts = actDao.find(0,Integer.MAX_VALUE);
		//2.输出
		for (Account act : acts) {
			System.out.println(act);
		}
	}
	
	
	@After
	public void after(){
		System.out.println("后面");
	}
}
/*
 * 自己写JUnit框架
 *   1.自定义标注@zhiqian  @zhihou  @test
 *   2.利用反射技术去看某类下的方法是否被@test所标注，如果标注就执行该方法
 *   3.corejava（泛型、多态、IO、网络、线程、图形化编程、集合（数据结构））
 *     db（大数据存储或拿或计算 hadoop/fastDFS/ES）  b/s : jdbc/servlet/jsp
 * 
 * 
 */
