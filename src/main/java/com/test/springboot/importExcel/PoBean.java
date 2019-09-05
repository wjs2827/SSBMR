package com.test.springboot.importExcel;
import java.math.BigDecimal;

public class PoBean {
	
    private String poNo;

    private String supplierCode;

    private String markUp;

    private BigDecimal afAccount;

    private BigDecimal fob;

    private String skuSize;

    private String qty;

    private String shipDate;

    public PoBean(){
 		this.poNo="PO001";
 		this.supplierCode="PO001";
 		this.markUp="7";
 		this.afAccount=BigDecimal.valueOf(36.2);
 		this.fob=BigDecimal.valueOf(25.3);
 		this.skuSize="S";
 		this.qty="2";
 		this.shipDate="2019-08-29";
    }

	public String getPoNo() {
		return poNo;
	}

	public void setPoNo(String poNo) {
		this.poNo = poNo;
	}

	public String getSupplierCode() {
		return supplierCode;
	}

	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}

	public String getMarkUp() {
		return markUp;
	}

	public void setMarkUp(String markUp) {
		this.markUp = markUp;
	}

	public BigDecimal getAfAccount() {
		return afAccount;
	}

	public void setAfAccount(BigDecimal afAccount) {
		this.afAccount = afAccount;
	}

	public BigDecimal getFob() {
		return fob;
	}

	public void setFob(BigDecimal fob) {
		this.fob = fob;
	}

	public String getSkuSize() {
		return skuSize;
	}

	public void setSkuSize(String skuSize) {
		this.skuSize = skuSize;
	}

	public String getQty() {
		return qty;
	}

	public void setQty(String qty) {
		this.qty = qty;
	}

	public String getShipDate() {
		return shipDate;
	}

	public void setShipDate(String shipDate) {
		this.shipDate = shipDate;
	}
}
