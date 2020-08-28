package com.test.testpokemon;

import android.app.ProgressDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.test.testpokemon.model.Pokemon;
import com.test.testpokemon.model.PokemonInformation;
import com.test.testpokemon.network.GetDataService;
import com.test.testpokemon.network.RetrofitClientInstance;


import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private List<Pokemon> dataList;
    private Context context;

    public CustomAdapter(Context context, List<Pokemon> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        public final View mView;

        TextView tvPokemonNameValue;
        CardView rowItem;

        CustomViewHolder(View itemView) {
            super(itemView);
            mView = itemView;

            tvPokemonNameValue = mView.findViewById(R.id.tvPokemonNameValue);
            rowItem = mView.findViewById(R.id.rowItem);
        }
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.custom_row, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, final int position) {
        holder.tvPokemonNameValue.setText(dataList.get(position).getName().toUpperCase());
        holder.rowItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                ProgressDialog progressDoalog = new ProgressDialog(context);
                progressDoalog.setMessage("Loading....");
                progressDoalog.show();
                getPokemonInformationCall(position , progressDoalog);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    private void getPokemonInformationCall(int position, final ProgressDialog progressDoalog){
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<PokemonInformation> call = service.getSelectedPokemon(dataList.get(position).getUrl());
        call.enqueue(new Callback<PokemonInformation>() {
            @Override
            public void onResponse(Call<PokemonInformation> call, Response<PokemonInformation> response) {
                progressDoalog.dismiss();
                PokemonInformation selectedPokemon = response.body();
                Gson gson = new Gson();
                String selectedPokemonDataObjectAsAString = gson.toJson(selectedPokemon);

//                LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//                View dialogView = inflater.inflate(R.layout.fragment_pokemoninfo_list_dialog, null);
//                BottomSheetDialog dialog = new BottomSheetDialog(context);
//                dialog.setContentView(dialogView);
//                dialog.show();

                PokemonInfoListDialogFragment bottomSheetFragment = new PokemonInfoListDialogFragment(selectedPokemonDataObjectAsAString);
                bottomSheetFragment.show(((AppCompatActivity)context).getSupportFragmentManager(), bottomSheetFragment.getTag());
//                Intent intent = new Intent(context, PokemonInformationActivity.class);
//                intent.putExtra("MyPokemonObjectAsString", selectedPokemonDataObjectAsAString);
//                context.startActivity(intent);
            }

            @Override
            public void onFailure(Call<PokemonInformation> call, Throwable t) {
                progressDoalog.dismiss();
                Toast.makeText(context, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
