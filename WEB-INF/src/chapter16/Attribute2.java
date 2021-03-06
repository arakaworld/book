package chapter16;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Product;
import dao.ProductDAO;

/**
 * リクエスト属性に「Product」オブジェクトを設定するクラスです。
 */
@WebServlet(urlPatterns= {"/chapter16/attribute2"})
public class Attribute2 extends HttpServlet
{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		try
		{
			ProductDAO dao = new ProductDAO();
			List<Product> list = dao.search("");

			// リクエスト属性に検索結果リストオブジェクトを設定する
			req.setAttribute("list", list);

			// JSPファイルにフォワードする
			req.getRequestDispatcher("attribute2.jsp").forward(req, resp);

		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
