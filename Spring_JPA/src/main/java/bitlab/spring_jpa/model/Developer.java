package bitlab.spring_jpa.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "DEVELOPERS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Developer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", nullable = false, unique = true)
    private String name;

    @Column(name = "AGE")
    private String age;

    @Column(name = "BIRTH_PLACE", columnDefinition = "TEXT")
    private String birthPlace;
}
