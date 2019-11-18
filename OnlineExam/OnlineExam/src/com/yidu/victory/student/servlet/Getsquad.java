package com.yidu.victory.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;
import com.yidu.victory.excle.dao.ConditionsDao;
import com.yidu.victory.excle.dao.ExamDao;
import com.yidu.victory.excle.dao.StugradeDao;
import com.yidu.victory.excle.dao.TestPaperDao;
import com.yidu.victory.excle.dao.TestPaperTopicDao;
import com.yidu.victory.excle.dao.TopicbankDao;
import com.yidu.victory.excle.dao.Impl.ConditionsDaoImpl;
import com.yidu.victory.excle.dao.Impl.ExamDaoImpl;
import com.yidu.victory.excle.dao.Impl.StugradeDaoImpl;
import com.yidu.victory.excle.dao.Impl.TestPaperDaoImpl;
import com.yidu.victory.excle.dao.Impl.TestPaperTopicDaoImpl;
import com.yidu.victory.excle.dao.Impl.TopicbankDaoImpl;
import com.yidu.victory.excle.domain.Conditions;
import com.yidu.victory.excle.domain.Exam;
import com.yidu.victory.excle.domain.Stugrade;
import com.yidu.victory.excle.domain.TestPaper;
import com.yidu.victory.excle.domain.TestPaperTopic;
import com.yidu.victory.excle.domain.Topicbank;
import com.yidu.victory.student.dao.CourseDao;
import com.yidu.victory.student.dao.SquadDao;
import com.yidu.victory.student.dao.StudentDao;
import com.yidu.victory.student.dao.StudtypeDao;
import com.yidu.victory.student.dao.TeacherDao;
import com.yidu.victory.student.dao.Impl.CourseDaoImpl;
import com.yidu.victory.student.dao.Impl.SquadDaoImpl;
import com.yidu.victory.student.dao.Impl.StudentDaoImpl;
import com.yidu.victory.student.dao.Impl.StudtypeDaoImpl;
import com.yidu.victory.student.dao.Impl.TeacherDaoImpl;
import com.yidu.victory.student.domain.Course;
import com.yidu.victory.student.domain.Squad;
import com.yidu.victory.student.domain.Student;
import com.yidu.victory.student.domain.Studtype;
import com.yidu.victory.student.domain.Teacher;

/**
 * Servlet implementation class Getsquad
 */
