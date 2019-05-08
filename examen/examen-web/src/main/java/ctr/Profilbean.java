package ctr;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import persistence.User;
import sessionBeans.UserProfilServiceRemote;

@ManagedBean
@ViewScoped
public class Profilbean implements Serializable {

	@EJB
	UserProfilServiceRemote userprofile;
	private User users;
	public User Detail( int id){
		 System.out.println("emchii");
		 return userprofile.getProfilUserById(id);
		
		
		
	}
	public User getUsers() {
		return users;
	}
	public void setUsers(User users) {
		this.users = users;
	}
	public UserProfilServiceRemote getUserprofile() {
		return userprofile;
	}
	public void setUserprofile(UserProfilServiceRemote userprofile) {
		this.userprofile = userprofile;
	}
	
	
}
