/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pritam.model;

/**
 *
 * @author Pritam
 */
public class NewsList {

     private double id;
     private String articlelink;
     private String image;
     private String data;
     private String heading1;
     private String cat;
     private String auth_detail;
     private String time_cptn;
     private String timestamp;
     private String time_date;

     
    public NewsList() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public NewsList(double id, String articlelink, String image, String data, String heading1, String cat, String auth_detail, String time_cptn, String timestamp, String time_date) {
        this.id = id;
        this.articlelink = articlelink;
        this.image = image;
        this.data = data;
        this.heading1 = heading1;
        this.cat = cat;
        this.auth_detail = auth_detail;
        this.time_cptn = time_cptn;
        this.timestamp = timestamp;
        this.time_date = time_date;
    }
    
    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public String getArticlelink() {
        return articlelink;
    }

    public void setArticlelink(String articlelink) {
        this.articlelink = articlelink;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHeading1() {
        return heading1;
    }

    public void setHeading1(String heading1) {
        this.heading1 = heading1;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public String getAuth_detail() {
        return auth_detail;
    }

    public void setAuth_detail(String auth_detail) {
        this.auth_detail = auth_detail;
    }

    public String getTime_cptn() {
        return time_cptn;
    }

    public void setTime_cptn(String time_cptn) {
        this.time_cptn = time_cptn;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getTime_date() {
        return time_date;
    }

    public void setTime_date(String time_date) {
        this.time_date = time_date;
    }

}
