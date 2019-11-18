package com.yidu.victory.student.servlet;

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
import com.yidu.victory.student.dao.DifficultyDao;
import com.yidu.victory.student.dao.Impl.DifficultyDaoImpl;
import com.yidu.victory.student.domain.Difficulty;

/**
 * Servlet implementation class DifficultyServlet
 */
@WebServlet("/DifficultyServlet")
public class DifficultyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DifficultyServlet() {
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
		//��ȡ���������������ݹ������������ַ���
		String difficultyNoStr=request.getParameter("difficultyNoStr");
		//���ַ������а�","(����)�ָ���ַ�������
		String[] difficultyNos=difficultyNoStr.split(",");
		
		//�������ݲ��������
		DifficultyDao difficultyDao=new DifficultyDaoImpl();
		//��������ɾ������ʧ�ܣ��˴�ʹ���쳣������ʵ��
		try{
			//ʹ��ѭ������������ɾ��
			for(int i=0;i<difficultyNos.length;i++){
				//��ȡ��ǰ�ַ���
				String difficultyDaoNo=difficultyNos[i];
				//���ַ������ת��Ϊ���ε�Ա�����
				int tid=Integer.parseInt(difficultyDaoNo);
				
				//ִ��ɾ������
				difficultyDao.delete(tid);
				out.print("success");
			}
		}catch(Exception e){
			out.print("failure");
		}
		//�ر��������
		out.close();
	}

	/**
	 * ����
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out=response.getWriter();
		//�������Կͻ��˵�����
		int tid=Integer.parseInt(request.getParameter("tid"));
		String grade=request.getParameter("grade");
		//���ݷ�װ�ɶ���
		Difficulty difficulty=new Difficulty(tid, grade);
		//�������ݲ����ִ����ӷ���
		DifficultyDao difficultyDao=new DifficultyDaoImpl();
		int rows=difficultyDao.update(difficulty);
		//�ж�����Ƿ�ɹ�
		if(rows>0){
			out.print("success");
		}else{
			out.print("failure");
		}
		
		out.close();
	}

	/**
	 * ����
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out=response.getWriter();
		//�������Կͻ��˵�����
		int tid=Integer.parseInt(request.getParameter("tid"));
		String grade=request.getParameter("grade");
		//���ݷ�װ�ɶ���
		Difficulty difficulty=new Difficulty(tid, grade);
		//�������ݲ����ִ����ӷ���
		DifficultyDao difficultyDao=new DifficultyDaoImpl();
		int rows=difficultyDao.add(difficulty);
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
	private void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//����һ�������
		PrintWriter out=response.getWriter();
		//�õ����������е���������
		String tid=request.getParameter("tid");
		String grade=request.getParameter("grade");
		
		//���ɲ�ѯ����
		//select * from ���� where ���� limit n1,n2
		//where �ֶ���=? and �ֶ���=? and �ֶ���=?
		String condition=" where 1=1 ";
		
		//���������ݽ����жϲ���ϳɲ�ѯ����
		if(grade!=null && !grade.equals("")){
			condition=condition+" and grade like '%"+grade+"%' ";
		}
		//���ݹ����ֶ�ֵ�����жϣ���������
		if(tid!=null && !tid.equals("")){
			condition=condition+" and tid like '%"+tid+"%' ";
		}
		
		//�������Կͻ��˵�datagrid����Ĵ��ݹ�����page��rows����
		int rows=Integer.parseInt(request.getParameter("rows"));
		int page=Integer.parseInt(request.getParameter("page"));
		
		//�������ݲ�ִ�з�ҳ��ѯ
		DifficultyDao difficultydao=new DifficultyDaoImpl();
		//��õ�ǰҳ�����ݼ���
		List<Difficulty> difficultyList=difficultydao.findAll(rows, page, condition);
		
		// ��condition�ĸ�ʽת����int
		//int cond=Integer.parseInt(condition);
		//��ѯ��Makeuptable����ܼ�¼��
		int totalRows=difficultydao.count(condition);
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
		mapData.put("rows", difficultyList);
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
