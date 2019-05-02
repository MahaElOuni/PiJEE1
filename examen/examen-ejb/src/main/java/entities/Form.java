package entities;

import java.io.Serializable;
import java.lang.Boolean;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Form
 *
 */
@Entity


public class Form implements Serializable {

	@EmbeddedId
	private FormPK id;
	
	private String pseudo;
	private String photos;
	private String cin;
	private int age;
	//@Enumerated(EnumType.)
	private String  sex;
	private String profession;
	private String countrie;
	private String address;
	private Boolean participant;
	private String mdp;
	
	private int eventId;
	private String Title;
	public FormPK getId() {
		return id;
	}
	public void setId(FormPK id) {
		this.id = id;
	}
	/*public Sex getSex() {
		return sex;
	}
	public void setSex(Sex sex) {
		this.sex = sex;
	}
	public MethodeDePayemment getMdp() {
		return mdp;
	}
	public void setMdp(MethodeDePayemment mdp) {
		this.mdp = mdp;
	}
	*/

	private static final long serialVersionUID = 1L;

	public Form() {
		super();
	}   
	public String getPseudo() {
		return this.pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}   
	public String getPhotos() {
		return this.photos;
	}

	public void setPhotos(String photos) {
		this.photos = photos;
	}   
	public String getCin() {
		return this.cin;
	}

	@Override
	public String toString() {
		return "Form [id=" + id + ", pseudo=" + pseudo + ", photos=" + photos + ", cin=" + cin + ", age=" + age
				+ ", sex=" + sex + ", profession=" + profession + ", countrie=" + countrie + ", address=" + address
				+ ", participant=" + participant + ", mdp=" + mdp + ", eventId=" + eventId + ", Title=" + Title
				+ ", getId()=" + getId()/* + ", getSex()=" + getSex() + ", getMdp()=" + getMdp() */+ ", getPseudo()="
				+ getPseudo() + ", getPhotos()=" + getPhotos() + ", getCin()=" + getCin() + ", getAge()=" + getAge()
				+ ", getProfession()=" + getProfession() + ", getCountrie()=" + getCountrie() + ", getAddress()="
				+ getAddress() + ", getParticipant()=" + getParticipant() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	public Form(String pseudo, String photos, String cin, int age, Sex sex, String profession, String countrie,
			String address, Boolean participant, MethodeDePayemment mdp) {
		super();
		this.pseudo = pseudo;
		this.photos = photos;
		this.cin = cin;
		this.age = age;
		//this.sex = sex;
		this.profession = profession;
		this.countrie = countrie;
		this.address = address;
		this.participant = participant;
		//this.mdp = mdp;
		
	}
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}   
	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}   
	public String getProfession() {
		return this.profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}   
	public String getCountrie() {
		return this.countrie;
	}

	public void setCountrie(String countrie) {
		this.countrie = countrie;
	}   
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}   
	public Boolean getParticipant() {
		return this.participant;
	}

	public void setParticipant(Boolean participant) {
		this.participant = participant;
	}
   
}
