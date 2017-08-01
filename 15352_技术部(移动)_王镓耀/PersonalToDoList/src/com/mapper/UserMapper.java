package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.model.Items;
import com.model.User;

public interface UserMapper {
//    String findUser(String username); 
    User  checkUser(String username);
    List<Items> findItems(@Param(value="user_id") String user_id);
   User findUser(@Param(value="user_id") String user_id);
  
    int addItem(@Param(value="user_id") String user_id,@Param(value="todo_item_title") String todo_item_title,@Param(value="todo_item_content") String todo_item_content,
    		@Param(value="priority") String priority);
    
                                                                                                                                                       
int updateItem(@Param(value="todo_item_id") String todo_item_id,@Param(value="todo_item_title") String todo_item_title,@Param(value="todo_item_content") String todo_item_content,@Param(value="priority") String priority,@Param(value="last_update_time") String last_update_time);

int updateUser(@Param(value="user_id") String user_id,@Param(value="user_name") String user_name,@Param(value="password") String password,@Param(value="sex") String sex,@Param(value="age") String age,@Param(value="phone_number") String phone_number,@Param(value="comments") String comments,@Param(value="last_update_date") String last_update_date);


int deleteItem(@Param(value="todo_item_id") String todo_item_id);

}