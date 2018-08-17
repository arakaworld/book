package chapter14;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import tool.Page;

@WebServlet(urlPatterns= {"/chapter14/transaction"})
public class Transaction extends HttpServlet
{
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		PrintWriter out = resp.getWriter();
		Page.header(out);

		try
		{
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/book");
			Connection con = ds.getConnection();

			// オートコミットをオフに設定
			con.setAutoCommit(false);

			// リクエストパラメータから商品名と価格を取得
			String name = req.getParameter("name");
			int price = Integer.parseInt(req.getParameter("price"));

			// 商品を追加
			PreparedStatement st = con.prepareStatement("insert into product(name, price) values(?, ?)");
			st.setString(1, name);
			st.setInt(2, price);
			st.executeUpdate();

			// 追加した商品を検索する
			st = con.prepareStatement("select * from product where name=?");
			st.setString(1, name);
			ResultSet rs = st.executeQuery();

			int line = 0;

			while(rs.next())
			{
				line++;
			}

			if (line == 1)
			{
				con.commit();
				out.println("商品を登録しました。");
			} else {
				con.rollback();
				out.println("商品はすでに登録されています。");
			}

			// オートコミットをオンに戻す
			// 手動と自動のトランザクション管理が混在している場合、戻したほうがいいらしい
			con.setAutoCommit(true);

			st.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace(out);
		}
		Page.footer(out);
	}
}
