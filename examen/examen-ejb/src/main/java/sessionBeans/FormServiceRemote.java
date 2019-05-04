package sessionBeans;

import javax.ejb.Remote;

@Remote
public interface FormServiceRemote {
	public String consommationGet();
	public String consommationGetById(int id);
	public String consommationGetByEvent(int id);

}
