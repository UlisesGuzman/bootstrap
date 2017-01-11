package mx.utng.practice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity  @Table(name="countries")
public class Country {
	@Id @GeneratedValue
	private Long id;
	@Column(length =50)
	private String countryName;
	@Column(length =20)
	private int regionId;
	
	public Country(String countryName, int regionId) {
		super();
		this.countryName = countryName;
		this.regionId = regionId;
	}
	
	public Country() {
		this("",0);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public int getRegionId() {
		return regionId;
	}

	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", countryName=" + countryName + ", regionId=" + regionId + "]";
	}
	
}
