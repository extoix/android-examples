package com.extoix.android.retrofit;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.http.GET;
import retrofit.http.Query;


public class MainActivity extends ActionBarActivity {

    public interface TheMovieDB {
        @GET("/3/discover/movie")
        void retrieveMovieDetailResult(@Query("sort_by") String sortBy, @Query("api_key") String apiKey, Callback<MovieDetailResult> callback);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint("http://api.themoviedb.org").build();
        TheMovieDB theMovieDBService = restAdapter.create(TheMovieDB.class);

        String sortBy = "vote_average.desc";
        String apiKey = getString(R.string.themoviedb_api_key);

        theMovieDBService.retrieveMovieDetailResult(sortBy, apiKey, new Callback<MovieDetailResult>() {
            @Override
            public void success(MovieDetailResult movieDetailResult, Response response) {

                List<MovieDetail> movieDetailList = movieDetailResult.getResults();

                for(MovieDetail movieDetail: movieDetailList) {
                    String title = movieDetail.getTitle();
                    String releaseDate = movieDetail.getRelease_date();
                    String voteAverage = movieDetail.getVote_average();
                    String posterPath = movieDetail.getPoster_path();
                    String overview = movieDetail.getOverview();
                }
            }

            @Override
            public void failure(RetrofitError error) {
                String someErrorMessage = error.getMessage();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
