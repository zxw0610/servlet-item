package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Account;
import service.impl.AccountServiceDaoImpl;
import service.prototype.IAccountService;

/**
 * 处理转账请求的servlet
 * 做控制转发，接收客户端发送过来的参数，跳转页面
 * view   --- controller -- biz  --- service
 * 页面找servlet，servlet找后台，
 * mvc设计的模型
 * @author Administrator
 */
@SuppressWarnings("serial")
@WebServlet("/transfer")
public class TransferServlet extends HttpServlet {
	
	//依赖于业务层的代码，所以应该有个Service引用
	private IAccountService actService = new AccountServiceDaoImpl();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.接收客户端发过来的请求参数
		int fromId = Integer.parseInt(request.getParameter("fromId"));
		int toId = Integer.parseInt(request.getParameter("toId"));
		double money = Double.parseDouble(request.getParameter("money"));
		
		//2.先查找账户
		Account from = actService.searchAccount(fromId);
		Account to = actService.searchAccount(toId);
		//3.转账
		actService.transfer(from, to, money);
		//4.跳转页面
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		out.write("转账成功");
	}
}
/*
 * 1.客户端做输入款的校验  js
 *   如果检验不通过，那么久不要访问后台，而且给出友善的提示信息
 * 2.严格意义上来说，不要过分的迷信客户端的校验，往往客户端的校验是给那些正常的人用的，对于黑客或者其他高手是不起作用的，
 *   所以，应该在后台也做校验。
 * 3.分页功能：
 *   分页查询：数据库自带的功能
 *   limit  0：偏移量    5：页大小    左开右闭
 *   如何根据给定的页大小计算出总页数
 *   已知条件：1.pageSize（页大小）  2.total（总条目数）   
 *   求总的页数   int  pageNum（int total，pageSize）{
 *   			if(total%pageSize == 0){
 *   				return total/pageSize
 *               }else
 *                  return total/pageSize + 1 ；
 *            }
 *   已知条件：偏移量 ：offest    页大小：pageSize
 *         偏移量：（pageNo-1）*pageSize         
 *    
 */ 
