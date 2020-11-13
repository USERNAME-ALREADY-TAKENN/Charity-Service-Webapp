package pl.coderslab.charity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.repository.DonationRepository;

@Service
public class DonationServiceDb implements DonationService {
    private DonationRepository donationRepository;

    @Autowired
    public DonationServiceDb(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    @Override
    public long countAllItems() {
        return this.donationRepository.sumQuantity();
    }
}
