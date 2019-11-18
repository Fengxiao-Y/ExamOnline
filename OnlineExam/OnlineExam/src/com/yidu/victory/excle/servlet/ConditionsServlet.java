package com.yidu.victory.excle.servlet;

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
import com.yidu.victory.excle.dao.ConditionsDao;
import com.yidu.victory.excle.dao.Impl.ConditionsDaoImpl;
import com.yidu.victory.excle.domain.Conditions;


/**
 * Servlet implementation class ConditionsServlet
 */
@WebServlet("/ConditionsServlet")
public class ConditionsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConditionsServlet() {
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
		String conditionsNoStr=request.getParameter("conditionsNoStr");
		//将字符串进行按","(逗号)分割的子字符串数组
		String[] conditionsNos=conditionsNoStr.split(",");
		
		//创建数据层操作对象
		ConditionsDao conditionsDao=new ConditionsDaoImpl();
		
		//由于是批量删除，有可能失败，此处使用异常处理来实现
		try{
			//使用循环进行批量删除
			for(int i=0;i<conditionsNos.length;i++){
				//获取当前子字符串
				String conditionsDaoNo=conditionsNos[i];
				//将字符串编号转换为整型的员工编号
				int tid=Integer.parseInt(conditionsDaoNo);
				//执行删除操作
				conditionsDao.delete(tid);
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
				int tid=Integer.parseInt(request.getParameter("tid"));
				double falsely=Double.parseDouble(request.getParameter("falsely"));
				
				//数据封装成对象
				Conditions conditions=new Conditions(tid, falsely);
				
				//调用数据层对象执行添加方法
				ConditionsDao makeuptableDao=new ConditionsDaoImpl();
				int rows=makeuptableDao.update(conditions);
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
		int tid=Integer.parseInt(request.getParameter("tid"));
		double falsely=Double.parseDouble(request.getParameter("falsely"));
		
		
		//把数据封装成对象
		  Conditions conditions=new Conditions(tid,falsely);
		  //调用数据层对象执行添加方法
		  ConditionsDao conditionsDao=new ConditionsDaoImpl();
		  int rows=conditionsDao.add(conditions);
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
		  String falsely=request.getParameter("falsely");
		  String tid=request.getParameter("tid");

		  String condition=" where 1=1 ";
		  //对条件数据进行判断并组合成查询条件
		  if(falsely!=null && !falsely.equals("")){
				condition=condition+" and falsely like '%"+falsely+"%' ";
		  }
			//根据工种字段值进行判断，生成条件
		  if(tid!=null && !tid.equals("")){
				condition=condition+" and tid like '%"+tid+"%' ";
		  }
			
		 
		  
		  
		  //接收来自客户端的datagrid组件的传递过来的page和rows参数
		  int rows=Integer.parseInt(request.getParameter("rows"));
		  int page=Integer.parseInt(request.getParameter("page"));
		  
		  //调用数据层执行分页查询
		  ConditionsDao conditionsDao=new ConditionsDaoImpl();
		  //获得当前页的数据集合
		  List<Conditions> conditionsList=conditionsDao.findAll(rows, page, condition);
		  //查询出student表的总记录数
		  int totalRows=conditionsDao.count(condition);
		  
		  //定义映射集合对象
		  Map<String, Object> mapData = new HashMap<String, Object>();
		  mapData.put("total", totalRows);
		  mapData.put("rows", conditionsList);
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
