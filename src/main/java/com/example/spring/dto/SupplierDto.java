package com.example.spring.dto;

import lombok.Data;

@Data
public class SupplierDto {
    private Integer supplierId;
    private String supplierName;
    private String contactName;
    private String address;
    private String city;
    private String postalCode;
    private String country;
    private String phone;
}
