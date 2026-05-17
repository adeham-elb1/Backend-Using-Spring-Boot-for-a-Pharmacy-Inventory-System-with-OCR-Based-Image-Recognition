package com.Pharmacy.Inventory.system.service;

import com.Pharmacy.Inventory.system.entity.ImageRecognitionResult;
import com.Pharmacy.Inventory.system.entity.Medicine;
import com.Pharmacy.Inventory.system.repository.MedicineRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class ImageRecognitionService {
    public String extractText(MultipartFile image) {
        // temporary fake logic OR Tesseract later
        return "paracetamol";
    }

    private final MedicineRepository medicineRepository;

    public ImageRecognitionService(MedicineRepository medicineRepository) {
        this.medicineRepository = medicineRepository;
    }

    public ImageRecognitionResult identifyMedicine(String ocrText) {

        String text = ocrText.toLowerCase().trim();

        List<Medicine> medicines = medicineRepository.findAll();

        for (Medicine m : medicines) {

            if (text.contains(m.getName().toLowerCase())) {

                ImageRecognitionResult result = new ImageRecognitionResult();
                result.setMedicineName(m.getName());
                result.setFound(true);
                result.setConfidenceScore(0.95);

                return result;
            }
        }

        // if nothing found
        ImageRecognitionResult result = new ImageRecognitionResult();
        result.setMedicineName("Unknown");
        result.setFound(false);
        result.setConfidenceScore(0.0);

        return result;
    }
}