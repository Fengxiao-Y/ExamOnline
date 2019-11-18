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
		//����������Ӧ���ַ�������
		request.setCharacterEncoding("utf-8");
		//��������������������
		response.setContentType("text/html");
		//�������������ַ�������
		response.setCharacterEncoding("utf-8");
		//��������
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
		
		//��session��ȡ����ǰѧ������
		HttpSession session=request.getSession();
		Student st=(Student) session.getAttribute("stu");
		
		//�������ݲ��������
		StugradeDao stu=new StugradeDaoImpl();
		String condition=" where sid='"+st.getSid()+"'";

		Stugrade stugrade=stu.findByCondition(condition);

		session.setAttribute("checkscore", stugrade);
		
		
	}

	private void doexcle(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		List<Topicbank> newlist=(List<Topicbank>)session.getAttribute("tpblist");
		//����Gson����
		Gson gson = new Gson();
		//ͨ��Gson����Map����ת����json���ݸ�ʽ
		String jsonData = gson.toJson(newlist);
		out.print(jsonData);
		
		out.close();
		
	}

	private void score(HttpServletRequest request, HttpServletResponse response) {
		String str=request.getParameter("str");

		if(str!=null||str!=""){
			//�гɼ�
			//����Gson����
			Gson gson=new Gson();
			Map map=gson.fromJson(str, HashMap.class);
			//����ɼ�
			int score=0;
			//��map����
			Iterator entries=map.entrySet().iterator();
			while(entries.hasNext()){
				//����������ݲ��������
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
				
				
				//���ò��������Ĳ鵥�������жϴ��Ƿ���ȷ
				
				if(value.equals(tpb.findById(key).getRightsult())){
					score+=2;
				}/*else{
					//�������ݲ��������
					ConditionsDao conditionsdao=new ConditionsDaoImpl();
					Conditions conditions=  conditionsdao.findById(tpb.findById(key).getTestid());
					conditions.setFalsely(conditions.getFalsely());
					conditionsdao.update(conditions);
					
				}*/
			}

			//���ɼ���ӵ��ɼ�����
			HttpSession session=request.getSession();
			//ȡ��ѧ������
			Student student= (Student)session.getAttribute("stu");
			
			
			//�����ɼ���Ĳ����Զ���
			StugradeDao stugradedao=new StugradeDaoImpl();
			//ͨ��ѧ���༶�Ϳ��Ա����Ծ�id
			ExamDao examdao=new ExamDaoImpl();
			String condition=" where sqid="+student.getSqid().getsqid();
			//���ɼ���װ�ɶ���
			
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
		//����session����
		HttpSession session=request.getSession();
		//ȡ����ǰѧ������
		Student stu=(Student)session.getAttribute("stu");
		//�������Ա�����ݲ��������
		ExamDao examdao=new ExamDaoImpl();
		//��������
		String condition=" where sqid="+stu.getSqid().getsqid()+" and againexam='����' ";
		//�жϵ�ǰѧ���༶�Ƿ��д����Ŀ���
		Exam exam= examdao.findbycondition(condition);
		//�������������
		PrintWriter out=response.getWriter();
		if(exam!=null){
			//��ȡ��ǰʱ��
			Date date=new Date();

			//ȡ�����ݿ�Ŀ��Կ�ʼʱ��Ϳ��Խ���ʱ��
			String start=exam.getExamtime();
			String finish=exam.getFinishtime();
			//��Stringת��ΪDate��
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date startdate=sdf.parse(start);
			Date finishdate=sdf.parse(finish);
			//����ǰʱ�������ݿ�ʱ����жԱ��ж��Ƿ�ʼ����
			if(date.before(startdate)){
				out.print("tobefore");
			}else if(date.after(startdate)&&date.before(finishdate)){
				//�õ�����״̬�����ݲ��������
				StudtypeDao stypedao=new StudtypeDaoImpl();
				Studtype studtype2=stypedao.findById(stu.getSid());
				if(studtype2.getExamtype()==0){
					//����ѧ��״̬��ʵ�������
					Studtype studtype=new Studtype(stu.getSid(),1,stu.getSqid().getsqid());
					//������ʼ�����޸Ŀ���״̬��״̬
					int row=stypedao.update(studtype);
					//ȡ���Ծ�
					TestPaperTopicDao tptdao=new TestPaperTopicDaoImpl();
					//����
					String ss=" where testpaperid="+exam.getCid();
					//�������ݲ��������õ��Ծ�
					List<TestPaperTopic> tptlist=tptdao.findall(ss);
					//����һ��������ݲ��������
					TopicbankDao tbdao=new TopicbankDaoImpl();
					//����һ��������Ŀ������
					List<Topicbank> tblist=new ArrayList<>();
					
					for(int i=0;i<tptlist.size();i++){
						//�������ʵ�������
						Topicbank tb=tbdao.findById(tptlist.get(i).getTopicbankid());
						tblist.add(tb);
						
					}
					
					
					//������Ŀѭ��
					java.util.Collections.shuffle(tblist);

					//���Ծ���Ŀ����
					session.setAttribute("tblist", tblist);
					//ת��ʱ��
					long time=finishdate.getTime()-date.getTime();
					int seconds=(int)time/1000;
					//���濼��ʱ��
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
		//�����������ݲ��������
		TopicbankDao tpbdao=new TopicbankDaoImpl();
		//���ò�������
		String condition=" and cname='"+classname+"' ";
		//���÷��� ���� ����γ̵���������
		List<Topicbank> tpblist=tpbdao.findall(condition);
		//�õ�session����
		HttpSession session=request.getSession();
		//����Ŀ���浽session ������
		session.setAttribute("tpblist", tpblist);

		//����������
		PrintWriter out=response.getWriter();
		//����һ���ɹ���Ϣ
		out.print("success");
		
	}

	private void getcccc(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//�������Ա��������
		ExamDao examdao=new ExamDaoImpl();
		List<Exam> examlist=examdao.findAll();
		//����Gson����
		Gson gson = new Gson();
		//ͨ��Gson����Map����ת����json���ݸ�ʽ
		String jsonData = gson.toJson(examlist);
		//����һ�������
		PrintWriter out=response.getWriter();
		out.print(jsonData);

		out.close();
		
	}

	private void getheadline(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//�����Ծ�����ݲ��������
		TestPaperDao testpaperdao=new TestPaperDaoImpl();
		List<TestPaper> testpaperlist=testpaperdao.findAll();
		//����Gson����
				Gson gson = new Gson();
				//ͨ��Gson����Map����ת����json���ݸ�ʽ
				String jsonData = gson.toJson(testpaperlist);
				//����һ�������
				PrintWriter out=response.getWriter();
				out.print(jsonData);

				out.close();
		
	}

	private void getteacher(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//�����γ̱����ݲ����
		TeacherDao teacherdao=new TeacherDaoImpl();
		List<Teacher> teacherlist=teacherdao.findAll();
		//����Gson����
		Gson gson = new Gson();
		//ͨ��Gson����Map����ת����json���ݸ�ʽ
		String jsonData = gson.toJson(teacherlist);
		//����һ�������
		PrintWriter out=response.getWriter();
		out.print(jsonData);

		out.close();
		
	}

	private void getclassname(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//�����γ̱����ݲ����
		SquadDao squaddao=new SquadDaoImpl();
		List<Squad> squadlist=squaddao.findAll();
		//����Gson����
		Gson gson = new Gson();
		//ͨ��Gson����Map����ת����json���ݸ�ʽ
		String jsonData = gson.toJson(squadlist);
		//����һ�������
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
