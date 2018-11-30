package com.wf.ew.system.model;


import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

@TableName("mp_number")
public class Number {
    @TableId
    private Integer id;
    @TableField("download_number")
    private Long downloadNum;
    @TableField("document_number")
    private Long docNum;
    @TableField("initial_download_number")
    private Long initDownloadNum;
    @TableField("initial_document_number")
    private Long initDocNum;
    private Integer sharePoint;
    private Integer downloadPoint;

    public Integer getDownloadPoint() {
        return downloadPoint;
    }

    public void setDownloadPoint(Integer downloadPoint) {
        this.downloadPoint = downloadPoint;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getDownloadNum() {
        return downloadNum;
    }

    public void setDownloadNum(Long downloadNum) {
        this.downloadNum = downloadNum;
    }

    public Long getDocNum() {
        return docNum;
    }

    public void setDocNum(Long docNum) {
        this.docNum = docNum;
    }

    public Long getInitDownloadNum() {
        return initDownloadNum;
    }

    public void setInitDownloadNum(Long initDownloadNum) {
        this.initDownloadNum = initDownloadNum;
    }

    public Long getInitDocNum() {
        return initDocNum;
    }

    public void setInitDocNum(Long initDocNum) {
        this.initDocNum = initDocNum;
    }

    public Integer getSharePoint() {
        return sharePoint;
    }

    public void setSharePoint(Integer sharePoint) {
        this.sharePoint = sharePoint;
    }
}
