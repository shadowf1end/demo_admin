package com.wf.ew.system.service;

import com.wf.ew.common.PageResult;
import com.wf.ew.system.model.Document;

public interface DocumentService {
    PageResult<Document> list(int pageNum, int pageSize);

    boolean add(Document document);

    boolean update(Document document);

    boolean delete(int id);
}
