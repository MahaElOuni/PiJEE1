package sessionBeans;

import javax.ejb.Remote;

@Remote
public interface AdminServiceRemote {
	public void getPendingUser();
	public void getUsers();

}
