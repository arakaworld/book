package tool;

import java.io.PrintWriter;

/**
 * @author araka
 *
 */
public class Page
{
	/**
	 * ヘッダーを出力します。
	 * @param out 標準出力オブジェクト
	 */
	public static void header(PrintWriter out)
	{
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Servlet/JSP Sample Programs</title>");
		out.println("</head>");
		out.println("<body>");
	}

	/**
	 * フッターを出力します。
	 * @param out 標準出力オブジェクト
	 */
	public static void footer(PrintWriter out)
	{
		out.println("</body>");
		out.println("</html>");
	}
}
