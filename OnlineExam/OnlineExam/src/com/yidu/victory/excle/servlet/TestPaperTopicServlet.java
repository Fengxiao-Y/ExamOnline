package com.yidu.victory.excle.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yidu.victory.excle.dao.TestPaperDao;
import com.yidu.victory.excle.dao.TestPaperTopicDao;
import com.yidu.victory.excle.dao.Impl.TestPaperDaoImpl;
import com.yidu.victory.excle.dao.Impl.TestPaperTopicDaoImpl;
import com.yidu.victory.excle.domain.TestPaper;
import com.yidu.victory.excle.domain.TestPaperTopic;

/**
 * Servlet implementation class TestPaperTopicServlet
 */
@WebServlet("/TestPaperTopicServlet")
public class TestPaperTopicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestPaperTopicServlet() {
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
		//�������������
		PrintWriter out=response.getWriter();
		//��ȡ�������������ݹ�����Ա������ַ���
		String tidStr=request.getParameter("tidStr");
		//���ַ������а�","(����)�ָ�����ַ�������
		String[] tids=tidStr.split(",");
		
		//�������ݲ��������
		TestPaperTopicDao testPaperTopicDao=new TestPaperTopicDaoImpl();
		
		//����������ɾ�����п���ʧ�ܣ��˴�ʹ���쳣������ʵ��
		try{
			//ʹ��ѭ����������ɾ��
			for(int i=0;i<tids.length;i++){
				//��ȡ��ǰ���ַ���
				String ttid=tids[i];
				//���ַ������ת��Ϊ���͵�Ա�����
				int tid=Integer.parseInt(ttid);
				//ִ��ɾ������
				testPaperTopicDao.delete(tid);
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
		int tid=Integer.parseInt(request.getParameter("tid"));
		int testpaperid=Integer.parseInt(request.getParameter("testpaperid"));
		int topicbankid=Integer.parseInt(request.getParameter("topicbankid"));
		
		//�����ݷ�װ�ɶ���
		TestPaperTopic testPaperTopic=new TestPaperTopic(tid, testpaperid, topicbankid);
		
		//�������ݲ���޸ķ���
		TestPaperTopicDao testPaperTopicDao=new TestPaperTopicDaoImpl();
		int rows=testPaperTopicDao.update(testPaperTopic);
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
		int tid=Integer.parseInt(request.getParameter("tid"));
		int testpaperid=Integer.parseInt(request.getParameter("testpaperid"));
		int topicbankid=Integer.parseInt(request.getParameter("topicbankid"));
		
		//�����ݷ�װ�ɶ���
		TestPaperTopic testPaperTopic=new TestPaperTopic(tid, testpaperid, topicbankid);
		
		//�������ݲ����ӷ���
		TestPaperTopicDao testPaperTopicDao=new TestPaperTopicDaoImpl();
		int rows=testPaperTopicDao.add(testPaperTopic);
		//�ж�����Ƿ�ɹ�
		if(rows>0){
			out.print("success");
		}else{
			out.print("failure");
		}
		//�ر��������
		out.close();
		
	}

	private void findAll(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
