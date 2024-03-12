package bitlab.techorda.g1.firstsprint.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Student {
    private Long id;
    private String firstName;
    private String lastName;
    private Integer exam;
    private String mark;
}
