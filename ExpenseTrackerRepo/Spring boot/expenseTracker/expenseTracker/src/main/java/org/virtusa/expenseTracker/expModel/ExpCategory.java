package org.virtusa.expenseTracker.expModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="expcategory")
public class ExpCategory {

	@Id
	@Column(name="id")	
	private Integer id;
	@Column(name="category")	
	private String category;
	
	public ExpCategory()
	{
		
	}
	public ExpCategory(Integer id, String category) {
		super();
		this.id = id;
		this.category = category;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
}
