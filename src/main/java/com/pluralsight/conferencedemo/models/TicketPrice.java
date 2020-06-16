package com.pluralsight.conferencedemo.models;

import javax.persistence.*;

@Entity(name = "ticket_prices")
public class TicketPrice {
    @Id
    private Long ticket_price_id;

    private String pricing_category_code;

    @OneToOne(cascade = CascadeType.REFRESH, orphanRemoval = false)
    @JoinColumn(name = "pricing_category_code", referencedColumnName = "pricing_category_code", insertable = false, updatable = false)
    private PricingCategory pricingCategory;

    public Long getTicket_price_id() {
        return ticket_price_id;
    }

    public void setTicket_price_id(Long ticket_price_id) {
        this.ticket_price_id = ticket_price_id;
    }

    public String getPricing_category_code() {
        return pricing_category_code;
    }

    public void setPricing_category_code(String pricing_category_code) {
        this.pricing_category_code = pricing_category_code;
    }

    public PricingCategory getPricingCategory() {
        return pricingCategory;
    }

    public void setPricingCategory(PricingCategory pricingCategory) {
        this.pricingCategory = pricingCategory;
    }
}
