package chapter6;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Page;

@WebServlet(urlPatterns= {"/chapter6/select"})
public class Select extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		// MIMEタイプと文字エンコーディングの指定
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();

			req.setCharacterEncoding("UTF-8");

			String count=req.getParameter("count");
			String payment=req.getParameter("payment");
			String review=req.getParameter("review");
			String mail=req.getParameter("mail");

			Page.header(out);
			out.println("<p>" + count + "個の商品をカートに入れました。</p>");
			out.println("<p>お支払い方法を" + payment + "に設定しました。</p>");
			out.println("<p>ご感想ありがとうございます。</p>");
			out.println("<p>「" + review + "」</p>");
			if (mail != null)
			{
				out.println("<p>メールをお送りします。</p>");
			} else {
				out.println("<p>メールはお送りしません。</p>");
			}

			// リクエストパラメータ名一覧の取得
			List<String> names = Collections.list(req.getParameterNames());

			out.println("<p>/////////////////////////////////////////////////////</p>");

			// リクエストパラメータ名一覧から個々の値を取得し、表示
			for(String name : names)
			{
				String[] values = req.getParameterValues(name);
				for(String val : values)
				{
					out.println("<p>" + name + " = " + val + "</p>");
				}
			}
			Page.footer(out);
	}
}
