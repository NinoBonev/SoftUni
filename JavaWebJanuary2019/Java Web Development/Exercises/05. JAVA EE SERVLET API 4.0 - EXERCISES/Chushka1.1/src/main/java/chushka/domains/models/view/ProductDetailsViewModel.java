package chushka.domains.models.view;

import chushka.domains.entities.Type;

/**
 * Created by Nino Bonev - 7.2.2019 г., 14:57
 */
public class ProductDetailsViewModel {

    private String name;
    private String description;
    private Type type;

    public ProductDetailsViewModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
