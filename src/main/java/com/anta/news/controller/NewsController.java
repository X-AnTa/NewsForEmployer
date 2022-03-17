package com.anta.news.controller;

import com.anta.news.entity.News;
import com.anta.news.service.NewsService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "News", description = "CRUD news")
@RestController
@RequestMapping("/newsline")
public class NewsController {

    private final NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("/news")
    public ResponseEntity<List<News>> getAllNews() {
        return new ResponseEntity<>(newsService.getAllNews(), HttpStatus.OK);
    }

    @GetMapping("/news/{id}")
    public ResponseEntity<News> getNews(@PathVariable int id) {
        News news = newsService.getNews(id);
        return new ResponseEntity<>(news, HttpStatus.OK);
    }

    @PostMapping("/news")
    public ResponseEntity<News> addNews(@RequestBody News news) {
        News newNews = newsService.addNews(news);
        return new ResponseEntity<>(newNews, HttpStatus.CREATED);
    }

    @PutMapping("/news/{id}")
    public ResponseEntity<News> updateNews(@PathVariable int id, @RequestBody News news) {
        News updatedNews = newsService.updateNews(id, news);
        return new ResponseEntity<>(updatedNews, HttpStatus.OK);
    }

    @DeleteMapping("/news/{id}")
    public ResponseEntity<Boolean> deleteNews(@PathVariable int id) {
        Boolean delete = newsService.deleteNews(id);
        return new ResponseEntity<>(delete, HttpStatus.OK);
    }
}
