package persistence;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

public class Form {
	
	
	@JsonProperty("$id")
	private String id;
	@JsonProperty("FormId")
	private int formId;
	@JsonProperty("FormDate")
	private String formDate;
	@JsonProperty("Pseudo")
	private String pseudo;
	@JsonProperty("photos")
	private String photos;
	@JsonProperty("CIN")
	private String cin;
	@JsonProperty("Sex")
	private int sex;
	@JsonProperty("Age")
	private int age;
	@JsonProperty("Profession")
	private String profession;
	@JsonProperty("Mail")
	private String mail;
	@JsonProperty("Countrie")
	private String countrie;
	@JsonProperty("Address")
	private String address;
	@JsonProperty("EventId")
	private int eventId;
	@JsonProperty("Title")
	private String title;
	@JsonProperty("MethodeDePayemment")
	private int methodeDePayemment;
	@JsonProperty("Participant")
	private boolean participant;
	
	
	public int getFormId() {
		return formId;
	}
	public void setFormId(int formId) {
		this.formId = formId;
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
	
	public Form(String formDate, String pseudo, String photos, String cin, int sex, int age, String profession, String mail,
			String countrie, String address, int eventId, String title, int methodeDePayemment,
			boolean participant) {
		super();
		this.formDate = formDate;
		this.pseudo = pseudo;
		this.photos = photos;
		this.cin = cin;
		this.sex = sex;
		this.age = age;
		this.profession = profession;
		this.mail = mail;
		this.countrie = countrie;
		this.address = address;
		this.eventId = eventId;
		this.title = title;
		this.methodeDePayemment = methodeDePayemment;
		this.participant = participant;
	}
	public Form(int formId, String formDate, String pseudo, String photos, String cin, int sex, int age, String profession,
			String mail, String countrie, String address, int eventId, String title,
			int methodeDePayemment, boolean participant) {
		super();
		this.formId = formId;
		this.formDate = formDate;
		this.pseudo = pseudo;
		this.photos = photos;
		this.cin = cin;
		this.sex = sex;
		this.age = age;
		this.profession = profession;
		this.mail = mail;
		this.countrie = countrie;
		this.address = address;
		this.eventId = eventId;
		this.title = title;
		this.methodeDePayemment = methodeDePayemment;
		this.participant = participant;
	}
	public String getFormDate() {
		return formDate;
	}
	public void setFormDate(String formDate) {
		this.formDate = formDate;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public int getMethodeDePayemment() {
		return methodeDePayemment;
	}
	public void setMethodeDePayemment(int methodeDePayemment) {
		this.methodeDePayemment = methodeDePayemment;
	}
	public boolean isParticipant() {
		return participant;
	}
	public void setParticipant(boolean participant) {
		this.participant = participant;
	}
	public Form() {
		// TODO Auto-generated constructor stub
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Form [formId=" + formId + ", formDate=" + formDate + ", pseudo=" + pseudo + ", photos=" + photos
				+ ", cin=" + cin + ", sex=" + sex + ", age=" + age + ", profession=" + profession + ", mail=" + mail
				+ ", countrie=" + countrie + ", address=" + address + ", eventId=" + eventId + ", title=" + title
				+ ", methodeDePayemment=" + methodeDePayemment + ", participant=" + participant + "]";
	}
	
	
}
