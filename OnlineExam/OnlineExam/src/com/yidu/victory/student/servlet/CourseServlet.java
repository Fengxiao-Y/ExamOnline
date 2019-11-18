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
import com.yidu.victory.student.dao.CourseDao;
import com.yidu.victory.student.dao.Impl.CourseDaoImpl;
import com.yidu.victory.student.domain.Course;




/**
 * Servlet implementation class CourseServlet
 */
@WebServlet("/CourseServlet")
public class CourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseServlet() {
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
		//��ȡ�������������ݹ�����Ա������ַ���
		String courseNoStr=request.getParameter("courseNoStr");
		//���ַ������а�","(����)�ָ�����ַ�������
		String[] courseNos=courseNoStr.split(",");
		
		//�������ݲ��������
		CourseDao courseDao=new CourseDaoImpl();
		
		//����������ɾ�����п���ʧ�ܣ��˴�ʹ���쳣������ʵ��
		try{
			//ʹ��ѭ����������ɾ��
			for(int i=0;i<courseNos.length;i++){
				//��ȡ��ǰ���ַ���
				String courseDaoNo=courseNos[i];
				//���ַ������ת��Ϊ���͵�Ա�����
				int cid=Integer.parseInt(courseDaoNo);
				//ִ��ɾ������
				courseDao.delete(cid);
			}
			out.print("success");
		}catch(Exception e){
			out.print("failure");
		}
		
		//�ر��������
		out.close();
	}

	/**
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out=response.getWriter();
		//�������Կͻ��˵�����
		int cid=Integer.parseInt(request.getParameter("cid"));
		String cname=request.getParameter("cname");
		String stagename=request.getParameter("stagename");
		
		//���ݷ�װ�ɶ���
		Course course=new Course(cid, cname, stagename);
		
		//�������ݲ����ִ����ӷ���
		CourseDao courseDao=new CourseDaoImpl();
		int rows=courseDao.update(course);
		//�ж�����Ƿ�ɹ�
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
		//�������Կͻ��˵�����
		
		String cname=request.getParameter("cname");
		String stagename=request.getParameter("stagename");
		
		
		//�����ݷ�װ�ɶ���
		 Course course=new Course(cname,stagename);
		  //�������ݲ����ִ����ӷ���
		 CourseDao courseDao=new CourseDaoImpl();
		  int rows=courseDao.add(course);
		  //�ж���ӷ����Ƿ�ɹ�
		  if(rows>0){
		   out.print("success");
		  }else{
		   out.print("failure");
		  }
		  //�ر��������
		  out.close();
	}

	/**
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//����һ�����������
		  PrintWriter out=response.getWriter();
		  //�õ����������е���������
		  String cname=request.getParameter("cname");
		  String stagename=request.getParameter("stagename");
		  String cid=request.getParameter("cid");

		  String condition=" where 1=1 ";
		  //���������ݽ����жϲ���ϳɲ�ѯ����
		  if(cname!=null && !cname.equals("")){
				condition=condition+" and cname like '%"+cname+"%' ";
		  }
			//���ݹ����ֶ�ֵ�����жϣ���������
		  if(stagename!=null && !stagename.equals("")){
				condition=condition+" and stagename like '%"+stagename+"%' ";
		  }
		  if(cid!=null && !cid.equals("")){
				condition=condition+" and cid like '%"+cid+"%' ";
		  }
			
		 
		  
		  
		  //�������Կͻ��˵�datagrid����Ĵ��ݹ�����page��rows����
		  int rows=Integer.parseInt(request.getParameter("rows"));
		  int page=Integer.parseInt(request.getParameter("page"));
		  
		  //�������ݲ�ִ�з�ҳ��ѯ
		  CourseDao courseDao=new CourseDaoImpl();
		  //��õ�ǰҳ�����ݼ���
		  List<Course> courseList=courseDao.findAll(rows, page, condition);
		  //��ѯ��student����ܼ�¼��
		  int totalRows=courseDao.count(condition);
		  
		  //����ӳ�伯�϶���
		  Map<String, Object> mapData = new HashMap<String, Object>();
		  mapData.put("total", totalRows);
		  mapData.put("rows", courseList);
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
