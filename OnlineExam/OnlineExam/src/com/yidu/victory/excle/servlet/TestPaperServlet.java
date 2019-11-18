package com.yidu.victory.excle.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.yidu.victory.excle.dao.TestPaperDao;
import com.yidu.victory.excle.dao.TestPaperTopicDao;
import com.yidu.victory.excle.dao.TopicbankDao;
import com.yidu.victory.excle.dao.Impl.TestPaperDaoImpl;
import com.yidu.victory.excle.dao.Impl.TestPaperTopicDaoImpl;
import com.yidu.victory.excle.dao.Impl.TopicbankDaoImpl;
import com.yidu.victory.excle.domain.TestPaper;
import com.yidu.victory.excle.domain.TestPaperTopic;
import com.yidu.victory.excle.domain.Topicbank;

/**
 * Servlet implementation class TestPaperServlet
 */
@WebServlet("/TestPaperServlet")
public class TestPaperServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestPaperServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置请求响应的字符集编码
		request.setCharacterEncoding("utf-8");
		//设置请求对象的内容类型
		response.setContentType("text/html");
		//设置请求对象的字符集编码
		response.setCharacterEncoding("utf-8");
		
		String method=request.getParameter("method");
		if("findAll".equals(method)){
			//查看表的方法
			this.findAll(request,response);
		}else if("add".equals(method)){
			//添加方法
			this.add(request,response);
		}else if("update".equals(method)){
			//修改方法
			this.update(request,response);
		}else if("delete".equals(method)){
			//删除方法
			this.delete(request,response);
		}
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//创建输出流对象
		PrintWriter out=response.getWriter();
		//获取来自请中所传递过来的员工编号字符串
		String cidStr=request.getParameter("cidStr");
		//将字符串进行按","(逗号)分割的子字符串数组
		String[] cids=cidStr.split(",");
		
		//创建数据层操作对象
		TestPaperDao testPaperDao=new TestPaperDaoImpl();
		//创建数据层操作对象
		TestPaperTopicDao tptdao=new TestPaperTopicDaoImpl();
		//由于是批量删除，有可能失败，此处使用异常处理来实现
		try{
			//使用循环进行批量删除
			for(int i=0;i<cids.length;i++){
				//获取当前子字符串
				String tcid=cids[i];
				//将字符串编号转换为整型的试卷编号
				int cid=Integer.parseInt(tcid);
				//调用数据层操作对象删除试卷表的试卷数据
				tptdao.delete(cid);
				
				//执行删除操作
				testPaperDao.delete(cid);
			}
			out.print("success");
		}catch(Exception e){
			out.print("failure");
		}
		
		//关闭输出对象
		out.close();
			
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//创建输出流对象
		PrintWriter out=response.getWriter();
		//接收来自客户端的数据
		int cid=Integer.parseInt(request.getParameter("cid"));
		String headline=request.getParameter("headline");
		String courseid=request.getParameter("courseid");
		
		String state=request.getParameter("state");
		//把数据封装成对象
		TestPaper testPaper=new TestPaper(cid, headline, courseid, state);
		
		//调用数据层的修改方法
		TestPaperDao testPaperDao=new TestPaperDaoImpl();
		int rows=testPaperDao.update(testPaper);
		//判断修改是否成功
		if(rows>0){
			out.print("success");
		}else{
			out.print("failure");
		}
		//关闭输出对象
		out.close();
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//创建输出流对象
		PrintWriter out=response.getWriter();
		//接收来自客户端的数据
		
		String headline=request.getParameter("headline");
		String courseid=request.getParameter("courseid");
		String state=request.getParameter("state");
		//把数据封装成对象
		TestPaper testPaper=new TestPaper( headline, courseid, state);
		//调用数据层的添加方法
		TestPaperDao testPaperDao=new TestPaperDaoImpl();
		int rows=testPaperDao.add(testPaper);
		//判断添加是否成功
		if(rows>0){
			//得到当前试卷id
			int tpid=testPaperDao.max();
			//创建需要的题目集合
			List<Topicbank> needlist=new ArrayList<>();
			
			TopicbankDao topicbankdao=new TopicbankDaoImpl();
			String condition=" and cname='"+courseid+"' ";

			List<Topicbank> topicbanklist=topicbankdao.findCondition(condition);

			if(state.equals("简单")){
				
				for( int i=0;i<5;i++){
					needlist.add(topicbanklist.get(i));
				}
				int[] randoms=getRandoms(5,topicbanklist.size(),45);
				for(int i=0;i<randoms.length;i++){
					needlist.add(topicbanklist.get(i));
				}
				
				
			}else if(state.equals("中等")){
				for( int i=0;i<10;i++){
					needlist.add(topicbanklist.get(i));
				}
				int[] randoms=getRandoms(10,topicbanklist.size(),40);
				for(int i=0;i<randoms.length;i++){
					needlist.add(topicbanklist.get(i));
				}
			}else if(state.equals("困难")){
				for( int i=0;i<15;i++){
					needlist.add(topicbanklist.get(i));
				}
				int[] randoms=getRandoms(15,topicbanklist.size(),35);
				for(int i=0;i<randoms.length;i++){
					needlist.add(topicbanklist.get(i));
				}
			}
			//创建数据层操作对象
			TestPaperTopicDao tptdao=new TestPaperTopicDaoImpl();
			TestPaperTopic tpt=null;
			for(int i=0;i<needlist.size();i++){
				tpt=new TestPaperTopic(tpid,needlist.get(i).getTestid());
				tptdao.add(tpt);
				
			}
			out.print("success");
		}else{
			out.print("failure");
		}
		//关闭输出对象
		out.close();
		
	}

	private void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//创建一个输出流对象
		PrintWriter out=response.getWriter();
		//得到来自请求中的条件数据
		String headline=request.getParameter("headline");
		String courseid=request.getParameter("courseid");
		String state=request.getParameter("state");
		
		String condition=" where 1=1 ";
		//对条件数据进行判断并组合成查询条件
		if(headline!=null && !headline.equals("")){
			condition=condition+"and headline like '%"+headline+"%' ";
		}
		if(courseid!=null && !courseid.equals("")){
			condition=condition+"and courseid like '%"+courseid+"%' ";
		}
		if(state!=null && !state.equals("")){
			condition=condition+"and state like '%"+state+"%' ";
		}
		
		//接收来自客户端的datagrid组件的传递过来的page和rows参数
		int rows=Integer.parseInt(request.getParameter("rows"));
		int page=Integer.parseInt(request.getParameter("page"));
		
		//调用数据层执行分页查询
		TestPaperDao testPaperDao=new TestPaperDaoImpl();
		//获得当前页的数据集合
		List<TestPaper> testPaperList=testPaperDao.findAll(rows, page, condition);
		//查询出student表的总记录数
		int totalRows=testPaperDao.count(condition);
		
		//定义映射集合对象
		Map<String, Object> mapData = new HashMap<String, Object>();
		mapData.put("total", totalRows);
		mapData.put("rows", testPaperList);
		//定义Gson对象
		Gson gson = new Gson();
		//通过Gson对象将Map集合转换成json数据格式
		String jsonData = gson.toJson(mapData);
		//将json数据输出到客户端
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
	
	public static int getRandom(int min,int max){
		Random random=new Random();
		return random.nextInt(max-min+1)+min;
	}
	public static int[] getRandoms(int min,int max,int count){
		int[] randoms = new int[count];
        List<Integer> listRandom = new ArrayList<Integer>();
 
        if( count > ( max - min + 1 )){
            return null;
        }
        // 将所有的可能出现的数字放进候选list
        for(int i = min; i <= max; i++){
            listRandom.add(i);
        }
        // 从候选list中取出放入数组，已经被选中的就从这个list中移除
        for(int i = 0; i < count; i++){
            int index = getRandom(0, listRandom.size()-1);
            randoms[i] = listRandom.get(index);
            listRandom.remove(index);
        }
 
        return randoms;
	}

}
