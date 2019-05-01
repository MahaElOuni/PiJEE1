package sessionBeans;

import javax.ejb.Local;

@Local
public interface FormServiceLocal {

	public void ConsommationGetAll();
	public void ConsommationGetById(int id);
	public void ConsommationGetByEvent(int id);
	public void ConsommationDelete(int id);
	public void ConsommationPost();
}
