package mx.cetys.jorgepayan.actividad1;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by jorge.payan on 8/25/17.
 */

public class MovieAdapter extends ArrayAdapter<Movie> {
    public MovieAdapter(Context context){
        super(context, R.layout.movie_row, R.id.text_view_name);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View oView = super.getView(position, convertView, parent);

        TextView textViewName = (TextView) oView.findViewById(R.id.text_view_name);
        TextView textViewDuration = (TextView) oView.findViewById(R.id.text_view_duration);
        TextView textViewDirector = (TextView) oView.findViewById(R.id.text_view_director);
        TextView textViewGenre = (TextView) oView.findViewById(R.id.text_view_genre);
        TextView textViewYOR = (TextView) oView.findViewById(R.id.text_view_yearOfRelease);

        Movie oMovie = this.getItem(position);
        textViewName.setText(oMovie.getName());
        textViewDuration.setText(String.valueOf(oMovie.getDuration()));
        textViewDirector.setText(oMovie.getDirector());
        textViewGenre.setText(oMovie.getGenre());
        textViewYOR.setText(String.valueOf(oMovie.getYearOfRelease()));

        return oView;
    }
}
