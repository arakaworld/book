package chapter4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Page;

public class Hello3 extends HttpServlet
{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		// MIMEタイプと文字エンコーディングの指定
		resp.setContentType("text/html; charset=UTF-8");

		PrintWriter out = resp.getWriter();

		Page.header(out);

		out.println("Hello! Java");
		out.println("こんにちは！");
		out.println(new java.util.Date());

		Page.footer(out);
	}
}

