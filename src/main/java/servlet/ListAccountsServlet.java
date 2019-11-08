package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Account;
import service.impl.AccountServiceDaoImpl;
import service.prototype.IAccountService;
import util.Pager;

/**
 * 列出账号的Servlet
 * 分页拿数据
 * @author RanJi
 *
 */
@SuppressWarnings("serial")
@WebServlet("/listacts")
public class ListAccountsServlet extends HttpServlet{
	
	private IAccountService actService;
	
	@Override
	public void init() throws ServletException {
		actService = new AccountServiceDaoImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//-- 1. 获取分页信息
		Integer pageNo = null;
		Integer pageSize = null;
		try {
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
			pageSize = Integer.parseInt(request.getParameter("pageSize"));
		} catch (NumberFormatException e) {}
		//-- 2. 判断是否转有分页，若没有，则查询全部人员信息
		Pager<Account> pager = null;
		if(pageNo==null || pageSize==null)
			pager = actService.listPaged(1, 5);   //限制每页显示多少条数据
		else
			pager = actService.listPaged(pageNo, pageSize);
		//-- 2. 把查询到数据放入到Request对象中
		request.setAttribute("pager", pager);
		//-- 3. 转发页面
		request.getRequestDispatcher("list.jsp").forward(request, response);
	}
}
