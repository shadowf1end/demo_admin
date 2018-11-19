package com.wf.ew.system.service;

import com.wf.ew.common.PageResult;
import com.wf.ew.system.model.WxUser;

public interface WxUserService {
    PageResult<WxUser> list(int pageNum, int pageSize);
}
