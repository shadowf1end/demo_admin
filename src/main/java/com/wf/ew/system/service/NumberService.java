package com.wf.ew.system.service;

import com.wf.ew.common.PageResult;
import com.wf.ew.system.model.Number;

public interface NumberService {
    PageResult<Number> list(int pageNum, int pageSize);

    boolean update(Number number);
}
