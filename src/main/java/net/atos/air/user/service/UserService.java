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
	/** This method will fetch all the registered user and return
	 * @param 
	 * @return List<UserDetails>
	 */
		@TrackExecutionTime
	public List<UserDetails> getAllUser() {
		List<UserDetails> userDetails = new ArrayList<UserDetails>();
		userRepository.findAll().forEach(user -> userDetails.add(user));
		return userDetails;
	}

	/**
	 * This method will take UserDetailsdto as input and map to UserDetails entity and save the data in database.
	 *  
	 * @param UserDetailsdto
	*/
	@TrackExecutionTime
	public void userRegistration(UserDetailsdto UserDetailsdto) {
		UserDetails userDetails = new UserDetails();
		userDetails.setUserName(UserDetailsdto.getUserName());
		userDetails.setBirthdate(UserDetailsdto.getBirthdate());
		userDetails.setPhoneNumber(UserDetailsdto.getPhoneNumber());
		userDetails.setResidenceCountry(UserDetailsdto.getResidenceCountry());
		userDetails.setGender(UserDetailsdto.getGender());

		userRepository.save(userDetails);
	}
	
	/**
	 * This method will check if user already exist in database, and return the boolean to caller method. 
	 * @param userName : String 
	 * @return boolean
	 */
	public boolean  findByUserName(String userName) {
		UserDetails userDetails =userRepository.findByUserName(userName);
		return userDetails!=null && userDetails.getUserName().equalsIgnoreCase(userName) ? true :false;
	}
}
