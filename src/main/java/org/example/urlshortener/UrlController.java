package org.example.urlshortener;

import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class UrlController {

    private final UrlService urlService;

    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    @PostMapping("/shorten")
    public String shorten(@RequestParam String url) {
        return urlService.shorten(url);
    }

    @GetMapping("/{code}")
    public void redirect(@PathVariable String code, HttpServletResponse response) throws IOException {
        String url = urlService.getUrl(code);
        if (url == null) {
            response.sendError(404);
        } else {
            response.sendRedirect(url);
        }
    }
}