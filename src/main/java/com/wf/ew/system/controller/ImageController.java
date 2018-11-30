package com.wf.ew.system.controller;

import com.wf.ew.common.JsonResult;
import com.wf.ew.common.PageResult;
import com.wf.ew.system.model.Image;
import com.wf.ew.system.service.ImageService;
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
@RequestMapping("/image")
public class ImageController {
    @Autowired
    private ImageService imageService;

    @GetMapping("/list")
    public PageResult<Image> list(Integer page, Integer limit) {
        if (page == null) {
            page = 0;
            limit = 0;
        }
        return imageService.list(page, limit);
    }

    @RequestMapping("/upload")
    public JsonResult upload(@RequestParam MultipartFile file, @RequestParam(required = false) Integer imgId, HttpServletRequest request) throws IOException {
        String imgUrl = uploadImg(file, request);
        Image image = new Image();
        image.setImg(imgUrl);
        image.setUpdateTime(LocalDateTime.now());
        if(imgId == null) {
            image.setCreateTime(LocalDateTime.now());
            if(imageService.add(image)) {
                return JsonResult.ok("添加成功");
            }else {
                return JsonResult.error("添加失败，请重新添加");
            }
        } else {
            image.setImg(imgUrl);
            image.setId(imgId);
            if(imageService.update(image)){
                return JsonResult.ok("修改成功");
            }else {
                return JsonResult.error("修改失败，请重新操作");
            }
        }
    }

    @RequestMapping("/delete")
    public JsonResult delete(Integer id) {
        if (imageService.delete(id)) {
            return JsonResult.ok("修改成功！");
        } else {
            return JsonResult.error("修改失败！");
        }
    }

    private static String uploadImg(MultipartFile file, HttpServletRequest request) throws IOException {
        String pathval = request.getSession().getServletContext().getRealPath("/");
        String newFileName = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS"));

        String saveFilePath = "images/";
        /* 构建文件目录 */
        File fileDir = new File(pathval + saveFilePath);
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }
        //上传的文件名
        String filename = file.getOriginalFilename();
        //文件的扩张名
        String extensionName = filename.substring(filename.lastIndexOf(".") + 1);

        String imgPath = saveFilePath + newFileName + "." + extensionName;
        FileOutputStream out = new FileOutputStream(pathval + imgPath);
        // 写入文件
        out.write(file.getBytes());
        out.flush();
        out.close();
        imgPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/" + imgPath;
        return imgPath;
    }
}
