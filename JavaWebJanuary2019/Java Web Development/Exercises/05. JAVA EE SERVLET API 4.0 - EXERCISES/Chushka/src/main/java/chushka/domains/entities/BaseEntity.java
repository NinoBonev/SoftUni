package chushka.domains.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by Nino Bonev - 2.2.2019 г., 11:32
 */

@MappedSuperclass
public abstract class BaseEntity {

    private String id;

    public BaseEntity() {
    }

    @Id
    @GeneratedValue(generator = "uuid-string")
    @GenericGenerator(name = "uuid-string", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", nullable = false, updatable = false , unique = true)
    public String getId() {
        return id;
    }

}
