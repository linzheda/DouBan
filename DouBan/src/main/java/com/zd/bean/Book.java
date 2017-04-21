package com.zd.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class Book implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	private Integer b_id;
	private String b_name;
	private Double b_price;
	private String b_author;
	private String b_isbn;
	private Integer b_c_id;
	private Integer b_br_id;
	private String b_c_name;
	private String b_pdfs;
	private String b_description;
	private List<MultipartFile> pdfsUrl;
	
	
	public List<String> getPdfsStringList(){
		 List<String> list=new ArrayList<String>();
		 if(b_pdfs!=null&&b_pdfs.length()>0){
			 String[] strs=b_pdfs.split("-");
			 for(String s:strs){
				 list.add(s.toString());
			 }
		 }
		 return list;
	}
	
	
	
	
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
	public Integer getB_c_id() {
		return b_c_id;
	}
	public void setB_c_id(Integer b_c_id) {
		this.b_c_id = b_c_id;
	}
	public Integer getB_br_id() {
		return b_br_id;
	}
	public void setB_br_id(Integer b_br_id) {
		this.b_br_id = b_br_id;
	}
	public String getB_c_name() {
		return b_c_name;
	}
	public void setB_c_name(String b_c_name) {
		this.b_c_name = b_c_name;
	}
	public String getB_pdfs() {
		return b_pdfs;
	}
	public void setB_pdfs(String b_pdfs) {
		this.b_pdfs = b_pdfs;
	}
	public String getB_description() {
		return b_description;
	}
	public void setB_description(String b_description) {
		this.b_description = b_description;
	}
	public List<MultipartFile> getPdfsUrl() {
		return pdfsUrl;
	}
	public void setPdfsUrl(List<MultipartFile> pdfsUrl) {
		this.pdfsUrl = pdfsUrl;
	}
	@Override
	public String toString() {
		return "Book [b_id=" + b_id + ", b_name=" + b_name + ", b_price=" + b_price + ", b_author=" + b_author
				+ ", b_isbn=" + b_isbn + ", b_c_id=" + b_c_id + ", b_br_id=" + b_br_id + ", b_c_name=" + b_c_name
				+ ", b_pdfs=" + b_pdfs + ", b_description=" + b_description + ", pdfsUrl=" + pdfsUrl + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((b_author == null) ? 0 : b_author.hashCode());
		result = prime * result + ((b_br_id == null) ? 0 : b_br_id.hashCode());
		result = prime * result + ((b_c_id == null) ? 0 : b_c_id.hashCode());
		result = prime * result + ((b_c_name == null) ? 0 : b_c_name.hashCode());
		result = prime * result + ((b_description == null) ? 0 : b_description.hashCode());
		result = prime * result + ((b_id == null) ? 0 : b_id.hashCode());
		result = prime * result + ((b_isbn == null) ? 0 : b_isbn.hashCode());
		result = prime * result + ((b_name == null) ? 0 : b_name.hashCode());
		result = prime * result + ((b_pdfs == null) ? 0 : b_pdfs.hashCode());
		result = prime * result + ((b_price == null) ? 0 : b_price.hashCode());
		result = prime * result + ((pdfsUrl == null) ? 0 : pdfsUrl.hashCode());
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
		Book other = (Book) obj;
		if (b_author == null) {
			if (other.b_author != null)
				return false;
		} else if (!b_author.equals(other.b_author))
			return false;
		if (b_br_id == null) {
			if (other.b_br_id != null)
				return false;
		} else if (!b_br_id.equals(other.b_br_id))
			return false;
		if (b_c_id == null) {
			if (other.b_c_id != null)
				return false;
		} else if (!b_c_id.equals(other.b_c_id))
			return false;
		if (b_c_name == null) {
			if (other.b_c_name != null)
				return false;
		} else if (!b_c_name.equals(other.b_c_name))
			return false;
		if (b_description == null) {
			if (other.b_description != null)
				return false;
		} else if (!b_description.equals(other.b_description))
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
		if (b_pdfs == null) {
			if (other.b_pdfs != null)
				return false;
		} else if (!b_pdfs.equals(other.b_pdfs))
			return false;
		if (b_price == null) {
			if (other.b_price != null)
				return false;
		} else if (!b_price.equals(other.b_price))
			return false;
		if (pdfsUrl == null) {
			if (other.pdfsUrl != null)
				return false;
		} else if (!pdfsUrl.equals(other.pdfsUrl))
			return false;
		return true;
	}


}
