package com.nf147.post.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Post {
    private Integer p_id;

    private String p_name;

    private String p_title;

    private String p_content;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date p_date;

    public Integer getP_id() {
        return p_id;
    }

    public void setP_id(Integer p_id) {
        this.p_id = p_id;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name == null ? null : p_name.trim();
    }

    public String getP_title() {
        return p_title;
    }

    public void setP_title(String p_title) {
        this.p_title = p_title == null ? null : p_title.trim();
    }

    public String getP_content() {
        return p_content;
    }

    public void setP_content(String p_content) {
        this.p_content = p_content == null ? null : p_content.trim();
    }

    public Date getP_date() {
        return p_date;
    }

    public void setP_date(Date p_date) {
        this.p_date = p_date;
    }
}