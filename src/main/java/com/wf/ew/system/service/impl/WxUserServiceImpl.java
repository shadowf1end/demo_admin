package com.wf.ew.system.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.wf.ew.common.PageResult;
import com.wf.ew.system.dao.WxUserMapper;
import com.wf.ew.system.model.WxUser;
import com.wf.ew.system.service.WxUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("wxUserService")
public class WxUserServiceImpl implements WxUserService {
    @Autowired
    private WxUserMapper wxUserMapper;

    @Override
    public PageResult<WxUser> list(int pageNum, int pageSize) {
        Wrapper<WxUser> wrapper = new EntityWrapper<>();
        Page<WxUser> userPage = new Page<>(pageNum, pageSize);
        List<WxUser> userList = wxUserMapper.selectPage(userPage, wrapper);
        return new PageResult<>(userPage.getTotal(), userList);
    }
}
