package chushka.domains.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * Created by Nino Bonev - 2.2.2019 г., 11:35
 */

@Entity(name = "products")
public class Product extends BaseEntity {


    private String name;
    private String description;
    private Type type;

    public Product() {
    }

    @Column(name = "name", unique = true, nullable = false)
    public String getName() {
        return name;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    public Type getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
