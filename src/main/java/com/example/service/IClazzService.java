package com.example.service;

import com.example.model.Clazz;

import java.util.List;

public interface IClazzService<E> {
     List<E> findAll();
}
