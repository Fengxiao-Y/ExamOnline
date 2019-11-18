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
import com.yidu.victory.excle.dao.ExamDao;
import com.yidu.victory.excle.dao.StugradeDao;
import com.yidu.victory.excle.dao.Impl.ExamDaoImpl;
import com.yidu.victory.excle.dao.Impl.StugradeDaoImpl;
import com.yidu.victory.excle.domain.Exam;
import com.yidu.victory.excle.domain.Stugrade;

/**
 * Servlet implementation class StugradeServlet
 */
@WebServlet("/StugradeServlet")
public class StugradeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StugradeServlet() {
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
		String gidStr=request.getParameter("gidStr");
		//将字符串进行按","(逗号)分割的子字符串数组
		String[] gids=gidStr.split(",");
		//创建数据层操作对象
		StugradeDao stugradeDao=new StugradeDaoImpl();
		//由于是批量删除，有可能失败，此处使用异常处理来实现
		try{
				//使用循环进行批量删除
				for(int i=0;i<gids.length;i++){
					//获取当前子字符串
					String tgid=gids[i];
					//将字符串编号转换为整型的考试编号
					int gid=Integer.parseInt(tgid);
					//执行删除操作
					stugradeDao.delete(gid);
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
		int gid=Integer.parseInt(request.getParameter("gid"));
		String sid=request.getParameter("sid");
		String sname=request.getParameter("sname");
		int grade=Integer.parseInt(request.getParameter("grade"));
		int squadid=Integer.parseInt(request.getParameter("squadid"));
		int cid=Integer.parseInt(request.getParameter("cid"));
		String remark=request.getParameter("remark");
		//把数据封装成对象
		Stugrade stugrade=new Stugrade(gid, sid, sname, grade, squadid, cid,remark);
		//调用数据层对象执行修改方法
		StugradeDao stugradeDao=new StugradeDaoImpl();
		int rows=stugradeDao.update(stugrade);
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
		String sid=request.getParameter("sid");
		String sname=request.getParameter("sname");
		int grade=Integer.parseInt(request.getParameter("grade"));
		int squadid=Integer.parseInt(request.getParameter("squadid"));
		int cid=Integer.parseInt(request.getParameter("cid"));
		String remark=request.getParameter("remark");
		
		//把数据封装成对象
		Stugrade stugrade=new Stugrade( sid, sname, grade, squadid, cid,remark);
		//调用数据层对象执行添加方法
		StugradeDao stugradeDao=new StugradeDaoImpl();
		int rows=stugradeDao.add(stugrade);
		//判断添加方法是否成功
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
		String sname=request.getParameter("sname");
		String squadid=request.getParameter("squadid");
		String cid=request.getParameter("cid");

		String condition=" where 1=1 ";
		//对条件数据进行判断并组合成查询条件
		if(sname!=null && !sname.equals("")){
			condition=condition+"and sname like '%"+sname+"%' ";
		}
		if(squadid!=null && !squadid.equals("")){
			//由于squadid是int类型，首先转换类型
			int squadid1=Integer.parseInt(squadid);
			//添加到条件中
			condition=condition+"and squadid="+squadid1+" ";
		}
		if(cid!=null && !cid.equals("")){
			//由于cid是int类型，首先转换类型
			int cid1=Integer.parseInt(cid);
			condition=condition+"and cid ="+cid1+" ";
		}
		
		//接收来自客户端的datagrid组件的传递过来的page和rows参数
		int rows=Integer.parseInt(request.getParameter("rows"));
		int page=Integer.parseInt(request.getParameter("page"));
		
		//调用数据层执行分页查询
		StugradeDao stugradeDao=new StugradeDaoImpl();
		//获得当前页的数据集合
		List<Stugrade> stugradeList=stugradeDao.findAll(rows, page, condition);
		//查询出student表的总记录数
		int totalRows=stugradeDao.count(condition);
		
		//定义映射集合对象
		Map<String, Object> mapData = new HashMap<String, Object>();
		mapData.put("total", totalRows);
		mapData.put("rows", stugradeList);
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
