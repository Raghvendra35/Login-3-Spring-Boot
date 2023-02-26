package com.login.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.login.model.CustomUserDetails;
import com.login.model.User;
import com.login.repo.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService
{
	@Autowired
	private UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException 
	{
		
	   User user=this.userRepo.findByUsername(userName);
		
	   
	   if(user==null)
		{
		   throw new UsernameNotFoundException("User not found !!!");
		}else
		{
			return new CustomUserDetails(user);
		}
		
	}

	
}
