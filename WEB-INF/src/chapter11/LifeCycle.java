package chapter11;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns= {"/chapter11/lifecycle"})
public class LifeCycle extends HttpServlet
{
	@Override
	public void init() throws ServletException
	{
		System.out.println("init");
	}

	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		System.out.println("service");

		// serviceメソッドが受信したリクエストの種類に応じて、その後のメソッドを呼び分ける。ex)doGet、doPost…
		super.service(req, resp);
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		System.out.println("doGet");
	}

	@Override
	public void destroy()
	{
		System.out.println("destroy");
	}
}
