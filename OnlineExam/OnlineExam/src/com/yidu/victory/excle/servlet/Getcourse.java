package com.yidu.victory.excle.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.yidu.victory.student.dao.CourseDao;
import com.yidu.victory.student.dao.Impl.CourseDaoImpl;
import com.yidu.victory.student.domain.Course;

/**�õ��γ̱�����
 * Servlet implementation class Getcourse
 */
@WebServlet("/Getcourse")
public class Getcourse extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Getcourse() {
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
		//�����γ̱����ݲ����
		CourseDao coursedao=new CourseDaoImpl();
		List<Course> courselist=coursedao.findAll();
		//����Gson����
		Gson gson = new Gson();
		//ͨ��Gson����Map����ת����json���ݸ�ʽ
		String jsonData = gson.toJson(courselist);
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
