package com.InvyMart.Service;


import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.InvyMart.Model.Supervisor;
import com.InvyMart.Repository.DepartmentRepo;
import com.InvyMart.Repository.SupervisorRepo;



import com.InvyMart.Exception.*;


@Service
public class SupervisorServiceImpl implements SupervisorService{

	@Autowired
	SupervisorRepo supervisorRepo;
	
	@Autowired
	DepartmentRepo departmentRepo;
	
	Supervisor temporaryobject = new Supervisor();
	
	
//	@Override
//	public Supervisor addSupervisor(Supervisor supervisor) {
//		return supervisorRepo.save(supervisor);
//	}
//	
//	@Override
//	public Supervisor updateSupervisor(Supervisor supervisor, long supervisorid) {
//		
//		Supervisor temp = supervisorRepo.findBySupId(supervisorid);
//		return supervisorRepo.save(temp);
//	}
	
//	@Override
//	public Supervisor addSupervisor(Supervisor supervisor) {
//		supervisor.setSupervisorCode(UUID.randomUUID().toString());
//		return supervisorRepo.save(supervisor);
//	}
	
	
	
	@Override
	public String addSupervisor(Supervisor supervisor, long departmentId) {
		
//	long codeString =	supervisor.setSupervisorCode(UUID.randomUUID().toString());
		return departmentRepo.findDepartmentBydepartmentId(departmentId).map(order->{
			supervisorRepo.addSupervisor(supervisor.getName(), supervisor.getSeniorityLevel(), supervisor.getUsername()
					, supervisor.getPassword(), supervisor.getEmailId(), UUID.randomUUID().toString(),supervisor.isActivesupervisor(), departmentId);
			return "success";
		}).orElseThrow(()->new OrderNotFoundException("Department by id " + departmentId + " was not found"));
		
	}
	
	
	//{Manage Supervisor State}
	@Override
	public Supervisor updateSupervisor(Supervisor supervisor, long supervisorid) {

		Supervisor doc = supervisorRepo.findSuperviserBysupervisorId(supervisorid).get();
					
			doc.setName(supervisor.getName());
			doc.setEmailId(supervisor.getEmailId());
			doc.setUsername(supervisor.getUsername());
			doc.setPassword(supervisor.getPassword());
			doc.setSeniorityLevel(supervisor.getSeniorityLevel());
				
		return supervisorRepo.save(doc);
	}
	@Override
	public List<Supervisor> viewSupervisors(){
		return supervisorRepo.findAll();
	}
	
	
	//{Delete Supervisor State}
	@Override
	public Supervisor deleteSupervisor(long supervisorid) {
		
		Supervisor supervisor = supervisorRepo.findSuperviserBysupervisorId(supervisorid).get();
		supervisorRepo.delete(supervisor);
		return supervisor;
	}
	
	@Override
	public Supervisor findSupervisorBysupervisorId(long supervisorid) {
		return supervisorRepo.findSuperviserBysupervisorId(supervisorid).orElseThrow(() -> 
		new UserNotFoundException("User by id " + supervisorid + " was not found"));
	}
	
	
	//{Authenticate State}
	//{logged In}
	
	@Override
	public Supervisor SupervisorLogin(String username, String password) {             
		if(supervisorRepo.isSupervisorExistByUsernameAndPassword(username,password)== 1) {
		
			temporaryobject = supervisorRepo.findSuperviserByusername(username).get();
			temporaryobject.setActive(true);
		return   supervisorRepo.save(temporaryobject);	
//		   return "success";
		}		
		else {
			
			throw new UserNotFoundException("Supervisor by username " + username + " was not found");
		}		
		
	}	

	
	//{Logout State}
	@Override
	public Supervisor logout(boolean isactive) {
		
		if(temporaryobject.isActive()) {
		temporaryobject.setActive(isactive);
		
		return supervisorRepo.save(temporaryobject);
		}
		
		else {
			throw new UserNotFoundException("Supervisor already logout");
		}
		
	}
		
	
}
