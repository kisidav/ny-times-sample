package io.davidkisida.nytimessample.api;

import io.davidkisida.nytimessample.api.model.MostViewedApiModel;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiClient {

    @GET("mostviewed/{section}/{time-period}.json")
    Observable<MostViewedApiModel> mostViewed(@Path("section") String section, @Path("time-period") Integer timePeriod,
                                              @Query("api-key") String apiKey);
}
