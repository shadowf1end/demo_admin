package com.wf.ew.system.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.wf.ew.common.PageResult;
import com.wf.ew.system.dao.NumberMapper;
import com.wf.ew.system.model.Number;
import com.wf.ew.system.service.NumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("numberService")
public class NumberServiceImpl implements NumberService {
    @Autowired
    private NumberMapper numberMapper;
    @Override
    public PageResult<Number> list(int pageNum, int pageSize) {
        Wrapper<Number> wrapper = new EntityWrapper<>();
        Page<Number> nodePage = new Page<>(pageNum, pageSize);
        List<Number> nodeList = numberMapper.selectPage(nodePage, wrapper);
        return new PageResult<>(nodePage.getTotal(), nodeList);
    }

    @Override
    public boolean update(Number number) {
        return numberMapper.updateById(number) > 0;
    }
}
