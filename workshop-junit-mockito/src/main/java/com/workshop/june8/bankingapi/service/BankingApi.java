package com.workshop.june8.bankingapi.service;

import com.workshop.june8.bankingapi.exception.BankingApiException;
import com.workshop.june8.bankingapi.model.Account;
import org.springframework.stereotype.Service;

@Service
public interface BankingApi {

    Account login(String pincode) throws BankingApiException;
    boolean transfer(double amount, String ibanFrom,String ibanTo) throws BankingApiException;
    double getBalance(String iban) throws BankingApiException;
    boolean applyForLone(Account account) throws BankingApiException;
}
