package fr.kabiro.lol.ism.core.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(of = {"key"})
public class Champion {

    @Id
    private String key;

    private String name;

    private String title;

    private Long id;
}
