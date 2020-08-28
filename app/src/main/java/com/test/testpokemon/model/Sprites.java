package com.test.testpokemon.model;

import com.google.gson.annotations.SerializedName;

public class Sprites {

    @SerializedName("back_default")
    private String back_default;
    @SerializedName("back_female")
    private String back_female;
    @SerializedName("back_shiny_female")
    private String back_shiny_female;
    @SerializedName("front_default")
    private String front_default;
    @SerializedName("front_female")
    private String front_female;
    @SerializedName("front_shiny")
    private String front_shiny;
    @SerializedName("front_shiny_female")
    private String front_shiny_female;

    public Sprites(String back_default, String back_female, String back_shiny_female, String front_default, String front_female, String front_shiny, String front_shiny_female) {
        this.back_default = back_default;
        this.back_female = back_female;
        this.back_shiny_female = back_shiny_female;
        this.front_default = front_default;
        this.front_female = front_female;
        this.front_shiny = front_shiny;
        this.front_shiny_female = front_shiny_female;
    }

    public String getBack_default() {
        return back_default;
    }

    public void setBack_default(String back_default) {
        this.back_default = back_default;
    }

    public String getBack_female() {
        return back_female;
    }

    public void setBack_female(String back_female) {
        this.back_female = back_female;
    }

    public String getBack_shiny_female() {
        return back_shiny_female;
    }

    public void setBack_shiny_female(String back_shiny_female) {
        this.back_shiny_female = back_shiny_female;
    }

    public String getFront_default() {
        return front_default;
    }

    public void setFront_default(String front_default) {
        this.front_default = front_default;
    }

    public String getFront_female() {
        return front_female;
    }

    public void setFront_female(String front_female) {
        this.front_female = front_female;
    }

    public String getFront_shiny() {
        return front_shiny;
    }

    public void setFront_shiny(String front_shiny) {
        this.front_shiny = front_shiny;
    }

    public String getFront_shiny_female() {
        return front_shiny_female;
    }

    public void setFront_shiny_female(String front_shiny_female) {
        this.front_shiny_female = front_shiny_female;
    }
}
