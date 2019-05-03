package sessionBeans;

import java.util.List;

import javax.ejb.Local;

import persistence.User;

@Local
public interface AdminServiceLocal {
	public List<User> getPendingUser();
	public void getUsers();
	public String getEtatByIdUser(int id);
	public String getRoleByIdUser(int id);
	public void changeState(int id,String state);

}
