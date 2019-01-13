package com.main.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

import com.main.vo.ProfileVo;

@Entity
@Table(name="PROFILE")
public class ProfileEntity {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long id;

	@Column(length=100)
	private String firstName;
	
	@Column(length=100)
	private String lastName;
	
	@Column(length=100)
	private String dateOfBirth;
	
	@Column(length=100)
	private String placeOfBirth;
	
	@Column(length=100)
	private String religion;
	
	@Column(length=100)
	private String caste;
	
	@Column(length=100)
	private String marritalStatus;
	
	@Column(length=100)
	private int heightFeet;
	
	@Column(length=100)
	private int heightInch;
	
	@Column(length=100)
	private String bodyType;
	
	@Column(length=100)
	private String complexion;
	
	@Column(length=100)
	private String challenged;
	
	@Column(length=100)
	private String highestDegree;
	
	@Column(length=100)
	private String collegeName;
	
	@Column(length=100)
	private String schoolName;
	
	@Column(length=100)
	private String occupation;
	
	@Column
	private int annualIncome;
	
	@Column(length=100)
	private String companyName;
	
	@Column(length=10)
	private String drinking;
	
	@Column(length=20)
	private String smoking;
	
	@Column(length=100)
	private String motherName;
	
	@Column(length=100)
	private String fatherName;
	
	@Column(length=100)
	private String fatherIs;
	
	@Column(length=100)
	private String motherIs;
	
	@Column
	private int numberOfSisters;
	
	@Column
	private int numberOfBrothers;
	
	@Column(length=100)
	private String gothra;
	
	@Column
	private double familyIncome;
	
	@Column(length=100)
	private String familyType;
	
	@Column(length=100)
	private String familyValues;
	
	@Column(length=100)
	private String livingWithParents;
	
	@Column(length=100)
	private String address;
	@Column(length=100)
	private String homeAddress;
	@Column(length=100)
	private String dietaryHabits;
	@Column(length=100)
	private String drinkingHabits;
	@Column(length=100)
	private String smokingHabits;
	@Column(length=100)
	private String skinType;
	@Column(length=100)
	private String bloodGroup;
	@Column(length=100)
	private String maternalGothra;
	@Column(length=500)
	private String aboutMe;
	
	@Column(length=12)
	private String contactNumber;
	
	@Column(length=50)
	private String email;
	
	@Column(length=10)
	private String gender;
	
	@Column(length=10)
	@ColumnDefault("18")
	private Integer age;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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

	public int getHeightFeet() {
		return heightFeet;
	}

	public void setHeightFeet(int heightFeet) {
		this.heightFeet = heightFeet;
	}

	public int getHeightInch() {
		return heightInch;
	}

	public void setHeightInch(int heightInch) {
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

	public void setAnnualIncome(int annualIncome) {
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

	
	
}
