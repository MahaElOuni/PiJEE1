package ctr;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import sessionBeans.AdminServiceRemote;
import sessionBeans.LoginService;
import sessionBeans.LoginServiceRemote;
@ManagedBean
@RequestScoped
public class Loginbean implements Serializable {
	private String login; 
	private String password;
	private int user;
	private Boolean loggedIn;
	private String role;
	private String etat;
	public static int idUser;
	@EJB
	LoginServiceRemote loginService;
	
	@EJB
	AdminServiceRemote adminService;
	
	
	public String doLogin()
	{
		String navigateTo = "null";
		user=loginService.loginCheck(login, password);
		idUser=user;
		System.out.println("userrrr="+idUser);

		if ( user != 0 ) {
			
			role = adminService.getRoleByIdUser(user);
			etat = adminService.getEtatByIdUser(user);
			
			if(role.equals("Admin")){
				navigateTo = "/xhtml/admin.xhtml"; 
				loggedIn = true; 
			}
			else{
				if(etat.equals("Pending")){
					FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("    Your request is in court of treatment"));
				}
				else if (etat.equals("Rejected")){
					FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("    Your request is rejected"));
				}
				else{
					navigateTo = "/xhtml/home.xhtml"; 
					loggedIn = true; 	
				}
			}			
		}
		else {
			FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("Bad Credentials"));
		}
	return navigateTo; 
	
	}
	
	public String doLogout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return"/xhtml/login?faces-redirect=true";		
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUser() {
		return user;
	}

	public void setUser(int user) {
		this.user = user;
	}

	public Boolean getLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	
	
	

}
