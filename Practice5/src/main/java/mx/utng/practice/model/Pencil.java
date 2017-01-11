package mx.utng.practice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity  @Table(name="pencils")
public class Pencil {
	@Id @GeneratedValue
	private Long id;
	@Column(length =20)
	private String color;
	@Column(length =20)
	private String price;
	@Column(length =50)
	private String description;
	@Column(length =20)
	private int size;
	
	public Pencil(String color, String price, String description, int size) {
		super();
		this.color = color;
		this.price = price;
		this.description = description;
		this.size = size;
	}


	public Pencil() {
		this("","","",0);
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}

	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}


	@Override
	public String toString() {
		return "Pencil [id=" + id + ", color=" + color + ", price=" + price + ", description=" + description + ", size="
				+ size + "]";
	}
}
