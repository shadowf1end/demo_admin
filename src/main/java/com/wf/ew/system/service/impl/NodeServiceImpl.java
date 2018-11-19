package com.wf.ew.system.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.wf.ew.common.PageResult;
import com.wf.ew.system.dao.NodeMapper;
import com.wf.ew.system.model.Node;
import com.wf.ew.system.service.NodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("nodeService")
public class NodeServiceImpl implements NodeService {
    @Autowired
    private NodeMapper nodeMapper;

    @Override
    public PageResult<Node> list(int pageNum, int pageSize) {
        Wrapper<Node> wrapper = new EntityWrapper<>();
        Page<Node> nodePage = new Page<>(pageNum, pageSize);
        List<Node> nodeList = nodeMapper.selectPage(nodePage, wrapper);
        return new PageResult<>(nodePage.getTotal(), nodeList);
    }

    @Override
    public boolean add(Node node) {
        return nodeMapper.insert(node) > 0;
    }

    @Override
    public boolean update(Node node) {
        return nodeMapper.updateById(node) > 0;
    }

    @Override
    public boolean delete(int value) {
        return nodeMapper.deleteById(value) > 0;
    }
}
