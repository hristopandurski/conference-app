package com.pluralsight.conferencedemo.controllers;

import com.pluralsight.conferencedemo.models.PricingCategory;
import com.pluralsight.conferencedemo.repositories.PricingCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pricingCategories")
public class PricingCategoriesController {
    @Autowired
    private PricingCategoryRepository pricingCategoryRepository;

    @GetMapping
    public List<PricingCategory> list() { return pricingCategoryRepository.findAll(); }
}
