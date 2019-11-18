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

/**得到课程表数据
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
		//设置请求响应的字符集编码
		request.setCharacterEncoding("utf-8");
		//设置请求对象的内容类型
		response.setContentType("text/html");
		//设置请求对象的字符集编码
		response.setCharacterEncoding("utf-8");
		//创建课程表数据层对象
		CourseDao coursedao=new CourseDaoImpl();
		List<Course> courselist=coursedao.findAll();
		//定义Gson对象
		Gson gson = new Gson();
		//通过Gson对象将Map集合转换成json数据格式
		String jsonData = gson.toJson(courselist);
		//创建一个输出流
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
