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
	private String profession;
	private String countrie;
	private String address;
	private Boolean participant;
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
