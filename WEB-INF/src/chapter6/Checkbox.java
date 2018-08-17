package chapter6;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Page;

@WebServlet(urlPatterns= {"/chapter6/checkbox"})
public class Checkbox extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		// MIMEタイプと文字エンコーディングの指定
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();

			req.setCharacterEncoding("UTF-8");


			// 複数のチェックボックスの状態を配列で取得
			String[] genre=req.getParameterValues("genre");

			Page.header(out);
			if (genre != null)
			{
				for(String item : genre)
				{
					out.println("「" + item + "」");
				}
				out.println("に関するお買い得情報をお送りします。");
			} else {
				out.println("お買い得情報はお送りしません。");
			}
			Page.footer(out);
	}
}
