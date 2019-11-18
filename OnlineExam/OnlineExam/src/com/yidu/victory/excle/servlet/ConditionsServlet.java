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
import com.yidu.victory.excle.dao.ConditionsDao;
import com.yidu.victory.excle.dao.Impl.ConditionsDaoImpl;
import com.yidu.victory.excle.domain.Conditions;


/**
 * Servlet implementation class ConditionsServlet
 */
@WebServlet("/ConditionsServlet")
public class ConditionsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConditionsServlet() {
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
		String conditionsNoStr=request.getParameter("conditionsNoStr");
		//���ַ������а�","(����)�ָ�����ַ�������
		String[] conditionsNos=conditionsNoStr.split(",");
		
		//�������ݲ��������
		ConditionsDao conditionsDao=new ConditionsDaoImpl();
		
		//����������ɾ�����п���ʧ�ܣ��˴�ʹ���쳣������ʵ��
		try{
			//ʹ��ѭ����������ɾ��
			for(int i=0;i<conditionsNos.length;i++){
				//��ȡ��ǰ���ַ���
				String conditionsDaoNo=conditionsNos[i];
				//���ַ������ת��Ϊ���͵�Ա�����
				int tid=Integer.parseInt(conditionsDaoNo);
				//ִ��ɾ������
				conditionsDao.delete(tid);
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
				int tid=Integer.parseInt(request.getParameter("tid"));
				double falsely=Double.parseDouble(request.getParameter("falsely"));
				
				//���ݷ�װ�ɶ���
				Conditions conditions=new Conditions(tid, falsely);
				
				//�������ݲ����ִ����ӷ���
				ConditionsDao makeuptableDao=new ConditionsDaoImpl();
				int rows=makeuptableDao.update(conditions);
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
		int tid=Integer.parseInt(request.getParameter("tid"));
		double falsely=Double.parseDouble(request.getParameter("falsely"));
		
		
		//�����ݷ�װ�ɶ���
		  Conditions conditions=new Conditions(tid,falsely);
		  //�������ݲ����ִ����ӷ���
		  ConditionsDao conditionsDao=new ConditionsDaoImpl();
		  int rows=conditionsDao.add(conditions);
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
		  String falsely=request.getParameter("falsely");
		  String tid=request.getParameter("tid");

		  String condition=" where 1=1 ";
		  //���������ݽ����жϲ���ϳɲ�ѯ����
		  if(falsely!=null && !falsely.equals("")){
				condition=condition+" and falsely like '%"+falsely+"%' ";
		  }
			//���ݹ����ֶ�ֵ�����жϣ���������
		  if(tid!=null && !tid.equals("")){
				condition=condition+" and tid like '%"+tid+"%' ";
		  }
			
		 
		  
		  
		  //�������Կͻ��˵�datagrid����Ĵ��ݹ�����page��rows����
		  int rows=Integer.parseInt(request.getParameter("rows"));
		  int page=Integer.parseInt(request.getParameter("page"));
		  
		  //�������ݲ�ִ�з�ҳ��ѯ
		  ConditionsDao conditionsDao=new ConditionsDaoImpl();
		  //��õ�ǰҳ�����ݼ���
		  List<Conditions> conditionsList=conditionsDao.findAll(rows, page, condition);
		  //��ѯ��student����ܼ�¼��
		  int totalRows=conditionsDao.count(condition);
		  
		  //����ӳ�伯�϶���
		  Map<String, Object> mapData = new HashMap<String, Object>();
		  mapData.put("total", totalRows);
		  mapData.put("rows", conditionsList);
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
