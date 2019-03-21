package com.main.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.main.entity.AgeRange;
import com.main.entity.DesiredProfile;
import com.main.entity.HeightRange;
import com.main.entity.Income;
import com.main.entity.MaritalStatus;
import com.main.entity.Qualification;
import com.main.entity.Religion;

public class DesiredProfileVo {

	String id;
	
	List<String> agerange;
	
	String challenged;
	
	String dietaryhabit;
	
	String drinking;
	
	List<String> heightrange;
	
	List<String> income;
	
	List<String> mariatalstatus;
	
	List<String> religion;
	
	List<String> qualification;
	
	String smoking;
	
	
	public List<String> getAgerange() {
		return agerange;
	}
	public void setAgerange(List<String> agerange) {
		this.agerange = agerange;
	}
	public String getChallenged() {
		return challenged;
	}
	public void setChallenged(String challenged) {
		this.challenged = challenged;
	}
	public String getDietaryhabit() {
		return dietaryhabit;
	}
	public void setDietaryhabit(String dietaryhabits) {
		this.dietaryhabit = dietaryhabits;
	}
	public String getDrinking() {
		return drinking;
	}
	public void setDrinking(String drinking) {
		this.drinking = drinking;
	}

	public String getSmoking() {
		return smoking;
	}
	public void setSmoking(String smoking) {
		this.smoking = smoking;
	}
	
	
	public DesiredProfile getEntity(){
		DesiredProfile desiredProfile= new DesiredProfile();
		
		desiredProfile.setChallenged(this.challenged);
		desiredProfile.setDietaryhabits(this.dietaryhabit);
		desiredProfile.setDrinking(this.drinking);
		desiredProfile.setSmoking(this.smoking);
	
		List<AgeRange> agerange = new ArrayList<AgeRange>();
		this.agerange.forEach(x -> {
			AgeRange agerangevo = new AgeRange();
			agerangevo.setAgerange(x);
			
			agerange.add(agerangevo);
		});	
		
		List<HeightRange> heightrange = new ArrayList<HeightRange>();
		this.heightrange.forEach(x -> {
			HeightRange heightrangevo = new HeightRange();
			heightrangevo.setRange(x);
			
			heightrange.add(heightrangevo);
		});	
		
		
		List<Income> income = new ArrayList<Income>();
		this.income.forEach(x -> {
			Income incomevo= new Income();
			incomevo.setRange(x);
			income.add(incomevo);
		});	
		

		List<Religion> religion= new ArrayList<Religion>();
		this.religion.forEach(x -> {
			Religion religionvo= new Religion();
			religionvo.setReligion(x);
			religion.add(religionvo);
		});	
		

		List<Qualification> qualification= new ArrayList<Qualification>();
		this.qualification.forEach(x -> {
			Qualification qualificationvo= new Qualification  ();
			qualificationvo.setQualification(x);
			qualification.add(qualificationvo);
		});
		

		List<MaritalStatus> maritalStatus= new ArrayList<MaritalStatus>();
		this.mariatalstatus.forEach(x -> {
			MaritalStatus maritalstatusvo= new MaritalStatus();
			maritalstatusvo.setStatus(x);
			maritalStatus.add(maritalstatusvo);
		});
		
		desiredProfile.setAgerange(agerange);
		desiredProfile.setIncome(income);
		desiredProfile.setReligion(religion);
		desiredProfile.setQualification(qualification);
		desiredProfile.setMaritalStatus(maritalStatus);
		desiredProfile.setHeightRange(heightrange);
		return desiredProfile;
	}
	
	@Override
	public String toString() {
		return "DesiredProfile [id=" + id + ", agerange=" + agerange + ", challenged=" + challenged + ", dietaryhabits="
				+ dietaryhabit + ", drinking=" + drinking + ", smoking=" + smoking + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<String> getHeightrange() {
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
	public List<String> getReligion() {
		return religion;
	}
	public void setReligion(List<String> religion) {
		this.religion = religion;
	}
	public List<String> getQualification() {
		return qualification;
	}
	public void setQualification(List<String> qualification) {
		this.qualification = qualification;
	}
	
	
	public static DesiredProfileVo getVo(DesiredProfile entity){
		DesiredProfileVo vo  = new DesiredProfileVo();
		vo.setAgerange(entity.getAgerange().stream().map( x-> x.getAgerange()).collect(Collectors.toList()));
		vo.setChallenged(entity.getChallenged());
		vo.setDietaryhabit(entity.getDietaryhabits());
		vo.setDrinking(entity.getDrinking());
		vo.setHeightrange(entity.getHeightRange().stream().map(x->x.getRange()).collect(Collectors.toList()));
		vo.setId(entity.getId());
		vo.setIncome(entity.getIncome().stream().map(x->x.getRange()).collect(Collectors.toList()));
		vo.setMariatalstatus(entity.getMaritalStatus().stream().map(x->x.getStatus()).collect(Collectors.toList()));
		vo.setQualification(entity.getQualification().stream().map(x->x.getQualification()).collect(Collectors.toList()));
		vo.setReligion(entity.getReligion().stream().map(x->x.getReligion()).collect(Collectors.toList()));
		vo.setSmoking(entity.getSmoking());
		return vo;
	}
	
}
