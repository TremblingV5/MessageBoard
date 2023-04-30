package org.demo.service.base;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import lombok.extern.slf4j.Slf4j;
import org.demo.entity.base.DataEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
public abstract class CrudService<M extends BaseMapper<T>,T extends DataEntity<T>> {

    @Autowired
    protected M mapper;

    public CrudService() {
    }

    public T get(String id) {
        QueryWrapper<T> wrapper = new QueryWrapper<T>().eq("id", id);
        List<T> list = this.findList(wrapper);
        if (0 < list.size()) {
            return list.get(0);
        } else {
            return null;
        }
//        return this.mapper.selectById(id);
    }

    public List<T> findList(QueryWrapper<T> wrapper) {
        wrapper.eq("del_flag",0);
        return this.mapper.selectList(wrapper);
    }

    public List<T> findAllList(QueryWrapper<T> wrapper) {
        return this.mapper.selectList(wrapper);
    }

    public int save(T entity) {
        int result = 0;
        if (entity.isNewRecord()) {
            entity.preInsert();
            result = this.mapper.insert(entity);
        } else {
            entity.preUpdate();
            result = this.mapper.updateById(entity);
        }
        return result;
    }

    public int delete(T entity) {
        int result = 0;
        if (entity != null) {
            entity.setDelFlag("1");
            entity.preUpdate();
            result = this.mapper.updateById(entity);
        }
        return result;
    }


}
