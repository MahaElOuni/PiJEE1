package sessionBeans;

import javax.ejb.Local;

@Local
public interface UserProfilServiceLocal {
	public void getProfilUserById(int id);

}
