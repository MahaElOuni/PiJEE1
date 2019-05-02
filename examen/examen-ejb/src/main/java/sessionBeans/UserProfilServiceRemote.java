package sessionBeans;

import javax.ejb.Remote;

@Remote
public interface UserProfilServiceRemote {
	public void getProfilUserById(int id);
}
