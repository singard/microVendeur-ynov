package com.antiamazon.vendeur1.model;

import org.springframework.lang.Nullable;

public class NewPaiementModel {

    @Nullable
    private String paiementCB;
    @Nullable
    private String paiementPaypal;
    @Nullable
    private String paiementCheque;

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
}
