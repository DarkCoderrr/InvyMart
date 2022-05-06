package com.InvyMart.Repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.InvyMart.Model.Supervisor;

public interface SupervisorRepo extends JpaRepository<Supervisor, Long>{


	
	Optional<Supervisor> findSuperviserBysupervisorId(Long id);
	

	Optional<Supervisor> findSuperviserByusername(String username);
	
	
	
	@Transactional
	
	@Query(value="SELECT COUNT(1) FROM supervisor WHERE username = :username AND password = :password", nativeQuery = true)
	Integer isSupervisorExistByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
	
	@Transactional
	@Modifying
	@Query(value = "insert into supervisor(name, seniority_Level, username, password, email_Id, supervisor_Code,is_active, department_ID) VALUES "
			+ "(:name, :seniority_Level,:username, :password, :email_Id, :supervisor_Code,:is_active, :department_ID)", nativeQuery = true)
	Integer addSupervisor(@Param("name") String name, @Param("seniority_Level") String seniorityLevel, 
			@Param("username") String username, @Param("password") String password, 
			@Param("email_Id") String emailId, @Param("supervisor_Code") String supervisorCode,@Param("is_active") boolean is_active, @Param("department_ID") long department_ID);
	
}
