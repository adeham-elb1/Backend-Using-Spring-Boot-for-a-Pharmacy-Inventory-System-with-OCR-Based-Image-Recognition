package com.Pharmacy.Inventory.system.entity;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ImageRecognitionResult {

    private String medicineName ;
    private double confidenceScore ;
    private boolean found ;
    public ImageRecognitionResult() {}

}
