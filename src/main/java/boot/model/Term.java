package boot.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="terms")
public class Term implements Serializable {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(length=45)
	private String name;
	@Column(length=45)
	private String type;
	@Column(length=45)
	private String acc;
	@Column(length=45)
	private String obsolete;
	@Column(length=45)
	private String root;
	@Column(length=45)
	private String relation;
	
	
	public Term(String name, String type, String acc, String obsolete, String root, String relation) {
		super();
		this.name = name;
		this.type = type;
		this.acc = acc;
		this.obsolete = obsolete;
		this.root = root;
		this.relation = relation;
	}

	public Term(){
		this("","","","","","");
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAcc() {
		return acc;
	}

	public void setAcc(String acc) {
		this.acc = acc;
	}

	public String getObsolete() {
		return obsolete;
	}

	public void setObsolete(String obsolete) {
		this.obsolete = obsolete;
	}

	public String getRoot() {
		return root;
	}

	public void setRoot(String root) {
		this.root = root;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	@Override
	public String toString() {
		return "Term [id=" + id + ", name=" + name + ", type=" + type + ", acc=" + acc + ", obsolete=" + obsolete
				+ ", root=" + root + ", relation=" + relation + "]";
	}
	
}
