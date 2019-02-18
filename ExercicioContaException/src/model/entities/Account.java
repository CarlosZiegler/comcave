package model.entities;

import model.domainExceptions.DomainExceptions;

public class Account {

	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;

	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		super();
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}

	@Override
	public String toString() {
		return "Account number= " + number + ", holder= " + holder + ", balance= " + balance + ", withdrawLimit= "
				+ withdrawLimit + "]";
	}

	public void deposit(Double amount) {
		this.balance +=amount; 
	}

	public void witchdraw(Double amount) throws DomainExceptions {
		if (this.withdrawLimit < amount) {
			throw new DomainExceptions("Error, Limit is litte als Amount");
		}
		if (this.balance == 0 || (this.balance - amount < 0)) {
			throw new DomainExceptions("Error, balance is :  "+ getBalance());
		
		}
		this.balance -= amount;
	}

}
