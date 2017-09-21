<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% String english =(String)request.getAttribute("english");%>
<% String japanese = (String)request.getAttribute("japanese");%>
<% String result = (String)request.getAttribute("result");%>
<% String record = (String)request.getAttribute("record");%>

<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>Result</title>
</head>
<body>
    <p>英単語は<%=english%>です。</p>
    <p>日本語は<%=japanese%>です。</p>
    <p><%=result%>件登録しました。</p>

    <p>登録件数は<%=record%>件です。</p>
   	<a href="index.jsp">TOPページへ</a>


</body>
</html>