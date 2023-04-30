package org.demo.entity.base;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @desc 数据库基本对象映射类
 * @date 2022/11/26
 */
@Accessors(chain = true)
public abstract class DataEntity<T>  extends BaseEntity<T> {

    private static final long serialVersionUID = 1L;

    protected String remarks;

    protected Date createDate;

    protected Date updateDate;

    protected String delFlag;

    public DataEntity() {
        this.delFlag = "0";
    }

    public DataEntity(Long id) {
        super(id);
    }

    @Override
    public void preInsert() {
        if (!this.isNewRecord) {
            this.setId(IdWorker.getId(this));
        }
        this.updateDate = new Date();
        this.createDate = this.updateDate;
    }

    @Override
    public void preUpdate() {
        this.updateDate = new Date();
    }


    public String getRemarks() {
        return this.remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss",
            timezone = "GMT+8"
    )
    public Date getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss",
            timezone = "GMT+8"
    )
    public Date getUpdateDate() {
        return this.updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getDelFlag() {
        return this.delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

}
