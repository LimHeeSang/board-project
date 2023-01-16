package com.heesang.boardproject.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Objects;

@Getter
@ToString(callSuper = true)
@Table(indexes = {
        @Index(columnList = "content"),
        @Index(columnList = "createdAt"),
        @Index(columnList = "createdBy")
})
@Entity
public class ArticleComment extends AuditingFields {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(nullable = false, length = 500)
    private String content;

    @Setter
    @ManyToOne(optional = false)
    private UserAccount userAccount;

    @ToString.Exclude
    @Setter
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Article article;

    protected ArticleComment() {
    }

    private ArticleComment(String content, UserAccount userAccount, Article article) {
        this.content = content;
        this.userAccount = userAccount;
        this.article = article;
    }

    public static ArticleComment of(String content, UserAccount userAccount, Article article) {
        return new ArticleComment(content, userAccount, article);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ArticleComment that)) return false;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
