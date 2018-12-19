package util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class AjaxUtil {
//	ÐÞ¸Ä\É¾³ý\Ìí¼Ó
	public static void outString(HttpServletResponse response,String b){
		PrintWriter out=null;
		try {
		out = response.getWriter();
		out.print(b);
		out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(out!=null){
			out.close();
			}
		}
	}
	
//	²éÑ¯
	public static void outjson(HttpServletResponse response,List list){
		PrintWriter out=null;
		try {
		Gson gs = new Gson();
		out = response.getWriter();
		out.print(gs.toJson(list));
		out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(out!=null){
			out.close();
			}
		}
	}
}
