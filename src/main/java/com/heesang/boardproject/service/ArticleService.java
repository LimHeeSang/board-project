package com.heesang.boardproject.service;

import com.heesang.boardproject.domain.type.SearchType;
import com.heesang.boardproject.dto.ArticleDto;
import com.heesang.boardproject.dto.ArticleWithCommentsDto;
import com.heesang.boardproject.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    @Transactional(readOnly = true)
    public Page<ArticleDto> searchArticles(Pageable pageable) {
        return Page.empty();
    }

    @Transactional(readOnly = true)
    public Page<ArticleDto> searchArticles(SearchType searchType, String searchKeyword, Pageable pageable) {
        return Page.empty();
    }

    @Transactional(readOnly = true)
    public ArticleWithCommentsDto getArticle(long articleId) {
        return null;
    }

    public void saveArticle(ArticleDto articleDto) {

    }

    public void updateArticle(ArticleDto articleDto) {
    }

    public void deleteArticle(long articleId) {
    }
}
