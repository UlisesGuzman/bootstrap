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

@Entity(name="memberships")
public class Membership implements Serializable {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(length=45)
	private String lastRenewalDate;
	@Column(length=45)
	private String memberSince;
	@Column(length=45)
	private String membershipType;
	
	public Membership(String lastRenewalDate, String memberSince, String membershipType) {
		super();
		this.lastRenewalDate = lastRenewalDate;
		this.memberSince = memberSince;
		this.membershipType = membershipType;
	}
	
	public Membership(){
		this("","","");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLastRenewalDate() {
		return lastRenewalDate;
	}

	public void setLastRenewalDate(String lastRenewalDate) {
		this.lastRenewalDate = lastRenewalDate;
	}

	public String getMemberSince() {
		return memberSince;
	}

	public void setMemberSince(String memberSince) {
		this.memberSince = memberSince;
	}

	public String getMembershipType() {
		return membershipType;
	}

	public void setMembershipType(String membershipType) {
		this.membershipType = membershipType;
	}

	@Override
	public String toString() {
		return "Membership [id=" + id + ", lastRenewalDate=" + lastRenewalDate + ", memberSince=" + memberSince
				+ ", membershipType=" + membershipType + "]";
	}	
}
