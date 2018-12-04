package com.fm.service;

import java.util.List;

/**
 * Created on 2018/9/29.
 *
 * @author guochangji
 */
public interface BaseService<T> {

    /**
     * 根据ID删除
     * @param id id
     * @return 返回受影响行数
     */
    abstract Integer deleteById(Integer id);

    /**
     * 修改记录
     * @param entity entity
     * @return 返回受影响行数
     */
    abstract Integer update(T entity);

    /**
     * 添加记录
     * @param entity entity
     * @return 返回受影响行数
     */
    abstract Integer save(T entity);

    /**
     * 查找全部
     * @return 返回list
     */
    abstract List<T> findAll();

    /**
     * 根据ID查找
     * @param id id
     * @return T
     */
    abstract T findById(Integer id);
}
