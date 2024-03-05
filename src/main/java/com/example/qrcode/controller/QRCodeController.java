package com.example.qrcode.controller;

import com.example.qrcode.service.QRCodeService;
import com.google.zxing.WriterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/")
public class QRCodeController {

    @Autowired
    QRCodeService qrCodeService;

    @PostMapping(value = "/qrcode")
    public void gerarComZXing() throws IOException, WriterException {
        this.qrCodeService.gerarComZXing();
    }
}
