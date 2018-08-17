package dao;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 * DAOの抽象クラスです。
 */
public abstract class DAO
{
	static DataSource ds;

	/**
	 * データベースとの接続を取得します。
	 * @return データソース
	 * @throws Exception エラーが発生したとき
	 */
	public Connection getConnection() throws Exception
	{
		// データソースが未初期化の場合、取得する
		if (ds == null)
		{
			InitialContext ic = new InitialContext();
			ds = (DataSource) ic.lookup("java:comp/env/jdbc/book");
		}

		return ds.getConnection();
	}
}
