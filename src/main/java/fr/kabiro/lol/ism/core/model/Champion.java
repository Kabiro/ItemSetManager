package fr.kabiro.lol.ism.core.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Champion {

    @Id
    private String key;

    private String name;

    private String title;

    private Long id;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
