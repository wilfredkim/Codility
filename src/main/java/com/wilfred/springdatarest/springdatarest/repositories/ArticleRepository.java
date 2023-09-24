package com.wilfred.springdatarest.springdatarest.repositories;

import com.wilfred.springdatarest.springdatarest.entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findByTitle(String title);
}
