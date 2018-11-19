package com.wf.ew.system.controller;

import com.wf.ew.common.PageResult;
import com.wf.ew.system.model.WxUser;
import com.wf.ew.system.service.WxUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wxUser")
public class WxUserController {
    @Autowired
    private WxUserService wxUserService;
    @PostMapping("/query")
    public PageResult<WxUser> list(Integer page, Integer limit) {
        if (page == null) {
            page = 0;
            limit = 0;
        }
        return wxUserService.list(page, limit);
    }
}
