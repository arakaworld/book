package chapter17;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Product;
import tool.Page;

@WebServlet(urlPatterns= {"/chapter17/cart-add"})
public class CartAdd extends HttpServlet
{
	@SuppressWarnings("unchecked")
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		PrintWriter out = resp.getWriter();
		Page.header(out);

		String name = req.getParameter("name");
		int price = Integer.parseInt(req.getParameter("price"));

		HttpSession session = req.getSession();

		List<Product> cart = (List<Product>) session.getAttribute("cart");

		// セッション属性からリストが取得できない場合、リストを初期化
		if (cart == null)
		{
			cart = new ArrayList<Product>();
		}

		Product p = new Product();
		p.setName(name);
		p.setPrice(price);
		cart.add(p);

		session.setAttribute("cart", cart);

		out.println("カートに商品を追加しました。");

		Page.footer(out);
	}
}