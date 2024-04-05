package bitlab.to_g1.trellofinalproject.entity;

import bitlab.to_g1.trellofinalproject.entity.base.BaseEntity;
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
public class Comment extends BaseEntity {
    @Column(name = "VALUE", nullable = false)
    private String value;

    @ManyToOne
    @JoinColumn(name = "TASK_ID")
    private Task task;
}
