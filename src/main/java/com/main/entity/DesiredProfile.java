package com.main.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.main.vo.DesiredProfileVo;

@Entity
@Table(name="T_DESIRED_PROFILE")
public class DesiredProfile {

	@Id
	@Column(name="USER_ID",length=20)
	String id;
	
	@OneToMany(cascade=CascadeType.ALL)	
	List<AgeRange> agerange;
	
	@OneToMany(cascade=CascadeType.ALL)	
	List<Income> income;
	
	@OneToMany(cascade=CascadeType.ALL)	
	List<Qualification> qualification;

	@OneToMany(cascade=CascadeType.ALL)	
	List<Religion> religion;
	
	@OneToMany(cascade=CascadeType.ALL)	
	List<HeightRange> heightRange;
	
	@OneToMany(cascade=CascadeType.ALL)	
	List<MaritalStatus> maritalStatus;
	
	@Column(length=20)
	String challenged;
	
	@Column(length=20)
	String dietaryhabits="";
	
	@Column(length=20)
	String drinking;
	
	/*@ElementCollection
	@Column(length=20)
	List<String> heightrange;
	
	@ElementCollection
	@Column(length=20)
	List<String> income;
	
	@ElementCollection
	@Column(length=20)
	List<String> mariatalstatus;
	
	
	@ElementCollection
	@Column(length=20)
	List<String> qualification;
	
	
	@ElementCollection
	@Column(length=20)
	List<String> religion;
	*/
	@Column(length=20)
	String smoking;
	
	
	public List<AgeRange> getAgerange() {
		return agerange;
	}
	public void setAgerange(List<AgeRange> agerange) {
		this.agerange = agerange;
	}
	public String getChallenged() {
		return challenged;
	}
	public void setChallenged(String challenged) {
		this.challenged = challenged;
	}
	public String getDietaryhabits() {
		return dietaryhabits;
	}
	public void setDietaryhabits(String dietaryhabits) {
		this.dietaryhabits = dietaryhabits;
	}
	public String getDrinking() {
		return drinking;
	}
	public void setDrinking(String drinking) {
		this.drinking = drinking;
	}
	/*public List<String> getHeightrange() {
		return heightrange;
	}
	public void setHeightrange(List<String> heightrange) {
		this.heightrange = heightrange;
	}
	public List<String> getIncome() {
		return income;
	}
	public void setIncome(List<String> income) {
		this.income = income;
	}
	public List<String> getMariatalstatus() {
		return mariatalstatus;
	}
	public void setMariatalstatus(List<String> mariatalstatus) {
		this.mariatalstatus = mariatalstatus;
	}
	public List<String> getQualification() {
		return qualification;
	}
	public void setQualification(List<String> qualification) {
		this.qualification = qualification;
	}
	public List<String> getReligion() {
		return religion;
	}
	public void setReligion(List<String> religion) {
		this.religion = religion;
	}*/
	public String getSmoking() {
		return smoking;
	}
	public void setSmoking(String smoking) {
		this.smoking = smoking;
	}
	@Override
	public String toString() {
		return "DesiredProfile [id=" + id + ", agerange=" + agerange + ", challenged=" + challenged + ", dietaryhabits="
				+ dietaryhabits + ", drinking=" + drinking + ", smoking=" + smoking + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<Income> getIncome() {
		return income;
	}
	public void setIncome(List<Income> income) {
		this.income = income;
	}
	public List<Qualification> getQualification() {
		return qualification;
	}
	public void setQualification(List<Qualification> qualification) {
		this.qualification = qualification;
	}
	public List<Religion> getReligion() {
		return religion;
	}
	public void setReligion(List<Religion> religion) {
		this.religion = religion;
	}
	public List<HeightRange> getHeightRange() {
		return heightRange;
	}
	public void setHeightRange(List<HeightRange> heightRange) {
		this.heightRange = heightRange;
	}
	public List<MaritalStatus> getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(List<MaritalStatus> maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	
	
	
	
}
