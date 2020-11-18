package pl.coderslab.charity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.repository.DonationRepository;

@Service
public class DonationServiceDb implements DonationService {
    private DonationRepository donationRepository;

    @Autowired
    public DonationServiceDb(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    @Override
    public long countAllGiftedItems() {
        return this.donationRepository.sumQuantity();
    }

    @Override
    public long countAllDonations() {
        return this.donationRepository.count();
    }

    @Override
    public void save(Donation donation) {
        this.donationRepository.save(donation);
    }

    @Override
    public Donation findByIdWithAllData(long id) {
        return this.donationRepository.findByIdWithCategories(id);
    }
}
