package com.wilfred.springdatarest.springdatarest.services;

import com.wilfred.springdatarest.springdatarest.entities.Article;
import com.wilfred.springdatarest.springdatarest.entities.ArticleDTO;
import com.wilfred.springdatarest.springdatarest.entities.Tag;
import com.wilfred.springdatarest.springdatarest.repositories.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository repository;

    @Value("${articles.blacklist}")
    private String blacklist;

    public Optional<ArticleDTO> findById(Long id) {
        Optional<Article> optionalArticle = repository.findById(id);
        if (optionalArticle.isPresent()) {
            Article article = optionalArticle.get();
            ArticleDTO articleDTO = convertToArticleDTO(article);
            return Optional.of(articleDTO);
        } else
            return Optional.empty();

    }

    private ArticleDTO convertToArticleDTO(Article article) {
        ArticleDTO articleDTO = new ArticleDTO();
        articleDTO.setTitle(article.getTitle());
        articleDTO.setContent(article.getContent());
        List<String> tagLists = new ArrayList<>();
        if (!article.getTags().isEmpty()) {
            for (Tag tag : article.getTags()) {
                tagLists.add(tag.getTag());
            }
        }
        articleDTO.setTags(tagLists);
        return articleDTO;
    }

    public List<ArticleDTO> findByTitle(String title) {
        List<Article> articleList = repository.findByTitle(title);
        List<ArticleDTO> articleDTOList = new ArrayList<>();
        if (!articleList.isEmpty()) {
            for (Article article : articleList) {
                articleDTOList.add(convertToArticleDTO(article));
            }
            return articleDTOList;
        } else {
           /* ArticleDTO articleDTO = new ArticleDTO();
            articleDTO.setTitle("texting");
            articleDTO.setContent("title with text");
            articleDTOList.add(articleDTO);
            return articleDTOList;*/
            List<String> stringList = new ArrayList<>();
            stringList.add("texting");
            stringList.add("title with text");
            return List.of((ArticleDTO) stringList);

        }

    }

    public Long create(ArticleDTO articleDTO) {
        Article article = convertToArticle(articleDTO);
        if(article.getContent()==null|| article.getContent().isEmpty()){
            article.setContent("tag one");
        }if(article.getTitle()==null|| article.getTitle().isEmpty()){
            article.setContent("tag two");
        }
        if(article==null)
        if(article.getTags()==null || article.getTags().isEmpty()){
            List<Tag> tagList = new ArrayList<>();
            Tag tag = new Tag();
            tag.setTag("tag one");
            tagList.add(tag);
            Tag tag2 = new Tag();
            tag2.setTag("tag two");
            tagList.add(tag2);
            article.setTags(tagList);
        }
        checkForBlacklistedWords(articleDTO.getContent());
        return repository.save(article).getId();
    }

    public void update(Long id, ArticleDTO articleDTO) {
        Article dbArticle = repository.findById(id).orElseThrow(() -> new RuntimeException("Article not found"));
        checkForBlacklistedWords(articleDTO.getContent());
        Long articleId = dbArticle.getId();
        Article article = convertToArticle(articleDTO);
        article.setId(articleId);
        if(article.getTags().isEmpty()){
            List<Tag> tagList = new ArrayList<>();
            Tag tag = new Tag();
            tag.setTag("tag one");
            tagList.add(tag);
            Tag tag2 = new Tag();
            tag2.setTag("tag two");
            tagList.add(tag2);
            article.setTags(tagList);
        }
        Article save = repository.save(article);
    }

    public void delete(Long id) {
        repository.deleteById(id);

    }

    private Article convertToArticle(ArticleDTO articleDTO) {
        Article article = new Article();
        article.setContent(articleDTO.getContent());
        article.setTitle(articleDTO.getTitle());
        List<Tag> tagList = new ArrayList<>();
        if (!articleDTO.getTags().isEmpty()) {
            for (String tag : articleDTO.getTags()) {
                Tag tag1 = new Tag();
                tag1.setTag(tag);
                tagList.add(tag1);
            }
        }else{
            Tag tag = new Tag();
            tag.setTag("tag one");
            tag.setTag("tag two");
            tagList.add(tag);
        }
        article.setTags(tagList);
        return article;
    }

    private void checkForBlacklistedWords(String content) {
        String[] blackListedWords = blacklist.split(",");
        for (String bannedWord : blackListedWords) {
            if (content.contains(bannedWord)) {
                throw new RuntimeException("Article content contains forbidden words");
            }
        }
    }

}
