package chapter15;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Product;
import dao.ProductDAO;

@WebServlet(urlPatterns= {"/chapter15/insert"})
public class Insert extends HttpServlet
{
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		PrintWriter out = resp.getWriter();

		try
		{
			String name = req.getParameter("name");
			int price =  Integer.parseInt(req.getParameter("price"));

			Product p = new Product();
			p.setName(name);
			p.setPrice(price);

			ProductDAO dao = new ProductDAO();
			int line = dao.insert(p);

			if (line > 0)
			{
				List<Product> list = dao.search("");

				for (Product resultProduct : list)
				{
					out.println(resultProduct.getId());
					out.println("：");
					out.println(resultProduct.getName());
					out.println("：");
					out.println(resultProduct.getPrice());
					out.println("<br>");
				}
			}

		} catch (Exception e) {
			e.printStackTrace(out);
		}
	}
}
