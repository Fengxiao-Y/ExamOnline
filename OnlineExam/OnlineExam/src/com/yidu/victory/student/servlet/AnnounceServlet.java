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
import com.yidu.victory.student.domain.Announce;
import com.yidu.victory.student.dao.AnnounceDao;
import com.yidu.victory.student.dao.Impl.AnnounceDaoImpl;

/**
 * Servlet implementation class announceServlet
 */
@WebServlet("/AnnounceServlet")
public class AnnounceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnnounceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.设置请求的字符编码和响应的内容类型
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

	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out=response.getWriter();
		//获取来自请中所传递过来的员工编号字符串
		String aidStr=request.getParameter("aidNoStr");
		//将字符串进行按","(逗号)分割的子字符串数组
		String[] aids=aidStr.split(",");
		
		//创建数据层操作对象
		AnnounceDao announce=new AnnounceDaoImpl();
		
		//由于是批量删除，有可能失败，此处使用异常处理来实现
		try{
			//使用循环进行批量删除
			for(int i=0;i<aids.length;i++){
				//获取当前子字符串
				String taid=aids[i];
				//将字符串编号转换为整型的员工编号
				int aid=Integer.parseInt(taid);
				//执行删除操作
				announce.delete(aid);
			}
			out.print("success");
		}catch(Exception e){
			out.print("failure");
		}
		
		//关闭输出对象
		out.close();
		
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out=response.getWriter();
		
		//接收来自客户端的数据
		int aid=Integer.parseInt(request.getParameter("aid"));
		String theme=request.getParameter("theme");
		String titlecontent=request.getParameter("titlecontent");
		String announcecont=request.getParameter("announcecont");
		String issuepeople=request.getParameter("issuepeople");
		String issuetime=request.getParameter("issuetime");
		//数据封装成对象
		Announce announce=new Announce(aid, theme, titlecontent, announcecont, issuepeople, issuetime);
		//调用数据层对象执行添加方法
		AnnounceDao announceDao=new AnnounceDaoImpl();
		int rows=announceDao.update(announce);
		//判断添加是否成功
		if(rows>0){
			out.print("success");
		}else{
			out.print("failure");
		}
		
		out.close();
		
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out=response.getWriter();
		
		//接收来自客户端的数据
		//接收来自客户端的数据
		String theme=request.getParameter("theme");
		String titlecontent=request.getParameter("titlecontent");
		String announcecont=request.getParameter("announcecont");
		String issuepeople=request.getParameter("issuepeople");
		String issuetime=request.getParameter("issuetime");
		//数据封装成对象
		Announce announce=new Announce( theme, titlecontent, announcecont, issuepeople, issuetime);
		//调用数据层对象执行添加方法
		AnnounceDao announceDao=new AnnounceDaoImpl();
		int rows=announceDao.add(announce);
		//判断添加是否成功
		if(rows>0){
			out.print("success");
		}else{
			out.print("failure");
		}
		
		out.close();
		
	}

	private void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
PrintWriter out=response.getWriter();
		
		//得到来自请求中的条件数据
		String titlecontent=request.getParameter("titlecontent");
		String announcecont=request.getParameter("announcecont");
		String issuetime=request.getParameter("issuetime");
		
		//生成查询条件
		//select * from 表名 where 条件 limit n1,n2 
		//where 字段名=? and 字段名=? and 字段名=?
		String condition=" where 1=1 ";
		//对条件数据进行判断并组合成查询条件
		if(titlecontent!=null && !titlecontent.equals("")){
			condition=condition+"and titlecontent like '%"+titlecontent+"%' ";
		}
		
		if(announcecont!=null && !announcecont.equals("")){
			condition=condition+"and announcecont like '%"+announcecont+"%' ";
		}
		
		if(issuetime!=null && !issuetime.equals("")){
			//由于deptno是int类型，首先转换类型
			//int dept=Integer.parseInt(deptno);
			//添加到条件中
			condition=condition+"and issuetime="+issuetime+" ";
		}
		
		
		
		//接收来自客户端的datagrid组件的传递过来的page和rows参数
		int rows=Integer.parseInt(request.getParameter("rows"));
		int page=Integer.parseInt(request.getParameter("page"));
		
		//调用数据层执行分页查询
		AnnounceDao announceDao=new AnnounceDaoImpl();
		//获得当前页的数据集合
		List<Announce> announceList=announceDao.findByPage(rows, page,condition);
		//查询出emp表的总记录数
		int totalRows=announceDao.count(condition);
		
		//A方式：
		/*
		//将数据集合转换成JSON数据格式
		String jsonStr=JSONArray.fromObject(empList).toString();
		//生成格式化数据
		String json="{\"total\":"+totalRows+",\"rows\":"+jsonStr+"}";
		*/
		
		//B:方式
		//定义映射集合对象
		Map<String, Object> mapData = new HashMap<String, Object>();
		mapData.put("total", totalRows);
		mapData.put("rows", announceList  );
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
