package com.mukflix.backend.apiserver.dto;

public class User {
    String usr_nm;
    String gend;
    String usr_email;
    String birth;
    String usr_sq;
    String join_dd;
    String lst_chg_dd;

    public String getUsr_nm() {
        return usr_nm;
    }

    public void setUsr_nm(String usr_nm) {
        this.usr_nm = usr_nm;
    }

    public String getGend() {
        return gend;
    }

    public void setGend(String gend) {
        this.gend = gend;
    }

    public String getUsr_email() {
        return usr_email;
    }

    public void setUsr_email(String usr_email) {
        this.usr_email = usr_email;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getUsr_sq() {
        return usr_sq;
    }

    public void setUsr_sq(String usr_sq) {
        this.usr_sq = usr_sq;
    }

    public String getJoin_dd() {
        return join_dd;
    }

    public void setJoin_dd(String join_dd) {
        this.join_dd = join_dd;
    }

    public String getLst_chg_dd() {
        return lst_chg_dd;
    }

    public void setLst_chg_dd(String lst_chg_dd) {
        this.lst_chg_dd = lst_chg_dd;
    }

    @Override
    public String toString() {
        return "User{" +
                "usr_nm='" + usr_nm + '\'' +
                ", gend='" + gend + '\'' +
                ", usr_email='" + usr_email + '\'' +
                ", birth='" + birth + '\'' +
                ", usr_sq='" + usr_sq + '\'' +
                ", join_dd='" + join_dd + '\'' +
                ", lst_chg_dd='" + lst_chg_dd + '\'' +
                '}';
    }
}
