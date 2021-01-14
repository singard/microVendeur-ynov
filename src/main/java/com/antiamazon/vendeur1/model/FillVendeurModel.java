package com.antiamazon.vendeur1.model;

import org.springframework.lang.Nullable;

public class FillVendeurModel {

    private String soc;
    private String desc;
    private String rue;
    private String ville;
    private int cp;
    private String paiementCB;
    private String paiementPaypal;
    @Nullable
    private String paiementCheque;
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

    public String getPaiementCB() {
        return paiementCB;
    }

    public void setPaiementCB(String paiementCB) {
        this.paiementCB = paiementCB;
    }

    public String getPaiementPaypal() {
        return paiementPaypal;
    }

    public void setPaiementPaypal(String paiementPaypal) {
        this.paiementPaypal = paiementPaypal;
    }

    @Nullable
    public String getPaiementCheque() {
        return paiementCheque;
    }

    public void setPaiementCheque(@Nullable String paiementCheque) {
        this.paiementCheque = paiementCheque;
    }

    public String getPhoto64() {
        return photo64;
    }

    public void setPhoto64(String photo64) {
        this.photo64 = photo64;
    }
}
