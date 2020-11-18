package pl.coderslab.charity.service;

import pl.coderslab.charity.entity.Donation;

public interface DonationService {
    long countAllGiftedItems();
    long countAllDonations();
    void save(Donation donation);
    Donation findByIdWithAllData(long id);
}
