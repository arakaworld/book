package chapter25;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Item;
import tool.Action;

public class CartRemoveAction extends Action
{
	@SuppressWarnings("unchecked")
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception
	{
		HttpSession session = req.getSession();

		int id = Integer.parseInt(req.getParameter("id"));

		List<Item> cart = (List<Item>) session.getAttribute("cart");

		for (Item i : cart)
		{
			if (i.getProduct().getId() == id)
			{
				cart.remove(i);
				break;
			}
		}
		return "cart.jsp";
	}
}
