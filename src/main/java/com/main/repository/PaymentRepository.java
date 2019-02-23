package com.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.entity.PaymentResponse;
import com.main.entity.ProfileEntity;

public interface PaymentRepository extends JpaRepository<PaymentResponse,Long> {

}
