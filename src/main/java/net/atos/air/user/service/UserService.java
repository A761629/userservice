package net.atos.air.user.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.atos.air.user.aop.advice.TrackExecutionTime;
import net.atos.air.user.dto.UserDetailsdto;
import net.atos.air.user.entity.UserDetails;
import net.atos.air.user.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	// getting all user Details

	@TrackExecutionTime
	public List<UserDetails> getAllUser() {
		List<UserDetails> userDetails = new ArrayList<UserDetails>();
		userRepository.findAll().forEach(user -> userDetails.add(user));
		return userDetails;
	}

	@TrackExecutionTime
	public void saveOrUpdate(UserDetailsdto UserDetailsdto) {
		UserDetails userDetails = new UserDetails();
		userDetails.setUserName(UserDetailsdto.getUserName());
		userDetails.setBirthdate(UserDetailsdto.getBirthdate());
		userDetails.setPhoneNumber(UserDetailsdto.getPhoneNumber());
		userDetails.setResidenceCountry(UserDetailsdto.getResidenceCountry());
		userDetails.setGender(UserDetailsdto.getGender());

		userRepository.save(userDetails);
	}
	
	public boolean  findByUserName(String userName) {
		UserDetails userDetails =userRepository.findByUserName(userName);
		return userDetails!=null && userDetails.getUserName().equalsIgnoreCase(userName) ? true :false;
	}
}
