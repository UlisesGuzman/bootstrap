package boot.model;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="lions")
public class Lion implements Serializable {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(length=45)
	private String name;
	@Column(length=45)
	private String color;
	@Temporal(TemporalType.DATE)
	@Column(name="birth_date")
	private Date birthdate;
	private boolean alive;
	
	public Lion(){
		this("","",new Date(),false);
	}

	public Lion(String name, String color, Date birthdate, boolean alive) {
		super();
		this.name = name;
		this.color = color;
		this.birthdate = birthdate;
		this.alive = alive;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	@Override
	public String toString() {
		return "Lion [id=" + id + ", name=" + name + ", color=" + color + ", birthdate=" + birthdate + ", alive="
				+ alive + "]";
	}	
	
}
