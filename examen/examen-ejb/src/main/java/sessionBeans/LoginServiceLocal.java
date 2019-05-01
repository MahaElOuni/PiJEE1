package sessionBeans;

import java.util.List;

import javax.ejb.Local;
import javax.ws.rs.core.Response;

@Local
public interface LoginServiceLocal {
	
	public  void getUsers();
	public int loginCheck(String email,String password);
	
}
