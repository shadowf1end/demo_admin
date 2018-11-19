package com.wf.ew.system.controller;

import com.wf.ew.common.JsonResult;
import com.wf.ew.common.PageResult;
import com.wf.ew.system.model.Number;
import com.wf.ew.system.service.NumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/number")
public class NumberController {
    @Autowired
    private NumberService numberService;

    @PostMapping("/query")
    public PageResult<Number> list(Integer page, Integer limit) {
        if (page == null) {
            page = 0;
            limit = 0;
        }
        return numberService.list(page, limit);
    }

    @PutMapping()
    public JsonResult update(Number number) {
        if (numberService.update(number)) {
            return JsonResult.ok("修改成功！");
        } else {
            return JsonResult.error("修改失败！");
        }
    }
}
