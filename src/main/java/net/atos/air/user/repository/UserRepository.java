package net.atos.air.user.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.atos.air.user.entity.UserDetails;

public interface UserRepository extends JpaRepository<UserDetails, Integer>  {
	public UserDetails findByUserName(String userName);

}
