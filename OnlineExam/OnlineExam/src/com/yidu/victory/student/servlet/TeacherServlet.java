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
import com.yidu.victory.student.dao.StudentDao;
import com.yidu.victory.student.dao.TeacherDao;
import com.yidu.victory.student.dao.Impl.StudentDaoImpl;
import com.yidu.victory.student.dao.Impl.TeacherDaoImpl;
import com.yidu.victory.student.domain.Student;
import com.yidu.victory.student.domain.Teacher;

/**
 * Servlet implementation class TeacherServlet
 */
@WebServlet("/TeacherServlet")
public class TeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherServlet() {
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
				}
			}
	


	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//����һ�����������
		PrintWriter out=response.getWriter();
		//��ȡ���������������ݹ����Ŀ��Ա���ַ���
		String tidStr=request.getParameter("tidStr");

		//���ַ������а�","(����)�ָ�����ַ�������
		String[] tids=tidStr.split(",");
		//�������ݲ��������
		TeacherDao teacherDao=new TeacherDaoImpl();
		//����������ɾ�����п���ʧ�ܣ��˴�ʹ���쳣������ʵ��
		try{
				//ʹ��ѭ����������ɾ��
				for(int i=0;i<tids.length;i++){
					//��ȡ��ǰ���ַ���
					String ttid=tids[i];

					//ִ��ɾ������
					teacherDao.delete(ttid);
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
				String tid=request.getParameter("tid");
				String tname=request.getParameter("tname");
				String sex=request.getParameter("sex");
				int age=Integer.parseInt(request.getParameter("age"));
				String phone=request.getParameter("phone");
				int penguin=Integer.parseInt(request.getParameter("penguin"));
				String address=request.getParameter("address");
				String situation=request.getParameter("situation");
				//�����ݷ�װ�ɶ���
				Teacher teacher=new Teacher(tid, tname, sex, age, phone, penguin,
						address, situation );
						
				
				//�������ݲ����ִ���޸ķ���
				TeacherDao teacherDao=new TeacherDaoImpl();
				int rows=teacherDao.update(teacher);
				//�ж��Ƿ��޸ĳɹ�
				if(rows>0){
					out.print("success");
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
		String tid=request.getParameter("tid");
		String tname=request.getParameter("tname");
		String sex=request.getParameter("sex");
		int age=Integer.parseInt(request.getParameter("age"));
		String phone=request.getParameter("phone");
		int penguin=Integer.parseInt(request.getParameter("penguin"));
		String address=request.getParameter("address");
		String situation=request.getParameter("situation");
		//�����ݷ�װ�ɶ���
		Teacher teacher=new Teacher(tid, tname, sex, age, phone, penguin,
				address, situation );
				
		//�������ݲ����ִ����ӷ���
		TeacherDao teacherDao=new TeacherDaoImpl();
		int rows=teacherDao.add(teacher);
		//�ж��Ƿ���ӳɹ�
		if(rows>0){
			out.print("success");
		}else{
			out.print("failure");
		}
		//�ر��������
		out.close();
		
	}


	private void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//����һ�����������
		PrintWriter out=response.getWriter();
		//�õ����������е���������
		String tid=request.getParameter("tid");
		String tname=request.getParameter("tname");
		String phone=request.getParameter("phone");
		String condition=" where 1=1 ";
		//���������ݽ����жϲ���ϳɲ�ѯ����
		if(tid!=null && !tid.equals("")){
			condition=condition+"and tid like '%"+tid+"%' ";
		}
		if(tname!=null && !tname.equals("")){
			condition=condition+"and tname like '%"+tname+"%' ";
		}
		if(phone!=null && !phone.equals("")){
			condition=condition+"and phone like '%"+phone+"%' ";
		}	

		//�������Կͻ��˵�datagrid����Ĵ��ݹ�����page��rows����
		int rows=Integer.parseInt(request.getParameter("rows"));
		int page=Integer.parseInt(request.getParameter("page"));
		//�������ݲ�ִ�з�ҳ��ѯ
		TeacherDao teacherDao=new TeacherDaoImpl();
		//��õ�ǰҳ�����ݼ���
		List<Teacher> teacherList=teacherDao.findAll(rows, page, condition);
		//��ѯ��student����ܼ�¼��
		int totalRows=teacherDao.count(condition);
		
		//����ӳ�伯�϶���
		Map<String, Object> mapData = new HashMap<String, Object>();
		mapData.put("total", totalRows);
		mapData.put("rows", teacherList);
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
