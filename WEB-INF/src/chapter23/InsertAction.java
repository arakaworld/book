package chapter23;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Product;
import dao.ProductDAO;
import tool.Action;

public class InsertAction extends Action
{
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception
	{
		String name = req.getParameter("name");
		int price =  Integer.parseInt(req.getParameter("price"));

		Product p = new Product();
		p.setName(name);
		p.setPrice(price);

		ProductDAO dao = new ProductDAO();
		dao.insert(p);

		List<Product> list = dao.search("");
		req.setAttribute("list", list);

		return "list.jsp";
	}
}
