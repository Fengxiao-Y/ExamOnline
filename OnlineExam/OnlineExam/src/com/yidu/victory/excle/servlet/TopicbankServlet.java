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
		//�������������
		PrintWriter out=response.getWriter();
		//��ȡ�������������ݹ�����Ա������ַ���
		String testidStr=request.getParameter("testidNoStr");
		//���ַ������а�","(����)�ָ�����ַ�������
		String[] testids=testidStr.split(",");
		
		//�������ݲ��������
		TopicbankDao TopicbankDao=new TopicbankDaoImpl();
		
		//����������ɾ�����п���ʧ�ܣ��˴�ʹ���쳣������ʵ��
		try{
			//ʹ��ѭ����������ɾ��
			for(int i=0;i<testids.length;i++){
				//��ȡ��ǰ���ַ���
				String ttestid=testids[i];
				//���ַ������ת��Ϊ���͵�Ա�����
				int testid=Integer.parseInt(ttestid);
				//ִ��ɾ������
				TopicbankDao.delete(testid);
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
		
		//��ȡ�γ̽׶Σ��õ�course���ݲ��������
		CourseDao coursedao=new CourseDaoImpl();
		String condition22=" where cname='"+cname+"' ";
 		Course course =coursedao.findAll(condition22);
 		String stagename=course.getStagename();
 		
 		//�Ѷȵȼ�����
 				DifficultyDao diffcultydao=new DifficultyDaoImpl();
 				Difficulty diffculty=new Difficulty(testid,grade);
 				diffcultydao.update(diffculty);
 				//��Ŀ�����ʶ���
 				ConditionsDao conditiondao=new ConditionsDaoImpl();
 				Conditions conditions=new Conditions(testid,falsely);
 				conditiondao.update(conditions);
 		
		//�����ݷ�װ�ɶ���
		Topicbank topicbank=new Topicbank(testid, testtype, aresult, bresult, cresult, dresult, eresult, fresult, rightsult, content, grade, falsely, cname, stagename);
				
		
		//�������ݲ���޸ķ���
		TopicbankDao topicbankDao = new TopicbankDaoImpl(); 
		int rows=topicbankDao.update(topicbank);
		//�ж��޸��Ƿ�ɹ�
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
		//�������ݲ��������
		CourseDao coursedao=new CourseDaoImpl();
		String ss=" where 1=1 and cname='"+cname+"' ";
		String stagename=coursedao.findAll(ss).getStagename();
		//�����ݷ�װ�ɶ���
		//������
		Topicbank topicbank=new Topicbank(testtype, aresult, bresult, cresult, dresult, eresult, fresult, rightsult, content, grade, cname, stagename);
		
		//�������ݲ����ӷ���
		TopicbankDao topicbankDao = new TopicbankDaoImpl(); 
		int rows=topicbankDao.add(topicbank);
		//��ȡ��ǰ��ӵ���Ŀ��ID
		int rrrr=topicbankDao.findlast();
		
		//�Ѷȵȼ�����
		DifficultyDao diffcultydao=new DifficultyDaoImpl();
		Difficulty diffculty=new Difficulty(rrrr,grade);
		diffcultydao.add(diffculty);
		//��Ŀ�����ʶ���
		ConditionsDao conditiondao=new ConditionsDaoImpl();
		Conditions conditions=new Conditions(rrrr,0);
		conditiondao.add(conditions);
		//�ж�����Ƿ�ɹ�
		if(rows>0){
			out.print("success");
		}else{
			out.print("failure");
		}
		//�ر��������
		out.close();
		
	}

	private void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//����һ�������
		PrintWriter out=response.getWriter();
		//�õ����������е���������
		String testtype=request.getParameter("testtype");
		String content=request.getParameter("content");
		String cname=request.getParameter("cname");
		String stagename=request.getParameter("stagename");
		
		
		//���ɲ�ѯ����
		//select * from ���� where ���� limit n1,n2
		//where �ֶ���=? and �ֶ���=? and �ֶ���=?
		String condition=" ";
		
		//���������ݽ����жϲ���ϳɲ�ѯ����
		if(testtype!=null && !testtype.equals("")){
			condition=condition+" and testtype like '%"+testtype+"%' ";
		}
		//���ݹ����ֶ�ֵ�����жϣ���������
		if(content!=null && !content.equals("")){
			condition=condition+" and content like '%"+content+"%' ";
		}
		if(cname!=null && !cname.equals("")){
			condition=condition+" and cname like '%"+cname+"%' ";
		}
		if(stagename!=null && !stagename.equals("")){
			condition=condition+" and stagename like '%"+stagename+"%' ";
		}
		
		//�������Կͻ��˵�datagrid����Ĵ��ݹ�����page��rows����
		int rows=Integer.parseInt(request.getParameter("rows"));
		int page=Integer.parseInt(request.getParameter("page"));
		
		//�������ݲ�ִ�з�ҳ��ѯ
		TopicbankDao topicbankdao=new TopicbankDaoImpl();
		//��õ�ǰҳ�����ݼ���
		List<Topicbank> topicbankList=topicbankdao.findAll(rows, page, condition);
		
		// ��condition�ĸ�ʽת����int
		//int cond=Integer.parseInt(condition);
		//��ѯ��Makeuptable����ܼ�¼��
		int totalRows=topicbankdao.count(condition);
		//A��ʽ��
		/*
		//�����ݼ���ת����JSON���ݸ�ʽ
		String jsonStr=JSONArray.fromObject(conditionsList).toString();
		//���ɸ�ʽ������
		String json="{\"total\":"+totalRows+",\"rows\":"+jsonStr+"}";
		*/
		
		//B:��ʽ
		//����ӳ�伯�϶���
		HashMap<String, Object> mapData = new HashMap<String, Object>();
		mapData.put("total", totalRows);
		mapData.put("rows", topicbankList);
		//����Gson����
		Gson gson = new Gson();
		//ͨ��Gson����Map����ת����json���ݸ�ʽ
		String jsonData = gson.toJson(mapData);
		//��json����������ͻ���
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
