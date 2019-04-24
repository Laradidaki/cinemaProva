package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ordine {

	@Id
	private String code;
	private Date date;
	
	//private Contatto contatto;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	/*public Contatto getContatto() {
	return contatto;
}
public void setContatto(Contatto contatto) {
	this.contatto = contatto;
}*/

}
