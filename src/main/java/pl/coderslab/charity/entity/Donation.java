package pl.coderslab.charity.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
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

    @NotBlank
    @Min(value = 1)
    private Integer quantity;

    @NotEmpty
    @OneToMany//(mappedBy = "donation")
    private List<Category> categories;

    @NotEmpty
    @ManyToOne
    private Institution institution;

    private String street;

    private String city;

    private String zipCode;

    private String pickUpDate;

    private String pickUpTime;

    private String pickUpComment;

}