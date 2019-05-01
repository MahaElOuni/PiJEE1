package sessionBeans;

import java.util.List;

import javax.ejb.Remote;
import javax.ws.rs.core.Response;

@Remote
public interface LoginServiceRemote {
	public void getUsers();
	 public int loginCheck(String email,String password);
}
