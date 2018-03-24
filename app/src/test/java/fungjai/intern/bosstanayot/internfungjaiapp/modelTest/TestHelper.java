package fungjai.intern.bosstanayot.internfungjaiapp.modelTest;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by barjord on 23/3/2018 AD.
 */

public class TestHelper {
    private static String convertStreamToString(InputStream is) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line).append("\n");
        }
        reader.close();
        return sb.toString();
    }

    public static String getStringFromFile(String fileName) throws Exception {
        String filePath = System.getProperty("user.dir") + "/app/src/test/java/fungjai/intern/bosstanayot/internfungjaiapp/modelTest/";
        final InputStream stream = new FileInputStream(filePath + fileName);
        String ret = convertStreamToString(stream);
        stream.close();
        return ret;
    }
}
