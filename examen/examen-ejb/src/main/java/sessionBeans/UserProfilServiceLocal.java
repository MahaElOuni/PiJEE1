package sessionBeans;

import javax.ejb.Local;

import persistence.User;

@Local
public interface UserProfilServiceLocal {
	public User getProfilUserById(int id);

}
