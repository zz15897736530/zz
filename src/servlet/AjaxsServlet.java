package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.AjaxsDao;
import entity.AjaxsEntity;

@WebServlet(name = "aja", urlPatterns = { "/aja" })
public class AjaxsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    AjaxsDao dao=new AjaxsDao();
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String opt=request.getParameter("opt");
		if(opt.equals("query")){
			this.query(request,response);
		}else if(opt.equals("add")){
			this.add(request,response);
		}
	}
//添加
private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("name");
		String pwd=request.getParameter("pwd");
		String code=request.getParameter("code");
		boolean b=dao.add(new AjaxsEntity(name, pwd, code));
		PrintWriter out=response.getWriter();
		out.print(b);
		out.flush();
		out.close();
	}
//查询全部
	private void query(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		List<AjaxsEntity> list=dao.query();
		Gson gs=new Gson();
		PrintWriter out=response.getWriter();
		out.print(gs.toJson(list));//输出gs
		out.flush();//清楚缓存
		out.close();//关闭
	}
}
