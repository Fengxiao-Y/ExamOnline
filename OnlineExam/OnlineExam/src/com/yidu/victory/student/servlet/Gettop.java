package com.yidu.victory.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.yidu.victory.excle.domain.Topicbank;

/**
 * Servlet implementation class Gettop
 */
@WebServlet("/Gettop")
public class Gettop extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Gettop() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//����������Ӧ���ַ�������
		request.setCharacterEncoding("utf-8");
		//��������������������
		response.setContentType("text/html");
		//�������������ַ�������
		response.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		List<Topicbank> newlist=(List<Topicbank>)session.getAttribute("tblist");
		
		//����Gson����
		Gson gson = new Gson();
		//ͨ��Gson����Map����ת����json���ݸ�ʽ
		String jsonData = gson.toJson(newlist);
		//����һ�������
		PrintWriter out=response.getWriter();
		out.print(jsonData);

		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
