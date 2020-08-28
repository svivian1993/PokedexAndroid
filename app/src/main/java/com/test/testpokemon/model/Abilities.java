package com.test.testpokemon.model;

import com.google.gson.annotations.SerializedName;

public class Abilities {

    @SerializedName("ability")
    private Ability ability;
    @SerializedName("isHidden")
    private boolean isHidden;
    @SerializedName("slot")
    private int slot;

    public Abilities(Ability ability, boolean isHidden, int slot) {
        this.ability = ability;
        this.isHidden = isHidden;
        this.slot = slot;
    }

    public Ability getAbility() {
        return ability;
    }

    public void setAbility(Ability ability) {
        this.ability = ability;
    }

    public boolean isHidden() {
        return isHidden;
    }

    public void setHidden(boolean hidden) {
        isHidden = hidden;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }
}
