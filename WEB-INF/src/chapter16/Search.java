package chapter16;

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
import tool.Page;

@WebServlet(urlPatterns= {"/chapter16/search"})
public class Search extends HttpServlet
{
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		PrintWriter out = resp.getWriter();
		Page.header(out);

		try
		{
			String keyword = req.getParameter("keyword");

			ProductDAO dao = new ProductDAO();
			List<Product> list = dao.search(keyword);

			req.setAttribute("list", list);
			req.getRequestDispatcher("attribute2.jsp").forward(req, resp);

		} catch (Exception e) {
			e.printStackTrace(out);
		}

		Page.footer(out);
	}
}
