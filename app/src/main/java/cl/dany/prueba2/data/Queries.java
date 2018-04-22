package cl.dany.prueba2.data;

import java.util.ArrayList;
import java.util.List;

import cl.dany.prueba2.models.Place;
//se crea el metodo listPLaces que retorna una lista
public class Queries {
    public List<Place> listPlaces ()
    {
        //se crea una variable List tipo Array
        List<Place> places = new ArrayList<>();
        //se incializa con todos los datos de Place usando el listAll(Place.class)
        List<Place> placeList = Place.find(Place.class,"visited = 0");
        //se valida que no esté en cero
        if(placeList != null && placeList.size() > 0)
        {
            //se agrega al array la lista placeList con la busqueda del Place.class
            places.addAll(placeList);
        }
        //se retorna el arrayList
        return places;

    }
}
