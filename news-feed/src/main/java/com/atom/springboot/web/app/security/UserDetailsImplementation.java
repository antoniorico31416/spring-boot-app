package com.atom.springboot.web.app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.atom.springboot.web.app.repository.UserRepository;

@Service
public class UserDetailsImplementation implements UserDetailsService {

	//Import the repository
	private UserRepository userRepository = null;
	
	@Autowired
	public UserDetailsImplementation(UserRepository userRepository) {
		this.userRepository = userRepository;

	}
	
	public UserDetailsImplementation() {
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//Use all the path of model
		com.atom.springboot.web.app.models.User user = userRepository.findByUsername(username);
		UserBuilder builder = null;
		
		if(user != null) {
			builder = User.withUsername(username);
			builder.disabled(false);
			builder.password(user.getPassword());
			builder.authorities(new SimpleGrantedAuthority("ROLE_USER"));
		}
		else {
			throw new UsernameNotFoundException("User not found");
		}
		
		// TODO Auto-generated method stub
		return builder.build();
	}

}
