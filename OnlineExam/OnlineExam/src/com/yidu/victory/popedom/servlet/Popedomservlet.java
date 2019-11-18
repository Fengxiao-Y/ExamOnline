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
		//设置请求，响应对象
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
		//设置输出对象
		PrintWriter out=response.getWriter();
		//把session 中的用户对象取出来
		HttpSession session=request.getSession();
		Users user=(Users)session.getAttribute("user");
		
		
		//密码正确通过用户角色表，得到用户角色
		
		User_roleDao user_roledao=new User_roleDaoImpl();
		//通过用户角色内的账号字段得到用户权限对象，主要找到角色编号
		User_role user_role= user_roledao.findById(user.getUnumber());
		//通过角色编号获取用户菜单 id
		//得到角色权限表数据层对象
		Role_popedomDao role_popedomdao=new Role_popedomDaoImpl();
		//设置条件
		String condition=" where 1=1 ";
		String sql=condition+" and roleid="+user_role.getRoleid();
		//通过用户的角色编号的到 他的 菜单id集合
		List<Role_popedom>    role_popedomlist=role_popedomdao.findBycondition(sql);
		//创建菜单表的数据层操作对象
		PopedomDao popedomdao=new PopedomDaoImpl();
		//创建一个int类型的数组
		List<Integer> intlist=new ArrayList<>();
		//遍历对象集合
		for( int i=0;i<role_popedomlist.size();i++){
			//得到每一个角色菜单表对象
			Role_popedom role_popedom=role_popedomlist.get(i);
			//将本角色拥有的菜单ID全都包装到集合中
			intlist.add(role_popedom.getPdmid());
		}
		//创建Popedom集合
		List<Popedom> popedomlist=new ArrayList<Popedom>();
		Popedom popedom=null;
		//遍历集合
		for (Integer integer : intlist) {
			//得到Popedom对象
			 popedom=popedomdao.findById(integer);
			//将对象添加到数组中
			popedomlist.add(popedom);
		}
		
		//创建一个Map集合，key类型是pdmid类型，值为实体类；
		Map<Integer,Popedom> map=new HashMap<>();
		//创建一个父菜单数组
		List<Popedom> parents=new ArrayList<>();
		//遍历集合，
		for (Popedom popedom2 : popedomlist) {
			//集合中的元素添加到map中key是pdmid,值是popedom对象
			map.put(popedom2.getId(), popedom2);
			//判断是否为父节点
			if(popedom2.getPdmfather()==null||popedom2.getPdmfather()==0){
				//是则添加到父菜单数组中
				
				parents.add(popedom2);
			}
		}
		
		
		for (Popedom popedom2 : popedomlist) {
			//通过get（key）得到value  也就是通过子菜单的父菜单ID得到父菜单对象
			Popedom parent=map.get(popedom2.getPdmfather());
			if(parent!=null){
				//如果父菜单不为空的话 ，将这个菜单添加到父菜单的子菜单下面
				
				parent.getChildren().add(popedom2);
			}
		}
		
		//转换parent为json格式
		
		//定义json对象
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
		
		//设置输出对象
				PrintWriter out=response.getWriter();
		//接收网页的数据用户账号,密码
		String unumber=request.getParameter("unumber");
		
		String passwords=request.getParameter("passwords");

		//通过用户表的实现层的查单个方法 查找到账号的密码 进行核对实现登录
			//创建数据层操作对象
			UsersDao usersdao=new UsersDaoImpl();
			//通过查找单个方法 得到用户对象
			Users user=usersdao.findById(unumber);
			
			if(user!=null){
				

				if(passwords.equals(user.getPasswords())){
					
					HttpSession session=request.getSession();
					session.setAttribute("user", user);
					out.print("success");
					
					
					
				}else{
					//密码错误
					out.print("error");
				}
			}else{
				//没找到用户
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
