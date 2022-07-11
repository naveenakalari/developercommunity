package com.dcp.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcp.entity.User;
import com.dcp.exception.UserNotFoundException;
import com.dcp.repository.UserRepository;
import com.dcp.service.IUserService;


@Service
public class UserService implements IUserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private DeveloperService ds;
	
	public String validateUser(int userId ,String password){
	  if( userRepository.findByUserIdAndPassword(userId, password) != null) {
		  return "Valid user";
	  }
      return "Invalid user,Please Register";
	}
	
	public List<User> addUser(User user) 
	  {
		userRepository.save(user);
		return userRepository.findAll();
		}
	
	public List<User> removeUser(int id)
	{
		userRepository.deleteById(id);
		return userRepository.findAll();
	}
	
	public String SignOut(String message) {
	   if(message.equals("SignOut")) {
		   return "signed out succesfully";
	   }
	   return "Still Signed in";
	}

	@Override
	public List<User> updatePassword(int id, String password) throws UserNotFoundException{
		try {
			if(!userRepository.existsById(id)) {
				throw new UserNotFoundException();
			}
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		User user=userRepository.findById(id).get();
		user.setPassword(password);
		return userRepository.findAll();
	}

	

	

	

	

}
