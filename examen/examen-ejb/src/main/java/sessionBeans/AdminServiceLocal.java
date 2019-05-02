package sessionBeans;

import javax.ejb.Local;

@Local
public interface AdminServiceLocal {
	public void getPendingUser();
	public void getUsers();

}
