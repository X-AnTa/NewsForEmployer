package com.anta.news.service;

import com.anta.news.dao.NewsRepository;
import com.anta.news.dao.TypeRepository;
import com.anta.news.entity.News;
import com.anta.news.entity.Type;
import com.anta.news.exception_handling.NoSuchNewsException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class NewsServiceImpl implements NewsService {

    @Resource
    private NewsRepository newsRepository;

    @Resource
    private TypeRepository typeRepository;


    @Override
    public List<News> getAllNews() {
        return newsRepository.findAll();
    }

    @Override
    public News getNews(int id) {
        Optional<News> newsOptional = newsRepository.findById(id);

        if (newsOptional.isPresent()){
            return newsOptional.get();
        }
        else
            throw new NoSuchNewsException();
    }

    @Override
    public News addNews(News news) {
        return newsRepository.save(news);
    }

    @Override
    public News updateNews(int id, News news) {
        return newsRepository.save(news);
    }

    @Override
    public boolean deleteNews(int id) {
        Optional<News> newsOptional = newsRepository.findById(id);

        if (newsOptional.isPresent()){
            newsRepository.deleteById(id);
            return true;
        }
        else
            return false;
    }

    @Override
    public List<News> getAllByType() {
        return null;
    }

    @Override
    public List<Type> getAllTypes() {
        return null;
    }
}
