package sessionBeans;

import javax.ejb.Remote;

@Remote
public interface LoginServiceRemote {
	void Login();

}
