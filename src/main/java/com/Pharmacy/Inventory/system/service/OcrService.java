package com.Pharmacy.Inventory.system.service;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Service
public class OcrService {

    public String extractText(MultipartFile image) {

        try {
            // convert MultipartFile → temp file
            File tempFile = File.createTempFile("ocr_", ".png");
            image.transferTo(tempFile);

            Tesseract tesseract = new Tesseract();

            // IMPORTANT: tessdata path
            tesseract.setDatapath("C:/Program Files/Tesseract-OCR/tessdata");

            String text = tesseract.doOCR(tempFile);

            // clean result
            text = text.toLowerCase()
                    .replaceAll("[^a-z0-9 ]", " ")
                    .replaceAll("\\s+", " ")
                    .trim();

            return text;

        } catch (Exception e) {
            throw new RuntimeException("OCR failed", e);
        }
    }
}