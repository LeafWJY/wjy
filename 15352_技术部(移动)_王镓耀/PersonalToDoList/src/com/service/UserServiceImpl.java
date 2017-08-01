package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper.UserMapper;
import com.model.Items;
import com.model.User;
import com.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{   
    @Resource
    public UserMapper userMapper;
    
    @Override
    public User checkUser(String username) {
        // TODO Auto-generated method stub
        User user =userMapper.checkUser(username);
        return user;
    }
    @Override
   public List<Items> findItems(String user_id){
    	List<Items> items=userMapper.findItems(user_id);
    	return items;
    	
    }
    
    @Override
	public User findUser(String user_id){
    	User user=userMapper.findUser(user_id);
    	return user;
    }
    @Override
    public int addItem( String user_id,String todo_item_title, String todo_item_content, String priority){
    	int a=userMapper.addItem(user_id, todo_item_title, todo_item_content, priority);
    	return a;
    }
    
    @Override
    public int updateItem(String todo_item_id,String todo_item_title,String todo_item_content, String priority,String last_update_time){
    	int a=userMapper.updateItem(todo_item_id, todo_item_title, todo_item_content, priority,last_update_time);
    	return a;
    	
    	
    }
    @Override
    public int updateUser(String user_id,String user_name, String password, String sex, String age, String phone_number,String comments,String last_update_date){
    	int a=userMapper.updateUser(user_id, user_name, password, sex, age, phone_number,comments,last_update_date);
    	return a;
    }

    @Override
    public int deleteItem(String todo_item_id){
    	int a= userMapper.deleteItem(todo_item_id);
    	return a;
    	
    }
    
    
    

}