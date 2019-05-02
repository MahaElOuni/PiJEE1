package sessionBeans;

import java.util.List;

import javax.ejb.Remote;

import entities.Form;

@Remote
public interface FormServiceRemote {

	public List<Form> ConsommationGetAll();
	public void ConsommationGetById(int id);
	public void ConsommationGetByEvent(int id);
	public void ConsommationDelete(int id);
	public void ConsommationPost();

}
