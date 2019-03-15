package bean;

public class UserAddress {
	private String consigneeName;
	private String consigneePhone;
	private String consigneeCity;
	private String consigneeAddress;
	private String consigneePostcode;
	public String getConsigneeName() {
		return consigneeName;
	}
	public void setConsigneeName(String consigneeName) {
		this.consigneeName = consigneeName;
	}
	public String getConsigneePhone() {
		return consigneePhone;
	}
	public void setConsigneePhone(String consigneePhone) {
		this.consigneePhone = consigneePhone;
	}
	public String getConsigneeCity() {
		return consigneeCity;
	}
	public void setConsigneeCity(String consigneeCity) {
		this.consigneeCity = consigneeCity;
	}
	public String getConsigneeAddress() {
		return consigneeAddress;
	}
	public void setConsigneeAddress(String consigneeAddress) {
		this.consigneeAddress = consigneeAddress;
	}
	public String getConsigneePostcode() {
		return consigneePostcode;
	}
	public void setConsigneePostcode(String consigneePostcode) {
		this.consigneePostcode = consigneePostcode;
	}

	public String toString() {
		return consigneeName+","+consigneePhone+","+consigneeAddress+","+consigneePostcode ;
	}
	
	
	
	
}
