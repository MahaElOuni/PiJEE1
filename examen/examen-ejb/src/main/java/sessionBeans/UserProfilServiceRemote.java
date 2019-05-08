package sessionBeans;

import javax.ejb.Remote;

import persistence.User;

@Remote
public interface UserProfilServiceRemote {
	public User getProfilUserById(int id);
}
