package bitlab.to_g1.trellofinalproject.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "TASKS")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DESCRIPTION")
    private String description; // TEXT

    @Column(name = "STATUS")
    private int status;        // 0 - todo, 1 - intest, 2 - done, 3 - failed

    @ManyToOne
    private Folder folder; // Many To One

}
