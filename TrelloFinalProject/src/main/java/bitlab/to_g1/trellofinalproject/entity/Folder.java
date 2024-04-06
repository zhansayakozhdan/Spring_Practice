package bitlab.to_g1.trellofinalproject.entity;

import bitlab.to_g1.trellofinalproject.entity.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
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
