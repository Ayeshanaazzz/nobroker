package com.nobroker.service.impl;

import com.nobroker.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class EmailVerificationService {
    static final Map<String,String> emailOtpMapping = new HashMap<>();
    @Autowired
    private UserService userService;
    public Map<String,String> verifyOtp(String email,String otp){
        String s = emailOtpMapping.get(email);
        Map<String,String>response=new HashMap<>();
        if(s!=null && s.equals(otp)){
           User user=userService.getUserByEmail(email);
           if(user!=null){
               userService.verifyEmail(user);
               response.put("status","success");
               response.put("message","Email verified successfully bhaisaab");
           }
           else {
               response.put("status","error");
               response.put("message","user not found");
           }
        }
        else {
            response.put("status","error");
            response.put("message","invalid otp");
        }
        return response;
    }
}
