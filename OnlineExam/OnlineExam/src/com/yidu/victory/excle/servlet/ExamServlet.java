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
		String eidStr=request.getParameter("eidStr");
		//���ַ������а�","(����)�ָ�����ַ�������
		String[] eids=eidStr.split(",");
		//�������ݲ��������
		ExamDao examDao=new ExamDaoImpl();
		//����������ɾ�����п���ʧ�ܣ��˴�ʹ���쳣������ʵ��
		try{
				//ʹ��ѭ����������ɾ��
				for(int i=0;i<eids.length;i++){
					//��ȡ��ǰ���ַ���
					String teid=eids[i];
					//���ַ������ת��Ϊ���͵Ŀ��Ա��
					int eid=Integer.parseInt(teid);
					//����eid��ÿ��Եİ༶
					Exam exam=examDao.findById(eid);
					//���ݰ༶IDɾ��ѧ��״̬�������иð༶ѧ��
					//����ѧ��״̬�����ݲ��������
					StudtypeDao stdtypedao=new StudtypeDaoImpl();
					String condition=" where squadid="+exam.getSqid();
					stdtypedao.deleteBycondition(condition);				
					//ִ��ɾ������
					examDao.delete(eid);
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
		int eid=Integer.parseInt(request.getParameter("eid"));
		int cid=Integer.parseInt(request.getParameter("cid"));
		String headline=request.getParameter("headline");
		String cname=request.getParameter("cname");

		int sqid=Integer.parseInt(request.getParameter("sqid"));
		String examtime=request.getParameter("examtime");
		String finishtime=request.getParameter("finishtime");
		String againexam=request.getParameter("againexam");
		
		//�����ݷ�װ�ɶ���
		Exam exam=new Exam(eid, cid, headline, cname, sqid, examtime, finishtime, againexam);
		
		//�������ݲ����ִ���޸ķ���
		ExamDao examDao=new ExamDaoImpl();
		int rows=examDao.update(exam);
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
		String headline=request.getParameter("headline");
		
		int sqid=Integer.parseInt(request.getParameter("sqid"));
		String examtime=request.getParameter("examtime");
		String finishtime=request.getParameter("finishtime");
		String againexam=request.getParameter("againexam");
		//�������ݲ��������
		TestPaperDao testpaperdao=new TestPaperDaoImpl();
		String condition=" where headline='"+headline+"' ";
		TestPaper testpaper=testpaperdao.findAll(condition);
		String cname=testpaper.getCourseid();
		int cid=testpaper.getCid();	
		
		//�����ݷ�װ�ɶ���
		Exam exam=new Exam(cid, headline, cname, sqid, examtime, finishtime, againexam);
		//�������ݲ����ִ����ӷ���
		ExamDao examDao=new ExamDaoImpl();
		int rows=examDao.add(exam);
		//�ж��Ƿ���ӳɹ�
		if(rows>0){
			//�޸�ѧ������״̬
			//����ѧ��״̬�����ݲ��������
			StudtypeDao stdtypedao=new StudtypeDaoImpl();
			//����ѧ��������ݲ��������
			StudentDao studentdao=new StudentDaoImpl();
			//ͨ��ѧ�����ѯ�����԰༶������ѧ��
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
		//�ر��������
		out.close();
		
	}

	private void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//����һ�����������
		PrintWriter out=response.getWriter();
		//�õ����������е���������
		String cid=request.getParameter("cid");
		String sqid=request.getParameter("sqid");
		String cname=request.getParameter("cname");
		

		String condition=" where 1=1 ";
		//���������ݽ����жϲ���ϳɲ�ѯ����
		if(cname!=null && !cname.equals("")){
			condition=condition+" and cname like '%"+cname+"%' ";
		}
		if(cid!=null && !cid.equals("")){
			//����cid��int���ͣ�����ת������
			int cid1=Integer.parseInt(cid);
			//��ӵ�������
			condition=condition+" and cid="+cid1;
		}
		if(sqid!=null && !sqid.equals("")){
			//����sid��int���ͣ�����ת������
			int sqid1=Integer.parseInt(sqid);
			condition=condition+"  and sqid="+sqid1+" ";
		}
		
		//�������Կͻ��˵�datagrid����Ĵ��ݹ�����page��rows����
		int rows=Integer.parseInt(request.getParameter("rows"));
		int page=Integer.parseInt(request.getParameter("page"));
		
		//�������ݲ�ִ�з�ҳ��ѯ
		ExamDao examDao=new ExamDaoImpl();
		//��õ�ǰҳ�����ݼ���
		List<Exam> examList=examDao.findAll(rows, page, condition);
		//��ѯ��student����ܼ�¼��
		int totalRows=examDao.count(condition);
		
		//����ӳ�伯�϶���
		Map<String, Object> mapData = new HashMap<String, Object>();
		mapData.put("total", totalRows);
		mapData.put("rows", examList);
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
