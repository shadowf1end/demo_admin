package com.wf.ew.system.service;

import com.wf.ew.common.PageResult;
import com.wf.ew.system.model.Image;

public interface ImageService {
    PageResult<Image> list(int pageNum, int pageSize);

    boolean add(Image image);

    boolean update(Image image);

    boolean delete(int id);
}
