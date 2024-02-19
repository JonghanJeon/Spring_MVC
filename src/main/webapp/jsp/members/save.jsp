<%--첫 줄은 JSP 문서라는 뜻이다. JSP는 이렇게 시작해야 한다.--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%--JSP는 자바 코드를 그대로 다 사용할 수 있다.--%>
<%
    //request, response 사용 가능
    MemberRepository memberRepository = MemberRepository.getInstance();

    System.out.println("MemberSaveServlet.service");
    String username = request.getParameter("username");
    int age = Integer.parseInt(request.getParameter("age"));

    Member member = new Member(username, age);
    memberRepository.save(member);

%>
<html>
<head>
    <title>Title</title>
</head>
<body>
성공
<ul>
<%--  <%=%> 자바 코드를 출력할 수 있다.  --%>
    <li>id=<%=member.getId()%></li>
    <li>username=<%=member.getUsername()%></li>
    <li>age=<%=member.getAge()%></li>
</ul>
<a href="${pageContext.request.contextPath}/index.html">메인</a>
</body>
</html>