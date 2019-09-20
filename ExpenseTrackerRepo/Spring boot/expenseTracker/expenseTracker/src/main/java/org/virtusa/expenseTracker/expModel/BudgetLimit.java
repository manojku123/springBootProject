package org.virtusa.expenseTracker.expModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="budgetlimit")
public class BudgetLimit {

	@Id
	@Column(name="itemNo")
	private Integer itemNo;
	@Column(name="item")
	private String item;
	@Column(name="amount")
	private Integer amount;
	@Column(name="date")
	private String date;
	
	public BudgetLimit() {}
	public BudgetLimit(Integer itmNo,String item, Integer amount, String date) {
		super();
		this.itemNo = itmNo;
		this.item = item;
		this.amount = amount;
		this.date = date;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Integer getItemNo() {
		return itemNo;
	}
	public void setItemNo(Integer itemNo) {
		this.itemNo = itemNo;
	}
	
}
