package ctr;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import persistence.User;
import sessionBeans.AdminServiceRemote;

@ManagedBean
@ViewScoped
public class Adminbean implements Serializable {
	
	@EJB
	AdminServiceRemote adminService;
	
	private List<User> users;
	
	public void acceptUser(int id){
		System.out.println("mel admin bean "+id);
		adminService.changeState(id,"Approved");
	}
	
	public void rejectUser(int id){
		adminService.changeState(id,"Rejected");
	}

	public List<User> getUsers() {
		users= adminService.getPendingUser();
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public AdminServiceRemote getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminServiceRemote adminService) {
		this.adminService = adminService;
	}
	
	
	
	

}
