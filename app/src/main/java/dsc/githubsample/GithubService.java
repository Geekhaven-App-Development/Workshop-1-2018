package dsc.githubsample;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by betterclever on 2/4/2018.
 */

public interface GithubService {

    @GET("users/{user}")
    Call<GithubUser> fetchUser(@Path("user") String user);

}