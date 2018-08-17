package chapter24;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tool.Action;

public class LogoutAction extends Action
{
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception
	{
		HttpSession session = req.getSession();

		if (session.getAttribute("customer") != null)
		{
			session.removeAttribute("customer");
			return "logout-out.jsp";
		}

		return "logout-error.jsp";
	}
}
