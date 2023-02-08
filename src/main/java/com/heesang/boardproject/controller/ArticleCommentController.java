package com.heesang.boardproject.controller;

import com.heesang.boardproject.dto.UserAccountDto;
import com.heesang.boardproject.dto.request.ArticleCommentRequest;
import com.heesang.boardproject.service.ArticleCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@RequestMapping("/comments")
@Controller
public class ArticleCommentController {

    private final ArticleCommentService articleCommentService;

    @PostMapping("/new")
    public String saveNewArticleComment(ArticleCommentRequest articleCommentRequest) {
        // TODO: 2023-02-08 인증 정보를 넣어줘야 한다.
        articleCommentService.saveArticleComment(articleCommentRequest.toDto(
                UserAccountDto.of("heesang", "password", "heesang@mail.com", "heesang", "memo", null, null, null, null)
        ));
        return "redirect:/articles/" + articleCommentRequest.articleId();
    }

    @PostMapping("/{commentId}/delete")
    public String deleteArticleComment(@PathVariable Long commentId, Long articleId) {
        // TODO: 2023-02-08 인증 정보를 넣어줘야 한다.
        articleCommentService.deleteArticleComment(commentId);
        return "redirect:/articles/" + articleId;
    }
}
