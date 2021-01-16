package com.antiamazon.vendeur1.model;

import org.springframework.lang.Nullable;

public class NewAdresseModel {

    @Nullable
    private String rue;
    @Nullable
    private String ville;
    @Nullable
    private int cp;

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
}
