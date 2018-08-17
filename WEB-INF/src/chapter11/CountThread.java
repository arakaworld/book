package chapter11;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Page;

/**
 * スレッドセーフな加算が行われるクラスです。
 */
@WebServlet(urlPatterns= {"/chapter11/count-thread"})
public class CountThread extends HttpServlet
{
	/** ２スレッド以上から加算されるカウンタ */
	int count;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		PrintWriter out = resp.getWriter();
		Page.header(out);

		// 排他制御を行う処理をsynchronizedブロックで囲む
		// 他のスレッドは現在実行されているスレッドの処理が終了するまで待機
		synchronized (this)
		{
			int i = count;
			try
			{
				// ２以上のアクセスを再現するため、３秒停止
				Thread.sleep(3000);

			} catch (InterruptedException e)
			{
				// 発生しない
			}
			count = i + 1;
			out.println(count);
		}

		Page.footer(out);
	}
}

///**
// * マルチスレッドで不正な加算が行われるクラスです。
// */
//@WebServlet(urlPatterns= {"/chapter11/count-thread"})
//public class CountThread extends HttpServlet
//{
//	/** ２スレッド以上から不正に加算されるカウンタ */
//	int count;
//
//	@Override
//	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
//	{
//		PrintWriter out = resp.getWriter();
//		Page.header(out);
//
//		int i = count;
//
//		try
//		{
//			// ２以上のアクセスを再現するため、３秒停止
//			Thread.sleep(3000);
//
//		} catch (InterruptedException e) {
//			// 発生しない
//		}
//
//		count = i + 1;
//		out.println(count);
//
//		Page.footer(out);
//	}
//}
