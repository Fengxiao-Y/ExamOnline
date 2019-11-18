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
import com.yidu.victory.student.dao.StudentDao;
import com.yidu.victory.student.dao.TeacherDao;
import com.yidu.victory.student.dao.Impl.StudentDaoImpl;
import com.yidu.victory.student.dao.Impl.TeacherDaoImpl;
import com.yidu.victory.student.domain.Student;
import com.yidu.victory.student.domain.Teacher;

/**
 * Servlet implementation class TeacherServlet
 */
@WebServlet("/TeacherServlet")
public class TeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherServlet() {
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
		//创建一个输出流对象
		PrintWriter out=response.getWriter();
		//获取来自请求中所传递过来的考试编号字符串
		String tidStr=request.getParameter("tidStr");

		//将字符串进行按","(逗号)分割的子字符串数组
		String[] tids=tidStr.split(",");
		//创建数据层操作对象
		TeacherDao teacherDao=new TeacherDaoImpl();
		//由于是批量删除，有可能失败，此处使用异常处理来实现
		try{
				//使用循环进行批量删除
				for(int i=0;i<tids.length;i++){
					//获取当前子字符串
					String ttid=tids[i];

					//执行删除操作
					teacherDao.delete(ttid);
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
				String tid=request.getParameter("tid");
				String tname=request.getParameter("tname");
				String sex=request.getParameter("sex");
				int age=Integer.parseInt(request.getParameter("age"));
				String phone=request.getParameter("phone");
				int penguin=Integer.parseInt(request.getParameter("penguin"));
				String address=request.getParameter("address");
				String situation=request.getParameter("situation");
				//将数据封装成对象
				Teacher teacher=new Teacher(tid, tname, sex, age, phone, penguin,
						address, situation );
						
				
				//调用数据层对象执行修改方法
				TeacherDao teacherDao=new TeacherDaoImpl();
				int rows=teacherDao.update(teacher);
				//判断是否修改成功
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
		String tid=request.getParameter("tid");
		String tname=request.getParameter("tname");
		String sex=request.getParameter("sex");
		int age=Integer.parseInt(request.getParameter("age"));
		String phone=request.getParameter("phone");
		int penguin=Integer.parseInt(request.getParameter("penguin"));
		String address=request.getParameter("address");
		String situation=request.getParameter("situation");
		//将数据封装成对象
		Teacher teacher=new Teacher(tid, tname, sex, age, phone, penguin,
				address, situation );
				
		//调用数据层对象执行添加方法
		TeacherDao teacherDao=new TeacherDaoImpl();
		int rows=teacherDao.add(teacher);
		//判断是否添加成功
		if(rows>0){
			out.print("success");
		}else{
			out.print("failure");
		}
		//关闭输出对象
		out.close();
		
	}


	private void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//创建一个输出流对象
		PrintWriter out=response.getWriter();
		//得到来自请求中的条件数据
		String tid=request.getParameter("tid");
		String tname=request.getParameter("tname");
		String phone=request.getParameter("phone");
		String condition=" where 1=1 ";
		//对条件数据进行判断并组合成查询条件
		if(tid!=null && !tid.equals("")){
			condition=condition+"and tid like '%"+tid+"%' ";
		}
		if(tname!=null && !tname.equals("")){
			condition=condition+"and tname like '%"+tname+"%' ";
		}
		if(phone!=null && !phone.equals("")){
			condition=condition+"and phone like '%"+phone+"%' ";
		}	

		//接收来自客户端的datagrid组件的传递过来的page和rows参数
		int rows=Integer.parseInt(request.getParameter("rows"));
		int page=Integer.parseInt(request.getParameter("page"));
		//调用数据层执行分页查询
		TeacherDao teacherDao=new TeacherDaoImpl();
		//获得当前页的数据集合
		List<Teacher> teacherList=teacherDao.findAll(rows, page, condition);
		//查询出student表的总记录数
		int totalRows=teacherDao.count(condition);
		
		//定义映射集合对象
		Map<String, Object> mapData = new HashMap<String, Object>();
		mapData.put("total", totalRows);
		mapData.put("rows", teacherList);
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
