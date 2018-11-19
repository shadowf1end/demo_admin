package com.wf.ew.system.controller;

import com.wf.ew.common.JsonResult;
import com.wf.ew.common.PageResult;
import com.wf.ew.system.model.Document;
import com.wf.ew.system.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/document")
public class DocumentController {
    @Autowired
    private DocumentService documentService;

    @PostMapping("/query")
    public PageResult<Document> list(Integer page, Integer limit) {
        if (page == null) {
            page = 0;
            limit = 0;
        }
        return documentService.list(page, limit);
    }

    @PostMapping()
    public JsonResult add(Document document) {
        if (documentService.add(document)) {
            return JsonResult.ok("添加成功");
        } else {
            return JsonResult.error("添加失败");
        }
    }

    @PutMapping()
    public JsonResult update(Document document) {
        if (documentService.update(document)) {
            return JsonResult.ok("修改成功！");
        } else {
            return JsonResult.error("修改失败！");
        }
    }

    @DeleteMapping("/{id}")
    public JsonResult delete(@PathVariable("id") Integer id) {
        if (documentService.delete(id)) {
            return JsonResult.ok("修改成功！");
        } else {
            return JsonResult.error("修改失败！");
        }
    }
}
