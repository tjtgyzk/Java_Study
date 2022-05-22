package LeetCode.String.Statistics;

import java.util.HashMap;
import java.util.Random;

public class L535 {
    //随机从字母表中选择7个字符,作为key,对应当前的longUrl,存到HashMap中
    //拿到shortUrl直接去Map中找即可
    String alphabet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    HashMap<String, String> map = new HashMap<>();
    String key;
    Random random = new Random();

    public String getKey() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 7; i++) {
            sb.append(alphabet.charAt(random.nextInt(62)));
        }
        return sb.toString();
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        do {
            key = getKey();
        } while (map.containsKey(key));
        map.put(key, longUrl);
        return key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }
}
