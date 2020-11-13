package pl.coderslab.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {
    private InstitutionService institutionService;
    private DonationService donationService;

    @Autowired
    public HomeController(InstitutionService institutionService, DonationService donationService) {
        this.institutionService = institutionService;
        this.donationService = donationService;
    }

    @GetMapping()
    public String showHomepage(Model model) {
        List<Institution> institutionList = this.institutionService.findAll();
        model.addAttribute("institutionList", institutionList);

        long numOfDonations = this.donationService.countAllItems();
        model.addAttribute("numOfDonations", numOfDonations);
        return "index";
    }
}
