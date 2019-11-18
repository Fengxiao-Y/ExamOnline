package com.yidu.victory.popedom.servlet;

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
import com.yidu.victory.popedom.dao.User_roleDao;
import com.yidu.victory.popedom.dao.UsersDao;
import com.yidu.victory.popedom.dao.Impl.User_roleDaoImpl;
import com.yidu.victory.popedom.dao.Impl.UsersDaoImpl;
import com.yidu.victory.popedom.domain.User_role;
import com.yidu.victory.popedom.domain.Users;




/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
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
		String uidStr=request.getParameter("uidStr");
		//���ַ������а�","(����)�ָ�����ַ�������
		String[] uids=uidStr.split(",");
		//�������ݲ��������
		UsersDao usersDao=new UsersDaoImpl();
		//����������ɾ�����п���ʧ�ܣ��˴�ʹ���쳣������ʵ��
		try{
				//ʹ��ѭ����������ɾ��
				for(int i=0;i<uids.length;i++){
					//��ȡ��ǰ���ַ���
					String tuid=uids[i];
					//���ַ������ת��Ϊ���͵Ŀ��Ա��
					int uid=Integer.parseInt(tuid);
					User_roleDao userroledao=new User_roleDaoImpl();
					Users users=usersDao.findById(uid);
					userroledao.delete(users.getUnumber());
					//ִ��ɾ������
					usersDao.delete(uid);
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
		int uid=Integer.parseInt(request.getParameter("uid"));
		String unumber=request.getParameter("unumber");
		String passwords=request.getParameter("passwords");
		int role=Integer.parseInt(request.getParameter("role"));
		User_role user_role=new User_role(unumber,role);
		User_roleDao useroledao=new User_roleDaoImpl();
		//�����ݷ�װ�ɶ���
		Users users = new Users(uid,unumber,passwords);
		
		//�������ݲ����ִ���޸ķ���
		UsersDao usersDao=new UsersDaoImpl();
		int rows=usersDao.update(users);
		//�ж��Ƿ��޸ĳɹ�
		if(rows>0){
			useroledao.update(user_role);
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
		String unumber=request.getParameter("unumber");
		String passwords=request.getParameter("passwords");
		int role=Integer.parseInt(request.getParameter("role"));
		User_role user_role=new User_role(unumber,role);
		User_roleDao useroledao=new User_roleDaoImpl();
		
		//�����ݷ�װ�ɶ���
		Users users = new Users(unumber, passwords);
		
		//�������ݲ����ִ����ӷ���
		UsersDao usersDao=new UsersDaoImpl();
		int rows=usersDao.add(users);
		//�ж��Ƿ���ӳɹ�
		if(rows>0){
			useroledao.add(user_role);
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
		String unumber=request.getParameter("unumber");
		String condition=" where 1=1 ";
		//���������ݽ����жϲ���ϳɲ�ѯ����
		if(unumber!=null && !unumber.equals("")){
			condition=condition+"and unumber like '%"+unumber+"%' ";
		}
		//�������Կͻ��˵�datagrid����Ĵ��ݹ�����page��rows����
		int rows=Integer.parseInt(request.getParameter("rows"));
		int page=Integer.parseInt(request.getParameter("page"));
		
		//�������ݲ�ִ�з�ҳ��ѯ
		UsersDao usersDao=new UsersDaoImpl();
		//��õ�ǰҳ�����ݼ���
		List<Users> usersList=usersDao.findByPage(rows, page, condition);
		//��ѯ��student����ܼ�¼��
		int totalRows=usersDao.count(condition);
		
		//����ӳ�伯�϶���
		Map<String, Object> mapData = new HashMap<String, Object>();
		mapData.put("total", totalRows);
		mapData.put("rows", usersList);
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
