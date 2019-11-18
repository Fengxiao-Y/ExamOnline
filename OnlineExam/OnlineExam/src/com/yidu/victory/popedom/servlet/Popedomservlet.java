package com.yidu.victory.popedom.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.yidu.victory.popedom.dao.PopedomDao;
import com.yidu.victory.popedom.dao.Role_popedomDao;
import com.yidu.victory.popedom.dao.User_roleDao;
import com.yidu.victory.popedom.dao.UsersDao;
import com.yidu.victory.popedom.dao.Impl.PopedomDaoImpl;
import com.yidu.victory.popedom.dao.Impl.Role_popedomDaoImpl;
import com.yidu.victory.popedom.dao.Impl.User_roleDaoImpl;
import com.yidu.victory.popedom.dao.Impl.UsersDaoImpl;
import com.yidu.victory.popedom.domain.Popedom;
import com.yidu.victory.popedom.domain.Role_popedom;
import com.yidu.victory.popedom.domain.User_role;
import com.yidu.victory.popedom.domain.Users;

/**
 * Servlet implementation class Popedomservlet
 */
@WebServlet("/Popedomservlet")
public class Popedomservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Popedomservlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//����������Ӧ����
		response.setCharacterEncoding("utf8");
		response.setContentType("text/html");
		request.setCharacterEncoding("utf8");
		
		
		
		String method=request.getParameter("method");
		if(method.equals("login")){
			login(request,response);
		}else if(method.equals("treejson")){
			treejson(request,response);
		}
		
		
		
	}

	private void treejson(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//�����������
		PrintWriter out=response.getWriter();
		//��session �е��û�����ȡ����
		HttpSession session=request.getSession();
		Users user=(Users)session.getAttribute("user");
		
		
		//������ȷͨ���û���ɫ���õ��û���ɫ
		
		User_roleDao user_roledao=new User_roleDaoImpl();
		//ͨ���û���ɫ�ڵ��˺��ֶεõ��û�Ȩ�޶�����Ҫ�ҵ���ɫ���
		User_role user_role= user_roledao.findById(user.getUnumber());
		//ͨ����ɫ��Ż�ȡ�û��˵� id
		//�õ���ɫȨ�ޱ����ݲ����
		Role_popedomDao role_popedomdao=new Role_popedomDaoImpl();
		//��������
		String condition=" where 1=1 ";
		String sql=condition+" and roleid="+user_role.getRoleid();
		//ͨ���û��Ľ�ɫ��ŵĵ� ���� �˵�id����
		List<Role_popedom>    role_popedomlist=role_popedomdao.findBycondition(sql);
		//�����˵�������ݲ��������
		PopedomDao popedomdao=new PopedomDaoImpl();
		//����һ��int���͵�����
		List<Integer> intlist=new ArrayList<>();
		//�������󼯺�
		for( int i=0;i<role_popedomlist.size();i++){
			//�õ�ÿһ����ɫ�˵������
			Role_popedom role_popedom=role_popedomlist.get(i);
			//������ɫӵ�еĲ˵�IDȫ����װ��������
			intlist.add(role_popedom.getPdmid());
		}
		//����Popedom����
		List<Popedom> popedomlist=new ArrayList<Popedom>();
		Popedom popedom=null;
		//��������
		for (Integer integer : intlist) {
			//�õ�Popedom����
			 popedom=popedomdao.findById(integer);
			//��������ӵ�������
			popedomlist.add(popedom);
		}
		
		//����һ��Map���ϣ�key������pdmid���ͣ�ֵΪʵ���ࣻ
		Map<Integer,Popedom> map=new HashMap<>();
		//����һ�����˵�����
		List<Popedom> parents=new ArrayList<>();
		//�������ϣ�
		for (Popedom popedom2 : popedomlist) {
			//�����е�Ԫ����ӵ�map��key��pdmid,ֵ��popedom����
			map.put(popedom2.getId(), popedom2);
			//�ж��Ƿ�Ϊ���ڵ�
			if(popedom2.getPdmfather()==null||popedom2.getPdmfather()==0){
				//������ӵ����˵�������
				
				parents.add(popedom2);
			}
		}
		
		
		for (Popedom popedom2 : popedomlist) {
			//ͨ��get��key���õ�value  Ҳ����ͨ���Ӳ˵��ĸ��˵�ID�õ����˵�����
			Popedom parent=map.get(popedom2.getPdmfather());
			if(parent!=null){
				//������˵���Ϊ�յĻ� ��������˵���ӵ����˵����Ӳ˵�����
				
				parent.getChildren().add(popedom2);
			}
		}
		
		//ת��parentΪjson��ʽ
		
		//����json����
		Gson gson=new Gson();
		String parentstr=gson.toJson(parents);

		out.print(parentstr);
		
		
		/*
		request.setAttribute("treejson", parentstr);

		request.getRequestDispatcher("http://localhost:8080/OnlineExam/back/index.jsp").forward(request, response);
		return;
		*/
		
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		//�����������
				PrintWriter out=response.getWriter();
		//������ҳ�������û��˺�,����
		String unumber=request.getParameter("unumber");
		
		String passwords=request.getParameter("passwords");

		//ͨ���û����ʵ�ֲ�Ĳ鵥������ ���ҵ��˺ŵ����� ���к˶�ʵ�ֵ�¼
			//�������ݲ��������
			UsersDao usersdao=new UsersDaoImpl();
			//ͨ�����ҵ������� �õ��û�����
			Users user=usersdao.findById(unumber);
			
			if(user!=null){
				

				if(passwords.equals(user.getPasswords())){
					
					HttpSession session=request.getSession();
					session.setAttribute("user", user);
					out.print("success");
					
					
					
				}else{
					//�������
					out.print("error");
				}
			}else{
				//û�ҵ��û�
				out.print("notfund");
			}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
