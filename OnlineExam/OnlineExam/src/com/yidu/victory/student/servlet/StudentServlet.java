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
		//����������Ӧ���ַ�������
		request.setCharacterEncoding("utf-8");
		//��������������������
		response.setContentType("text/html");
		//�������������ַ�������
		response.setCharacterEncoding("utf-8");
		
		String method=request.getParameter("method");

		if("findAll".equals(method)){
			//�鿴��ķ���
			this.findAll(request,response);

		}else if("add".equals(method)){
			//��ӷ���
			this.add(request,response);
		}else if("update".equals(method)){
			//�޸ķ���
			this.update(request,response);
		}else if("delete".equals(method)){
			//ɾ������
			this.delete(request,response);
		}else if("login".equals(method)){
			this.login(request,response);
		}else if("updatepassword".equals(method)){
			this.updatepassword(request,response);
		}
	}

	private void updatepassword(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//����һ�����������
				PrintWriter out=response.getWriter();
				//��ȡ������ҳ������
				String unumber=request.getParameter("unumber");
				String password=request.getParameter("passwords1");
				
				//��session��ȡ����ǰѧ������
				HttpSession session=request.getSession();
				Student st=(Student) session.getAttribute("stu");
				
				//�������ݲ��������
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
		//������ҳ�������û��˺�,����
		String unumber=request.getParameter("unumber");
		String passwords=request.getParameter("passwords");

		//ͨ���û����ʵ�ֲ�Ĳ鵥������ ���ҵ��˺ŵ����� ���к˶�ʵ�ֵ�¼
			//�������ݲ��������
			StudentDao studentdao=new StudentDaoImpl();
			//ͨ�����ҵ������� �õ�ѧ������
			Student st=studentdao.findById(unumber);
			if(st!=null){
				

				if(passwords.equals(st.getPasswords())){
					HttpSession session=request.getSession();
					session.setAttribute("stu", st);
					out.print("success");
					
				}else{
					//�������
					out.print("error");
				}
			}else{
				//û�ҵ��û�
				out.print("notfund");
			}
		
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//����һ�����������
		PrintWriter out=response.getWriter();
		//��ȡ���������������ݹ����Ŀ��Ա���ַ���
		String sidStr=request.getParameter("sidStr");
		//���ַ������а�","(����)�ָ�����ַ�������
		String[] sids=sidStr.split(",");
		//�������ݲ��������
		StudentDao studentDao=new StudentDaoImpl();
		SquadDao squaddao=new SquadDaoImpl();
		//����������ɾ�����п���ʧ�ܣ��˴�ʹ���쳣������ʵ��
		try{
				//ʹ��ѭ����������ɾ��
				for(int i=0;i<sids.length;i++){
					//��ȡ��ǰ���ַ���
					
					String tsid=sids[i];

					//�����༶�����ݲ��������
					Student student=studentDao.findById(sids[i]);

					Squad squad=squaddao.findById(student.getSqid().getsqid());
					Squad squad2=new Squad(squad.getsqid(),squad.getSnumber(),squad.getSpeople()-1,squad.getSquadtime(),squad.getTeacher(),squad.getSadministration(),squad.getState(),squad.getClassify());
					squaddao.update(squad2);
					
					//ִ��ɾ������
					studentDao.delete(tsid);
					
					
				}
				out.print("success");
				
				
		}catch(Exception e){
				out.print("failure");
		}
		//�ر��������
		out.close();
		
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//�������������
		PrintWriter out=response.getWriter();
		//�������Կͻ��˵�����
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
		
		//�����༶�����ݲ��������
		StudentDao studentDao=new StudentDaoImpl();
		Student student2=studentDao.findById(sid);
		SquadDao squaddao=new SquadDaoImpl();
		Squad squad=squaddao.findById(student2.getSqid().getsqid());
		Squad squad2=new Squad(squad.getsqid(),squad.getSnumber(),squad.getSpeople()-1,squad.getSquadtime(),squad.getTeacher(),squad.getSadministration(),squad.getState(),squad.getClassify());
		squaddao.update(squad2);
		
		//�����ݷ�װ�ɶ���
		Student student=new Student(sid, sname, sex, age, sqid, passwords,
				register, identitycard, phone, guardian, guardianwith, 
				guardianphone, address, situation);
		
		//�������ݲ����ִ���޸ķ���
		
		int rows=studentDao.update(student);
		//�ж��Ƿ��޸ĳɹ�
		if(rows>0){
			out.print("success");
			//�����༶�����ݲ��������
			Squad squad3=squaddao.findById(sqid);
			Squad squad4=new Squad(squad3.getsqid(),squad3.getSnumber(),squad3.getSpeople()+1,squad3.getSquadtime(),squad3.getTeacher(),squad3.getSadministration(),squad3.getState(),squad3.getClassify());
			squaddao.update(squad4);
		}else{
			out.print("failure");
		}
		//�ر��������
		out.close();
		
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//�������������
		PrintWriter out=response.getWriter();
		//�������Կͻ��˵�����
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
		
		
		//�����ݷ�װ�ɶ���
		Student student=new Student(sid, sname, sex, age, sqid,passwords,
				register, identitycard, phone, guardian, guardianwith, 
				guardianphone, address, situation);
		
		//�������ݲ����ִ����ӷ���
		StudentDao studentDao=new StudentDaoImpl();
		int rows=studentDao.add(student);
		//�ж��Ƿ���ӳɹ�
		if(rows>0){
			out.print("success");
		}else{
			out.print("failure");
		}
		//�����༶�����ݲ��������
			SquadDao squaddao=new SquadDaoImpl();
			Squad squad=squaddao.findById(sqid);
			Squad squad2=new Squad(squad.getsqid(),squad.getSnumber(),squad.getSpeople()+1,squad.getSquadtime(),squad.getTeacher(),squad.getSadministration(),squad.getState(),squad.getClassify());
			squaddao.update(squad2);
		//�ر��������
		out.close();
		
	}

	private void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//����һ�����������
		PrintWriter out=response.getWriter();
		//�õ����������е���������
		String sname=request.getParameter("sname");
		String sqid=request.getParameter("sqid");
		String identitycard=request.getParameter("identitycard");
		

		String condition=" where 1=1 ";
		//���������ݽ����жϲ���ϳɲ�ѯ����
		if(sname!=null && !sname.equals("")){
			condition=condition+"and sname like '%"+sname+"%' ";
		}
		if(identitycard!=null && !identitycard.equals("")){
			condition=condition+"and identitycard like '%"+identitycard+"%' ";
		}
		if(sqid!=null && !sqid.equals("")){
			condition=condition+"and sqid="+sqid+" ";
		}

		//�������Կͻ��˵�datagrid����Ĵ��ݹ�����page��rows����
		int rows=Integer.parseInt(request.getParameter("rows"));
		int page=Integer.parseInt(request.getParameter("page"));
		//�������ݲ�ִ�з�ҳ��ѯ
		StudentDao studentDao=new StudentDaoImpl();
		//��õ�ǰҳ�����ݼ���
		List<Student> studentList=studentDao.findAll(rows, page, condition);
		//��ѯ��student����ܼ�¼��
		int totalRows=studentDao.count(condition);
		
		//����ӳ�伯�϶���
		Map<String, Object> mapData = new HashMap<String, Object>();
		mapData.put("total", totalRows);
		mapData.put("rows", studentList);
		//����Gson����
		Gson gson = new Gson();
		//ͨ��Gson����Map����ת����json���ݸ�ʽ
		String jsonData = gson.toJson(mapData);
		//��json����������ͻ���
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
