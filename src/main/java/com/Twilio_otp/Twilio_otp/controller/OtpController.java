package com.Twilio_otp.Twilio_otp.controller;

import com.Twilio_otp.Twilio_otp.payload.OtpRequestDto;
import com.Twilio_otp.Twilio_otp.service.OtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class OtpController {

    private final OtpService otpService;

    @Autowired
    public OtpController(OtpService otpService) {
        this.otpService = otpService;
    }

    //http://localhost:8080/send-otp
    @PostMapping("/send-otp")
    public void sendOtp(@RequestBody OtpRequestDto request) {
        String phoneNumber = request.getPhoneNumber();
        String otp = generateOtp(); // Implement your OTP generation logic here

        otpService.sendOtp(phoneNumber, otp);
    }

    private String generateOtp() {
        int otpLength = 6; // Length of the OTP
        StringBuilder otp = new StringBuilder();

        // Generate random digits for the OTP
        Random random = new Random();
        for (int i = 0; i < otpLength; i++) {
            otp.append(random.nextInt(10)); // Append a random digit (0-9) to the OTP
        }

        return otp.toString();
    }

}
