package com.jacktutorial.service;

import java.util.List;

import com.jacktutorial.model.Article;;

public interface ArticleService {

	public List<Article> getAllArticles();

	public Article getArticleById(long id);

	public void saveOrUpdate(Article article);

	public void deleteArticle(long id);
}
