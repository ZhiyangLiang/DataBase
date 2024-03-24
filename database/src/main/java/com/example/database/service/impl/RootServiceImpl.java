package com.example.database.service.impl;

import com.example.database.service.RootService;
import com.example.database.mapper.RootMapper;
import com.example.database.items.*;
import java.util.List;
import com.example.database.utils.enums.ResponseEnum;
import com.example.database.utils.response.UniversalResponse;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service
public class RootServiceImpl implements RootService {
    @Resource
    private RootMapper rootMapper;
    @Override
    public UniversalResponse<List<Borrower>> getBorrower() {
        return new UniversalResponse<>(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getMsg(), rootMapper.getBorrower());
    }

    @Override
    public UniversalResponse<List<Loan>> getLoan() {
        return new UniversalResponse<>(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getMsg(), rootMapper.getLoan());
    }

    @Override
    public UniversalResponse<List<Payment>> getPayment() {
        return new UniversalResponse<>(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getMsg(), rootMapper.getPayment());
    }

    @Override
    public UniversalResponse<?> insertPayment(Payment payment) {
        return new UniversalResponse<>(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getMsg(), rootMapper.insertPayment(payment.getLoan_number(), payment.getPayment_number(), payment.getPayment_datetime(), payment.getPayment_amount()));
    }
}
