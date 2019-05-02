package ctr;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import sessionBeans.LoginService;

public class LoginBean implements Serializable {
	private String login; 
	private String password;
	private int user;
	private Boolean loggedIn;
	@EJB
	LoginService loginService;
	
	public String doLogin()
	{
		String navigateTo = "null";
		user=loginService.loginCheck(login, password);
		if (user != 0 ) {
			navigateTo = "/xhtml/home?faces-redirect=true"; 
			loggedIn = true; 		
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

	public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
	
	

}
