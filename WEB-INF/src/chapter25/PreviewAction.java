package chapter25;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Item;
import tool.Action;

public class PreviewAction extends Action
{
	@SuppressWarnings("unchecked")
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception
	{
		HttpSession session = req.getSession();

		// セッション属性に顧客情報が設定されてない場合は未ログインのためエラー
		if (session.getAttribute("customer") == null)
		{
			return "preview-error-login.jsp";
		}

		List<Item> cart = (List<Item>) session.getAttribute("cart");

		// セッション属性にカート情報がないときはエラー
		if  (cart == null || cart.size() == 0)
		{
			return "preview-error-cart.jsp";
		}

		return "purchase-in.jsp";
	}
}
