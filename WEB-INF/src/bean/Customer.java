package bean;

/**
 * 顧客情報を表すクラスです。
 */
public class Customer extends BaseBean
{
	/** 顧客ID */
	private int id;

	/** ログインID */
	private String login;

	/** パスワード */
	private String password;

	/**
	 * @return
	 */
	public int getId()
	{
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(int id)
	{
		this.id = id;
	}

	/**
	 * @return
	 */
	public String getLogin()
	{
		return login;
	}

	/**
	 * @param login
	 */
	public void setLogin(String login)
	{
		this.login = login;
	}

	/**
	 * @return
	 */
	public String getPassword()
	{
		return password;
	}

	/**
	 * @param password
	 */
	public void setPassword(String password)
	{
		this.password = password;
	}
}
