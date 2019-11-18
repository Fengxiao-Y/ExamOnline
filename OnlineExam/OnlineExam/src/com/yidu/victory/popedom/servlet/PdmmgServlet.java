package com.yidu.victory.popedom.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yidu.victory.popedom.dao.Role_popedomDao;
import com.yidu.victory.popedom.dao.Impl.Role_popedomDaoImpl;
import com.yidu.victory.popedom.domain.Role_popedom;


@WebServlet("/PdmmgServlet")
public class PdmmgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public PdmmgServlet() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out=response.getWriter();
	//设置请求，响应对象
	response.setCharacterEncoding("utf8");
	response.setContentType("text/html");
	request.setCharacterEncoding("utf8");
	String method=request.getParameter("method");
	if(method.equals("add")){
		add(request,response);
	}else if(method.equals("delete")){
		delete(request,response);
	}
	
	
			
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out=response.getWriter();
		int chioce=Integer.parseInt(request.getParameter("chioce"));
		String arr=request.getParameter("arr");
		
		
		Role_popedomDao role_popedomdao=new Role_popedomDaoImpl();
		String[] arrlist=arr.split(",");
		try {
			for(int i=0;i<arrlist.length;i++){
				String condition=" where 1=1 and roleid="+chioce+" and pdmid="+arrlist[i];

				int a=role_popedomdao.delete(condition);
				
			}
			out.print("success");
		} catch (Exception e) {
			out.print("lostall");
			
		}
	
		
	}


	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out=response.getWriter();
		int chioce=Integer.parseInt(request.getParameter("chioce"));
		String arr=request.getParameter("arr");
		
		String condition=" where 1=1 and roleid="+chioce;

		Role_popedomDao role_popedomdao=new Role_popedomDaoImpl();
		//删除当前角色所有权限
		int x=role_popedomdao.delete(condition);
		if(x>0){
			//删除完后 将修改后的权限添加进角色权限表中
			String[] arrlist=arr.split(",");
			try {
				for(int i=0;i<arrlist.length;i++){
					Role_popedom role_popedom=new Role_popedom(Integer.parseInt(arrlist[i]),chioce);
					role_popedomdao.add(role_popedom);
					
				}
				out.print("success");
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				out.print("lostall");
			}
			
		}else{
			out.print("error");
		}
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
