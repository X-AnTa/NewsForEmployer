package com.anta.news.service;

import com.anta.news.entity.News;
import com.anta.news.entity.Type;

import java.util.List;

public interface NewsService {

    List<News> getAllNews();

    News getNews(int id);

    News addNews(News news);

    News updateNews(int id, News news);

    boolean deleteNews(int id);

    boolean deleteType(int id);

    List<Type> getAllTypes();
}
