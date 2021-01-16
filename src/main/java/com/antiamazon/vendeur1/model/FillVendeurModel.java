package com.antiamazon.vendeur1.model;

import org.springframework.lang.Nullable;

public class FillVendeurModel {

    private String soc;
    private String desc;
    private String rue;
    private String ville;
    private int cp;
    @Nullable
    private String paiementCB;
    @Nullable
    private String paiementPaypal;
    @Nullable
    private String paiementCheque;
    @Nullable
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

    @Nullable
    public String getPaiementCB() {
        return paiementCB;
    }

    public void setPaiementCB(@Nullable String paiementCB) {
        this.paiementCB = paiementCB;
    }

    @Nullable
    public String getPaiementPaypal() {
        return paiementPaypal;
    }

    public void setPaiementPaypal(@Nullable String paiementPaypal) {
        this.paiementPaypal = paiementPaypal;
    }

    @Nullable
    public String getPaiementCheque() {
        return paiementCheque;
    }

    public void setPaiementCheque(@Nullable String paiementCheque) {
        this.paiementCheque = paiementCheque;
    }

    @Nullable
    public String getPhoto64() {
        return photo64;
    }

    public void setPhoto64(@Nullable String photo64) {
        this.photo64 = photo64;
    }
}
