

import java.util.List;

import org.junit.Test;

import entity.Account;
import service.impl.AccountServiceDaoImpl;
import service.prototype.IAccountService;

/**
 * 账号业务测试类
 * @author RanJi
 *
 */
public class AccountServiceTest {
	
	private IAccountService actService = new AccountServiceDaoImpl();
	
	@Test
	public void listAccounts(){
		List<Account> acts = actService.listAccounts(1,Integer.MAX_VALUE);
		for (Account act : acts) {
			System.out.println(act);
		}
	}
}
