package org.example.urlshortener;

import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class UrlService {

    private final UrlMappingRepository repository;

    public UrlService(UrlMappingRepository repository) {
        this.repository = repository;
    }

    public String shorten(String url) {
        String code = UUID.randomUUID().toString().substring(0, 6);
        UrlMapping mapping = new UrlMapping();
        mapping.setCode(code);
        mapping.setOriginalUrl(url);
        repository.save(mapping);
        return "http://localhost:8080/" + code;
    }

    public String getUrl(String code) {
        return repository.findByCode(code)
                .map(UrlMapping::getOriginalUrl)
                .orElse(null);
    }
}