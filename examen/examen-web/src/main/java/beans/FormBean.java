package beans;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.ApplicationException;
import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entities.Form;
import sessionBeans.FormService;


@ManagedBean
@ApplicationScoped
public class FormBean implements Serializable{

	private static final long serialVersionUID=1L;
	
	private int formId;
	private int EventId;
	//private SexWeb sex;
	private int age;
	private String profession;
	private String mail;
	private String countrie;
	private String address;
	private Date FormDate;
	private String Pseudo;
	private String photos= "aaa";
	private String cin;
	private boolean Participant;
	private String Title;
	//private MethodeDePayemmentWeb MDPW;
	
	@EJB
	private FormService fs;
	
	private List<Form> lf;
	
	public List<Form> getForms(){
		return lf;
	}
	public void setForms(List<Form> form){
		this.lf=form;
	}
	
	@PostConstruct
	public void init(){
		lf=fs.ConsommationGetAll();
	}
	
	//public L
	public FormBean() {
		// TODO Auto-generated constructor stub
	}
	
	public FormBean( int eventId/*, SexWeb sex*/, int age, String profession, String mail, String countrie,
			String address, Date formDate, String pseudo, String photos, String cin, boolean participant, String title
			/*MethodeDePayemmentWeb mDPW*/) {
		super();
		this.formId = formId;
		EventId = eventId;
		//this.sex = sex;
		this.age = age;
		this.profession = profession;
		this.mail = mail;
		this.countrie = countrie;
		this.address = address;
		FormDate = formDate;
		Pseudo = pseudo;
		this.photos = photos;
		this.cin = cin;
		this.Participant = participant;
		this.Title = title;
		//MDPW = mDPW;
	}

	public int getFormId() {
		return formId;
	}

	public void setFormId(int formId) {
		this.formId = formId;
	}

	public int getEventId() {
		return EventId;
	}

	public void setEventId(int eventId) {
		EventId = eventId;
	}

	/*public SexWeb getSex() {
		return sex;
	}

	public void setSex(SexWeb sex) {
		this.sex = sex;
	}
*/
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

	public Date getFormDate() {
		return FormDate;
	}

	public void setFormDate(Date formDate) {
		FormDate = formDate;
	}

	public String getPseudo() {
		return Pseudo;
	}

	public void setPseudo(String pseudo) {
		Pseudo = pseudo;
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

	public boolean isParticipant() {
		return Participant;
	}

	public void setParticipant(boolean participant) {
		Participant = participant;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}
/*
	public MethodeDePayemmentWeb getMDPW() {
		return MDPW;
	}

	public void setMDPW(MethodeDePayemmentWeb mDPW) {
		MDPW = mDPW;
	}
*/
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

	

}
