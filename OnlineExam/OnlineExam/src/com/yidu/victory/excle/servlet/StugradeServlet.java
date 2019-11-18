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
import com.yidu.victory.excle.dao.StugradeDao;
import com.yidu.victory.excle.dao.Impl.ExamDaoImpl;
import com.yidu.victory.excle.dao.Impl.StugradeDaoImpl;
import com.yidu.victory.excle.domain.Exam;
import com.yidu.victory.excle.domain.Stugrade;

/**
 * Servlet implementation class StugradeServlet
 */
@WebServlet("/StugradeServlet")
public class StugradeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StugradeServlet() {
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
		String gidStr=request.getParameter("gidStr");
		//���ַ������а�","(����)�ָ�����ַ�������
		String[] gids=gidStr.split(",");
		//�������ݲ��������
		StugradeDao stugradeDao=new StugradeDaoImpl();
		//����������ɾ�����п���ʧ�ܣ��˴�ʹ���쳣������ʵ��
		try{
				//ʹ��ѭ����������ɾ��
				for(int i=0;i<gids.length;i++){
					//��ȡ��ǰ���ַ���
					String tgid=gids[i];
					//���ַ������ת��Ϊ���͵Ŀ��Ա��
					int gid=Integer.parseInt(tgid);
					//ִ��ɾ������
					stugradeDao.delete(gid);
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
		int gid=Integer.parseInt(request.getParameter("gid"));
		String sid=request.getParameter("sid");
		String sname=request.getParameter("sname");
		int grade=Integer.parseInt(request.getParameter("grade"));
		int squadid=Integer.parseInt(request.getParameter("squadid"));
		int cid=Integer.parseInt(request.getParameter("cid"));
		String remark=request.getParameter("remark");
		//�����ݷ�װ�ɶ���
		Stugrade stugrade=new Stugrade(gid, sid, sname, grade, squadid, cid,remark);
		//�������ݲ����ִ���޸ķ���
		StugradeDao stugradeDao=new StugradeDaoImpl();
		int rows=stugradeDao.update(stugrade);
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
		String sid=request.getParameter("sid");
		String sname=request.getParameter("sname");
		int grade=Integer.parseInt(request.getParameter("grade"));
		int squadid=Integer.parseInt(request.getParameter("squadid"));
		int cid=Integer.parseInt(request.getParameter("cid"));
		String remark=request.getParameter("remark");
		
		//�����ݷ�װ�ɶ���
		Stugrade stugrade=new Stugrade( sid, sname, grade, squadid, cid,remark);
		//�������ݲ����ִ����ӷ���
		StugradeDao stugradeDao=new StugradeDaoImpl();
		int rows=stugradeDao.add(stugrade);
		//�ж���ӷ����Ƿ�ɹ�
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
		String sname=request.getParameter("sname");
		String squadid=request.getParameter("squadid");
		String cid=request.getParameter("cid");

		String condition=" where 1=1 ";
		//���������ݽ����жϲ���ϳɲ�ѯ����
		if(sname!=null && !sname.equals("")){
			condition=condition+"and sname like '%"+sname+"%' ";
		}
		if(squadid!=null && !squadid.equals("")){
			//����squadid��int���ͣ�����ת������
			int squadid1=Integer.parseInt(squadid);
			//��ӵ�������
			condition=condition+"and squadid="+squadid1+" ";
		}
		if(cid!=null && !cid.equals("")){
			//����cid��int���ͣ�����ת������
			int cid1=Integer.parseInt(cid);
			condition=condition+"and cid ="+cid1+" ";
		}
		
		//�������Կͻ��˵�datagrid����Ĵ��ݹ�����page��rows����
		int rows=Integer.parseInt(request.getParameter("rows"));
		int page=Integer.parseInt(request.getParameter("page"));
		
		//�������ݲ�ִ�з�ҳ��ѯ
		StugradeDao stugradeDao=new StugradeDaoImpl();
		//��õ�ǰҳ�����ݼ���
		List<Stugrade> stugradeList=stugradeDao.findAll(rows, page, condition);
		//��ѯ��student����ܼ�¼��
		int totalRows=stugradeDao.count(condition);
		
		//����ӳ�伯�϶���
		Map<String, Object> mapData = new HashMap<String, Object>();
		mapData.put("total", totalRows);
		mapData.put("rows", stugradeList);
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
