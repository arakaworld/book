package chapter25;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Item;
import bean.Product;
import tool.Action;

public class CartAddAction extends Action
{
	@SuppressWarnings("unchecked")
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception
	{
		HttpSession session = req.getSession();

		int id = Integer.parseInt(req.getParameter("id"));

		List<Item> cart = (List<Item>) session.getAttribute("cart");

		// カート属性が存在しないとき
		if (cart == null)
		{
			cart = new ArrayList<Item>();
			session.setAttribute("cart", cart);
		}

		for (Item i : cart)
		{
			if (i.getProduct().getId() == id)
			{
				i.setCount(i.getCount() + 1);
				return "cart.jsp";
			}
		}

		List<Product> list = (List<Product>) session.getAttribute("list");
		for (Product p : list)
		{
			if (p.getId() == id)
			{
				Item i = new Item();
				i.setProduct(p);
				i.setCount(1);
				cart.add(i);
			}
		}

		return "cart.jsp";
	}
}
