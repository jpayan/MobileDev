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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);

        Intent intent = getIntent();

        listView = (ListView) findViewById(R.id.list_view_movieList);
        movieAdapter = new MovieAdapter(this);
        listView.setAdapter(movieAdapter);
        ArrayList<Movie> movies = (ArrayList<Movie>) intent.getSerializableExtra(MainActivity.EXTRA_KEY);
        fillMovieDatabase(movies);
    }

    private void fillMovieDatabase(ArrayList<Movie> movieList) {
        movieAdapter.clear();

        for(Movie movie : movieList) {
            movieAdapter.add(movie);
        }
    }
}
