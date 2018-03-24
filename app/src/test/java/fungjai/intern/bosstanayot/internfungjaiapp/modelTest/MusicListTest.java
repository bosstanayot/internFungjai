package fungjai.intern.bosstanayot.internfungjaiapp.modelTest;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Type;
import java.util.List;

import fungjai.intern.bosstanayot.internfungjaiapp.MusicList.MusicList;

public class MusicListTest {
    private String json;
    private List<MusicList> musicList;

    @Before
    public void setUp() throws Exception {
        json = TestHelper.getStringFromFile("fungjai_api.json");
        Type listType = new TypeToken<List<MusicList>>() {
        }.getType();
        musicList = new Gson().fromJson(json, listType);
    }

    @Test
    public void parseJsonIndex0_getArtist() throws Exception {
        Assert.assertEquals("Artist", musicList.get(0).getArtist(), "ORNLY YOU");
    }

    @Test
    public void parseJsonIndex0_getCover() throws Exception {
        Assert.assertEquals("Cover", musicList.get(0).getCover(), "https://image.fungjai.com/2018/02/13/cover/1518527403434232.jpg");
    }

    @Test
    public void parseJsonIndex0_getSong() throws Exception {
        Assert.assertEquals("Song", musicList.get(0).getSong(), "มะงึกๆอุ๋งๆ");
    }

    @Test
    public void parseJsonIndex0_getType() throws Exception {
        Assert.assertEquals("Type", musicList.get(0).getType(), "track");
    }

    @Test
    public void parseJsonIndex1_getArtist() throws Exception {
        Assert.assertEquals("Artist", musicList.get(1).getArtist(), "markmywords.");
    }

    @Test
    public void parseJsonIndex1_getCover() throws Exception {
        Assert.assertEquals("Cover", musicList.get(1).getCover(), "https://image.fungjai.com/2018/02/12/cover/1518429706726234.jpg");
    }

    @Test
    public void parseJsonIndex1_getSong() throws Exception {
        Assert.assertEquals("Song", musicList.get(1).getSong(), "น้องสาวครับ (Sister)");
    }

    @Test
    public void parseJsonIndex1_getType() throws Exception {
        Assert.assertEquals("Type", musicList.get(1).getType(), "track");
    }

    @Test
    public void parseJsonIndex2_getCover() throws Exception {
        Assert.assertEquals("Cover", musicList.get(2).getCover(), "https://www.fungjaizine.com/wp-content/uploads/2018/03/KAEW-TARWAAN-bnk48-fungjaizine-cover2.jpg");
    }

    @Test
    public void parseJsonIndex2_getDescription() throws Exception {
        Assert.assertEquals("Artist", musicList.get(2).getDescription(), "Fungjaizine ขอเชิญทุกท่านมาทำความรู้จัก แก้ว และ ตาหวาน 2" +
                " สมาชิกจากแก๊งชราไลน์แห่ง BNK48 กับเรื่องราวการไปเล่นดนตรีที่ญี่ปุ่นและชีวิตที่ทั้งคู่ไม่เคยเปิดเผยที่ไหนมาก่อน");
    }

    @Test
    public void parseJsonIndex2_getTitle() throws Exception {
        Assert.assertEquals("Song", musicList.get(2).getTitle(), "แก้วตาหวานใจ : Playlist เพลงโปรดของ แก้ว และ ตาหวาน BNK48");
    }

    @Test
    public void parseJsonIndex2_getType() throws Exception {
        Assert.assertEquals("Type", musicList.get(2).getType(), "zine");
    }

    @Test
    public void parseJsonIndex2_getUrl() throws Exception {
        Assert.assertEquals("Url", musicList.get(2).getUrl(), "https://www.fungjaizine.com/feature/my_ears/kaew-tawaan-bnk48");
    }

    @Test
    public void parseJsonIndex3_getArtist() throws Exception {
        Assert.assertEquals("Artist", musicList.get(3).getArtist(), "markmywords.");
    }

    @Test
    public void parseJsonIndex3_getCover() throws Exception {
        Assert.assertEquals("Cover", musicList.get(3).getCover(), "https://image.fungjai.com/2018/01/22/cover/1516608278260238.jpg");
    }

