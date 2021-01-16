package com.antiamazon.vendeur1.model;

import com.antiamazon.vendeur1.entity.Adresse;

public class UpdateVendeurModel {

    private String soc;
    private String desc;
    private String rue;
    private String ville;
    private int cp;
    private String photo64;


    public String getSoc() {
        return soc;
    }

    public void setSoc(String soc) {
        this.soc = soc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public String getPhoto64() {
        return photo64;
    }

    public void setPhoto64(String photo64) {
        this.photo64 = photo64;
    }
}
