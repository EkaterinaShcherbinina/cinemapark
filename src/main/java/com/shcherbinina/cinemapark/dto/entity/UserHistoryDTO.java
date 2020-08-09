package com.shcherbinina.cinemapark.dto.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class UserHistoryDTO {
    private int purchasedTickets;
    private BigDecimal totalSpend;
    private List<MovieThumbnailDTO> movies;
}
