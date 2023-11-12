package com.example.service;

import com.example.model.Student;

import java.util.List;

public interface IStudentService<E> {
    List<E> FindAll();

    boolean add(E e);

    boolean edit(int id, E e);

    boolean delete(int id);

    int findIndexById(int id);

    E findStudentById(int id);
}