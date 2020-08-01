package com.shcherbinina.cinemapark.dto.entity;

import java.math.BigDecimal;
import java.util.List;

public class UserHistoryDTO {
    private int purchasedTickets;
    private BigDecimal totalSpend;
    private List<MovieThumbnailDTO> movies;

    public UserHistoryDTO() {
    }

    public int getPurchasedTickets() {
        return purchasedTickets;
    }

    public void setPurchasedTickets(int purchasedTickets) {
        this.purchasedTickets = purchasedTickets;
    }

    public BigDecimal getTotalSpend() {
        return totalSpend;
    }

    public void setTotalSpend(BigDecimal totalSpend) {
        this.totalSpend = totalSpend;
    }

    public List<MovieThumbnailDTO> getMovies() {
        return movies;
    }

    public void setMovies(List<MovieThumbnailDTO> movies) {
        this.movies = movies;
    }
}
