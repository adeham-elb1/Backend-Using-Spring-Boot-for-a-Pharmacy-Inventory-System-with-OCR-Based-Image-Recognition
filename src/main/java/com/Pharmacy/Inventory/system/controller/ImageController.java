package com.Pharmacy.Inventory.system.controller;

import com.Pharmacy.Inventory.system.entity.ImageRecognitionResult;
import com.Pharmacy.Inventory.system.service.ImageRecognitionService;
import com.Pharmacy.Inventory.system.service.OcrService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/ocr")
public class ImageController {

    private final ImageRecognitionService imageRecognitionService;
    private final OcrService ocrService;

    public ImageController(
            ImageRecognitionService imageRecognitionService,
            OcrService ocrService) {

        this.imageRecognitionService = imageRecognitionService;
        this.ocrService = ocrService;
    }

    @PostMapping("/check")
    public ImageRecognitionResult checkMedicine(
            @RequestParam("image") MultipartFile image) {

        String text = ocrService.extractText(image);

        return imageRecognitionService.identifyMedicine(text);
    }
}