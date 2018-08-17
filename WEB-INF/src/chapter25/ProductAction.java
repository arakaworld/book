package chapter25;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Product;
import dao.ProductDAO;
import tool.Action;

public class ProductAction extends Action
{
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception
	{
		HttpSession session = req.getSession();

		String keyword = req.getParameter("keyword") == null ? "" : req.getParameter("keyword");

		ProductDAO dao = new ProductDAO();
		List<Product> list = dao.search(keyword);

		session.setAttribute("list", list);

		return "product.jsp";
	}
}
