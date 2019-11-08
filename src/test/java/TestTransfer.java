import entity.Account;
import service.impl.AccountServiceDaoImpl;
import service.prototype.IAccountService;
/**
 * 测试转账操作
 * 单元测试：
 *    黑盒测试：功能性测试，比如：页面有登录按钮、注册按钮、下订单、支付按钮
 *      人工测试，其实也可以利用一些工具
 *    白盒测试：
 *       单侧测试：就是白盒测试，测试我们内部代码有什么问题。
 *       所有的逻辑代码都要测试到才可以   dao.modify（） -- 参数设置越界异常问题  bug，进行修复
 *       比如：modify（User u，Connection u）
 * @author Administrator
 *
 */

public class TestTransfer {
	public static void main(String[] args) {
	    //1.业务实现
		IAccountService ias = new AccountServiceDaoImpl();
		//2.查询账号
		Account zs = ias.searchAccount(1);
		Account ls = ias.searchAccount(2);
		/*System.out.println(zs);
		System.out.println(ls);*/
		//3.转账
		ias.transfer(zs, ls, 1000);
		System.out.println(zs);
		System.out.println(ls);
		
		//测试
		//IAccountDao actDao = new Account
		
	}
	
}
