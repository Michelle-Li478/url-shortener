package org.example.urlshortener;

import jakarta.persistence.*;

@Entity
@Table(name = "url_mapping")
public class UrlMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;
    private String originalUrl;

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public String getOriginalUrl() { return originalUrl; }
    public void setOriginalUrl(String url) { this.originalUrl = url; }
}