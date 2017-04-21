package com.zd.bean;

import java.io.Serializable;

public class Books implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	private Integer b_id;
	private String b_name;
	private Double b_price;
	private String b_author;
	private String b_isbn;
	private Bookrank bookrank;
	private Category category;
	public Integer getB_id() {
		return b_id;
	}
	public void setB_id(Integer b_id) {
		this.b_id = b_id;
	}
	public String getB_name() {
		return b_name;
	}
	public void setB_name(String b_name) {
		this.b_name = b_name;
	}
	public Double getB_price() {
		return b_price;
	}
	public void setB_price(Double b_price) {
		this.b_price = b_price;
	}
	public String getB_author() {
		return b_author;
	}
	public void setB_author(String b_author) {
		this.b_author = b_author;
	}
	public String getB_isbn() {
		return b_isbn;
	}
	public void setB_isbn(String b_isbn) {
		this.b_isbn = b_isbn;
	}
	public Bookrank getBookrank() {
		return bookrank;
	}
	public void setBookrank(Bookrank bookrank) {
		this.bookrank = bookrank;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Book2 [b_id=" + b_id + ", b_name=" + b_name + ", b_price=" + b_price + ", b_author=" + b_author
				+ ", b_isbn=" + b_isbn + ", bookrank=" + bookrank + ", category=" + category + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((b_author == null) ? 0 : b_author.hashCode());
		result = prime * result + ((b_id == null) ? 0 : b_id.hashCode());
		result = prime * result + ((b_isbn == null) ? 0 : b_isbn.hashCode());
		result = prime * result + ((b_name == null) ? 0 : b_name.hashCode());
		result = prime * result + ((b_price == null) ? 0 : b_price.hashCode());
		result = prime * result + ((bookrank == null) ? 0 : bookrank.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Books other = (Books) obj;
		if (b_author == null) {
			if (other.b_author != null)
				return false;
		} else if (!b_author.equals(other.b_author))
			return false;
		if (b_id == null) {
			if (other.b_id != null)
				return false;
		} else if (!b_id.equals(other.b_id))
			return false;
		if (b_isbn == null) {
			if (other.b_isbn != null)
				return false;
		} else if (!b_isbn.equals(other.b_isbn))
			return false;
		if (b_name == null) {
			if (other.b_name != null)
				return false;
		} else if (!b_name.equals(other.b_name))
			return false;
		if (b_price == null) {
			if (other.b_price != null)
				return false;
		} else if (!b_price.equals(other.b_price))
			return false;
		if (bookrank == null) {
			if (other.bookrank != null)
				return false;
		} else if (!bookrank.equals(other.bookrank))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		return true;
	}
	
	
	
	


}
