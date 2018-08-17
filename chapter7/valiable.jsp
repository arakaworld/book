<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../header.html" %>

<%-- 変数の宣言 --%>
<%! int countA = 0; %>

<%-- スクリプトレット内での変数の宣言 --%>
<%
    int countB = 0;
    countA++;
    countB++;
%>

<p>宣言による変数countAは<%=countA%></p>
<p>スクリプトレット内の変数countBは<%=countB%></p>

<p><% out.println(Math.random()); %></p>
<p><%=Math.random() %></p>

<%@include file="../footer.html" %>