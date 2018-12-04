package Capstone;

import java.math.BigDecimal;

public class Check {

	private String checkNum;
	private String dateOfCheck;
	private String routingNum;
	private String healthInsProv;
	private BigDecimal checkTotal;
	private BigDecimal checkRemain; 

	
	
	public Check(String checkNum, String dateOfCheck, String routingNum, String healthInsProv,
			BigDecimal checkTotal, BigDecimal checkRemain) {
		super();
		this.checkNum = checkNum;
		this.dateOfCheck = dateOfCheck;
		this.routingNum = routingNum;
		this.healthInsProv = healthInsProv;
		this.checkTotal = checkTotal;
		this.checkRemain = checkRemain;
	}

	public String getCheckNum() {
		return checkNum;
	}

	public void setCheckNum(String checkNum) {
		this.checkNum = checkNum;
	}

	public String getDateOfCheck() {
		return dateOfCheck;
	}

	public void setDateOfCheck(String dateOfCheck) {
		this.dateOfCheck = dateOfCheck;
	}

	public String getRoutingNum() {
		return routingNum;
	}

	public void setRoutingNum(String routingNum) {
		this.routingNum = routingNum;
	}

	public String getHealthInsProv() {
		return healthInsProv;
	}

	public void setHealthInsProv(String healthInsProv) {
		this.healthInsProv = healthInsProv;
	}

	public BigDecimal getCheckTotal() {
		return checkTotal;
	}

	public void setCheckTotal(BigDecimal checkTotal) {
		this.checkTotal = checkTotal;
	}

	public BigDecimal getCheckRemain() {
		return checkRemain;
	}
	
	public void setCheckRemain(BigDecimal checkRemain) {
		this.checkRemain = checkRemain;
	}
	@Override
	public String toString() {
		return String
				.format("Check [checkNum=%s, dateOfCheck=%s, routingNum=%s, healthInsProv=%s, checkTotal=%s, checkRemain=%s]",
						checkNum, dateOfCheck, routingNum, healthInsProv, checkTotal, checkRemain);
	}
	
}
