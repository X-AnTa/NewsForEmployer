package com.anta.news.dao;

import com.anta.news.entity.News;
import com.anta.news.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TypeRepository extends JpaRepository<Type, Integer> {

    List<Type> findAllByName(String type_name);
}
