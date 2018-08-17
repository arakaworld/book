package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Product;

/**
 * 商品情報のDAOクラスです。
 */
public class ProductDAO extends DAO
{
	/**
	 * 検索文字列から商品情報を検索します。
	 * @param keyword 検索文字列
	 * @return 検索結果リスト
	 * @throws Exception エラーが発生したとき
	 */
	public List<Product> search(String keyword) throws Exception
	{
		Connection con = this.getConnection();

		// 商品を検索する
		PreparedStatement st = con.prepareStatement("select * from product where name like (?)");
		st.setString(1, "%" + keyword + "%");
		ResultSet rs = st.executeQuery();

		List<Product> list = new ArrayList<>();

		while(rs.next())
		{
			Product p = new Product();
			p.setId(rs.getInt("id"));
			p.setName(rs.getString("name"));
			p.setPrice(rs.getInt("price"));
			list.add(p);
		}

		st.close();
		con.close();

		return list;
	}

	/**
	 * 商品情報を追加します。
	 * @param product 商品情報
	 * @return 追加されたレコード数
	 * @throws Exception エラーが発生したとき
	 */
	public int insert(Product product) throws Exception
	{
		Connection con = this.getConnection();

		// 商品情報をインサートする
		PreparedStatement st = con.prepareStatement("insert into product(name, price) values(?, ?)");
		st.setString(1, product.getName());
		st.setInt(2, product.getPrice());
		int line = st.executeUpdate();

		st.close();
		con.close();

		return line;
	}
}
