package util;

import javax.servlet.http.HttpServletResponse;

/**
 * ステータスコードの定数クラスです。（一部のみ）
 */
public enum EnumStatusCode
{
	/**
	 *
	 */
	SC_OK(HttpServletResponse.SC_OK),

	/**
	 *
	 */
	SC_MOVED_PERMANETLY(HttpServletResponse.SC_MOVED_PERMANENTLY),

	/**
	 *
	 */
	SC_MOVED_TEMPORARILY(HttpServletResponse.SC_MOVED_TEMPORARILY),

	/**
	 *
	 */
	SC_NOT_MODIFIED(HttpServletResponse.SC_NOT_MODIFIED),

	/**
	 *
	 */
	SC_NOT_FOUND(HttpServletResponse.SC_NOT_FOUND),

	/**
	 *
	 */
	SC_INTERNAL_SERVER_ERROR(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

	private final int code;

	/**
	 *  コンストラクタ
	 * @param code ステータスコード
	 */
	private EnumStatusCode(int code)
	{
		this.code = code;
	}

	/**
	 * ステータスコードを返却します。
	 * @return ステータスコード
	 */
	public int getCode()
	{
		return this.code;
	}
}
