package org.demo.entity.base;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.io.Serializable;

/**
 * @desc 基本实体类
 * @date 2022/11/26
 */

@Accessors(chain = true)
public abstract class BaseEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String DEL_FLAG_NORMAL = "0";
    public static final String DEL_FLAG_DELETE = "1";

    protected Long id;

    @TableField(exist = false)
    protected boolean isNewRecord = false;

    public BaseEntity() {
    }

    public BaseEntity(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public abstract void preInsert();

    public abstract void preUpdate();

    @JsonIgnore
    public boolean isNewRecord() {
        return this.isNewRecord;
    }

    public void setNewRecord(boolean newRecord) {
        this.isNewRecord = newRecord;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }


}
