package com.zd.bean;

import java.io.Serializable;

public class Bookrank implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	private Integer br_id;
	private String br_rank;
	private String br_ip;
	private Integer br_scores;
	public Integer getBr_id() {
		return br_id;
	}
	public void setBr_id(Integer br_id) {
		this.br_id = br_id;
	}
	public String getBr_rank() {
		return br_rank;
	}
	public void setBr_rank(String br_rank) {
		this.br_rank = br_rank;
	}
	public String getBr_ip() {
		return br_ip;
	}
	public void setBr_ip(String br_ip) {
		this.br_ip = br_ip;
	}
	public Integer getBr_scores() {
		return br_scores;
	}
	public void setBr_scores(Integer br_scores) {
		this.br_scores = br_scores;
	}
	@Override
	public String toString() {
		return "Bookrank [br_id=" + br_id + ", br_rank=" + br_rank + ", br_ip=" + br_ip + ", br_scores=" + br_scores
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((br_id == null) ? 0 : br_id.hashCode());
		result = prime * result + ((br_ip == null) ? 0 : br_ip.hashCode());
		result = prime * result + ((br_rank == null) ? 0 : br_rank.hashCode());
		result = prime * result + ((br_scores == null) ? 0 : br_scores.hashCode());
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
		Bookrank other = (Bookrank) obj;
		if (br_id == null) {
			if (other.br_id != null)
				return false;
		} else if (!br_id.equals(other.br_id))
			return false;
		if (br_ip == null) {
			if (other.br_ip != null)
				return false;
		} else if (!br_ip.equals(other.br_ip))
			return false;
		if (br_rank == null) {
			if (other.br_rank != null)
				return false;
		} else if (!br_rank.equals(other.br_rank))
			return false;
		if (br_scores == null) {
			if (other.br_scores != null)
				return false;
		} else if (!br_scores.equals(other.br_scores))
			return false;
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
