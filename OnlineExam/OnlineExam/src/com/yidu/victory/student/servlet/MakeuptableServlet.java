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
import com.yidu.victory.student.dao.MakeuptableDao;
import com.yidu.victory.student.dao.Impl.MakeuptableDaoImpl;
import com.yidu.victory.student.domain.Makeuptable;




/**
 * Servlet implementation class MakeuptableServlet
 */
@WebServlet("/MakeuptableServlet")
public class MakeuptableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MakeuptableServlet() {
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
	 * @throws IOException �׳��쳣
	 */
	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out=response.getWriter();
		//��ȡ�������������ݹ�����Ա������ַ���
		String makeuptableNoStr=request.getParameter("makeuptableNoStr");
		//���ַ������а�","(����)�ָ�����ַ�������
		String[] makeuptableNos=makeuptableNoStr.split(",");
		
		
		
		//�������ݲ��������
		MakeuptableDao makeuptableDao=new MakeuptableDaoImpl();
		
		//����������ɾ�����п���ʧ�ܣ��˴�ʹ���쳣������ʵ��
		try{
			//ʹ��ѭ����������ɾ��
			for(int i=0;i<makeuptableNos.length;i++){
				//��ȡ��ǰ���ַ���
				String makeuptableDaoNo=makeuptableNos[i];

				//���ַ������ת��Ϊ���͵�Ա�����
				int tid=Integer.parseInt(makeuptableDaoNo);
				
				//ִ��ɾ������
				makeuptableDao.delete(tid);
				out.print("success");
			}
			
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
		int sid=Integer.parseInt(request.getParameter("sid"));
		String sname=request.getParameter("sname");
		int grade=Integer.parseInt(request.getParameter("grade"));
		int squadid=Integer.parseInt(request.getParameter("squadid"));
		int eid=Integer.parseInt(request.getParameter("eid"));
		String conditions=request.getParameter("conditions");
		
		//���ݷ�װ�ɶ���
		Makeuptable makeuptable=new Makeuptable(sid, sname, grade, squadid, eid, conditions);
		
		//�������ݲ����ִ����ӷ���
		MakeuptableDao makeuptableDao=new MakeuptableDaoImpl();
		int rows=makeuptableDao.update(makeuptable);
		//�ж��޸��Ƿ�ɹ�
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
		int sid=Integer.parseInt(request.getParameter("sid"));
		String sname=request.getParameter("sname");
		int grade=Integer.parseInt(request.getParameter("grade"));
		int squadid=Integer.parseInt(request.getParameter("squadid"));
		int eid=Integer.parseInt(request.getParameter("eid"));
		String conditions=request.getParameter("conditions");
		
		
		//���ݷ�װ�ɶ���
		Makeuptable makeuptable=new Makeuptable(sid, sname, grade, squadid, eid, conditions);

		//�������ݲ����ִ����ӷ���
		MakeuptableDao makeuptableDao=new MakeuptableDaoImpl();
		int rows=makeuptableDao.add(makeuptable);
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
		
		String sid=request.getParameter("sid");
		String sname=request.getParameter("sname");
		String grade=request.getParameter("grade");
		String squadid=request.getParameter("squadid");
		String eid=request.getParameter("eid");
		String conditions=request.getParameter("conditions");
		//String deptno=request.getParameter("deptno");
		
		//���ɲ�ѯ����
		//select * from ���� where ���� limit n1,n2 
		//where �ֶ���=? and �ֶ���=? and �ֶ���=?
		String condition=" where 1=1 ";
		
		//���������ݽ����жϲ���ϳɲ�ѯ����
		if(sname!=null && !sname.equals("")){
			condition=condition+" and sname like '%"+sname+"%' ";
		}
		//���ݹ����ֶ�ֵ�����жϣ���������
		if(sid!=null && !sid.equals("")){
			condition=condition+" and sid like '%"+sid+"%' ";
		}
		if(grade!=null && !grade.equals("")){
			condition=condition+" and grade like '%"+grade+"%' ";
		}
		if(squadid!=null && !squadid.equals("")){
			condition=condition+" and squadid like '%"+squadid+"%' ";
		}
		
		if(eid!=null && !eid.equals("")){
			condition=condition+" and eid like '%"+eid+"%' ";
		}
		if(conditions!=null && !conditions.equals("")){
			condition=condition+" and conditions like '%"+conditions+"%' ";
		}
		
		/*
		if(deptno!=null && !deptno.equals("")){
			//����deptno��int���ͣ�����ת������
			int dept=Integer.parseInt(deptno);
			//��ӵ�������
			condition=condition+" and deptno="+dept+" ";
		}
		*/

		
		//�������Կͻ��˵�datagrid����Ĵ��ݹ�����page��rows����
		int rows=Integer.parseInt(request.getParameter("rows"));
		int page=Integer.parseInt(request.getParameter("page"));
		
		//�������ݲ�ִ�з�ҳ��ѯ
		MakeuptableDao makeuptabledao=new MakeuptableDaoImpl();
		//��õ�ǰҳ�����ݼ���
		List<Makeuptable> makeuptableList=makeuptabledao.findAll(rows, page, condition);
		
		// ��condition�ĸ�ʽת����int
		//int cond=Integer.parseInt(condition);
		//��ѯ��Makeuptable����ܼ�¼��
		int totalRows=makeuptabledao.count(condition);
				
		
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
		mapData.put("rows", makeuptableList);
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
