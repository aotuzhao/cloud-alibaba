package com.zhao.springcloud.service.impl;

import com.zhao.springcloud.dao.PaymentDao;
import com.zhao.springcloud.entities.Payment;
import com.zhao.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @Description: desc
 * @Author zhaoxuezhao
 * @Date 2021/1/26 1:25 下午
 */
@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int creat(Payment payment) {
        return paymentDao.creat(payment);
    }

    @Override
    public Payment getById(Long id) {
        return paymentDao.getById(id);
    }
}
