package bitlab.to_g1.trellofinalproject.entity;

import bitlab.to_g1.trellofinalproject.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "TASKS")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Task extends BaseEntity {
    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "DESCRIPTION")
    private String description; // TEXT

    @Column(name = "STATUS", nullable = false)
    private Integer status;        // 0 - todo, 1 - intest, 2 - done, 3 - failed

    @ManyToOne
    @JoinColumn(name = "FOLDER_ID")
    private Folder folder; // Many To One

}
