package com.test.testpokemon.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PokemonInformation {
    @SerializedName("id")
    private int id;
    @SerializedName("abilities")
    private List<Abilities> abilities;
    @SerializedName("sprites")
    private Sprites sprites;
    @SerializedName("baseExperience")
    private int baseExperience;
    @SerializedName("height")
    private int height;
    @SerializedName("weight")
    private int weight;
    @SerializedName("name")
    private String name;
    /*
     * Additional attributes to add later:
     * forms
     * game_indices
     * held_items
     * is_default
     * location_area_encounters
     * moves
     * order
     * species
     * stats
     * types
     *
     * */

    public PokemonInformation(int id, List<Abilities> abilities, Sprites sprites, int baseExperience, int height, int weight, String name) {
        this.id = id;
        this.abilities = abilities;
        this.sprites = sprites;
        this.baseExperience = baseExperience;
        this.height = height;
        this.weight = weight;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Abilities> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Abilities> abilities) {
        this.abilities = abilities;
    }

    public Sprites getSprites() {
        return sprites;
    }

    public void setSprites(Sprites sprites) {
        this.sprites = sprites;
    }

    public int getBaseExperience() {
        return baseExperience;
    }

    public void setBaseExperience(int baseExperience) {
        this.baseExperience = baseExperience;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
