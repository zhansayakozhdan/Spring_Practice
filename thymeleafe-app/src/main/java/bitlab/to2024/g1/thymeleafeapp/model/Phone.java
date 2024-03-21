package bitlab.to2024.g1.thymeleafeapp.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Phone {
    private Long id;
    private String name;
    private Integer price;
    private String description;
    private String status;
}
