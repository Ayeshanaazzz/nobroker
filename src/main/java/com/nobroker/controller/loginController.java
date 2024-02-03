package com.nobroker.controller;

import com.nobroker.service.impl.EmailVerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class loginController {
    @Autowired
    private EmailVerificationService emailVerificationService;
    //
    @PostMapping("/send-otp-for-login")
    public Map<String,String> sendOtpForLogin(@RequestBody String email){
        return emailVerificationService.sendOtpForLogin(email);
    }

    @PostMapping("/verify-otp-for-login")
    public Map<String,String> verifyOtpForLogin(@RequestParam String email,@RequestParam String otp){
        return emailVerificationService.verifyOtpForLogin(email,otp);
    }


}
