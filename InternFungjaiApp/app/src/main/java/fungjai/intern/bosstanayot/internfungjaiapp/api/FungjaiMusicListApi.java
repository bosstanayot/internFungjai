package fungjai.intern.bosstanayot.internfungjaiapp.api;

import java.util.List;

import fungjai.intern.bosstanayot.internfungjaiapp.model.MusicList;
import retrofit2.Call;
import retrofit2.http.GET;

public interface FungjaiMusicListApi {
    String BASE = "https://us-central1-fjawesomeintern.cloudfunctions.net";
    @GET("/musiclist")
    Call<List<MusicList>> getMusicList();
}
