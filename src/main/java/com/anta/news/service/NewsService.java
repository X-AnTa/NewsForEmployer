package com.anta.news.service;

import com.anta.news.repository.NewsRepository;
import com.anta.news.entity.News;
import com.anta.news.exception_handling.NoSuchNewsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NewsService {

    private final NewsRepository newsRepository;

    @Autowired
    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public List<News> getAllNews() {
        return newsRepository.findAll();
    }

    public News getNews(int id) {
        Optional<News> newsOptional = newsRepository.findById(id);
        if (newsOptional.isPresent()) {
            return newsOptional.get();
        } else throw new NoSuchNewsException();
    }

    public News addNews(News news) {
        return newsRepository.save(news);
    }

    public News updateNews(int id, News news) {
        return newsRepository.save(news);
    }

    public boolean deleteNews(int id) {
        Optional<News> newsOptional = newsRepository.findById(id);

        if (newsOptional.isPresent()) {
            newsRepository.deleteById(id);
            return true;
        } else return false;
    }
}
