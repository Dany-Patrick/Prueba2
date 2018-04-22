package cl.dany.prueba2.adapter;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

import cl.dany.prueba2.R;
import cl.dany.prueba2.data.Queries;
import cl.dany.prueba2.models.Place;
//se extiende al RecyclerView llamando a su ViewHolder

public class PlacesAdapter extends RecyclerView.Adapter<PlacesAdapter.ViewHolder > {
    private List<Place> listPlace = new Queries().listPlaces();
    private PlaceClickListener listener;

    public PlacesAdapter(PlaceClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_place, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        // se obtiene de la lista de Place la posicion
        final Place place = listPlace.get(position);
        //se setean las vistas a mostrar llamando los getter de la clase Place
        holder.textView.setText(place.getName());
        holder.textView2.setText(String.valueOf(place.getRanking()));
        //escucha si cambia de estado el checbox
        holder.imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            int auxPosition = holder.getAdapterPosition();
                            Place auxPlace = listPlace.get(auxPosition);
                            auxPlace.setVisited(true);
                            auxPlace.save();
                            listPlace.remove(auxPosition);

                            notifyItemRemoved(auxPosition);
                        }
                    }, 200);

            }
        });

        //cuando se toque en el textview hace una accion
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Place auxPlace = listPlace.get(holder.getAdapterPosition());
                listener.clickedId(auxPlace.getId());
            }
        });

    }

    public void update(Place place)
    {
        listPlace.add(place);
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        //retorna el total de la lista,si está en cero, no mostrará nada
        return listPlace.size();
    }
//creando la clase ViewHolder
    static class ViewHolder extends RecyclerView.ViewHolder
    {
        private ImageButton imageButton;
        private TextView textView;
        private TextView textView2;

        public ViewHolder(View itemView) {
            super(itemView);
            imageButton = itemView.findViewById(R.id.placeImgBtn);
            textView = itemView.findViewById(R.id.placeTextView);
            textView2 = itemView.findViewById(R.id.itemRated);
        }
    }
}
