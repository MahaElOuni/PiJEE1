package persistence;

import org.codehaus.jackson.annotate.JsonProperty;

public class Form {
	
	@JsonProperty("formId")
	private int formId;
	@JsonProperty("formDate")
	private String formDate;
	@JsonProperty("pseudo")
	private String pseudo;
	@JsonProperty("photos")
	private String photos;
	@JsonProperty("cin")
	private String cin;
	@JsonProperty("sex")
	private String sex;
	@JsonProperty("age")
	private int age;
	@JsonProperty("profession")
	private String profession;
	@JsonProperty("mail")
	private String mail;
	@JsonProperty("countrie")
	private String countrie;
	@JsonProperty("address")
	private String address;
	public Form(String formDate, String pseudo, String photos, String cin, String sex, int age, String profession,
			String mail, String countrie, String address, int eventId, String title, String methodeDePayemment,
			String participant) {
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
	public Form(int formId, String formDate, String pseudo, String photos, String cin, String sex, int age,
			String profession, String mail, String countrie, String address, int eventId, String title,
			String methodeDePayemment, String participant) {
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
	public String getParticipant() {
		return participant;
	}
	public void setParticipant(String participant) {
		this.participant = participant;
	}
	@JsonProperty("eventId")
	private int eventId;
	@JsonProperty("title")
	private String title;
	@JsonProperty("methodeDePayemment")
	private String methodeDePayemment;
	@JsonProperty("particiant")
	private String participant;
	

	public Form() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Form [formId=" + formId + ", formDate=" + formDate + ", pseudo=" + pseudo + ", photos=" + photos
				+ ", cin=" + cin + ", sex=" + sex + ", age=" + age + ", profession=" + profession + ", mail=" + mail
				+ ", countrie=" + countrie + ", address=" + address + ", eventId=" + eventId + ", title=" + title
				+ ", methodeDePayemment=" + methodeDePayemment + ", participant=" + participant + "]";
	}
	
	
}
