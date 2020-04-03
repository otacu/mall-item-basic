
package com.egoist.mall.item.basic.service;

import com.egoist.mall.item.basic.dao.SpuMapper;
import com.egoist.mall.item.basic.pojo.Spu;
import com.egoist.mall.parent.constant.EgoistResultStatusConstant;
import com.egoist.mall.parent.pojo.EgoistResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SpuService {
    @Autowired
    private SpuMapper spuMapper;

    public EgoistResult queryById(Long id) {
        Spu spu = spuMapper.selectByPrimaryKey(id);
        if (spu == null) {
            return new EgoistResult(EgoistResultStatusConstant.STATUS_400, "查询spu失败", null);
        }
        return EgoistResult.ok(spu);
    }
}
