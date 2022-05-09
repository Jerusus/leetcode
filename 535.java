import java.util.HashMap;
import java.util.Map;

public class Codec {

  Map<String, String> m = new HashMap<>();

  // Encodes a URL to a shortened URL.
  public String encode(String longUrl) {
    String key = String.valueOf(longUrl.hashCode());
    m.put(key, longUrl);
    return key;
  }

  // Decodes a shortened URL to its original URL.
  public String decode(String shortUrl) {
    if (m.containsKey(shortUrl)) {
      return m.get(shortUrl);
    }
    return null;
  }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));