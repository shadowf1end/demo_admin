package com.wf.ew.system.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.wf.ew.common.PageResult;
import com.wf.ew.system.dao.ImageMapper;
import com.wf.ew.system.model.Image;
import com.wf.ew.system.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("imageService")
public class ImageServiceImpl implements ImageService {
    @Autowired
    private ImageMapper imageMapper;

    @Override
    public PageResult<Image> list(int pageNum, int pageSize) {
        Wrapper<Image> wrapper = new EntityWrapper<>();
        Page<Image> nodePage = new Page<>(pageNum, pageSize);
        List<Image> nodeList = imageMapper.selectPage(nodePage, wrapper);
        return new PageResult<>(nodePage.getTotal(), nodeList);
    }

    @Override
    public boolean add(Image image) {
        return imageMapper.insert(image) > 0;
    }

    @Override
    public boolean update(Image image) {
        return imageMapper.updateById(image) > 0;
    }

    @Override
    public boolean delete(int id) {
        return imageMapper.deleteById(id) > 0;
    }
}
