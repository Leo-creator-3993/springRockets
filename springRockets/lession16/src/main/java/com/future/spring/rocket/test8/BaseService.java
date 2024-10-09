package com.future.spring.rocket.test8;

import com.future.spring.rocket.test8.dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseService<T> {

    @Autowired
    IDao<T> dao;

    public IDao<T> getDao() {
        return dao;
    }

    public void setDao(IDao<T> dao) {
        this.dao = dao;
    }
}
