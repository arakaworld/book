package tool;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * アクションの基底クラスです。
 */
public abstract class Action
{
	/**
	 * 処理を実行します。
	 * @param req リクエスト
	 * @param resp レスポンス
	 * @return フォワード先のURL
	 * @throws Exception エラーが発生したとき
	 */
	public abstract String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception;
}
