package com.wf.ew.system.service;

import com.wf.ew.common.PageResult;
import com.wf.ew.system.model.Node;

public interface NodeService {
    PageResult<Node> list(int pageNum, int pageSize);

    boolean add(Node node);

    boolean update(Node node);

    boolean delete(int value);
}
