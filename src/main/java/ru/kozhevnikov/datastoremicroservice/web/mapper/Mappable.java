package ru.kozhevnikov.datastoremicroservice.web.mapper;

import java.util.List;

public interface Mappable<E, D> {

    E toEntity(D d);

    List<E> toEntity(List<D> d);

    D toDto(E e);

    List<D> toDto(List<E> e);

//    E toEntity(D dto);
//
//    List<E> toEntity(List<D> dto);
//
//    D toDto(E entity);
//
//    List<D> toDto(List<E> entity);
}
