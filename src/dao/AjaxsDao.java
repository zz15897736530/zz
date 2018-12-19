package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.AjaxsEntity;

public class AjaxsDao extends BaseDao{
      Connection con=null;
      PreparedStatement pst=null;
      ResultSet rst=null;
//²éÑ¯
      public List<AjaxsEntity> query(){
    	  try {
    	  con=super.getCon();
    	  String sql="select * from stu";
		  pst=con.prepareStatement(sql);
    	  rst=pst.executeQuery();
    	  List<AjaxsEntity> list=new ArrayList<AjaxsEntity>();
    	  AjaxsEntity aja=null;
    	  while(rst.next()){
    		  int stuid=rst.getInt("stuid");
    		  String name=rst.getString("name");
    		  String pwd=rst.getString("pwd");
    		  String code=rst.getString("code");
    		  aja=new AjaxsEntity(stuid, name, pwd, code);
    		  list.add(aja);
    	  }
    	  return list;
    	  } catch (SQLException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  			return null;
  		} finally{
  			super.closeCon(con, pst, rst);
  		}  	  
      }
//Ìí¼Ó
      public boolean add(AjaxsEntity aja){
    	  try {
    	  con=super.getCon();
    	  String sql="insert stu values(?,?,?)";
		  pst=con.prepareStatement(sql);
		  pst.setString(1,aja.getName());
		  pst.setString(2,aja.getPwd());
		  pst.setString(3,aja.getCode());
		  int i=pst.executeUpdate();
		  if(i!=0){
			  return true;
		  }else{
			  return false;
		  }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally{
			super.closeCon(con, pst, rst);
		}   	  
      }
//ÐÞ¸Ä
      public boolean upadte(AjaxsEntity aja){
    	  try {
    	  con=super.getCon();
    	  String sql="update stu set name=?,pwd=?,code=? where stuid=?";
		  pst=con.prepareStatement(sql);
		  pst.setString(1,aja.getName());
		  pst.setString(2,aja.getPwd());
		  pst.setString(3,aja.getCode());
		  pst.setInt(4,aja.getStuid());
		  int i=pst.executeUpdate();
		  if(i>0){
			  return true;
		  }else{
			  return false;
		  }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally{
			super.closeCon(con, pst, rst);
		} 	  
      }
//É¾³ý
      public boolean delete(int id){
    	  try {
    	  con=super.getCon();
    	  String sql="delete from stu where stuid=?";
		  pst=con.prepareStatement(sql);
		  pst.setInt(1,id);
		  int i=pst.executeUpdate();
		  if(i!=0){
			  return true;
		  }else{
			  return false;
		  }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally{
			super.closeCon(con, pst, rst);
		}	  
    	  
      }
}
