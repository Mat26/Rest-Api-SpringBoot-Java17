package com.example.restapi.dto;

import java.time.LocalDateTime;


public record ProductDto(String title,
                         String description,
                         LocalDateTime expirationDate,
                         int price) {
}
