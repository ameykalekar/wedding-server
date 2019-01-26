package com.main.vo;

import com.main.entity.ProfileEntity;

public class ProfileVo {

	private long id;
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	private String placeOfBirth;
	private String religion;
	private String caste;
	private String marritalStatus;
	private String heightFeet="0";
	private String heightInch="0";
	private String bodyType;
	private String complexion;
	private String challenged;
	private String highestDegree;
	private String collegeName;
	private String schoolName;
	private String occupation;
	private Integer annualIncome;
	private String companyName;
	private String drinking;
	private String smoking;
	private String motherName;
	private String fatherName;
	private String fatherIs;
	private String motherIs;
	private int numberOfSisters;
	private int numberOfBrothers;
	private String gothra;
	private double familyIncome;
	private String familyType;
	private String familyValues;
	private String livingWithParents;
	private String contactNumber;
	private String address;
	private String homeAddress;
	private String dietaryHabits;
	private String drinkingHabits;
	private String smokingHabits;
	private String skinType;
	private String bloodGroup;
	private String maternalGothra;
	private String aboutMe;
	
	private String picture1;
	private String email;
	private String gender;
	private Integer age;
	private String ageRange;
	private Integer start =0 ;
	private Integer maxLimit=100;

	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getPlaceOfBirth() {
		return placeOfBirth;
	}
	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}
	public String getReligion() {
		return religion;
	}
	public void setReligion(String religion) {
		this.religion = religion;
	}
	public String getCaste() {
		return caste;
	}
	public void setCaste(String caste) {
		this.caste = caste;
	}
	public String getMarritalStatus() {
		return marritalStatus;
	}
	public void setMarritalStatus(String marritalStatus) {
		this.marritalStatus = marritalStatus;
	}
	public String getHeightFeet() {
		return heightFeet;
	}
	public void setHeightFeet(String heightFeet) {
		this.heightFeet = heightFeet;
	}
	public String getHeightInch() {
		return heightInch;
	}
	public void setHeightInch(String heightInch) {
		this.heightInch = heightInch;
	}
	public String getBodyType() {
		return bodyType;
	}
	public void setBodyType(String bodyType) {
		this.bodyType = bodyType;
	}
	public String getComplexion() {
		return complexion;
	}
	public void setComplexion(String complexion) {
		this.complexion = complexion;
	}
	public String getChallenged() {
		return challenged;
	}
	public void setChallenged(String challenged) {
		this.challenged = challenged;
	}
	public String getHighestDegree() {
		return highestDegree;
	}
	public void setHighestDegree(String highestDegree) {
		this.highestDegree = highestDegree;
	}
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public Integer getAnnualIncome() {
		return annualIncome;
	}
	public void setAnnualIncome(Integer annualIncome) {
		this.annualIncome = annualIncome;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
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
	public String getMotherName() {
		return motherName;
	}
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getFatherIs() {
		return fatherIs;
	}
	public void setFatherIs(String fatherIs) {
		this.fatherIs = fatherIs;
	}
	public String getMotherIs() {
		return motherIs;
	}
	public void setMotherIs(String motherIs) {
		this.motherIs = motherIs;
	}
	public int getNumberOfSisters() {
		return numberOfSisters;
	}
	public void setNumberOfSisters(int numberOfSisters) {
		this.numberOfSisters = numberOfSisters;
	}
	public int getNumberOfBrothers() {
		return numberOfBrothers;
	}
	public void setNumberOfBrothers(int numberOfBrothers) {
		this.numberOfBrothers = numberOfBrothers;
	}
	public String getGothra() {
		return gothra;
	}
	public void setGothra(String gothra) {
		this.gothra = gothra;
	}
	public double getFamilyIncome() {
		return familyIncome;
	}
	public void setFamilyIncome(double familyIncome) {
		this.familyIncome = familyIncome;
	}
	public String getFamilyType() {
		return familyType;
	}
	public void setFamilyType(String familyType) {
		this.familyType = familyType;
	}
	public String getFamilyValues() {
		return familyValues;
	}
	public void setFamilyValues(String familyValues) {
		this.familyValues = familyValues;
	}
	public String getLivingWithParents() {
		return livingWithParents;
	}
	public void setLivingWithParents(String livingWithParents) {
		this.livingWithParents = livingWithParents;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}
	public String getDietaryHabits() {
		return dietaryHabits;
	}
	public void setDietaryHabits(String dietaryHabits) {
		this.dietaryHabits = dietaryHabits;
	}
	public String getDrinkingHabits() {
		return drinkingHabits;
	}
	public void setDrinkingHabits(String drinkingHabits) {
		this.drinkingHabits = drinkingHabits;
	}
	public String getSmokingHabits() {
		return smokingHabits;
	}
	public void setSmokingHabits(String smokingHabits) {
		this.smokingHabits = smokingHabits;
	}
	public String getSkinType() {
		return skinType;
	}
	public void setSkinType(String skinType) {
		this.skinType = skinType;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public String getMaternalGothra() {
		return maternalGothra;
	}
	public void setMaternalGothra(String maternalGothra) {
		this.maternalGothra = maternalGothra;
	}
	public String getAboutMe() {
		return aboutMe;
	}
	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}
	
	public String getPicture1() {
		return picture1;
	}
	public void setPicture1(String picture1) {
		this.picture1 = picture1;
	}
	
	
	
	/**
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "ProfileVo [firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth=" + dateOfBirth
				+ ", placeOfBirth=" + placeOfBirth + ", religion=" + religion + ", caste=" + caste + ", marritalStatus="
				+ marritalStatus + ", heightFeet=" + heightFeet + ", heightInch=" + heightInch + ", bodyType="
				+ bodyType + ", complexion=" + complexion + ", challenged=" + challenged + ", highestDegree="
				+ highestDegree + ", collegeName=" + collegeName + ", schoolName=" + schoolName + ", occupation="
				+ occupation + ", annualIncome=" + annualIncome + ", companyName=" + companyName + ", drinking="
				+ drinking + ", smoking=" + smoking + ", motherName=" + motherName + ", fatherName=" + fatherName
				+ ", fatherIs=" + fatherIs + ", motherIs=" + motherIs + ", numberOfSisters=" + numberOfSisters
				+ ", numberOfBrothers=" + numberOfBrothers + ", gothra=" + gothra + ", familyIncome=" + familyIncome
				+ ", familyType=" + familyType + ", familyValues=" + familyValues + ", livingWithParents="
				+ livingWithParents + ", address=" + address + ", homeAddress=" + homeAddress + ", dietaryHabits="
				+ dietaryHabits + ", drinkingHabits=" + drinkingHabits + ", smokingHabits=" + smokingHabits
				+ ", skinType=" + skinType + ", bloodGroup=" + bloodGroup + ", maternalGothra=" + maternalGothra
				+ ", aboutMe=" + aboutMe + "]";
	}
	
	
	public ProfileVo getVo(ProfileEntity entity){
		ProfileVo vo = new ProfileVo();
		vo.setFirstName(entity.getFirstName());
		vo.setLastName(entity.getLastName());
		vo.setAnnualIncome(entity.getAnnualIncome());
		vo.setBodyType(entity.getBodyType());
		vo.setCaste(entity.getCaste());
		vo.setChallenged(entity.getChallenged());
		vo.setCollegeName(entity.getCollegeName());
		vo.setCompanyName(entity.getCompanyName());
		vo.setComplexion(entity.getComplexion());
		vo.setDateOfBirth(entity.getDateOfBirth());
		vo.setDrinking(entity.getDrinking());
		vo.setFamilyIncome(entity.getFamilyIncome());
		vo.setFamilyType(entity.getFamilyType());
		vo.setFamilyValues(entity.getFamilyValues());
		vo.setFatherIs(entity.getFatherIs());
		vo.setFatherName(entity.getFatherName());
		vo.setFatherIs(entity.getFatherIs());
		vo.setGothra(entity.getGothra());
		vo.setHeightFeet(entity.getHeightFeet()+"");
		vo.setHeightInch(entity.getHeightInch()+"");
		vo.setHighestDegree(entity.getHighestDegree());
		vo.setLivingWithParents(entity.getLivingWithParents());
		vo.setMarritalStatus(entity.getMarritalStatus());
		vo.setMotherIs(entity.getMotherIs());
		vo.setMotherName(entity.getMotherName());
		vo.setNumberOfBrothers(entity.getNumberOfBrothers());
		vo.setNumberOfSisters(entity.getNumberOfSisters());
		vo.setOccupation(entity.getOccupation());
		vo.setPlaceOfBirth(entity.getPlaceOfBirth());
		vo.setReligion(entity.getReligion());
		vo.setSchoolName(entity.getSchoolName());
		vo.setSmoking(entity.getSmoking());
		vo.setAddress(entity.getAddress());
		vo.setHomeAddress(entity.getHomeAddress());
		vo.setDietaryHabits(entity.getDietaryHabits());
		vo.setDrinkingHabits(entity.getDrinkingHabits());
		vo.setSmokingHabits(entity.getSmokingHabits());
		vo.setSkinType(entity.getSkinType());
		vo.setBloodGroup(entity.getBloodGroup());
		vo.setMaternalGothra(entity.getMaternalGothra());
		vo.setAboutMe(entity.getAboutMe());
		vo.setContactNumber(entity.getContactNumber());
		vo.setEmail(entity.getEmail());
		vo.setGender(entity.getGender());
		vo.setId(entity.getId());
		vo.setAge(entity.getAge());
		return vo;
	}

	
	
	public ProfileEntity getEntity(){
		ProfileEntity entity = new ProfileEntity();
		entity.setFirstName(firstName);
		entity.setLastName(lastName);
		entity.setAnnualIncome(annualIncome==null || annualIncome.equals("")? 0 : annualIncome);
		entity.setBodyType(bodyType);
		entity.setCaste(caste);
		entity.setChallenged(challenged);
		entity.setCollegeName(collegeName);
		entity.setCompanyName(companyName);
		entity.setComplexion(complexion);
		entity.setDateOfBirth(dateOfBirth);
		entity.setDrinking(drinking);
		entity.setFamilyIncome(familyIncome);
		entity.setFamilyType(familyType);
		entity.setFamilyValues(familyValues);
		entity.setFatherIs(fatherIs);
		entity.setFatherName(fatherName);
		entity.setFatherIs(fatherIs);
		entity.setGothra(gothra);
		entity.setHeightFeet(Integer.valueOf(heightFeet));
		entity.setHeightInch(Integer.valueOf(heightInch));
		entity.setHighestDegree(highestDegree);
		entity.setLivingWithParents(livingWithParents);
		entity.setMarritalStatus(marritalStatus);
		entity.setMotherIs(motherIs);
		entity.setMotherName(motherName);
		entity.setNumberOfBrothers(numberOfBrothers);
		entity.setNumberOfSisters(numberOfSisters);
		entity.setOccupation(occupation);
		entity.setPlaceOfBirth(placeOfBirth);
		entity.setReligion(religion);
		entity.setSchoolName(schoolName);
		entity.setAddress(address);
		entity.setHomeAddress(homeAddress);
		entity.setDietaryHabits(dietaryHabits);
		entity.setDrinkingHabits(drinkingHabits);
		entity.setSmokingHabits(smokingHabits);
		entity.setSkinType(skinType);
		entity.setBloodGroup(bloodGroup);
		entity.setMaternalGothra(maternalGothra);
		entity.setAboutMe(aboutMe);
		entity.setContactNumber(contactNumber);
		entity.setEmail(email);
		entity.setGender(gender);
		entity.setId(id);
		entity.setAge(age);
		return entity;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the ageRange
	 */
	public String getAgeRange() {
		return ageRange;
	}
	/**
	 * @param ageRange the ageRange to set
	 */
	public void setAgeRange(String ageRange) {
		this.ageRange = ageRange;
	}
	/**
	 * @return the start
	 */
	public Integer getStart() {
		return start;
	}
	/**
	 * @param start the start to set
	 */
	public void setStart(Integer start) {
		this.start = start;
	}
	/**
	 * @return the end
	 */
	public Integer getMaxLimit() {
		return maxLimit;
	}
	/**
	 * @param end the end to set
	 */
	public void setMaxLimit(Integer end) {
		this.maxLimit = end;
	}
	
	
	
	
}
