package com.sip.ams.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sip.ams.entities.Article;

public interface ArticleRepository extends CrudRepository<Article, Long>{

}
