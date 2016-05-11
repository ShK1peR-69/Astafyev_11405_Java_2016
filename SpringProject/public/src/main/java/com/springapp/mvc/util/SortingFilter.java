package com.springapp.mvc.util;

import java.math.BigDecimal;

/**
 * @author Astafyev Igor
 *         11-405
 *         for SemWork
 */

public class SortingFilter {
    private String sport;
    private String sorting;
    private BigDecimal from;
    private BigDecimal to;

    public SortingFilter(String sport, String sorting, BigDecimal from, BigDecimal to) {
        this.sport = sport;
        this.sorting = sorting;
        this.from = from;
        this.to = to;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public String getSorting() {
        return sorting;
    }

    public void setSorting(String sorting) {
        this.sorting = sorting;
    }

    public BigDecimal getFrom() {
        return from;
    }

    public void setFrom(BigDecimal from) {
        this.from = from;
    }

    public BigDecimal getTo() {
        return to;
    }

    public void setTo(BigDecimal to) {
        this.to = to;
    }
}
