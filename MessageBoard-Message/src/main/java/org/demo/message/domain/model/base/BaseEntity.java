package org.demo.message.domain.model.base;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.MappedSuperclass;

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
