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
import com.yidu.victory.student.dao.SquadDao;
import com.yidu.victory.student.dao.StudentDao;
import com.yidu.victory.student.dao.Impl.SquadDaoImpl;
import com.yidu.victory.student.dao.Impl.StudentDaoImpl;
import com.yidu.victory.student.domain.Squad;
import com.yidu.victory.student.domain.Student;

/**
 * Servlet implementation class SquadServlet
 */
@WebServlet("/SquadServlet")
public class SquadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SquadServlet() {
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
		String sqidStr=request.getParameter("sqidStr");
		//���ַ������а�","(����)�ָ�����ַ�������
		String[] sqids=sqidStr.split(",");
		//�������ݲ��������
		SquadDao squadDao=new SquadDaoImpl();
		//����������ɾ�����п���ʧ�ܣ��˴�ʹ���쳣������ʵ��
		try{
				//ʹ��ѭ����������ɾ��
				for(int i=0;i<sqids.length;i++){
					//��ȡ��ǰ���ַ���
					String tsqid=sqids[i];
					int sqid=Integer.parseInt(tsqid);
					//ִ��ɾ������
					squadDao.delete(sqid);
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
				int sqid=Integer.parseInt(request.getParameter("sqid"));
				String snumber=request.getParameter("snumber");
				int speople=Integer.parseInt(request.getParameter("speople"));
				String squadtime=request.getParameter("squadtime");
				String teacher=request.getParameter("teacher");
				String sadministration=request.getParameter("sadministration");
				String state=request.getParameter("state");
				String classify=request.getParameter("classify");
				
				//�����ݷ�װ�ɶ���
				Squad squad=new Squad(sqid, snumber, speople, squadtime, teacher, sadministration,
						state, classify);
				//�������ݲ����ִ���޸ķ���
				SquadDao squadDao=new SquadDaoImpl();
				int rows=squadDao.update(squad);
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
		String snumber=request.getParameter("snumber");
		int speople=Integer.parseInt(request.getParameter("speople"));
		String squadtime=request.getParameter("squadtime");
		String teacher=request.getParameter("teacher");
		String sadministration=request.getParameter("sadministration");
		String state=request.getParameter("state");
		String classify=request.getParameter("classify");
		
		//�����ݷ�װ�ɶ���
		Squad squad=new Squad( snumber, speople, squadtime, teacher, sadministration,
				state, classify);
		//�������ݲ����ִ���޸ķ���
		SquadDao squadDao=new SquadDaoImpl();
		int rows=squadDao.add(squad);
		//�ж��Ƿ��޸ĳɹ�
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
		String snumber=request.getParameter("snumber");
		String teacher=request.getParameter("teacher");
		String state=request.getParameter("state");
		String condition=" where 1=1 ";
		//���������ݽ����жϲ���ϳɲ�ѯ����
		if(snumber!=null && !snumber.equals("")){
			condition=condition+" and snumber like '%"+snumber+"%' ";
		}
		if(teacher!=null && !teacher.equals("")){
			condition=condition+" and teacher like '%"+teacher+"%' ";
		}
		if(state!=null && !state.equals("")){
			condition=condition+" and state like '%"+state+"%' ";
		}

		//�������Կͻ��˵�datagrid����Ĵ��ݹ�����page��rows����
		int rows=Integer.parseInt(request.getParameter("rows"));
		int page=Integer.parseInt(request.getParameter("page"));
		//�������ݲ�ִ�з�ҳ��ѯ
		SquadDao squadDao=new SquadDaoImpl();
		//��õ�ǰҳ�����ݼ���
		List<Squad> squadList=squadDao.findAll(rows, page, condition);
		//��ѯ��student����ܼ�¼��
		int totalRows=squadDao.count(condition);
		
		//����ӳ�伯�϶���
		Map<String, Object> mapData = new HashMap<String, Object>();
		mapData.put("total", totalRows);
		mapData.put("rows", squadList);
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
