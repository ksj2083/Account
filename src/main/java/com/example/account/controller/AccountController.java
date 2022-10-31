package com.example.account.controller;

import javax.validation.Valid;

import com.example.account.domain.Account;
import com.example.account.dto.AccountDto;
import com.example.account.dto.DeleteAccount;
import com.example.account.service.AccountService;
import com.example.account.service.RedisTestService;

import com.example.account.dto.CreateAccount;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;
    private final RedisTestService redisTestService;

    //계좌생성
    @PostMapping("/account")
    public CreateAccount.Response createAccount(
        @RequestBody @Valid CreateAccount.Request request
    ) {
        return CreateAccount.Response.from(accountService.createAccount(
            request.getUserId(),
            request.getInitialBalance()
        ));
    }

    @DeleteMapping("/account")
    public DeleteAccount.Response deleteAccount(
        @RequestBody @Valid DeleteAccount.Request request
    ) {
        return DeleteAccount.Response.from(accountService.deleteAccount(
            request.getUserId(),
            request.getAccountNumber()
        ));
    }

    @GetMapping("/get-lock")
    public String getLock() {
        return redisTestService.getLock();
    }


    @GetMapping("/account/{id}")
    public Account getAccount(
            @PathVariable Long id){
        return accountService.getAccount(id);
    }
}