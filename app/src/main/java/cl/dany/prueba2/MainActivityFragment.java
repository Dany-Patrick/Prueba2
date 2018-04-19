package cl.dany.prueba2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cl.dany.prueba2.adapter.PlacesAdapter;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
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
        //se seteael tamaño del recyclerView
        recyclerView.setHasFixedSize(true);
        //se llama al linear layout y se le pasa el contexto
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        ////////////
        //Aqui se pueden setear datos
        ////////////////
        PlacesAdapter placesAdapter = new PlacesAdapter();
        recyclerView.setAdapter(placesAdapter);
    }
}
