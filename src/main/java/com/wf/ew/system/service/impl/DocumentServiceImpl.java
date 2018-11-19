package com.wf.ew.system.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.wf.ew.common.PageResult;
import com.wf.ew.system.dao.DocumentMapper;
import com.wf.ew.system.model.Document;
import com.wf.ew.system.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("documentService")
public class DocumentServiceImpl implements DocumentService {
    @Autowired
    private DocumentMapper documentMapper;

    @Override
    public PageResult<Document> list(int pageNum, int pageSize) {
        Wrapper<Document> wrapper = new EntityWrapper<>();
        Page<Document> nodePage = new Page<>(pageNum, pageSize);
        List<Document> nodeList = documentMapper.selectPage(nodePage, wrapper);
        return new PageResult<>(nodePage.getTotal(), nodeList);
    }

    @Override
    public boolean add(Document document) {
        return documentMapper.insert(document) > 0;
    }

    @Override
    public boolean update(Document document) {
        return documentMapper.updateById(document) > 0;
    }

    @Override
    public boolean delete(int id) {
        return documentMapper.deleteById(id) > 0;
    }
}
