package com.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.model.Items;
import com.model.User;

public interface UserService {
   
    User checkUser(String username);
    List<Items> findItems(String user_id);
    
    
   User  findUser(String user_id);
    
    int addItem( String user_id,String todo_item_title, String todo_item_content, String priority);
    
  
int updateItem(String todo_item_id,String todo_item_title,String todo_item_content, String priority,String last_update_time);

int updateUser(String user_id,String user_name, String password, String sex, String age, String phone_number,String comments,String last_update_date);


int deleteItem(String todo_item_id);
}