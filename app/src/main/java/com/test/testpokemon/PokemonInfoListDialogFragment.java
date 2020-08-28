package com.test.testpokemon;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.gson.Gson;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;
import com.test.testpokemon.model.PokemonInformation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


public class PokemonInfoListDialogFragment extends BottomSheetDialogFragment {

    private TextView tvPokemonName;
    private TextView tvPokemonBaseExperienceValue;
    private TextView tvPokemonWeightValue;
    private TextView tvPokemonHeightValue;
    private ImageView ivPokemon;
    private PokemonInformation selectedPokemon;

    private void initializeLayout(View view) {
        tvPokemonName = view.findViewById(R.id.tvPokemonName);
        tvPokemonBaseExperienceValue = view.findViewById(R.id.tvPokemonBaseExperienceValue);
        tvPokemonWeightValue = view.findViewById(R.id.tvPokemonWeightValue);
        tvPokemonHeightValue = view.findViewById(R.id.tvPokemonHeightValue);
        ivPokemon = view.findViewById(R.id.ivPokemon);
    }

    private void setDataToView() {
        tvPokemonName.setText(selectedPokemon.getName().toUpperCase());
        tvPokemonBaseExperienceValue.setText(String.valueOf(selectedPokemon.getBaseExperience()));
        tvPokemonWeightValue.setText(String.valueOf(selectedPokemon.getWeight()));
        tvPokemonHeightValue.setText(String.valueOf(selectedPokemon.getHeight()));

        //Help to load image from URL inside image view
        Picasso.Builder builder = new Picasso.Builder(getContext());
        builder.downloader(new OkHttp3Downloader(getContext()));
        builder.build().load(selectedPokemon.getSprites().getFront_default())
                .placeholder((R.drawable.ic_launcher_background))
                .error(R.drawable.ic_launcher_background)
                .into(ivPokemon);
    }

    public PokemonInfoListDialogFragment(String selectedPokemonDataObjectAsAString) {
        Gson gson = new Gson();
        this.selectedPokemon = gson.fromJson(selectedPokemonDataObjectAsAString, PokemonInformation.class);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_pokemoninfo_list_dialog, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initializeLayout(view);
        setDataToView();
    }
}
