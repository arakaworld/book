package tool;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns= {"*.action"})
public class FrontController extends HttpServlet
{
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		PrintWriter out = resp.getWriter();
		try
		{
			// アクションクラスの特定
			String path = req.getServletPath().substring(1);
			String name = path.replace(".a", "A").replace('/', '.');
			Action action = (Action) Class.forName(name).newInstance();

			// 特定したアクションクラスの処理を開始
			String url = action.execute(req, resp);

			// 処理結果から取得したJSPへフォワードを行う
			req.getRequestDispatcher(url).forward(req, resp);

		} catch (Exception e) {
			e.printStackTrace(out);
		}
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		doPost(req, resp);
	}
}
