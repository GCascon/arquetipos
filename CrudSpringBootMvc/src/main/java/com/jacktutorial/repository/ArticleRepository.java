package com.jacktutorial.repository;

import org.springframework.data.repository.CrudRepository;

import com.jacktutorial.model.Article;

public interface ArticleRepository extends CrudRepository<Article, Long> {

}
