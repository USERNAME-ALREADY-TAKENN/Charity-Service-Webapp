package pl.coderslab.charity.service;

import pl.coderslab.charity.entity.Donation;

import java.util.List;

public interface DonationService {
    long countAllGiftedItems();
    long countAllDonations();
    void save(Donation donation);
    Donation findByIdWithAllData(long id);
    List<Donation> findAll();
    List<Donation> findAllWithAllData();
    void remove(Donation donation);
}
