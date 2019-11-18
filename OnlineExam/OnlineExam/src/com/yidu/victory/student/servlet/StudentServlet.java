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
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.yidu.victory.student.dao.SquadDao;
import com.yidu.victory.student.dao.StudentDao;
import com.yidu.victory.student.dao.Impl.SquadDaoImpl;
import com.yidu.victory.student.dao.Impl.StudentDaoImpl;
import com.yidu.victory.student.domain.Squad;
import com.yidu.victory.student.domain.Student;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
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
		}else if("login".equals(method)){
			this.login(request,response);
		}else if("updatepassword".equals(method)){
			this.updatepassword(request,response);
		}
	}

	private void updatepassword(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//创建一个输出流对象
				PrintWriter out=response.getWriter();
				//获取来自网页的密码
				String unumber=request.getParameter("unumber");
				String password=request.getParameter("passwords1");
				
				//从session中取出当前学生对象
				HttpSession session=request.getSession();
				Student st=(Student) session.getAttribute("stu");
				
				//创建数据层操作对象
				StudentDao studentdao=new StudentDaoImpl();
				if(st !=null & unumber.equals(st.getPasswords())){
					st.setPasswords(password);
					studentdao.update(st);
					out.print("success");
					
				}else {
					out.print("error");
				}
		
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out=response.getWriter();
		//接收网页的数据用户账号,密码
		String unumber=request.getParameter("unumber");
		String passwords=request.getParameter("passwords");

		//通过用户表的实现层的查单个方法 查找到账号的密码 进行核对实现登录
			//创建数据层操作对象
			StudentDao studentdao=new StudentDaoImpl();
			//通过查找单个方法 得到学生对象
			Student st=studentdao.findById(unumber);
			if(st!=null){
				

				if(passwords.equals(st.getPasswords())){
					HttpSession session=request.getSession();
					session.setAttribute("stu", st);
					out.print("success");
					
				}else{
					//密码错误
					out.print("error");
				}
			}else{
				//没找到用户
				out.print("notfund");
			}
		
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//创建一个输出流对象
		PrintWriter out=response.getWriter();
		//获取来自请求中所传递过来的考试编号字符串
		String sidStr=request.getParameter("sidStr");
		//将字符串进行按","(逗号)分割的子字符串数组
		String[] sids=sidStr.split(",");
		//创建数据层操作对象
		StudentDao studentDao=new StudentDaoImpl();
		SquadDao squaddao=new SquadDaoImpl();
		//由于是批量删除，有可能失败，此处使用异常处理来实现
		try{
				//使用循环进行批量删除
				for(int i=0;i<sids.length;i++){
					//获取当前子字符串
					
					String tsid=sids[i];

					//创建班级表数据层操作对象
					Student student=studentDao.findById(sids[i]);

					Squad squad=squaddao.findById(student.getSqid().getsqid());
					Squad squad2=new Squad(squad.getsqid(),squad.getSnumber(),squad.getSpeople()-1,squad.getSquadtime(),squad.getTeacher(),squad.getSadministration(),squad.getState(),squad.getClassify());
					squaddao.update(squad2);
					
					//执行删除操作
					studentDao.delete(tsid);
					
					
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
		String sid=request.getParameter("sid");
		String sname=request.getParameter("sname");
		String sex=request.getParameter("sex");
		int age=Integer.parseInt(request.getParameter("age"));
		int sqid=Integer.parseInt(request.getParameter("sqid"));
		String passwords=request.getParameter("passwords");
		String register=request.getParameter("register");
		String identitycard=request.getParameter("identitycard");
		String phone=request.getParameter("phone");
		String guardian=request.getParameter("guardian");
		String guardianwith=request.getParameter("guardianwith");
		String guardianphone=request.getParameter("guardianphone");
		String address=request.getParameter("address");
		String situation=request.getParameter("situation");
		
		//创建班级表数据层操作对象
		StudentDao studentDao=new StudentDaoImpl();
		Student student2=studentDao.findById(sid);
		SquadDao squaddao=new SquadDaoImpl();
		Squad squad=squaddao.findById(student2.getSqid().getsqid());
		Squad squad2=new Squad(squad.getsqid(),squad.getSnumber(),squad.getSpeople()-1,squad.getSquadtime(),squad.getTeacher(),squad.getSadministration(),squad.getState(),squad.getClassify());
		squaddao.update(squad2);
		
		//将数据封装成对象
		Student student=new Student(sid, sname, sex, age, sqid, passwords,
				register, identitycard, phone, guardian, guardianwith, 
				guardianphone, address, situation);
		
		//调用数据层对象执行修改方法
		
		int rows=studentDao.update(student);
		//判断是否修改成功
		if(rows>0){
			out.print("success");
			//创建班级表数据层操作对象
			Squad squad3=squaddao.findById(sqid);
			Squad squad4=new Squad(squad3.getsqid(),squad3.getSnumber(),squad3.getSpeople()+1,squad3.getSquadtime(),squad3.getTeacher(),squad3.getSadministration(),squad3.getState(),squad3.getClassify());
			squaddao.update(squad4);
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
		String sid=request.getParameter("sid");
		String sname=request.getParameter("sname");
		String sex=request.getParameter("sex");
		int age=Integer.parseInt(request.getParameter("age"));
		int sqid=Integer.parseInt(request.getParameter("sqid"));
		String passwords=request.getParameter("passwords");
		String register=request.getParameter("register");
		String identitycard=request.getParameter("identitycard");
		String phone=request.getParameter("phone");
		String guardian=request.getParameter("guardian");
		String guardianwith=request.getParameter("guardianwith");
		String guardianphone=request.getParameter("guardianphone");
		String address=request.getParameter("address");
		String situation=request.getParameter("situation");
		
		
		//将数据封装成对象
		Student student=new Student(sid, sname, sex, age, sqid,passwords,
				register, identitycard, phone, guardian, guardianwith, 
				guardianphone, address, situation);
		
		//调用数据层对象执行添加方法
		StudentDao studentDao=new StudentDaoImpl();
		int rows=studentDao.add(student);
		//判断是否添加成功
		if(rows>0){
			out.print("success");
		}else{
			out.print("failure");
		}
		//创建班级表数据层操作对象
			SquadDao squaddao=new SquadDaoImpl();
			Squad squad=squaddao.findById(sqid);
			Squad squad2=new Squad(squad.getsqid(),squad.getSnumber(),squad.getSpeople()+1,squad.getSquadtime(),squad.getTeacher(),squad.getSadministration(),squad.getState(),squad.getClassify());
			squaddao.update(squad2);
		//关闭输出对象
		out.close();
		
	}

	private void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//创建一个输出流对象
		PrintWriter out=response.getWriter();
		//得到来自请求中的条件数据
		String sname=request.getParameter("sname");
		String sqid=request.getParameter("sqid");
		String identitycard=request.getParameter("identitycard");
		

		String condition=" where 1=1 ";
		//对条件数据进行判断并组合成查询条件
		if(sname!=null && !sname.equals("")){
			condition=condition+"and sname like '%"+sname+"%' ";
		}
		if(identitycard!=null && !identitycard.equals("")){
			condition=condition+"and identitycard like '%"+identitycard+"%' ";
		}
		if(sqid!=null && !sqid.equals("")){
			condition=condition+"and sqid="+sqid+" ";
		}

		//接收来自客户端的datagrid组件的传递过来的page和rows参数
		int rows=Integer.parseInt(request.getParameter("rows"));
		int page=Integer.parseInt(request.getParameter("page"));
		//调用数据层执行分页查询
		StudentDao studentDao=new StudentDaoImpl();
		//获得当前页的数据集合
		List<Student> studentList=studentDao.findAll(rows, page, condition);
		//查询出student表的总记录数
		int totalRows=studentDao.count(condition);
		
		//定义映射集合对象
		Map<String, Object> mapData = new HashMap<String, Object>();
		mapData.put("total", totalRows);
		mapData.put("rows", studentList);
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
