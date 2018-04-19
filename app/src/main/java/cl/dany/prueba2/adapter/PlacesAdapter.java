package cl.dany.prueba2.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.List;

import cl.dany.prueba2.R;
import cl.dany.prueba2.data.Queries;
import cl.dany.prueba2.models.Place;
//se extiende al RecyclerView llamando a su ViewHolder

public class PlacesAdapter extends RecyclerView.Adapter<PlacesAdapter.ViewHolder > {
    private List<Place> listPlace = new Queries().listPlaces();
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_place, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // se obtiene de la lista de Place la posicion
        Place place = listPlace.get(position);
        //se setean las vistas a mostrar llamando los getter de la clase Place
        holder.textView.setText(place.getName());
        holder.checkBox.setChecked(place.isVisited());
        //escucha si cambia de estado el checbox
        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {


            }
        });
        //cuando se toque en el textview haceuna accion
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }


    @Override
    public int getItemCount() {
        //retorna el total de la lista,si está en cero, no mostrará nada
        return listPlace.size();
    }
//creando la clase ViewHolder
    static class ViewHolder extends RecyclerView.ViewHolder
    {
        private CheckBox checkBox;
        private TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            checkBox = itemView.findViewById(R.id.placeCheckBox);
            textView = itemView.findViewById(R.id.placeTextView);
        }
    }
}
