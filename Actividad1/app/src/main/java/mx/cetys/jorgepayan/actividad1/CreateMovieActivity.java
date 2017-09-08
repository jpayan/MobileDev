package mx.cetys.jorgepayan.actividad1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class CreateMovieActivity extends AppCompatActivity {

    ArrayList<Movie> movies = new ArrayList<Movie>() {{
        add(new Movie("Reservoir Dogs", 99, "Quentin Tarantino", "Crime", 1992));
        add(new Movie("The Departed", 151, "Martin Scorsese", "Crime", 2006));
        add(new Movie("El Payan", 180, "Fidel Castro", "Documentary", 2017));
        add(new Movie("There Will Be Blood", 158, "Paul Thomas Anderson", "Drama", 2007));
        add(new Movie("Snatch", 104, "Guy Ritchie", "Crime", 2000));
    }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_movie);

        Button button_goBack;
        Button button_createMovie;
        final EditText movieName = (EditText) findViewById(R.id.movieName);
        final EditText movieDuration = (EditText) findViewById(R.id.movieDuration);
        final EditText movieDirector = (EditText) findViewById(R.id.movieDirector);
        final EditText movieGenre = (EditText) findViewById(R.id.movieGenre);
        final EditText movieYear = (EditText) findViewById(R.id.movieYear);

        button_goBack = (Button) findViewById(R.id.button_backToMain);
        button_createMovie = (Button) findViewById(R.id.button_createMovie);

        Intent intent = getIntent();

        button_goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        button_createMovie.setOnClickListener(
            new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    buildMovie(movieName, movieDuration, movieDirector, movieGenre, movieYear);
                    Intent intent = new Intent(getApplicationContext(), MovieListActivity.class);
                    intent.putExtra(MainActivity.EXTRA_KEY, movies);
                    startActivity(intent);
                    startActivityForResult(intent,MainActivity.RETURN_CODE);
                }
            }
        );
    }

    private void buildMovie(EditText name, EditText duration, EditText director, EditText genre,
                            EditText year) {
        Movie movie = new Movie(
            name.getText().toString(),
            Integer.parseInt(duration.getText().toString()),
            director.getText().toString(),
            genre.getText().toString(),
            Integer.parseInt(year.getText().toString())
        );
        movies.add(movie);
    }
}
