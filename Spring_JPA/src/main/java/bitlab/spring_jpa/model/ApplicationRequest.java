package bitlab.spring_jpa.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "REQUESTS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApplicationRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "USER_NAME", nullable = false)
    private String userName;
    @Column(name = "COURSE_NAME", nullable = false)
    private String courseName;
    @Column(name = "COMMENTARY")
    private String commentary;
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "HANDLED")
    private boolean handled;

}