@WebServlet("/Getsquad")
public class Getsquad extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Getsquad() {
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
		//接收数据
		String method=request.getParameter("method");
		if(method.equals("classname")){
			getclassname(request,response);
		}else if(method.equals("teacher")){
			getteacher(request,response);
		}else if(method.equals("headline")){
			getheadline(request,response);
		}else if(method.equals("cccc")){
			getcccc(request,response);
		}else if(method.equals("getexcle")){
			getexcle(request,response);
		}else if(method.equals("getexam")){
			try {
				getexam(request,response);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(method.equals("gettime")){
			gettime(request,response);
		}else if(method.equals("score")){
			score(request,response);
		}else if(method.equals("doexcle")){
			doexcle(request,response);
		}else if(method.equals("checkscore")){
			checksocore(request,response);
		}
	}



	private void checksocore(HttpServletRequest request, HttpServletResponse response) {
		
		//从session中取出当前学生对象
		HttpSession session=request.getSession();
		Student st=(Student) session.getAttribute("stu");
		
		//创建数据层操作对象
		StugradeDao stu=new StugradeDaoImpl();
		String condition=" where sid='"+st.getSid()+"'";

		Stugrade stugrade=stu.findByCondition(condition);

		session.setAttribute("checkscore", stugrade);
		
		
	}

	private void doexcle(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		List<Topicbank> newlist=(List<Topicbank>)session.getAttribute("tpblist");
		//定义Gson对象
		Gson gson = new Gson();
		//通过Gson对象将Map集合转换成json数据格式
		String jsonData = gson.toJson(newlist);
		out.print(jsonData);
		
		out.close();
		
	}

	private void score(HttpServletRequest request, HttpServletResponse response) {
		String str=request.getParameter("str");

		if(str!=null||str!=""){
			//有成绩
			//定义Gson对象
			Gson gson=new Gson();
			Map map=gson.fromJson(str, HashMap.class);
			//定义成绩
			int score=0;
			//将map遍历
			Iterator entries=map.entrySet().iterator();
			while(entries.hasNext()){
				//创建题库数据层操作对象
				TopicbankDao tpb=new TopicbankDaoImpl();
				Map.Entry entry=(Map.Entry)entries.next();
				Integer key=Integer.parseInt((String)entry.getKey());
				
				String values="";
				if(entry.getValue() instanceof ArrayList){
				values=String.join("", (ArrayList<String>)entry.getValue());
				}else{
					values=(String)entry.getValue();
				}
				String value=values;
				
				
				//调用操作层对象的查单个方法判断答案是否正确
				
				if(value.equals(tpb.findById(key).getRightsult())){
					score+=2;
				}/*else{
					//创建数据层操作对象
					ConditionsDao conditionsdao=new ConditionsDaoImpl();
					Conditions conditions=  conditionsdao.findById(tpb.findById(key).getTestid());
					conditions.setFalsely(conditions.getFalsely());
					conditionsdao.update(conditions);
					
				}*/
			}

			//将成绩添加到成绩表中
			HttpSession session=request.getSession();
			//取得学生对象
			Student student= (Student)session.getAttribute("stu");
			
			
			//创建成绩表的操作对对象
			StugradeDao stugradedao=new StugradeDaoImpl();
			//通过学生班级和考试表获得试卷id
			ExamDao examdao=new ExamDaoImpl();
			String condition=" where sqid="+student.getSqid().getsqid();
			//将成绩封装成对象
			
			Stugrade stugrade=new Stugrade(student.getSid(), student.getSname(), score, student.getSqid().getsqid(), examdao.findbycondition(condition).getEid(), "");
			stugradedao.add(stugrade);
			
			
			
		}
		
		
	}

	private void gettime(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		int time=(int)session.getAttribute("time");
		out.print(time);
	}

	private void getexam(HttpServletRequest request, HttpServletResponse response) throws ParseException, IOException {
		//创建session对象
		HttpSession session=request.getSession();
		//取出当前学生对象
		Student stu=(Student)session.getAttribute("stu");
		//创建考试表的数据层操作对象
		ExamDao examdao=new ExamDaoImpl();
		//创建条件
		String condition=" where sqid="+stu.getSqid().getsqid()+" and againexam='待考' ";
		//判断当前学生班级是否有待考的考试
		Exam exam= examdao.findbycondition(condition);
		//创建输出流对象
		PrintWriter out=response.getWriter();
		if(exam!=null){
			//获取当前时间
			Date date=new Date();

			//取出数据库的考试开始时间和考试结束时间
			String start=exam.getExamtime();
			String finish=exam.getFinishtime();
			//将String转换为Date；
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date startdate=sdf.parse(start);
			Date finishdate=sdf.parse(finish);
			//将当前时间与数据库时间进行对比判断是否开始考试
			if(date.before(startdate)){
				out.print("tobefore");
			}else if(date.after(startdate)&&date.before(finishdate)){
				//得到考试状态表数据层操作对象
				StudtypeDao stypedao=new StudtypeDaoImpl();
				Studtype studtype2=stypedao.findById(stu.getSid());
				if(studtype2.getExamtype()==0){
					//创建学生状态表实体类对象
					Studtype studtype=new Studtype(stu.getSid(),1,stu.getSqid().getsqid());
					//考生开始考试修改考试状态表状态
					int row=stypedao.update(studtype);
					//取出试卷
					TestPaperTopicDao tptdao=new TestPaperTopicDaoImpl();
					//条件
					String ss=" where testpaperid="+exam.getCid();
					//调用数据层操作对象得到试卷
					List<TestPaperTopic> tptlist=tptdao.findall(ss);
					//创建一个题库数据层操作对象
					TopicbankDao tbdao=new TopicbankDaoImpl();
					//创建一个接收题目的数组
					List<Topicbank> tblist=new ArrayList<>();
					
					for(int i=0;i<tptlist.size();i++){
						//创建题库实体类对象
						Topicbank tb=tbdao.findById(tptlist.get(i).getTopicbankid());
						tblist.add(tb);
						
					}
					
					
					//打乱题目循序
					java.util.Collections.shuffle(tblist);

					//将试卷题目储存
					session.setAttribute("tblist", tblist);
					//转换时间
					long time=finishdate.getTime()-date.getTime();
					int seconds=(int)time/1000;
					//储存考试时间
					session.setAttribute("time", seconds);

					
					out.print("nice");
				}else{
					out.print("noangain");
				}
				
				
				
			}else if(date.after(finishdate)){
				out.print("toafter");
			}
		}else{
			out.print("notexam");
		}
		
		
		
	}

	private void getexcle(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String classname=request.getParameter("classname");
		//创建题库的数据层操作对象
		TopicbankDao tpbdao=new TopicbankDaoImpl();
		//设置查找条件
		String condition=" and cname='"+classname+"' ";
		//调用方法 查找 这个课程的所有试题
		List<Topicbank> tpblist=tpbdao.findall(condition);
		//得到session对象
		HttpSession session=request.getSession();
		//将题目储存到session 对象中
		session.setAttribute("tpblist", tpblist);

		//创建返回流
		PrintWriter out=response.getWriter();
		//返回一个成功信息
		out.print("success");
		
	}

	private void getcccc(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//创建考试表操作对象
		ExamDao examdao=new ExamDaoImpl();
		List<Exam> examlist=examdao.findAll();
		//定义Gson对象
		Gson gson = new Gson();
		//通过Gson对象将Map集合转换成json数据格式
		String jsonData = gson.toJson(examlist);
		//创建一个输出流
		PrintWriter out=response.getWriter();
		out.print(jsonData);

		out.close();
		
	}

	private void getheadline(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//创建试卷表数据层操作对象
		TestPaperDao testpaperdao=new TestPaperDaoImpl();
		List<TestPaper> testpaperlist=testpaperdao.findAll();
		//定义Gson对象
				Gson gson = new Gson();
				//通过Gson对象将Map集合转换成json数据格式
				String jsonData = gson.toJson(testpaperlist);
				//创建一个输出流
				PrintWriter out=response.getWriter();
				out.print(jsonData);

				out.close();
		
	}

	private void getteacher(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//创建课程表数据层对象
		TeacherDao teacherdao=new TeacherDaoImpl();
		List<Teacher> teacherlist=teacherdao.findAll();
		//定义Gson对象
		Gson gson = new Gson();
		//通过Gson对象将Map集合转换成json数据格式
		String jsonData = gson.toJson(teacherlist);
		//创建一个输出流
		PrintWriter out=response.getWriter();
		out.print(jsonData);

		out.close();
		
	}

	private void getclassname(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//创建课程表数据层对象
		SquadDao squaddao=new SquadDaoImpl();
		List<Squad> squadlist=squaddao.findAll();
		//定义Gson对象
		Gson gson = new Gson();
		//通过Gson对象将Map集合转换成json数据格式
		String jsonData = gson.toJson(squadlist);
		//创建一个输出流
		PrintWriter out=response.getWriter();
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
