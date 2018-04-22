package cl.dany.prueba2.views.main.details;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import cl.dany.prueba2.R;
import cl.dany.prueba2.models.Place;
import cl.dany.prueba2.views.main.MainActivity;

public class DetailsActivity extends AppCompatActivity {
    //se crrea la variable constrante que irá a otro activity
    public static final String USER_ID = "cl.dany.prueba2.views.KEY.USER_ID";

    private Place place;
    private EditText editText;
    private RatingBar ratingBar;
    private TextView textView2;
    private float ratingStar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        //se crea una variable tipo long y se iguala con la super key USER_ID
        long idLong = getIntent().getLongExtra(USER_ID,0);

        setContentView(R.layout.activity_details);
        place = Place.findById(Place.class,idLong);
        getSupportActionBar().setTitle(place.getName());
        editText = findViewById(R.id.placeDetailTv);
        ratingBar = findViewById(R.id.starDetail);
        textView2 = findViewById(R.id.itemTextRanking);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ratingStar = rating;
                float ranking = rating;

                if(ranking == 0.0 || ranking == 0.5)
                {

                    textView2.setText("Horrible");
                }else if(ranking == 1.0  || ranking == 1.5)
                {
                    textView2.setText("Malisimo");
                }else if(ranking == 2.0  || ranking == 2.5)
                {
                    textView2.setText("Más o menos");
                }else if(ranking == 3.0  || ranking == 3.5)
                {
                    textView2.setText("Bueno");
                }else if(ranking == 4.0  || ranking == 4.5)
                {
                    textView2.setText("Muy Bueno");
                }else if(ranking == 5.0 )
                {
                    textView2.setText("Excelente!!!");
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(place.getDescription() != null)
        {
            float ranking = place.getRanking();
            editText.setText(place.getDescription());
            ratingBar.setRating(ranking);



        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        place.setDescription(editText.getText().toString());
        place.setRanking(ratingBar.getRating());



        place.save();


    }

    //cuando aprete retroceder hace un intent sl mainActivity
    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        Intent intent= new Intent(DetailsActivity.this,MainActivity.class);
        startActivity(intent);
    }
}
