package com.yidu.victory.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.yidu.victory.student.dao.MakeuptableDao;
import com.yidu.victory.student.dao.Impl.MakeuptableDaoImpl;
import com.yidu.victory.student.domain.Makeuptable;




/**
 * Servlet implementation class MakeuptableServlet
 */
@WebServlet("/MakeuptableServlet")
public class MakeuptableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MakeuptableServlet() {
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
	 * @throws IOException 抛出异常
	 */
	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out=response.getWriter();
		//获取来自请中所传递过来的员工编号字符串
		String makeuptableNoStr=request.getParameter("makeuptableNoStr");
		//将字符串进行按","(逗号)分割的子字符串数组
		String[] makeuptableNos=makeuptableNoStr.split(",");
		
		
		
		//创建数据层操作对象
		MakeuptableDao makeuptableDao=new MakeuptableDaoImpl();
		
		//由于是批量删除，有可能失败，此处使用异常处理来实现
		try{
			//使用循环进行批量删除
			for(int i=0;i<makeuptableNos.length;i++){
				//获取当前子字符串
				String makeuptableDaoNo=makeuptableNos[i];

				//将字符串编号转换为整型的员工编号
				int tid=Integer.parseInt(makeuptableDaoNo);
				
				//执行删除操作
				makeuptableDao.delete(tid);
				out.print("success");
			}
			
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
		int sid=Integer.parseInt(request.getParameter("sid"));
		String sname=request.getParameter("sname");
		int grade=Integer.parseInt(request.getParameter("grade"));
		int squadid=Integer.parseInt(request.getParameter("squadid"));
		int eid=Integer.parseInt(request.getParameter("eid"));
		String conditions=request.getParameter("conditions");
		
		//数据封装成对象
		Makeuptable makeuptable=new Makeuptable(sid, sname, grade, squadid, eid, conditions);
		
		//调用数据层对象执行添加方法
		MakeuptableDao makeuptableDao=new MakeuptableDaoImpl();
		int rows=makeuptableDao.update(makeuptable);
		//判断修改是否成功
		if(rows>0){
			out.print("success");
		}else{
			out.print("failure");
		}
		
		out.close();
	}

	/**
	 * 增加
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out=response.getWriter();

		//接收来自客户端的数据
		int sid=Integer.parseInt(request.getParameter("sid"));
		String sname=request.getParameter("sname");
		int grade=Integer.parseInt(request.getParameter("grade"));
		int squadid=Integer.parseInt(request.getParameter("squadid"));
		int eid=Integer.parseInt(request.getParameter("eid"));
		String conditions=request.getParameter("conditions");
		
		
		//数据封装成对象
		Makeuptable makeuptable=new Makeuptable(sid, sname, grade, squadid, eid, conditions);

		//调用数据层对象执行添加方法
		MakeuptableDao makeuptableDao=new MakeuptableDaoImpl();
		int rows=makeuptableDao.add(makeuptable);
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
	private void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//创建一个输出流
		PrintWriter out=response.getWriter();
		
		//得到来自请求中的条件数据
		
		String sid=request.getParameter("sid");
		String sname=request.getParameter("sname");
		String grade=request.getParameter("grade");
		String squadid=request.getParameter("squadid");
		String eid=request.getParameter("eid");
		String conditions=request.getParameter("conditions");
		//String deptno=request.getParameter("deptno");
		
		//生成查询条件
		//select * from 表名 where 条件 limit n1,n2 
		//where 字段名=? and 字段名=? and 字段名=?
		String condition=" where 1=1 ";
		
		//对条件数据进行判断并组合成查询条件
		if(sname!=null && !sname.equals("")){
			condition=condition+" and sname like '%"+sname+"%' ";
		}
		//根据工种字段值进行判断，生成条件
		if(sid!=null && !sid.equals("")){
			condition=condition+" and sid like '%"+sid+"%' ";
		}
		if(grade!=null && !grade.equals("")){
			condition=condition+" and grade like '%"+grade+"%' ";
		}
		if(squadid!=null && !squadid.equals("")){
			condition=condition+" and squadid like '%"+squadid+"%' ";
		}
		
		if(eid!=null && !eid.equals("")){
			condition=condition+" and eid like '%"+eid+"%' ";
		}
		if(conditions!=null && !conditions.equals("")){
			condition=condition+" and conditions like '%"+conditions+"%' ";
		}
		
		/*
		if(deptno!=null && !deptno.equals("")){
			//由于deptno是int类型，首先转换类型
			int dept=Integer.parseInt(deptno);
			//添加到条件中
			condition=condition+" and deptno="+dept+" ";
		}
		*/

		
		//接收来自客户端的datagrid组件的传递过来的page和rows参数
		int rows=Integer.parseInt(request.getParameter("rows"));
		int page=Integer.parseInt(request.getParameter("page"));
		
		//调用数据层执行分页查询
		MakeuptableDao makeuptabledao=new MakeuptableDaoImpl();
		//获得当前页的数据集合
		List<Makeuptable> makeuptableList=makeuptabledao.findAll(rows, page, condition);
		
		// 将condition的格式转换成int
		//int cond=Integer.parseInt(condition);
		//查询出Makeuptable表的总记录数
		int totalRows=makeuptabledao.count(condition);
				
		
		//A方式：
		/*
		//将数据集合转换成JSON数据格式
		String jsonStr=JSONArray.fromObject(conditionsList).toString();
		//生成格式化数据
		String json="{\"total\":"+totalRows+",\"rows\":"+jsonStr+"}";
		*/
		
		//B:方式
		//定义映射集合对象
		HashMap<String, Object> mapData = new HashMap<String, Object>();
		mapData.put("total", totalRows);
		mapData.put("rows", makeuptableList);
		//定义Gson对象
		Gson gson = new Gson();
		//通过Gson对象将Map集合转换成json数据格式
		String jsonData = gson.toJson(mapData);
		//将json数据输出到客户端
		out.println(jsonData);

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
