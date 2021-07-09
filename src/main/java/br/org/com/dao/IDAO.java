package br.org.com.dao;

import java.util.List;

public interface IDAO <E>{

    public void create(E e);

    public E getOne(Integer id);

    public List<E> getAll();
}
