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
import com.yidu.victory.excle.dao.TestPaperDao;
import com.yidu.victory.excle.dao.Impl.ExamDaoImpl;
import com.yidu.victory.excle.dao.Impl.TestPaperDaoImpl;
import com.yidu.victory.excle.domain.Exam;
import com.yidu.victory.excle.domain.TestPaper;
import com.yidu.victory.student.dao.StudentDao;
import com.yidu.victory.student.dao.StudtypeDao;
import com.yidu.victory.student.dao.Impl.StudentDaoImpl;
import com.yidu.victory.student.dao.Impl.StudtypeDaoImpl;
import com.yidu.victory.student.domain.Student;
import com.yidu.victory.student.domain.Studtype;

/**
 * Servlet implementation class ExamServlet
 */
@WebServlet("/ExamServlet")
public class ExamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExamServlet() {
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
		String eidStr=request.getParameter("eidStr");
		//将字符串进行按","(逗号)分割的子字符串数组
		String[] eids=eidStr.split(",");
		//创建数据层操作对象
		ExamDao examDao=new ExamDaoImpl();
		//由于是批量删除，有可能失败，此处使用异常处理来实现
		try{
				//使用循环进行批量删除
				for(int i=0;i<eids.length;i++){
					//获取当前子字符串
					String teid=eids[i];
					//将字符串编号转换为整型的考试编号
					int eid=Integer.parseInt(teid);
					//根据eid获得考试的班级
					Exam exam=examDao.findById(eid);
					//根据班级ID删除学生状态表中所有该班级学生
					//创建学生状态表数据层操作对象
					StudtypeDao stdtypedao=new StudtypeDaoImpl();
					String condition=" where squadid="+exam.getSqid();
					stdtypedao.deleteBycondition(condition);				
					//执行删除操作
					examDao.delete(eid);
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
		int eid=Integer.parseInt(request.getParameter("eid"));
		int cid=Integer.parseInt(request.getParameter("cid"));
		String headline=request.getParameter("headline");
		String cname=request.getParameter("cname");

		int sqid=Integer.parseInt(request.getParameter("sqid"));
		String examtime=request.getParameter("examtime");
		String finishtime=request.getParameter("finishtime");
		String againexam=request.getParameter("againexam");
		
		//将数据封装成对象
		Exam exam=new Exam(eid, cid, headline, cname, sqid, examtime, finishtime, againexam);
		
		//调用数据层对象执行修改方法
		ExamDao examDao=new ExamDaoImpl();
		int rows=examDao.update(exam);
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
		String headline=request.getParameter("headline");
		
		int sqid=Integer.parseInt(request.getParameter("sqid"));
		String examtime=request.getParameter("examtime");
		String finishtime=request.getParameter("finishtime");
		String againexam=request.getParameter("againexam");
		//创建数据层操作对象
		TestPaperDao testpaperdao=new TestPaperDaoImpl();
		String condition=" where headline='"+headline+"' ";
		TestPaper testpaper=testpaperdao.findAll(condition);
		String cname=testpaper.getCourseid();
		int cid=testpaper.getCid();	
		
		//将数据封装成对象
		Exam exam=new Exam(cid, headline, cname, sqid, examtime, finishtime, againexam);
		//调用数据层对象执行添加方法
		ExamDao examDao=new ExamDaoImpl();
		int rows=examDao.add(exam);
		//判断是否添加成功
		if(rows>0){
			//修改学生考试状态
			//创建学生状态表数据层操作对象
			StudtypeDao stdtypedao=new StudtypeDaoImpl();
			//创建学生表的数据层操作对象
			StudentDao studentdao=new StudentDaoImpl();
			//通过学生表查询到考试班级的所有学生
			String str=" where sqid="+sqid+" ";
			List<Student> studentlist=studentdao.findAll(str);
			for(int i=0;i<studentlist.size();i++){
			Studtype studtype=new Studtype(studentlist.get(i).getSid(), 0, sqid);
			stdtypedao.add(studtype);
			}
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
		String cid=request.getParameter("cid");
		String sqid=request.getParameter("sqid");
		String cname=request.getParameter("cname");
		

		String condition=" where 1=1 ";
		//对条件数据进行判断并组合成查询条件
		if(cname!=null && !cname.equals("")){
			condition=condition+" and cname like '%"+cname+"%' ";
		}
		if(cid!=null && !cid.equals("")){
			//由于cid是int类型，首先转换类型
			int cid1=Integer.parseInt(cid);
			//添加到条件中
			condition=condition+" and cid="+cid1;
		}
		if(sqid!=null && !sqid.equals("")){
			//由于sid是int类型，首先转换类型
			int sqid1=Integer.parseInt(sqid);
			condition=condition+"  and sqid="+sqid1+" ";
		}
		
		//接收来自客户端的datagrid组件的传递过来的page和rows参数
		int rows=Integer.parseInt(request.getParameter("rows"));
		int page=Integer.parseInt(request.getParameter("page"));
		
		//调用数据层执行分页查询
		ExamDao examDao=new ExamDaoImpl();
		//获得当前页的数据集合
		List<Exam> examList=examDao.findAll(rows, page, condition);
		//查询出student表的总记录数
		int totalRows=examDao.count(condition);
		
		//定义映射集合对象
		Map<String, Object> mapData = new HashMap<String, Object>();
		mapData.put("total", totalRows);
		mapData.put("rows", examList);
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
