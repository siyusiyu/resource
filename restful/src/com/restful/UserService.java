
package com.restful;  
 
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONObject;  
//为WebServceis指定Path
@Path("/UserService") 
 
public class UserService {  
   UserDao userDao = new UserDao();  
   @GET 
   @Path("/users") 
   @Produces(MediaType.APPLICATION_JSON)
   //访问地址：http://localhost:8009/restful/rest/UserService/users
   public String getUsers(){ 
     List<User> list = userDao.getAllUsers();
     JSONArray jsonarray = new JSONArray(list);
     String json = jsonarray.toString();
     return json;  
   }
   
   @PUT
   @Path("/users") 
   @Produces(MediaType.APPLICATION_JSON)
   //访问地址：http://localhost:8009/restful/rest/UserService/users
   public String getUser(){ 
     return "这是put的返回值";  
   }
   
   @DELETE
   @Path("/users/{id}") 
   @Produces(MediaType.APPLICATION_JSON)
   //访问地址：http://localhost:8009/restful/rest/UserService/users/23
   public String deleteUser(@PathParam("id") String id){ 
     return "删除"+id+"成功";  
   }
   
   @POST
   @Path("/users")
   @Produces(MediaType.APPLICATION_XML)
   public List<User> getusers(){
	  List<User> list = userDao.getAllUsers();
	  return list;
   }   
   
   @GET
   @Path("/users/{id},{name}")
   //中文乱码问题
   @Produces("application/json;charset=utf-8")
   //访问地址：http://localhost:8009/restful/rest/UserService/users/12,%E5%91%A8%E7%91%9E
   public String showUser( @PathParam("id") String id, @PathParam("name") String name ) {
	  String str = "您传入的参数是:id="+id+",name="+name;
	  JSONObject json = new JSONObject();
	  json.put("result", str);
	  return json.toString();
   }
   
   @GET
   @Path("/user")
   //中文乱码问题
   @Produces("application/json;charset=utf-8")
   //访问地址：http://localhost:8009/restful/rest/UserService/user?id=12&name=zhourui
   public String getUser( @QueryParam("id")String id, @QueryParam("name")String name) {
	  if(name == null || "".equals(name)) {
		  return "姓名为空";
	  } 
	  String str = "您传入的参数是:id="+id+",name="+name;
	  JSONObject json = new JSONObject();
	  json.put("result", str);
	  return json.toString();
   }
   
   
   
   
   
   
   
   
   
}
