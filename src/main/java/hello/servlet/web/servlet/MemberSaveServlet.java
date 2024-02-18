package hello.servlet.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "memberSaveServlet", urlPatterns = "/servlet/members/save")
public class MemberSaveServlet extends HttpServlet {

	private MemberRepository memberRepository = MemberRepository.getInstance();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MemberSaveServlet.service");
		//Parameter 꺼내기
		String username = request.getParameter("username");
		int age = Integer.parseInt(request.getParameter("age"));

		//Member 저장
		Member member = new Member(username, age);
		memberRepository.save(member);

		//응답
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");

		PrintWriter w = response.getWriter();
		//동적으로 코드가 들어간 것을 확인할 수 있음.
		w.write("<html>\n" +
			"<head>\n" +
			"    <meta charset=\"UTF-8\">\n" +
			"</head>\n" +
			"<body>\n" +
			"성공\n" +
			"<ul>\n" +
			"    <li>id="+member.getId()+"</li>\n" +
			"    <li>username="+member.getUsername()+"</li>\n" +
			"    <li>age="+member.getAge()+"</li>\n" +
			"</ul>\n" +
			"<a href=\"/index.html\">메인</a>\n" +
			"</body>\n" +
			"</html>");
	}
}
