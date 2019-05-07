package com.el.springboot.service;

import com.el.springboot.model.Dept;

import java.util.List;

/**
 * @Auther: roman.zhang
 * @Date: 2019/4/28 17:14
 * @Version:V1.0
 * @Description:DeptService
 */
public interface DeptService {
    boolean add(Dept dept);
    Dept    get(Long id);
    List<Dept> list();
}
