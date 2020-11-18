package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.charity.entity.Donation;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {
    @Query("SELECT SUM(d.quantity) FROM Donation d")
    long sumQuantity();
    @Query("SELECT d FROM Donation d LEFT JOIN FETCH d.categories WHERE d.id=?1") //FETCH ALL PROPERTIES ")
//    @Query("SELECT d FROM Donation d LEFT JOIN FETCH ALL PROPERTIES WHERE d.id=?1") //FETCH ALL PROPERTIES ")
    Donation findByIdWithCategories(long id);
}
