package com.example.qrcode.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.spire.barcode.BarCodeGenerator;
import com.spire.barcode.BarCodeType;
import com.spire.barcode.BarcodeSettings;
import com.spire.barcode.QRCodeECL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;

@Service
public class QRCodeService {

    @Autowired QRCodeWriter qrCodeWriter;

    public void gerarComZXing() throws WriterException, IOException {
        String barcodeText = "https://stackoverflow.com/";
        BitMatrix bitMatrix = qrCodeWriter.encode(barcodeText, BarcodeFormat.QR_CODE, 300, 300);
        BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix);

        // GEra imagem local
        ImageIO.write(bufferedImage,"png",new File("QR_Code.png"));

        final ByteArrayOutputStream os = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage,"png",os);
        String s = Base64.getEncoder().encodeToString(os.toByteArray());

    }

    public void gerarComSpireBarCode() throws IOException {
        //Instantiate a BarcodeSettings object
        BarcodeSettings settings = new BarcodeSettings();
        //Set barcode type
        settings.setType(BarCodeType.QR_Code);
        //Set barcode data
        String data = "https://stackoverflow.com/";
        settings.setData(data);
        //Set barcode module width
        settings.setX(2);
        //Set error correction level
        settings.setQRCodeECL(QRCodeECL.M);

        //Set top text
        settings.setTopText("User Name");
        //Set bottom text
        settings.setBottomText("Event Name");

        //Set text visibility
        settings.setShowText(true);
        settings.setShowTopText(true);
        settings.setShowBottomText(true);

        //Set border visibility
        settings.hasBorder(false);

        //Instantiate a BarCodeGenerator object based on the specific settings
        BarCodeGenerator barCodeGenerator = new BarCodeGenerator(settings);
        //Generate QR code image
        BufferedImage bufferedImage = barCodeGenerator.generateImage();
        //save the image to a .png file
        //ImageIO.write(bufferedImage,"png",new File("QR_Code.png"));

        final ByteArrayOutputStream os = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage,"png",os);
        String s = Base64.getEncoder().encodeToString(os.toByteArray());
    }

}
