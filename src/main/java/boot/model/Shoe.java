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

@Entity(name="shoes")
public class Shoe implements Serializable {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(length=45)
	private String model;
	@Column(length=45)
	private String description;
	@Column(length=45)
	private String price;
	@Column(length=45)
	private String size;

	public Shoe() {
		this("","","","");
	}

	public Shoe( String model, String description, String price, String size) {
		super();
		this.model = model;
		this.description = description;
		this.price = price;
		this.size = size;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Shoe [id=" + id + ", model=" + model + ", description=" + description + ", price=" + price + ", size="
				+ size + "]";
	}
	
	
	
	
	
	

	
	
	
}
