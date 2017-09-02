package mx.cetys.jorgepayan.actividad1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MovieListActivity extends AppCompatActivity {
    MovieAdapter movieAdapter;
    ListView listView;
    TextView text_view_messageReceived;

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
        setContentView(R.layout.activity_movie_list);

        Intent intent = getIntent();
        String messageReceived = intent.getStringExtra(MainActivity.EXTRA_KEY);

        listView = (ListView) findViewById(R.id.list_view_movieList);
        movieAdapter = new MovieAdapter(this);
        listView.setAdapter(movieAdapter);
        fillMovieDatabase(movies);

    }

    private void fillMovieDatabase(ArrayList<Movie> movieList) {
        movieAdapter.clear();

        for(Movie movie : movieList) {
            movieAdapter.add(movie);
        }
    }
}
