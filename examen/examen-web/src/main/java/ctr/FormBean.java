package ctr;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.primefaces.json.JSONArray;
import org.primefaces.json.JSONObject;

import persistence.Form;
import sessionBeans.FormService;

@ManagedBean(name="formBean")
@SessionScoped
public class FormBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private int formId;
	private String formDate;
	private String pseudo;
	private String photos;
	private String cin;
	private String sex;
	private int age;
	private String profession;
	private String mail;
	private String countrie; 
	private String address;
	private int eventId;
	private String title;
	private String methodeDePayemment;
	private String participant;
	
	private Form o;

	public Form getO() {
		return o;
	}

	public void setO(Form o) {
		this.o = o;
	}

	public String getParticipant() {
		return participant;
	}

	public void setParticipant(String participant) {
		this.participant = participant;
	}

	private String part= null;
	public String getPart() {
		return part;
	}

	public void setPart(String part) {
		this.part = part;
	}

	@EJB
	FormService formService;
	
	
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Object> getAll(){
		String lr= formService.consommationGet();
		JSONArray array= new JSONArray(lr);
		ArrayList<Object> listdata=new ArrayList<Object>();
		
		if(array!= null){
			for(int i=0; i<array.length(); i++){
				
				
				listdata.add(array.get(i));

				
			}
		}
		return listdata;
	}

	
	public String getById(int id){
			o= formService.getById(id);
		setFormId(o.getFormId());
		setEventId(o.getEventId());
		setTitle(o.getTitle());
		setPseudo(o.getPseudo());
		setCin(o.getCin());
		setMail(o.getMail());
		setAge(o.getAge());
		setProfession(o.getProfession());
		setCountrie(o.getCountrie());
		setAddress(o.getAddress());
		setParticipant(o.getParticipant());
		
		
		
		return "DetailsForms.jsf?faces-redirect=true";
	}



	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Object> getByEventId(int id){
		String lr= formService.consommationGetByEvent();
		JSONArray array= new JSONArray(lr);
		ArrayList<Object> listdata=new ArrayList<Object>();
		
		if(array!= null){
			for(int i=0; i<array.length(); i++){
				
				if(array.getString(13)=="0")
					part="Waiting";
					else
						part="Participant";
					
				listdata.add(array.get(i));

				
			}
		}
		return listdata;
	}

	
	
	public int getFormId() {
		return formId;
	}

	public void setFormId(int formId) {
		this.formId = formId;
	}

	public String getFormDate() {
		return formDate;
	}

	public void setFormDate(String formDate) {
		this.formDate = formDate;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getPhotos() {
		return photos;
	}

	public void setPhotos(String photos) {
		this.photos = photos;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getCountrie() {
		return countrie;
	}

	public void setCountrie(String countrie) {
		this.countrie = countrie;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMethodeDePayemment() {
		return methodeDePayemment;
	}

	public void setMethodeDePayemment(String methodeDePayemment) {
		this.methodeDePayemment = methodeDePayemment;
	}

	
	public FormService getFormService() {
		return formService;
	}

	public void setFormService(FormService formService) {
		this.formService = formService;
	}
}
