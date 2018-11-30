package com.wf.ew.system.controller;

import com.wf.ew.common.JsonResult;
import com.wf.ew.common.PageResult;
import com.wf.ew.system.model.Document;
import com.wf.ew.system.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

    @PostMapping("/upload")
    public JsonResult upload(@RequestParam MultipartFile file, Integer value, HttpServletRequest request) throws IOException {
        if (value == null) {
            return JsonResult.error("请输入所属菜单ID");
        }
        String docUrl = upload(file, request);
        Document document = new Document();
        document.setCreateTime(LocalDateTime.now());
        document.setUpdateTime(LocalDateTime.now());
        document.setUrl(docUrl);
        document.setValue(value);
        String name = file.getOriginalFilename().split("\\.")[0];
        document.setDesc(name);
        document.setTitle(name);
        if (documentService.add(document)) {
            return JsonResult.ok("添加成功");
        } else {
            return JsonResult.error("添加失败，请重新添加");
        }
    }

    private static String upload(MultipartFile file, HttpServletRequest request) throws IOException {
        String pathval = request.getSession().getServletContext().getRealPath("/");
        String newFileDir = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-"));

        String saveFilePath = "docs/";
        /* 构建文件目录 */
        File fileDir = new File(pathval + saveFilePath);
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }
        ;

        String docPath = saveFilePath + newFileDir + file.getOriginalFilename();
        FileOutputStream out = new FileOutputStream(pathval + docPath);
        // 写入文件
        out.write(file.getBytes());
        out.flush();
        out.close();
        docPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/" + docPath;
        return docPath;
    }
}
