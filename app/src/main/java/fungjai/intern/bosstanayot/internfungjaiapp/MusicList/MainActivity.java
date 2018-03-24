package fungjai.intern.bosstanayot.internfungjaiapp.MusicList;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import fungjai.intern.bosstanayot.internfungjaiapp.R;
import fungjai.intern.bosstanayot.internfungjaiapp.MusicList.api.FungjaiMusicListApi;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private Context context;
    ProgressDialog loadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getMusicList();
    }

    public void getMusicList() {
        loadingDialog = ProgressDialog.show(MainActivity.this, "Download Data", "Loading...", true, false);
        OkHttpClient client = new OkHttpClient.Builder().build();
        Retrofit retrofit = new Retrofit
                .Builder()
                .client(client)
                .baseUrl(FungjaiMusicListApi.BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        FungjaiMusicListApi fungjaiMusicListApi = retrofit.create(FungjaiMusicListApi.class);

        Call<List<MusicList>> call = fungjaiMusicListApi.getMusicList();
        call.enqueue(new Callback<List<MusicList>>() {
            @Override
            public void onResponse(Call<List<MusicList>> call, Response<List<MusicList>> response) {
                if (response.isSuccessful()) {
                    List<MusicList> musicList = response.body();
                    ListAdapter listAdapter = new ListAdapter(getApplicationContext(), musicList);
                    RecyclerView recyclerView = findViewById(R.id.data_list);
                    recyclerView.setLayoutManager(new LinearLayoutManager(context));
                    recyclerView.setAdapter(listAdapter);
                    loadingDialog.dismiss();
                }

            }

            @Override
            public void onFailure(Call<List<MusicList>> call, Throwable t) {

            }

        });
    }
}
