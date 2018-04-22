package cl.dany.prueba2.views.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import cl.dany.prueba2.R;
import cl.dany.prueba2.adapter.PlaceClickListener;
import cl.dany.prueba2.adapter.PlacesAdapter;
import cl.dany.prueba2.models.Place;
import cl.dany.prueba2.views.main.details.DetailsActivity;

/**
 * A placeholder fragment containing a simple view.
 */
//se agrega el implements a la interface, esto trae el metodo de la interface
public class PlaceFragment extends Fragment implements PlaceClickListener {
    //se crrea la variable constrante que irá a otro activity
    public static final String USER_ID = "cl.dany.prueba2.views.KEY.USER_ID";
    //se crea la variable adapter
    private PlacesAdapter adapter;
    private EditText editText2;
    public PlaceFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }
    // se sobrescribe el viewCreated
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //se crrea una variable RecycleView
        RecyclerView recyclerView = view.findViewById(R.id.placeRecycle);
        //se setea el tamaño del recyclerView
        recyclerView.setHasFixedSize(true);
        //se llama al linear layout y se le pasa el contexto
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        ////////////
        //Aqui se pueden setear datos
        ////////////////
        adapter = new PlacesAdapter(this);
        recyclerView.setAdapter(adapter);
    }
    //metodo que actualiza la lista
    public void updateLisst(Place place)
    {

        adapter.update(place);
    }

    @Override
    public void clickedId(long id) {
        //se crea un intent al details
        Intent intent = new Intent(getActivity(), DetailsActivity.class);
        //se pasa el paramatro id al otro activity
        intent.putExtra(USER_ID, id);
        startActivity(intent);
    }
}
