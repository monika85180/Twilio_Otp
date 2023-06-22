package com.Twilio_otp.Twilio_otp.service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.stereotype.Service;

@Service
public class OtpService {
    // Twilio Account SID and Auth Token
    private static final String ACCOUNT_SID = "ACabe70dabfd114e0d5508dad4dfd2ea80";
    private static final String AUTH_TOKEN = "e317c94a981916ead385b75b108aeefc";

    // Twilio phone number
    private static final String TWILIO_PHONE_NUMBER = "+14068023736";

    public void sendOtp(String phoneNumber, String otp) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(
                        new PhoneNumber(phoneNumber),
                        new PhoneNumber(TWILIO_PHONE_NUMBER),
                        "Your OTP is: " + otp)
                .create();

        System.out.println(message.getSid());
    }
}
