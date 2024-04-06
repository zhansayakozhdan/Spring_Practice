package bitlab.to_g1.trellofinalproject.entity;

import bitlab.to_g1.trellofinalproject.entity.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "TASK_CATEGORIES")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class TaskCategory extends BaseEntity {
    @Column(name = "NAME", nullable = false)
    private String name;
}
