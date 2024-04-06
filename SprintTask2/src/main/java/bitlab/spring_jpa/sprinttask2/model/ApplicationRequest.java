package bitlab.spring_jpa.sprinttask2.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "APPLICATIONS")
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

    @Column(name = "PHONE_NUMBER", nullable = false, unique = true)
    private String phoneNumber;

    @Column(name = "COMMENT", nullable = false)
    private String comment;

    @Column(name = "HANDLED")
    private boolean handled;

    @ManyToOne  //много запросов на один курс или у одного курса много разных запросов
    private Course course;
}
