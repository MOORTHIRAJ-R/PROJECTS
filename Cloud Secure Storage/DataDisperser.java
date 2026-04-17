package cloudSecureStorage;

import java.util.ArrayList;
import java.util.List;

public class DataDisperser {
    public static List<String> splitData(String data, int parts) {
        List<String> list = new ArrayList<>();
        int len = data.length() / parts;
        for (int i = 0; i < parts; i++) {
            int start = i * len;
            int end = (i == parts - 1) ? data.length() : (i + 1) * len;
            list.add(data.substring(start, end));
        }
        return list;
    }

    public static String joinData(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (String s : list)
            sb.append(s);
        return sb.toString();
    }
}