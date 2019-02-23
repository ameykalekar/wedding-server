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

import com.main.entity.PaymentResponse;
import com.main.entity.ProfileEntity;
import com.main.repository.PaymentRepository;
import com.main.repository.ProfileRepository;
import com.main.vo.PaymentRequest;
import com.main.vo.ProfileVo;

@Service
public class PaymentService {

	@Autowired
	PaymentRepository repository;

	private final String salt = "KFSwE2j1";

	public PaymentResponse insertPayment(PaymentResponse paymentResponse) {

		PaymentResponse entity = repository.save(paymentResponse);

		return entity;
	}

}