    @Test
    public void parseJsonIndex3_getSong() throws Exception {
        Assert.assertEquals("Song", musicList.get(3).getSong(), "แคปเฌอ (Capture)");
    }

    @Test
    public void parseJsonIndex3_getType() throws Exception {
        Assert.assertEquals("Type", musicList.get(3).getType(), "track");
    }

    @Test
    public void parseJsonIndex4_getArtist() throws Exception {
        Assert.assertEquals("Artist", musicList.get(4).getArtist(), "VWW");
    }

    @Test
    public void parseJsonIndex4_getCover() throws Exception {
        Assert.assertEquals("Cover", musicList.get(4).getCover(), "https://image.fungjai.com/2018/02/03/cover/1517676818626315.jpg");
    }

    @Test
    public void parseJsonIndex4_getSong() throws Exception {
        Assert.assertEquals("Song", musicList.get(4).getSong(), "คุณพระอาทิตย์");
    }

    @Test
    public void parseJsonIndex4_getType() throws Exception {
        Assert.assertEquals("Type", musicList.get(4).getType(), "track");
    }

    @Test
    public void parseJsonIndex5_getArtist() throws Exception {
        Assert.assertEquals("Artist", musicList.get(5).getArtist(), "Meowhima");
    }

    @Test
    public void parseJsonIndex5_getCover() throws Exception {
        Assert.assertEquals("Cover", musicList.get(5).getCover(), "https://image.fungjai.com/2018/01/07/cover/1515336053305580.jpg");
    }

    @Test
    public void parseJsonIndex5_getSong() throws Exception {
        Assert.assertEquals("Song", musicList.get(5).getSong(), "คนเกรี้ยวกราด");
    }

    @Test
    public void parseJsonIndex5_getType() throws Exception {
        Assert.assertEquals("Type", musicList.get(5).getType(), "track");
    }

    @Test
    public void parseJsonIndex6_getArtist() throws Exception {
        Assert.assertEquals("Artist", musicList.get(6).getArtist(), "Present to President");
    }

    @Test
    public void parseJsonIndex6_getCover() throws Exception {
        Assert.assertEquals("Cover", musicList.get(6).getCover(), "https://image.fungjai.com/2018/01/28/cover/1517116135510488.jpg");
    }

    @Test
    public void parseJsonIndex6_getSong() throws Exception {
        Assert.assertEquals("Song", musicList.get(6).getSong(), "เพลงที่มีไม้ยมกเยอะๆ");
    }

    @Test
    public void parseJsonIndex6_getType() throws Exception {
        Assert.assertEquals("Type", musicList.get(6).getType(), "track");
    }

    @Test
    public void parseJsonIndex7_getCover() throws Exception {
        Assert.assertEquals("Cover", musicList.get(7).getCover(), "https://www.fungjaizine.com/wp-content/uploads/2017/10/cancanhead2.png");
    }

    @Test
    public void parseJsonIndex7_getDescription() throws Exception {
        Assert.assertEquals("Artist", musicList.get(7).getDescription(), "แคนแคน—นายิกา ศรีเนียน คือเด็กสาวน่ารัก อารมณ์ดี ด้วยภาพจำที่เธอเป็นหนึ่งในสมาชิก" +
                " BNK48 ไอดอลของมวลชน แต่ในอีกมุมหนึ่งเธอก็มีมิติของความเป็นผู้หญิงน่าค้นหา");
    }

    @Test
    public void parseJsonIndex7_getTitle() throws Exception {
        Assert.assertEquals("Song", musicList.get(7).getTitle(), "5 เพลงโปรดของ แคนแคน BNK48 และเหตุผลที่เธออยากเป็นนายกหญิงคนที่สอง!?");
    }

    @Test
    public void parseJsonIndex7_getType() throws Exception {
        Assert.assertEquals("Type", musicList.get(7).getType(), "zine");
    }

    @Test
    public void parseJsonIndex7_getUrl() throws Exception {
        Assert.assertEquals("Url", musicList.get(7).getUrl(), "https://www.fungjaizine.com/feature/my_ears/cancan-bnk48");
    }

    @After
    public void tearDown() {
        json = null;
        musicList = null;
    }
}