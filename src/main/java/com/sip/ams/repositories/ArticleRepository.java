package com.sip.ams.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sip.ams.entities.Article;
@Repository("articleRepository")
public interface ArticleRepository extends CrudRepository<Article, Long>{

	 @Query("select a from Article a  where lower(a.label) like %?1%")
	    List<Article> findArticlesByLabel(String l);
}
