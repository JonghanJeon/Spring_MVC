<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<!-- 상대 경로 사용, [현재 URL 이 속한 계층 경로 + /save] -->
<%-- 실제 개발할때는 대부분의 경우에서 절대경로를 사용한다. --%>
<form action="save" method="post">
    username: <input type="text" name="username" />
    age:      <input type="text" name="age" />
    <button type="submit">전송</button>
</form>

</body>
</html>
