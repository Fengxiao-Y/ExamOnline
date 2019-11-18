package com.yidu.victory.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.yidu.victory.student.dao.CourseDao;
import com.yidu.victory.student.dao.Impl.CourseDaoImpl;
import com.yidu.victory.student.domain.Course;




/**
 * Servlet implementation class CourseServlet
 */
@WebServlet("/CourseServlet")
public class CourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		
		
		String method=request.getParameter("method");
		
		if("findAll".equals(method)){
			this.findAll(request,response);
		}else if("add".equals(method)){
			this.add(request,response);
		}else if("update".equals(method)){
			this.update(request,response);
		}else if("delete".equals(method)){
			this.delete(request,response);
		}
		
	}


	/**
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out=response.getWriter();
		//获取来自请中所传递过来的员工编号字符串
		String courseNoStr=request.getParameter("courseNoStr");
		//将字符串进行按","(逗号)分割的子字符串数组
		String[] courseNos=courseNoStr.split(",");
		
		//创建数据层操作对象
		CourseDao courseDao=new CourseDaoImpl();
		
		//由于是批量删除，有可能失败，此处使用异常处理来实现
		try{
			//使用循环进行批量删除
			for(int i=0;i<courseNos.length;i++){
				//获取当前子字符串
				String courseDaoNo=courseNos[i];
				//将字符串编号转换为整型的员工编号
				int cid=Integer.parseInt(courseDaoNo);
				//执行删除操作
				courseDao.delete(cid);
			}
			out.print("success");
		}catch(Exception e){
			out.print("failure");
		}
		
		//关闭输出对象
		out.close();
	}

	/**
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out=response.getWriter();
		//接收来自客户端的数据
		int cid=Integer.parseInt(request.getParameter("cid"));
		String cname=request.getParameter("cname");
		String stagename=request.getParameter("stagename");
		
		//数据封装成对象
		Course course=new Course(cid, cname, stagename);
		
		//调用数据层对象执行添加方法
		CourseDao courseDao=new CourseDaoImpl();
		int rows=courseDao.update(course);
		//判断添加是否成功
		if(rows>0){
			out.print("success");
		}else{
			out.print("failure");
		}
		
		out.close();
	}

	/**
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out=response.getWriter();
		//接收来自客户端的数据
		
		String cname=request.getParameter("cname");
		String stagename=request.getParameter("stagename");
		
		
		//把数据封装成对象
		 Course course=new Course(cname,stagename);
		  //调用数据层对象执行添加方法
		 CourseDao courseDao=new CourseDaoImpl();
		  int rows=courseDao.add(course);
		  //判断添加方法是否成功
		  if(rows>0){
		   out.print("success");
		  }else{
		   out.print("failure");
		  }
		  //关闭输出对象
		  out.close();
	}

	/**
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//创建一个输出流对象
		  PrintWriter out=response.getWriter();
		  //得到来自请求中的条件数据
		  String cname=request.getParameter("cname");
		  String stagename=request.getParameter("stagename");
		  String cid=request.getParameter("cid");

		  String condition=" where 1=1 ";
		  //对条件数据进行判断并组合成查询条件
		  if(cname!=null && !cname.equals("")){
				condition=condition+" and cname like '%"+cname+"%' ";
		  }
			//根据工种字段值进行判断，生成条件
		  if(stagename!=null && !stagename.equals("")){
				condition=condition+" and stagename like '%"+stagename+"%' ";
		  }
		  if(cid!=null && !cid.equals("")){
				condition=condition+" and cid like '%"+cid+"%' ";
		  }
			
		 
		  
		  
		  //接收来自客户端的datagrid组件的传递过来的page和rows参数
		  int rows=Integer.parseInt(request.getParameter("rows"));
		  int page=Integer.parseInt(request.getParameter("page"));
		  
		  //调用数据层执行分页查询
		  CourseDao courseDao=new CourseDaoImpl();
		  //获得当前页的数据集合
		  List<Course> courseList=courseDao.findAll(rows, page, condition);
		  //查询出student表的总记录数
		  int totalRows=courseDao.count(condition);
		  
		  //定义映射集合对象
		  Map<String, Object> mapData = new HashMap<String, Object>();
		  mapData.put("total", totalRows);
		  mapData.put("rows", courseList);
		  //定义Gson对象
		  Gson gson = new Gson();
		  //通过Gson对象将Map集合转换成json数据格式
		  String jsonData = gson.toJson(mapData);
		  //将json数据输出到客户端
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
