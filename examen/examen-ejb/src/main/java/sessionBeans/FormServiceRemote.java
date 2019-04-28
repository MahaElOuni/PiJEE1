package sessionBeans;

import javax.ejb.Remote;

@Remote
public interface FormServiceRemote {

	public void ConsommationGetAll();
	public void ConsommationGetById(int id);
	public void ConsommationGetByEvent(int id);
	public void ConsommationDelete(int id);
	public void ConsommationPost();

}
