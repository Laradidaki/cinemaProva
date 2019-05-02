package model;

import java.util.ArrayList;
import java.util.List;


public class Film {

	private Integer idFilm;
	private String nomeFilm;
	private String durataFilm;
	private String annoFilm;
	private String costoFilm;
	private List<Attore> attori;
	private List<Regista> registi;
	
	
	/**
	 * @return the registi
	 */
	public List<Regista> getRegisti() {
		return registi;
	}
	/**
	 * @param registi the registi to set
	 */
	public void setRegisti(List<Regista> registi) {
		this.registi = registi;
	}
	
	public void addRegista(Regista r) {
		if (this.registi == null) {
			this.registi = new ArrayList<Regista>();
		}
		this.registi.add(r);
	}
	/**
	 * @return the attori
	 */
	public List<Attore> getAttori() {
		return attori;
	}
	/**
	 * @param attori the attori to set
	 */
	public void setAttori(List<Attore> attori) {
		this.attori = attori;
	}
	
	public void addAttore(Attore a) {
		if (this.attori == null) {
			this.attori = new ArrayList<Attore>();
		}
		this.attori.add(a);
	}
	/**
	 * @return the idFilm
	 */
	public Integer getIdFilm() {
		return idFilm;
	}
	/**
	 * @param idFilm the idFilm to set
	 */
	public void setIdFilm(Integer idFilm) {
		this.idFilm = idFilm;
	}
	/**
	 * @return the nomeFilm
	 */
	public String getNomeFilm() {
		return nomeFilm;
	}
	/**
	 * @param nomeFilm the nomeFilm to set
	 */
	public void setNomeFilm(String nomeFilm) {
		this.nomeFilm = nomeFilm;
	}
	/**
	 * @return the durataFilm
	 */
	public String getDurataFilm() {
		return durataFilm;
	}
	/**
	 * @param durataFilm the durataFilm to set
	 */
	public void setDurataFilm(String durataFilm) {
		this.durataFilm = durataFilm;
	}
	/**
	 * @return the annoFilm
	 */
	public String getAnnoFilm() {
		return annoFilm;
	}
	/**
	 * @param annoFilm the annoFilm to set
	 */
	public void setAnnoFilm(String annoFilm) {
		this.annoFilm = annoFilm;
	}
	/**
	 * @return the costoFilm
	 */
	public String getCostoFilm() {
		return costoFilm;
	}
	/**
	 * @param costoFilm the costoFilm to set
	 */
	public void setCostoFilm(String costoFilm) {
		this.costoFilm = costoFilm;
	}
	
	
}
