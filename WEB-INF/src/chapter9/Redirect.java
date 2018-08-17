package chapter9;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// リダイレクトは、サーブレットやJSPがレスポンスを出力する代わりに、指定したWebページをブラウザに開かせる機能です。
// ※パスの記載方法がフォワード/インクルードと違うので注意。

/**
 * TomcatのWebページへリダイレクトするクラスです。
 */
@WebServlet(urlPatterns= {"/chapter9/redirect"})
public class Redirect extends HttpServlet
{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		resp.sendRedirect("http://tomcat.apache.org/");
	}
}
