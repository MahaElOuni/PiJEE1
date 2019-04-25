package sessionBeans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class LoginService
 */
@Stateless
@LocalBean
public class LoginService implements LoginServiceRemote, LoginServiceLocal {

    /**
     * Default constructor. 
     */
    public LoginService() {
        // TODO Auto-generated constructor stub
    }

}
