package com.capg.fms.us.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.capg.fms.us.dao.UsersDAO;
import com.capg.fms.us.dto.Users;
import com.capg.fms.us.exception.UserAccountNotFoundException;


@Service
public class UsersService 
{
     @Autowired
     private UsersDAO udao;
     public void setUdao(UsersDAO udao) { this.udao=udao; }
     
     @Transactional(readOnly=true)
     public Optional<Users> getUser(String username)
     {
    	 if(!udao.existsById(username))
  	   {
  		   throw new UserAccountNotFoundException();
  	   }
  	   else {
  	   return udao.findById(username);
     }
    	 
     }
     
          
     @Transactional
     public Users addUser(Users user)
     {
    	 return udao.save(user);
     }
}
