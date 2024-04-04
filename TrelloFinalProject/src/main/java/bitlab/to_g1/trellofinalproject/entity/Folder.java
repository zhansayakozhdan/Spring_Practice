package bitlab.to_g1.trellofinalproject.entity;

import bitlab.to_g1.trellofinalproject.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "FOLDERS")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Folder extends BaseEntity {
    @Column(name = "NAME", nullable = false)
    private String name;

    @ManyToMany()
    private List<TaskCategory> taskCategories;

}
