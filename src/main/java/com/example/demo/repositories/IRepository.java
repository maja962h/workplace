package com.example.demo.repositories;

import java.util.List;

public interface IRepository<T> {
    //ReadAll
    public List<T> getAllEntities();

    //ReadSingle
    public T getSingleById(int id);

    //Create
    public void create(T entity);

    //Update

    //Delete
}
