package pl.coderslab.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.service.CategoryService;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;
import pl.coderslab.charity.service.UserService;

import javax.transaction.Transactional;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private UserService userService;
    private DonationService donationService;
    private InstitutionService institutionService;
    private CategoryService categoryService;

    @Autowired
    public AdminController(UserService userService, DonationService donationService, InstitutionService institutionService, CategoryService categoryService) {
        this.userService = userService;
        this.donationService = donationService;
        this.institutionService = institutionService;
        this.categoryService = categoryService;
    }

    @GetMapping("")
    private String adminDashboard() {
        return "admin/dashboard";
    }

    @GetMapping("/user/ban/{id}")
    @Transactional
    public String toggleBan(@PathVariable long id) {
        this.userService.userToggleBan(id);
        return "redirect:/admin";
    }

    /* Model attributes */

    @ModelAttribute("donations")
    public List<Donation> donations() {
        return this.donationService.findAll();
    }

    @ModelAttribute("users")
    public List<User> users() {
        return this.userService.findAll();
    }

    @ModelAttribute("institutions")
    public List<Institution> institutions() {
        return this.institutionService.findAll();
    }

    @ModelAttribute("categories")
    public List<Category> categories() {
        return this.categoryService.findAll();
    }
}
