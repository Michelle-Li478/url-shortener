package org.example.urlshortener;

import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UrlService {

    private final Map<String, String> store = new HashMap<>();

    public String shorten(String url) {
        String code = UUID.randomUUID().toString().substring(0, 6);
        store.put(code, url);
        return "http://localhost:8080/" + code;
    }

    public String getUrl(String code) {
        return store.get(code);
    }
}