package pl.coderslab.charity.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "donations")
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(value = 1)
    private Integer quantity;

    @NotEmpty
    @OneToMany//(mappedBy = "donation")
    private List<Category> categories;

//    @NotEmpty
    @ManyToOne
    private Institution institution;

    @NotEmpty
    private String street;

    @NotEmpty
    private String city;

    @NotEmpty
//    @Pattern()
    private String zipCode;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickUpDate;

    @DateTimeFormat(pattern = "hh:mm")
    private String pickUpTime;

    private String pickUpComment;

}
