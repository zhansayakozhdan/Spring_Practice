package bitlab.to_g1.trellofinalproject.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.servlet.tags.form.TextareaTag;

@Entity
@Table(name = "COMMENTS")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "VALUE")
    private String value;

    @ManyToOne
    private Task task;
}
