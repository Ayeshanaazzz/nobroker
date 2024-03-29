package com.nobroker.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import static com.nobroker.service.impl.EmailVerificationService.emailOtpMapping;
import java.util.Map;


@Service
@SuppressWarnings("unused")
  public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;
@Autowired
    private final UserService userService;


    @Autowired
    public EmailService(JavaMailSender javaMailSender, UserService userService) {
        this.javaMailSender = javaMailSender;
        this.userService = userService;
    }

    public String generateOtp(){
        return String.format("%04d",new java.util.Random().nextInt(10000));
    }

    public Map<String,String>sendOtpEmail(String email){
        String otp=generateOtp();
        emailOtpMapping.put(email,otp);

        sendEmail(email,"OTP for Email Verification","Your OTP is:" +otp);
        Map<String,String>response=new HashMap<>();
        response.put("status","success");
        response.put("message","OTP sent successfully");
        return response;

    }

    private void sendEmail(String to, String subject, String text) {
        SimpleMailMessage message=new SimpleMailMessage();
        message.setFrom("your.gmail.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        javaMailSender.send(message);
    }

}