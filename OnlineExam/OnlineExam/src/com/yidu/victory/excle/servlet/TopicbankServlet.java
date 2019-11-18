package com.yidu.victory.excle.servlet;

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
import com.yidu.victory.excle.dao.ConditionsDao;
import com.yidu.victory.excle.dao.TopicbankDao;
import com.yidu.victory.excle.dao.Impl.ConditionsDaoImpl;
import com.yidu.victory.excle.dao.Impl.TopicbankDaoImpl;
import com.yidu.victory.excle.domain.Conditions;
import com.yidu.victory.excle.domain.Topicbank;
import com.yidu.victory.student.dao.CourseDao;
import com.yidu.victory.student.dao.DifficultyDao;
import com.yidu.victory.student.dao.Impl.CourseDaoImpl;
import com.yidu.victory.student.dao.Impl.DifficultyDaoImpl;
import com.yidu.victory.student.domain.Course;
import com.yidu.victory.student.domain.Difficulty;



/**
 * Servlet implementation class TopicbankServlet
 */
@WebServlet("/TopicbankServlet")
public class TopicbankServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TopicbankServlet() {
        super();
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
		String testidStr=request.getParameter("testidNoStr");
		//将字符串进行按","(逗号)分割的子字符串数组
		String[] testids=testidStr.split(",");
		
		//创建数据层操作对象
		TopicbankDao TopicbankDao=new TopicbankDaoImpl();
		
		//由于是批量删除，有可能失败，此处使用异常处理来实现
		try{
			//使用循环进行批量删除
			for(int i=0;i<testids.length;i++){
				//获取当前子字符串
				String ttestid=testids[i];
				//将字符串编号转换为整型的员工编号
				int testid=Integer.parseInt(ttestid);
				//执行删除操作
				TopicbankDao.delete(testid);
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
		int testid=Integer.parseInt(request.getParameter("testid"));
		String testtype=request.getParameter("testtype");
		String aresult=request.getParameter("aresult");
		String bresult=request.getParameter("bresult");
		String cresult=request.getParameter("cresult");
		String dresult=request.getParameter("dresult");
		String eresult=request.getParameter("eresult");
		String fresult=request.getParameter("fresult");
		String rightsult=request.getParameter("rightsult");
		String content=request.getParameter("content");
		String grade=request.getParameter("grade");
		double falsely=Double.parseDouble(request.getParameter("falsely"));
		String cname=request.getParameter("cname");
		
		//获取课程阶段，得到course数据层操做对象
		CourseDao coursedao=new CourseDaoImpl();
		String condition22=" where cname='"+cname+"' ";
 		Course course =coursedao.findAll(condition22);
 		String stagename=course.getStagename();
 		
 		//难度等级对象
 				DifficultyDao diffcultydao=new DifficultyDaoImpl();
 				Difficulty diffculty=new Difficulty(testid,grade);
 				diffcultydao.update(diffculty);
 				//题目错误率对象
 				ConditionsDao conditiondao=new ConditionsDaoImpl();
 				Conditions conditions=new Conditions(testid,falsely);
 				conditiondao.update(conditions);
 		
		//把数据封装成对象
		Topicbank topicbank=new Topicbank(testid, testtype, aresult, bresult, cresult, dresult, eresult, fresult, rightsult, content, grade, falsely, cname, stagename);
				
		
		//调用数据层的修改方法
		TopicbankDao topicbankDao = new TopicbankDaoImpl(); 
		int rows=topicbankDao.update(topicbank);
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
		String testtype=request.getParameter("testtype");
		String aresult=request.getParameter("aresult");
		String bresult=request.getParameter("bresult");
		String cresult=request.getParameter("cresult");
		String dresult=request.getParameter("dresult");
		String eresult=request.getParameter("eresult");
		String fresult=request.getParameter("fresult");
		String rightsult=request.getParameter("rightsult");
		String content=request.getParameter("content");
		String grade=request.getParameter("grade");
		String cname=request.getParameter("cname");
		//创建数据层操作对象
		CourseDao coursedao=new CourseDaoImpl();
		String ss=" where 1=1 and cname='"+cname+"' ";
		String stagename=coursedao.findAll(ss).getStagename();
		//把数据封装成对象
		//题库对象
		Topicbank topicbank=new Topicbank(testtype, aresult, bresult, cresult, dresult, eresult, fresult, rightsult, content, grade, cname, stagename);
		
		//调用数据层的添加方法
		TopicbankDao topicbankDao = new TopicbankDaoImpl(); 
		int rows=topicbankDao.add(topicbank);
		//获取当前添加的题目的ID
		int rrrr=topicbankDao.findlast();
		
		//难度等级对象
		DifficultyDao diffcultydao=new DifficultyDaoImpl();
		Difficulty diffculty=new Difficulty(rrrr,grade);
		diffcultydao.add(diffculty);
		//题目错误率对象
		ConditionsDao conditiondao=new ConditionsDaoImpl();
		Conditions conditions=new Conditions(rrrr,0);
		conditiondao.add(conditions);
		//判断添加是否成功
		if(rows>0){
			out.print("success");
		}else{
			out.print("failure");
		}
		//关闭输出对象
		out.close();
		
	}

	private void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//创建一个输出流
		PrintWriter out=response.getWriter();
		//得到来自请求中的条件数据
		String testtype=request.getParameter("testtype");
		String content=request.getParameter("content");
		String cname=request.getParameter("cname");
		String stagename=request.getParameter("stagename");
		
		
		//生成查询条件
		//select * from 表明 where 条件 limit n1,n2
		//where 字段名=? and 字段名=? and 字段名=?
		String condition=" ";
		
		//对条件数据进行判断并组合成查询条件
		if(testtype!=null && !testtype.equals("")){
			condition=condition+" and testtype like '%"+testtype+"%' ";
		}
		//根据工种字段值进行判断，生成条件
		if(content!=null && !content.equals("")){
			condition=condition+" and content like '%"+content+"%' ";
		}
		if(cname!=null && !cname.equals("")){
			condition=condition+" and cname like '%"+cname+"%' ";
		}
		if(stagename!=null && !stagename.equals("")){
			condition=condition+" and stagename like '%"+stagename+"%' ";
		}
		
		//接收来自客户端的datagrid组件的传递过来的page和rows参数
		int rows=Integer.parseInt(request.getParameter("rows"));
		int page=Integer.parseInt(request.getParameter("page"));
		
		//调用数据层执行分页查询
		TopicbankDao topicbankdao=new TopicbankDaoImpl();
		//获得当前页的数据集合
		List<Topicbank> topicbankList=topicbankdao.findAll(rows, page, condition);
		
		// 将condition的格式转换成int
		//int cond=Integer.parseInt(condition);
		//查询出Makeuptable表的总记录数
		int totalRows=topicbankdao.count(condition);
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
		mapData.put("rows", topicbankList);
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
