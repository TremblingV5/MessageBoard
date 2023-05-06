package org.demo.message.domain.model.base;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @GeneratedValue(generator = "SnowflakeUtil", strategy = GenerationType.SEQUENCE)
    @GenericGenerator(name = "SnowflakeUtil", strategy = "org.demo.message.infrastructure.utils.SnowflakeUtil")
    private Long id;

    public BaseEntity() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void preInsert() {

    }

    public void preUpdate() {

    }
}
