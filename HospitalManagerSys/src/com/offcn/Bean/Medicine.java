package com.offcn.Bean;

import java.io.PrintWriter;

public class Medicine {
/*
    +-------------+--------------+------+-----+---------+-------+
            | Field       | Type         | Null | Key | Default | Extra |
            +-------------+--------------+------+-----+---------+-------+
            | mid         | varchar(100) | NO   | PRI | NULL    |       |
            | picture     | varchar(100) | YES  |     | NULL    |       |
            | inPrice     | double       | YES  |     | NULL    |       |
            | salPrice    | double       | YES  |     | NULL    |       |
            | name        | varchar(50)  | YES  |     | NULL    |       |
            | type        | int(11)      | YES  |     | NULL    |       |
            | descs       | varchar(200) | YES  |     | NULL    |       |
            | qualityDate | int(11)      | YES  |     | NULL    |       |
            | description | varchar(500) | YES  |     | NULL    |       |
            | produceFirm | varchar(80)  | YES  |     | NULL    |       |
            | readme      | varchar(300) | YES  |     | NULL    |       |
            | remark      | varchar(500) | YES  |     | NULL    |       |
            +-------------+--------------+------+-----+---------+-------+
*/
    private String mid;
    private String picture;
    private double inPrice;
    private double salPrice;
    private String name;
    private int type;
    private String descs;
    private int qualityDate;
    private String description;
    private String produceFirm;
    private String readme;
    private String remark;

    public Medicine() {
    }

    public Medicine(String mid, String picture, double inPrice, double salPrice, String name, int type, String descs, int qualityDate, String description, String produceFirm, String readme, String remark) {
        this.mid = mid;
        this.picture = picture;
        this.inPrice = inPrice;
        this.salPrice = salPrice;
        this.name = name;
        this.type = type;
        this.descs = descs;
        this.qualityDate = qualityDate;
        this.description = description;
        this.produceFirm = produceFirm;
        this.readme = readme;
        this.remark = remark;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public double getInPrice() {
        return inPrice;
    }

    public void setInPrice(double inPrice) {
        this.inPrice = inPrice;
    }

    public double getSalPrice() {
        return salPrice;
    }

    public void setSalPrice(double salPrice) {
        this.salPrice = salPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getDescs() {
        return descs;
    }

    public void setDescs(String descs) {
        this.descs = descs;
    }

    public int getQualityDate() {
        return qualityDate;
    }

    public void setQualityDate(int qualityDate) {
        this.qualityDate = qualityDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProduceFirm() {
        return produceFirm;
    }

    public void setProduceFirm(String produceFirm) {
        this.produceFirm = produceFirm;
    }

    public String getReadme() {
        return readme;
    }

    public void setReadme(String readme) {
        this.readme = readme;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "mid='" + mid + '\'' +
                ", picture='" + picture + '\'' +
                ", inPrice=" + inPrice +
                ", salPrice=" + salPrice +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", descs='" + descs + '\'' +
                ", qualityDate=" + qualityDate +
                ", description='" + description + '\'' +
                ", produceFirm='" + produceFirm + '\'' +
                ", readme='" + readme + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
