package com.hy.pojo;

import java.util.Date;

public class CpmEx {
    private Integer id;

    private Integer cid;

    private String cname;

    private Long cpm;

    private Date cpmDate;

    private String status;

    private Long cpmDiff;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

    public Long getCpm() {
        return cpm;
    }

    public void setCpm(Long cpm) {
        this.cpm = cpm;
    }

    public Date getCpmDate() {
        return cpmDate;
    }

    public void setCpmDate(Date cpmDate) {
        this.cpmDate = cpmDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Long getCpmDiff() {
        return cpmDiff;
    }

    public void setCpmDiff(Long cpmDiff) {
        this.cpmDiff = cpmDiff;
    }
}