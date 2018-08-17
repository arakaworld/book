<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>

<%@page import="bean.Product, java.util.*" %>

<!-- 下記の@SuppressWarningsはEclipseの警告を消すための記述です。 -->
<%
@SuppressWarnings("unchecked")
List<Product> list=(List<Product>)request.getAttribute("list");
%>

<!-- 拡張for文のスクリプトレットをいったん%>で閉じても繰り返しの中でJSPの式が使用できる -->
<% for (Product p : list) { %>
	<p><%=p.getId() %>：<%=p.getName() %>：<%=p.getPrice() %></p>
<% } %>

<!-- getAttributeNamesメソッド -->
<%
List<String> names = Collections.list(request.getAttributeNames());
for (String name : names)
{
	out.println(name + " = " + request.getAttribute(name) + "<br>");
}
%>

<%@include file="../footer.html" %>
