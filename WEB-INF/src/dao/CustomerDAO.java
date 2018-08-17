package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.Customer;

/**
 * 商品情報のDAOクラスです。
 */
public class CustomerDAO extends DAO
{
	/**
	 * 検索文字列から商品情報を検索します。
	 * @param keyword 検索文字列
	 * @return 検索結果リスト
	 * @throws Exception エラーが発生したとき
	 */
	public Customer search(String login, String password) throws Exception
	{
		Customer customer = null;

		Connection con = this.getConnection();

		PreparedStatement st = con.prepareStatement("select * from customer where login=? and password=?");
		st.setString(1, login);
		st.setString(2, password);
		ResultSet rs = st.executeQuery();

		while(rs.next())
		{
			customer = new Customer();
			customer.setId(rs.getInt("id"));
			customer.setLogin(rs.getString("login"));
			customer.setPassword(rs.getString("password"));
		}

		st.close();
		con.close();

		return customer;
	}
}
