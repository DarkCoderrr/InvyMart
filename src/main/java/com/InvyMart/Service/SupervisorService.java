package com.InvyMart.Service;

import java.util.List;


import com.InvyMart.Model.Supervisor;

public interface SupervisorService {

//	public Supervisor addSupervisor(Supervisor supervisor);
	public String addSupervisor(Supervisor order, long departmentId);
	public Supervisor updateSupervisor(Supervisor supervisor, long supervisorId);
	public List<Supervisor> viewSupervisors();
	public Supervisor deleteSupervisor (long supId);
	public Supervisor findSupervisorBysupervisorId(long supId);
	public Supervisor SupervisorLogin(String username, String password);
	public Supervisor logout(boolean isactive);
}
