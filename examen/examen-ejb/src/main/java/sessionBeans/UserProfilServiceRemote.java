package sessionBeans;

import javax.ejb.Remote;

import persistence.User;

@Remote
public interface UserProfilServiceRemote {
	public String getProfilUserById(int id);
}
