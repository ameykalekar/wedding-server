package com.main.service;

import java.io.File;
import java.io.FileOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Random;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.entity.ProfileEntity;
import com.main.repository.ProfileRepository;
import com.main.vo.PaymentRequest;
import com.main.vo.ProfileVo;

@Service
public class ProfileService {

	@Autowired
	ProfileRepository repository;

	private final String salt = "KFSwE2j1";

	public ProfileVo getProfile(String id) {
		/*
		 * ProfileVo profileVo = new ProfileVo();
		 * 
		 * profileVo.setFirstName("Suraj"); profileVo.setLastName("Patil");
		 * profileVo.setPlaceOfBirth("pune"); profileVo.setDateOfBirth("28/08/1987");
		 * profileVo.setAnnualIncome("8");
		 */
		ProfileEntity entity = repository.findById(Long.valueOf(id)).get();
		return new ProfileVo().getVo(entity);
	}

	public ProfileVo insertProfile(ProfileVo profileVo) {

		ProfileEntity entity = repository.save(profileVo.getEntity());
		try {
			if (profileVo.getPicture1() != null) {

				File directory = new File(String.valueOf("C:\\Users\\amayk\\images\\" + entity.getId()));
				if (!directory.exists())
					directory.mkdirs();

				FileOutputStream imageOutFile = new FileOutputStream(
						"C:\\Users\\amayk\\images\\" + entity.getId() + "\\1.jpg");
				imageOutFile.write(Base64.decodeBase64(profileVo.getPicture1()));

				imageOutFile.close();
			}

			if (profileVo.getPicture2() != null) {

				File directory = new File(String.valueOf("C:\\Users\\amayk\\images\\" + entity.getId()));
				if (!directory.exists())
					directory.mkdirs();

				FileOutputStream imageOutFile = new FileOutputStream(
						"C:\\Users\\amayk\\images\\" + entity.getId() + "\\2.jpg");
				imageOutFile.write(Base64.decodeBase64(profileVo.getPicture2()));

				imageOutFile.close();
			}	
			
			if (profileVo.getPicture3() != null) {

				File directory = new File(String.valueOf("C:\\Users\\amayk\\images\\" + entity.getId()));
				if (!directory.exists())
					directory.mkdirs();

				FileOutputStream imageOutFile = new FileOutputStream(
						"C:\\Users\\amayk\\images\\" + entity.getId() + "\\3.jpg");
				imageOutFile.write(Base64.decodeBase64(profileVo.getPicture3()));

				imageOutFile.close();
			}	
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ProfileVo().getVo(entity);
	}

	public List<ProfileEntity> searchProfile(ProfileVo profileVo) {

		return repository.searchProfile(profileVo);

	}

	public PaymentRequest getRequestData() {
		return null;
	}

	public String generateTxnID() {
		String txnid;
		Random rand = new Random();
		String rndm = Integer.toString(rand.nextInt()) + (System.currentTimeMillis() / 1000L);
		txnid = rndm;

		txnid = hashCal("SHA-256", rndm).substring(0, 20);
		return txnid;
	}

	public String hashCal(String type, String str) {
		byte[] hashseq = str.getBytes();
		StringBuffer hexString = new StringBuffer();
		try {
			MessageDigest algorithm = MessageDigest.getInstance(type);
			algorithm.reset();
			algorithm.update(hashseq);
			byte messageDigest[] = algorithm.digest();
			for (int i = 0; i < messageDigest.length; i++) {
				String hex = Integer.toHexString(0xFF & messageDigest[i]);
				if (hex.length() == 1) {
					hexString.append("0");
				}
				hexString.append(hex);
			}

		} catch (NoSuchAlgorithmException nsae) {
		}
		return hexString.toString();
	}

	public PaymentRequest generateHash(PaymentRequest paymentRequest) {
		String txnid =generateTxnID();

		String hashString = "";

		String hash = "";
		paymentRequest.setTxnid(txnid);

		hashString = paymentRequest.getKey() + "|" + paymentRequest.getTxnid() + "|" + paymentRequest.getAmount() + "|"
				+ paymentRequest.getProductinfo() + "|" + paymentRequest.getFirstname() + "|"
				+ paymentRequest.getEmail() + "|" + "||||||||||" + this.salt;

		System.out.println(hashString);
		hash = hashCal("SHA-512", hashString);

		paymentRequest.setHash(hash);

		return paymentRequest;

	}

	public boolean empty(String s) {
		if (s == null || s.trim().equals("")) {
			return true;
		} else {
			return false;
		}
	}
}
