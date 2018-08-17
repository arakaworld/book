<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../header.html" %>

<%-- import文 --%>
<%@page import="java.util.Date" %>
<p>Hello!</p>
<p>こんにちは！</p>

<%-- スクリプトレットの書き方 --%>
<p><% out.println(new Date()); %></p>
<p><% out.println(page); %></p>

<%-- 式の書き方 --%>
<p><%=new Date() %></p>

<%@include file="../footer.html" %>