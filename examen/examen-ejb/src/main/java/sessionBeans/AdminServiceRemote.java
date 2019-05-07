package sessionBeans;

import java.util.List;

import javax.ejb.Remote;

import persistence.User;

@Remote
public interface AdminServiceRemote {
	
	public List<User> getPendingUser();
	public void getUsers();
	public String getEtatByIdUser(int id);
	public String getRoleByIdUser(int id);
	public void changeState(int id,String state);
	public String getAllUsers();
	

}
