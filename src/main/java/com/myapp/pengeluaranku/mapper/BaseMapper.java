package com.myapp.pengeluaranku.mapper;

import java.util.List;

public interface BaseMapper<M, V, T> {


  T toVO(M model);
  M toModel(V vo);
  List<T> toVO(List<M> models);
  List<M> toModel(List<V> vos);

}