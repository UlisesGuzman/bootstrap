package mx.utng.practice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity  @Table(name="chairs")
public class Chair {
	@Id @GeneratedValue
	private Long id;
	@Column(length =50)
	private String style;
	@Column(length =20)
	private String color;
	@Column(length =20)
	private String price;
	@Column(length =20)
	private int size;
	
	public Chair(String style, String color, String price, int size) {
		super();
		this.style = style;
		this.color = color;
		this.price = price;
		this.size = size;
	}

	public Chair() {
		this("","","",0);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
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

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Chair [id=" + id + ", style=" + style + ", color=" + color + ", price=" + price + ", size=" + size
				+ "]";
	}
	
}
