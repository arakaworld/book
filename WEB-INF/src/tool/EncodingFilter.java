package tool;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(urlPatterns= {"/dummy"})
public class EncodingFilter implements Filter
{
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException
	{
		request.setCharacterEncoding("UTF-8");

		// ※フィルターに記載してもJSPのsetContentTypeは、JSPファイルを読み込む際の文字エンコーディングの指定も兼ねているため省略できない
		response.setContentType("text/html; charset=UTF-8");

		System.out.println("フィルタの前処理");

		chain.doFilter(request, response);

		System.out.println("フィルタの後処理");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException
	{
		// なにもしない
	}

	@Override
	public void destroy()
	{
		// なにもしない
	}
}
