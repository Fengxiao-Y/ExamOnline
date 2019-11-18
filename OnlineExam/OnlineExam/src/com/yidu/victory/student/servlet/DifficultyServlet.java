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
import com.yidu.victory.student.dao.DifficultyDao;
import com.yidu.victory.student.dao.Impl.DifficultyDaoImpl;
import com.yidu.victory.student.domain.Difficulty;

/**
 * Servlet implementation class DifficultyServlet
 */
@WebServlet("/DifficultyServlet")
public class DifficultyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DifficultyServlet() {
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
		//获取来自请求中所传递过来的试题编号字符串
		String difficultyNoStr=request.getParameter("difficultyNoStr");
		//将字符串进行按","(逗号)分割的字符串数组
		String[] difficultyNos=difficultyNoStr.split(",");
		
		//创建数据层操作对象
		DifficultyDao difficultyDao=new DifficultyDaoImpl();
		//由于批量删除可能失败，此处使用异常处理来实现
		try{
			//使用循环来进行批量删除
			for(int i=0;i<difficultyNos.length;i++){
				//获取当前字符串
				String difficultyDaoNo=difficultyNos[i];
				//将字符串编号转换为整形的员工编号
				int tid=Integer.parseInt(difficultyDaoNo);
				
				//执行删除操作
				difficultyDao.delete(tid);
				out.print("success");
			}
		}catch(Exception e){
			out.print("failure");
		}
		//关闭输出对象
		out.close();
	}

	/**
	 * 增加
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out=response.getWriter();
		//接收来自客户端的数据
		int tid=Integer.parseInt(request.getParameter("tid"));
		String grade=request.getParameter("grade");
		//数据封装成对象
		Difficulty difficulty=new Difficulty(tid, grade);
		//调用数据层对象执行添加方法
		DifficultyDao difficultyDao=new DifficultyDaoImpl();
		int rows=difficultyDao.update(difficulty);
		//判断添加是否成功
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
		int tid=Integer.parseInt(request.getParameter("tid"));
		String grade=request.getParameter("grade");
		//数据封装成对象
		Difficulty difficulty=new Difficulty(tid, grade);
		//调用数据层对象执行添加方法
		DifficultyDao difficultyDao=new DifficultyDaoImpl();
		int rows=difficultyDao.add(difficulty);
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
		String tid=request.getParameter("tid");
		String grade=request.getParameter("grade");
		
		//生成查询条件
		//select * from 表明 where 条件 limit n1,n2
		//where 字段名=? and 字段名=? and 字段名=?
		String condition=" where 1=1 ";
		
		//对条件数据进行判断并组合成查询条件
		if(grade!=null && !grade.equals("")){
			condition=condition+" and grade like '%"+grade+"%' ";
		}
		//根据工种字段值进行判断，生成条件
		if(tid!=null && !tid.equals("")){
			condition=condition+" and tid like '%"+tid+"%' ";
		}
		
		//接收来自客户端的datagrid组件的传递过来的page和rows参数
		int rows=Integer.parseInt(request.getParameter("rows"));
		int page=Integer.parseInt(request.getParameter("page"));
		
		//调用数据层执行分页查询
		DifficultyDao difficultydao=new DifficultyDaoImpl();
		//获得当前页的数据集合
		List<Difficulty> difficultyList=difficultydao.findAll(rows, page, condition);
		
		// 将condition的格式转换成int
		//int cond=Integer.parseInt(condition);
		//查询出Makeuptable表的总记录数
		int totalRows=difficultydao.count(condition);
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
		mapData.put("rows", difficultyList);
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
