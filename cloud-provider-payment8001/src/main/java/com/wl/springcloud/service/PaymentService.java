package com.wl.springcloud.service;

import com.wl.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author yt
 */

public interface PaymentService {
    int create(Payment payment);

    Payment getPaymentById(@Param("id")Long id);
}
