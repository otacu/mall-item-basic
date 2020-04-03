package com.egoist.mall.item.basic.dao;

import com.egoist.mall.item.basic.pojo.Spu;
import com.egoist.mall.item.basic.pojo.SpuExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SpuMapper {
    long countByExample(SpuExample example);

    int deleteByExample(SpuExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Spu record);

    int insertSelective(Spu record);

    List<Spu> selectByExample(SpuExample example);

    Spu selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Spu record, @Param("example") SpuExample example);

    int updateByExample(@Param("record") Spu record, @Param("example") SpuExample example);

    int updateByPrimaryKeySelective(Spu record);

    int updateByPrimaryKey(Spu record);
}