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

@Entity(name="products")
public class Product implements Serializable {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(length=45)
	private String line;
	@Column(length=45)
	private String family;
	@Column(length=45)
	private String category;
	@Column(length=45)
	private String name;
	@Column(length=45)
	private String sku;
	@Column(length=45)
	private String publisher;

	public Product() {
		this("","","","","","");
	}

	public Product(String line, String family, String category, String name, String sku, String publisher) {
		super();
		this.line = line;
		this.family = family;
		this.category = category;
		this.name = name;
		this.sku = sku;
		this.publisher = publisher;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", line=" + line + ", family=" + family + ", category=" + category + ", name="
				+ name + ", sku=" + sku + ", publisher=" + publisher + "]";
	}
	
	
}
