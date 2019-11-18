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
import com.yidu.victory.student.domain.Announce;
import com.yidu.victory.student.dao.AnnounceDao;
import com.yidu.victory.student.dao.Impl.AnnounceDaoImpl;

/**
 * Servlet implementation class announceServlet
 */
@WebServlet("/AnnounceServlet")
public class AnnounceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnnounceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.����������ַ��������Ӧ����������
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

	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out=response.getWriter();
		//��ȡ�������������ݹ�����Ա������ַ���
		String aidStr=request.getParameter("aidNoStr");
		//���ַ������а�","(����)�ָ�����ַ�������
		String[] aids=aidStr.split(",");
		
		//�������ݲ��������
		AnnounceDao announce=new AnnounceDaoImpl();
		
		//����������ɾ�����п���ʧ�ܣ��˴�ʹ���쳣������ʵ��
		try{
			//ʹ��ѭ����������ɾ��
			for(int i=0;i<aids.length;i++){
				//��ȡ��ǰ���ַ���
				String taid=aids[i];
				//���ַ������ת��Ϊ���͵�Ա�����
				int aid=Integer.parseInt(taid);
				//ִ��ɾ������
				announce.delete(aid);
			}
			out.print("success");
		}catch(Exception e){
			out.print("failure");
		}
		
		//�ر��������
		out.close();
		
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out=response.getWriter();
		
		//�������Կͻ��˵�����
		int aid=Integer.parseInt(request.getParameter("aid"));
		String theme=request.getParameter("theme");
		String titlecontent=request.getParameter("titlecontent");
		String announcecont=request.getParameter("announcecont");
		String issuepeople=request.getParameter("issuepeople");
		String issuetime=request.getParameter("issuetime");
		//���ݷ�װ�ɶ���
		Announce announce=new Announce(aid, theme, titlecontent, announcecont, issuepeople, issuetime);
		//�������ݲ����ִ����ӷ���
		AnnounceDao announceDao=new AnnounceDaoImpl();
		int rows=announceDao.update(announce);
		//�ж�����Ƿ�ɹ�
		if(rows>0){
			out.print("success");
		}else{
			out.print("failure");
		}
		
		out.close();
		
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out=response.getWriter();
		
		//�������Կͻ��˵�����
		//�������Կͻ��˵�����
		String theme=request.getParameter("theme");
		String titlecontent=request.getParameter("titlecontent");
		String announcecont=request.getParameter("announcecont");
		String issuepeople=request.getParameter("issuepeople");
		String issuetime=request.getParameter("issuetime");
		//���ݷ�װ�ɶ���
		Announce announce=new Announce( theme, titlecontent, announcecont, issuepeople, issuetime);
		//�������ݲ����ִ����ӷ���
		AnnounceDao announceDao=new AnnounceDaoImpl();
		int rows=announceDao.add(announce);
		//�ж�����Ƿ�ɹ�
		if(rows>0){
			out.print("success");
		}else{
			out.print("failure");
		}
		
		out.close();
		
	}

	private void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
PrintWriter out=response.getWriter();
		
		//�õ����������е���������
		String titlecontent=request.getParameter("titlecontent");
		String announcecont=request.getParameter("announcecont");
		String issuetime=request.getParameter("issuetime");
		
		//���ɲ�ѯ����
		//select * from ���� where ���� limit n1,n2 
		//where �ֶ���=? and �ֶ���=? and �ֶ���=?
		String condition=" where 1=1 ";
		//���������ݽ����жϲ���ϳɲ�ѯ����
		if(titlecontent!=null && !titlecontent.equals("")){
			condition=condition+"and titlecontent like '%"+titlecontent+"%' ";
		}
		
		if(announcecont!=null && !announcecont.equals("")){
			condition=condition+"and announcecont like '%"+announcecont+"%' ";
		}
		
		if(issuetime!=null && !issuetime.equals("")){
			//����deptno��int���ͣ�����ת������
			//int dept=Integer.parseInt(deptno);
			//��ӵ�������
			condition=condition+"and issuetime="+issuetime+" ";
		}
		
		
		
		//�������Կͻ��˵�datagrid����Ĵ��ݹ�����page��rows����
		int rows=Integer.parseInt(request.getParameter("rows"));
		int page=Integer.parseInt(request.getParameter("page"));
		
		//�������ݲ�ִ�з�ҳ��ѯ
		AnnounceDao announceDao=new AnnounceDaoImpl();
		//��õ�ǰҳ�����ݼ���
		List<Announce> announceList=announceDao.findByPage(rows, page,condition);
		//��ѯ��emp����ܼ�¼��
		int totalRows=announceDao.count(condition);
		
		//A��ʽ��
		/*
		//�����ݼ���ת����JSON���ݸ�ʽ
		String jsonStr=JSONArray.fromObject(empList).toString();
		//���ɸ�ʽ������
		String json="{\"total\":"+totalRows+",\"rows\":"+jsonStr+"}";
		*/
		
		//B:��ʽ
		//����ӳ�伯�϶���
		Map<String, Object> mapData = new HashMap<String, Object>();
		mapData.put("total", totalRows);
		mapData.put("rows", announceList  );
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
