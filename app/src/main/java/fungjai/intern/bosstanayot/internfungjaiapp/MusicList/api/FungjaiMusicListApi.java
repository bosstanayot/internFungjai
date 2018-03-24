package fungjai.intern.bosstanayot.internfungjaiapp.MusicList.api;

import java.util.List;

import fungjai.intern.bosstanayot.internfungjaiapp.MusicList.MusicList;
import retrofit2.Call;
import retrofit2.http.GET;

public interface FungjaiMusicListApi {
    String BASE = "https://us-central1-fjawesomeintern.cloudfunctions.net";

    @GET("/musiclist")
    Call<List<MusicList>> getMusicList();
}
