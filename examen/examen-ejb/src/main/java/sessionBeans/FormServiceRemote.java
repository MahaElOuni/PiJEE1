package sessionBeans;

import javax.ejb.Remote;

@Remote
public interface FormServiceRemote {
	public String consommationGet();

}
