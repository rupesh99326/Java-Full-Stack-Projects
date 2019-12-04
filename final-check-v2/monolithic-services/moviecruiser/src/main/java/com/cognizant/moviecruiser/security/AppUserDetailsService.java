package com.cognizant.moviecruiser.security;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cognizant.moviecruiser.MoviecruiserApplication;
import com.cognizant.moviecruiser.model.Role;
import com.cognizant.moviecruiser.model.Users;
import com.cognizant.moviecruiser.repository.RoleRepository;
import com.cognizant.moviecruiser.repository.UserRepository;



@Service
public class AppUserDetailsService implements UserDetailsService{
	

	private static final Logger LOGGER = LoggerFactory.getLogger(MoviecruiserApplication.class);

@Autowired
private UserRepository userrepository; 



@Autowired
public RoleRepository rolerepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		LOGGER.info("Start");
        LOGGER.debug("UserRepository:{}", userrepository);
        Users user = userrepository.findByUsername(username);
        LOGGER.debug("User:{}", user);

        if(user==null){
			throw new UsernameNotFoundException("User not found!");
		}
		else
		{
			LOGGER.info("user is:"+user);
			AppUser appUser = new AppUser(user);
			LOGGER.info("userDetails is: "+appUser);
			return appUser;
		}

	}

	public AppUserDetailsService(UserRepository userrepository) {
		super();
		this.userrepository = userrepository;
	}
	
	public boolean signup(Users newuser){
        Users u=userrepository.findByUsername(newuser.getUsername());
        if(u==null)
        {
            String password=newuser.getPassword();
            BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
            String newpassword=encoder.encode(password);
            Role role= rolerepository.findById(1).get();
            List<Role> roleset= new ArrayList<Role>();
            roleset.add(role);
            newuser.setRoles(roleset);
            newuser.setPassword(newpassword);
            userrepository.save(newuser);
            return true;
        }
        else
            return false;
   }

}
