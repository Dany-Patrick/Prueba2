package cl.dany.prueba2.views.main;

import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;

import cl.dany.prueba2.R;
import cl.dany.prueba2.models.Place;

public class MainActivity extends AppCompatActivity {
    private PlaceFragment placeFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //se llama en una variable el fragmente para despues llamar el updateList
        placeFragment = (PlaceFragment) getSupportFragmentManager().findFragmentById(R.id.placeFragment);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //se llama al dialog y se le pasa el contexto del main principal
                final Dialog dialog = new Dialog(MainActivity.this);
                //se indica al dialog que no tenga titulo
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                //se le pasa al dialogo el layout
                dialog.setContentView(R.layout.dialog_place);

                ImageButton imageButton = dialog.findViewById(R.id.savePlaceBtn);
                imageButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //se llama el textview del dialog
                        EditText editText = dialog.findViewById(R.id.placeListItem);
                        String name = editText.getText().toString();
                        if(name.trim().length() >0)
                        {
                            //se guarda un nuevo Place con el Name
                            Place place = new Place(name,"",0,false);
                            place.save();
                            //se actualiza la lista del mainfragment
                            placeFragment.updateLisst(place);
                        }
                        //se cierra el dialog
                        dialog.dismiss();
                    }
                });


                //se le indica al dialog que tenga ancho completo
                dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
                //se muestra el dialog
                dialog.show();
            }
        });
    }

}
