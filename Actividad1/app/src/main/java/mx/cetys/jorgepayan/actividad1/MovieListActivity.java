package mx.cetys.jorgepayan.actividad1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

import java.util.ArrayList;

public class MovieListActivity extends AppCompatActivity {
    private MovieAdapter movieAdapter;
    private ListView listView;
    private ArrayList<Movie> movies = new ArrayList<Movie>();
    private static final String TAG = MovieListActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);

        Intent intent = getIntent();

        listView = (ListView) findViewById(R.id.list_view_movieList);
        movieAdapter = new MovieAdapter(this);
        listView.setAdapter(movieAdapter);

        movies = intent.getParcelableArrayListExtra(MainActivity.EXTRA_KEY);
        fillMovieView(movies);

        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Movie movieToRemove = movies.get(position);
                movies.remove(position);
                movieAdapter.remove(movieToRemove);
                movieAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onBackPressed() {
        goBack();
    }

    public void goBack() {
        Intent resultIntent = new Intent();
        resultIntent.putExtra(MainActivity.EXTRA_KEY, movies);
        setResult(MainActivity.RETURN_CODE, resultIntent);
        finish();
    }

    private void fillMovieView(ArrayList<Movie> movieList) {
        movieAdapter.clear();

        for(Movie movie : movieList) {
            movieAdapter.add(movie);
        }
    }
}
