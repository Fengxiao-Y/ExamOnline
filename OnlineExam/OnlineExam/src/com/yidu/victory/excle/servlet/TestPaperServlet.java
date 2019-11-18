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
		//�������������
		PrintWriter out=response.getWriter();
		//��ȡ�������������ݹ�����Ա������ַ���
		String cidStr=request.getParameter("cidStr");
		//���ַ������а�","(����)�ָ�����ַ�������
		String[] cids=cidStr.split(",");
		
		//�������ݲ��������
		TestPaperDao testPaperDao=new TestPaperDaoImpl();
		//�������ݲ��������
		TestPaperTopicDao tptdao=new TestPaperTopicDaoImpl();
		//����������ɾ�����п���ʧ�ܣ��˴�ʹ���쳣������ʵ��
		try{
			//ʹ��ѭ����������ɾ��
			for(int i=0;i<cids.length;i++){
				//��ȡ��ǰ���ַ���
				String tcid=cids[i];
				//���ַ������ת��Ϊ���͵��Ծ���
				int cid=Integer.parseInt(tcid);
				//�������ݲ��������ɾ���Ծ����Ծ�����
				tptdao.delete(cid);
				
				//ִ��ɾ������
				testPaperDao.delete(cid);
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
		int cid=Integer.parseInt(request.getParameter("cid"));
		String headline=request.getParameter("headline");
		String courseid=request.getParameter("courseid");
		
		String state=request.getParameter("state");
		//�����ݷ�װ�ɶ���
		TestPaper testPaper=new TestPaper(cid, headline, courseid, state);
		
		//�������ݲ���޸ķ���
		TestPaperDao testPaperDao=new TestPaperDaoImpl();
		int rows=testPaperDao.update(testPaper);
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
		
		String headline=request.getParameter("headline");
		String courseid=request.getParameter("courseid");
		String state=request.getParameter("state");
		//�����ݷ�װ�ɶ���
		TestPaper testPaper=new TestPaper( headline, courseid, state);
		//�������ݲ����ӷ���
		TestPaperDao testPaperDao=new TestPaperDaoImpl();
		int rows=testPaperDao.add(testPaper);
		//�ж�����Ƿ�ɹ�
		if(rows>0){
			//�õ���ǰ�Ծ�id
			int tpid=testPaperDao.max();
			//������Ҫ����Ŀ����
			List<Topicbank> needlist=new ArrayList<>();
			
			TopicbankDao topicbankdao=new TopicbankDaoImpl();
			String condition=" and cname='"+courseid+"' ";

			List<Topicbank> topicbanklist=topicbankdao.findCondition(condition);

			if(state.equals("��")){
				
				for( int i=0;i<5;i++){
					needlist.add(topicbanklist.get(i));
				}
				int[] randoms=getRandoms(5,topicbanklist.size(),45);
				for(int i=0;i<randoms.length;i++){
					needlist.add(topicbanklist.get(i));
				}
				
				
			}else if(state.equals("�е�")){
				for( int i=0;i<10;i++){
					needlist.add(topicbanklist.get(i));
				}
				int[] randoms=getRandoms(10,topicbanklist.size(),40);
				for(int i=0;i<randoms.length;i++){
					needlist.add(topicbanklist.get(i));
				}
			}else if(state.equals("����")){
				for( int i=0;i<15;i++){
					needlist.add(topicbanklist.get(i));
				}
				int[] randoms=getRandoms(15,topicbanklist.size(),35);
				for(int i=0;i<randoms.length;i++){
					needlist.add(topicbanklist.get(i));
				}
			}
			//�������ݲ��������
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
		//�ر��������
		out.close();
		
	}

	private void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//����һ�����������
		PrintWriter out=response.getWriter();
		//�õ����������е���������
		String headline=request.getParameter("headline");
		String courseid=request.getParameter("courseid");
		String state=request.getParameter("state");
		
		String condition=" where 1=1 ";
		//���������ݽ����жϲ���ϳɲ�ѯ����
		if(headline!=null && !headline.equals("")){
			condition=condition+"and headline like '%"+headline+"%' ";
		}
		if(courseid!=null && !courseid.equals("")){
			condition=condition+"and courseid like '%"+courseid+"%' ";
		}
		if(state!=null && !state.equals("")){
			condition=condition+"and state like '%"+state+"%' ";
		}
		
		//�������Կͻ��˵�datagrid����Ĵ��ݹ�����page��rows����
		int rows=Integer.parseInt(request.getParameter("rows"));
		int page=Integer.parseInt(request.getParameter("page"));
		
		//�������ݲ�ִ�з�ҳ��ѯ
		TestPaperDao testPaperDao=new TestPaperDaoImpl();
		//��õ�ǰҳ�����ݼ���
		List<TestPaper> testPaperList=testPaperDao.findAll(rows, page, condition);
		//��ѯ��student����ܼ�¼��
		int totalRows=testPaperDao.count(condition);
		
		//����ӳ�伯�϶���
		Map<String, Object> mapData = new HashMap<String, Object>();
		mapData.put("total", totalRows);
		mapData.put("rows", testPaperList);
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
        // �����еĿ��ܳ��ֵ����ַŽ���ѡlist
        for(int i = min; i <= max; i++){
            listRandom.add(i);
        }
        // �Ӻ�ѡlist��ȡ���������飬�Ѿ���ѡ�еľʹ����list���Ƴ�
        for(int i = 0; i < count; i++){
            int index = getRandom(0, listRandom.size()-1);
            randoms[i] = listRandom.get(index);
            listRandom.remove(index);
        }
 
        return randoms;
	}

}
