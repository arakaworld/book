package chapter12;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.EnumStatusCode;

@WebServlet(urlPatterns= {"/chapter12/response"})
public class Response extends HttpServlet
{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		resp.setStatus(EnumStatusCode.SC_MOVED_TEMPORARILY.getCode());
		resp.setHeader("Location", "https://twitter.com/?lang=en");
	}
}
