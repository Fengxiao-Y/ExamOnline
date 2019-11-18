package com.yidu.victory.excle.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yidu.victory.excle.dao.TestPaperDao;
import com.yidu.victory.excle.dao.TestPaperTopicDao;
import com.yidu.victory.excle.dao.Impl.TestPaperDaoImpl;
import com.yidu.victory.excle.dao.Impl.TestPaperTopicDaoImpl;
import com.yidu.victory.excle.domain.TestPaper;
import com.yidu.victory.excle.domain.TestPaperTopic;

/**
 * Servlet implementation class TestPaperTopicServlet
 */
@WebServlet("/TestPaperTopicServlet")
public class TestPaperTopicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestPaperTopicServlet() {
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
		
		String method=request.getParameter("method");
		if("findAll".equals(method)){
			//查看表的方法
			this.findAll(request,response);
		}else if("add".equals(method)){
			//添加方法
			this.add(request,response);
		}else if("update".equals(method)){
			//修改方法
			this.update(request,response);
		}else if("delete".equals(method)){
			//删除方法
			this.delete(request,response);
		}
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//创建输出流对象
		PrintWriter out=response.getWriter();
		//获取来自请中所传递过来的员工编号字符串
		String tidStr=request.getParameter("tidStr");
		//将字符串进行按","(逗号)分割的子字符串数组
		String[] tids=tidStr.split(",");
		
		//创建数据层操作对象
		TestPaperTopicDao testPaperTopicDao=new TestPaperTopicDaoImpl();
		
		//由于是批量删除，有可能失败，此处使用异常处理来实现
		try{
			//使用循环进行批量删除
			for(int i=0;i<tids.length;i++){
				//获取当前子字符串
				String ttid=tids[i];
				//将字符串编号转换为整型的员工编号
				int tid=Integer.parseInt(ttid);
				//执行删除操作
				testPaperTopicDao.delete(tid);
			}
			out.print("success");
		}catch(Exception e){
			out.print("failure");
		}
		
		//关闭输出对象
		out.close();
		
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//创建输出流对象
		PrintWriter out=response.getWriter();
		//接收来自客户端的数据
		int tid=Integer.parseInt(request.getParameter("tid"));
		int testpaperid=Integer.parseInt(request.getParameter("testpaperid"));
		int topicbankid=Integer.parseInt(request.getParameter("topicbankid"));
		
		//把数据封装成对象
		TestPaperTopic testPaperTopic=new TestPaperTopic(tid, testpaperid, topicbankid);
		
		//调用数据层的修改方法
		TestPaperTopicDao testPaperTopicDao=new TestPaperTopicDaoImpl();
		int rows=testPaperTopicDao.update(testPaperTopic);
		//判断修改是否成功
		if(rows>0){
			out.print("success");
		}else{
			out.print("failure");
		}
		//关闭输出对象
		out.close();
		
	}
	
	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//创建输出流对象
		PrintWriter out=response.getWriter();
		//接收来自客户端的数据
		int tid=Integer.parseInt(request.getParameter("tid"));
		int testpaperid=Integer.parseInt(request.getParameter("testpaperid"));
		int topicbankid=Integer.parseInt(request.getParameter("topicbankid"));
		
		//把数据封装成对象
		TestPaperTopic testPaperTopic=new TestPaperTopic(tid, testpaperid, topicbankid);
		
		//调用数据层的添加方法
		TestPaperTopicDao testPaperTopicDao=new TestPaperTopicDaoImpl();
		int rows=testPaperTopicDao.add(testPaperTopic);
		//判断添加是否成功
		if(rows>0){
			out.print("success");
		}else{
			out.print("failure");
		}
		//关闭输出对象
		out.close();
		
	}

	private void findAll(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
