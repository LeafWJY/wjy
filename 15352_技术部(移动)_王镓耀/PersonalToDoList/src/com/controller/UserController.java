package com.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.model.Items;
import com.model.User;
import com.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    
    
    @RequestMapping(value="/login.do")
    public ModelAndView doLogin(String username,String password,HttpSession session)
    {
    	
    	User user=userService.checkUser(username);
    	 ModelAndView modelAndView = new ModelAndView();  
    	if(user!=null){
    	
    	session.setAttribute("user_id", user.getUser_id());
    	
    	 
    
//        System.out.println(rightpassword);//如果实验成功，在控制台会打印年龄25
//        System.out.println(password);//如果实验成功，在控制台会打印年龄25
//        
       
    	if(user.getPassword().equals(password)){
    		 modelAndView.setViewName("My2");
    	}
    	 else {
    		 modelAndView.setViewName("login");
		}
	
    	}
    	else {
    		modelAndView.setViewName("login");
		}
        return modelAndView;
    }
//    @RequestMapping(value="/mydetail")
//    public ModelAndView mydetail(String username,String password)
//    {
//    	 ModelAndView modelAndView = new ModelAndView();  
//    	 System.out.println(username+password);
//     String rightpassword=userService.findUser("王镓耀");
////        System.out.println(rightpassword);//如果实验成功，在控制台会打印年龄25
////        System.out.println(password);//如果实验成功，在控制台会打印年龄25
////        
//       
//    	if(rightpassword.equals(password)){
//    		 modelAndView.setViewName("index");
//    	}
//    	 else {
//    		 modelAndView.setViewName("hello");
//		}
//	
//    	
//        return modelAndView;
//    }
//    
    
    @RequestMapping(value="/myItems.do")
    public void myItems(String username,String password,HttpServletResponse response)
    {
    	  
    	 
     List<Items> items=userService.findItems("1");
     
     JsonObject jsonObject=new JsonObject();
     JsonArray array=new JsonArray();
     for(Items item:items){
    	 System.out.println(item.getTodo_item_title());
    	 JsonObject json=new JsonObject();
    	 json.addProperty("item_id",item.getTodo_item_id() );
    	 json.addProperty("title",item.getTodo_item_title() );
    	 json.addProperty("content", item.getTodo_item_content());
    	 json.addProperty("priority",item.getPriority() );
    	 json.addProperty("creation_date",item.getCreation_date() );
    	 json.addProperty("last_update_date",item.getLast_update_date() );
    	 
    	 array.add(json); 
     }
     
     jsonObject.add("items", array);
     
    		response.setContentType("text/html;charset=utf-8");
    		try {
				response.getWriter().write(jsonObject.toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

        
    }
    
    @RequestMapping(value="/findUser.do")
    public void findUser(HttpServletResponse response,HttpSession session)
    {
    String user_id=(String) session.getAttribute("user_id");
    
     User user=userService.findUser(user_id);
     
    
    
    	 JsonObject json=new JsonObject();
    	 json.addProperty("user_name",user.getUser_name() );
    	 json.addProperty("phone",user.getPhone_number() );
    	 json.addProperty("password",user.getPassword());
    	 json.addProperty("sex",user.getSex() );
    	 json.addProperty("age",user.getAge() );
    	 json.addProperty("creation_date", user.getCreation_date());
    	 json.addProperty("last_update_date",user.getLast_update_date());
    	 
    	 json.addProperty("comments",user.getComments() );
    
     
     
    		response.setContentType("text/html;charset=utf-8");
    		try {
				response.getWriter().write(json.toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

        
    }
    
    @RequestMapping(value="/addItem.do")
    public void addItem(HttpServletResponse response,HttpSession session, String todo_item_title,String todo_item_content,String priority)
    {
    String user_id=(String) session.getAttribute("user_id");

    
    String xx=null;
 try {
	 xx= new String(todo_item_title.getBytes("iso8859-1"),"utf-8");
	 
	    System.out.println(xx+"----------------------------");
} catch (UnsupportedEncodingException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}
    
    
     int a=userService.addItem(user_id, xx, todo_item_content, priority);
     JsonObject json=new JsonObject();
     if (a==0) {
    	 json.addProperty("addItem","fail");
    	 
	}
     else {
    	 json.addProperty("addItem","success");
	}
     response.setContentType("text/html;charset=utf-8");
    		try {
				response.getWriter().write(json.toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

        
    }
    
    
    @RequestMapping(value="/updateItem.do")
    public void updateItem(HttpServletResponse response,String todo_item_id,String todo_item_title,String todo_item_content,String priority)
    {
  

    	long l = System.currentTimeMillis();
    	Date time=new Date(l);
    	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
     int a=userService.updateItem(todo_item_id, todo_item_title, todo_item_content, priority,sdf.format(time));
     JsonObject json=new JsonObject();
     if (a==0) {
    	 json.addProperty("updateItem","fail");
    	 
	}
     else {
    	 json.addProperty("updateItem","success");
	}
     response.setContentType("text/html;charset=utf-8");
    		try {
				response.getWriter().write(json.toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

        
    }
    
    
    
    
    @RequestMapping(value="/updateUser.do")
    public void updateUser(HttpServletResponse response,HttpSession session,String user_name,String password,String sex,String age,String phone_number,String comments)
    {
  
    	long l = System.currentTimeMillis();
    	Date time=new Date(l);
    	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	System.out.println(sdf.format(time)+"1111111111111111111111111111111111111111111111");
    	
    	String user_id=(String)session.getAttribute("user_id");
    	
    	System.out.println(user_id+"--------------------------");
    
     int a=userService.updateUser(user_id, user_name, password, sex, age, phone_number,comments,sdf.format(time));
     JsonObject json=new JsonObject();
     if (a==0) {
    	 json.addProperty("updateUser","fail");
    	 
	}
     else {
    	 json.addProperty("updateUser","success");
	}
     response.setContentType("text/html;charset=utf-8");
    		try {
				response.getWriter().write(json.toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

        
    }
    
    @RequestMapping(value="/deleteItem.do")
    public void deleteItem(HttpServletResponse response,String todo_item_id)
    {
  
    	
    
     int a=userService.deleteItem(todo_item_id);
     JsonObject json=new JsonObject();
     if (a==0) {
    	 json.addProperty("deleteItem","fail");
    	 
	}
     else {
    	 json.addProperty("deleteItem","success");
	}
     response.setContentType("text/html;charset=utf-8");
    		try {
				response.getWriter().write(json.toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

        
    }
    
    
    
    
    
    
    
    
    
}