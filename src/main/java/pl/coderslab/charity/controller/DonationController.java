package pl.coderslab.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.service.CategoryService;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;

import java.util.List;

@Controller
@RequestMapping("/donation")
public class DonationController {
    private DonationService donationService;
    private CategoryService categoryService;
    private InstitutionService institutionService;

    @Autowired
    public DonationController(DonationService donationService, CategoryService categoryService, InstitutionService institutionService) {
        this.donationService = donationService;
        this.categoryService = categoryService;
        this.institutionService = institutionService;
    }

    @GetMapping("")
    public String donationForm(Model model) {
        Donation donation = new Donation();
        List<Category> categories = this.categoryService.findAll();
        List<Institution> institutions = this.institutionService.findAll();
        model.addAttribute("donation", donation);
        model.addAttribute("categories", categories);
        model.addAttribute("institutions", institutions);
        return "donation/form";
    }
}
