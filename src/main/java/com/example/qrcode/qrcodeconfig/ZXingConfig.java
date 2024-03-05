package com.example.qrcode.qrcodeconfig;

import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZXingConfig {

    @Bean
    public QRCodeWriter qrCodeWriter(){
        return new QRCodeWriter();
    }
}
