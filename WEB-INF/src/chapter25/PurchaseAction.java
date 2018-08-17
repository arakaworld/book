package chapter25;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Item;
import dao.PurchaseDAO;
import tool.Action;

public class PurchaseAction extends Action
{
	@SuppressWarnings("unchecked")
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception
	{
		HttpSession session = req.getSession();

		String name = req.getParameter("name");
		String address = req.getParameter("address");

		if (name.isEmpty() || address.isEmpty())
		{
			return "purchase-error-empty.jsp";
		}

		PurchaseDAO dao = new PurchaseDAO();

		List<Item> cart = (List<Item>) session.getAttribute("cart");
		if (cart == null || !dao.insert(cart, name, address))
		{
			return "purchase-error-insert.jsp";
		}

		session.removeAttribute("cart");

		return "purchase-out.jsp";
	}
}
