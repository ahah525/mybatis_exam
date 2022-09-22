package com.ll.exam.app_2022_09_23.app.article.repository;

import com.ll.exam.app_2022_09_23.app.article.dto.Article;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ArticleRepository {

    @Select("""
            <script>
            SELECT *
            FROM article
            </script>
            """)
    List<Article> getArticles();

    @Insert("""
            <script>
            INSERT INTO article(createDate, modifyDate, subject, content)
            values(NOW(), NOW(), #{subject}, #{content}) 
            </script>
            """)
    void write(@Param("subject") String subject, @Param("content") String content);
}