package com.wf.ew.system.controller;

import com.wf.ew.common.JsonResult;
import com.wf.ew.common.PageResult;
import com.wf.ew.system.model.Node;
import com.wf.ew.system.service.NodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/node")
public class NodeController {
    @Autowired
    private NodeService nodeService;

    @PostMapping("/query")
    public PageResult<Node> list(Integer page, Integer limit) {
        if (page == null) {
            page = 0;
            limit = 0;
        }
        return nodeService.list(page, limit);
    }

    @PostMapping()
    public JsonResult add(Node node) {
        if (nodeService.add(node)) {
            return JsonResult.ok("添加成功");
        } else {
            return JsonResult.error("添加失败");
        }
    }

    @PutMapping()
    public JsonResult update(Node node) {
        if (nodeService.update(node)) {
            return JsonResult.ok("修改成功！");
        } else {
            return JsonResult.error("修改失败！");
        }
    }

    @DeleteMapping("/{id}")
    public JsonResult delete(@PathVariable("id") Integer value) {
        if (nodeService.delete(value)) {
            return JsonResult.ok("修改成功！");
        } else {
            return JsonResult.error("修改失败！");
        }
    }
}
