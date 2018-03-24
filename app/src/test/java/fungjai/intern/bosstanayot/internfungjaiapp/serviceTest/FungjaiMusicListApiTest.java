package fungjai.intern.bosstanayot.internfungjaiapp.serviceTest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import fungjai.intern.bosstanayot.internfungjaiapp.MusicList.api.FungjaiMusicListApi;
import fungjai.intern.bosstanayot.internfungjaiapp.MusicList.MusicList;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import retrofit2.Response;

/**
 * Created by barjord on 23/3/2018 AD.
 */

public class FungjaiMusicListApiTest {
    FungjaiMusicListApi fungjaiMusicListApi;
    MockWebServer server;

    @Before
    public void startServer() throws Exception {
        server = new MockWebServer();
        server.start();
        fungjaiMusicListApi = RestServiceTestHelper
                .createRetrofitService(server.url("/").toString(), FungjaiMusicListApi.class);
    }

    @Test
    public void testLoadMusicList_ShouldNotNull() throws Exception {
        server.enqueue(new MockResponse().setResponseCode(200).setBody("[{\"artist\":\"ORNLY YOU\"}]"));
        Response<List<MusicList>> actual = fungjaiMusicListApi.getMusicList().execute();

        Assert.assertNotNull(actual.body());
        Assert.assertEquals(200, actual.code());
    }

    @Test
    public void testLoadMusicList_ShouldNull() throws Exception {
        server.enqueue(new MockResponse().setResponseCode(404).setBody("[{\"artist\":\"ORNLY YOU\"}]"));
        Response<List<MusicList>> actual = fungjaiMusicListApi.getMusicList().execute();

        Assert.assertNull(actual.body());
        Assert.assertEquals(404, actual.code());
    }

    @Test
    public void NotImplementedTest_ShouldNull() throws Exception {
        server.enqueue(new MockResponse().setResponseCode(501).setBody("[{\"artist\":\"ORNLY YOU\"}]"));
        Response<List<MusicList>> actual = fungjaiMusicListApi.getMusicList().execute();

        Assert.assertNull(actual.body());
        Assert.assertEquals(501, actual.code());
    }

    @After
    public void stopServer() throws Exception {
        server.shutdown();
    }
}
