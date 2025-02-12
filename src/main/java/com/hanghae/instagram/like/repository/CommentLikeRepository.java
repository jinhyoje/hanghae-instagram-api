package com.hanghae.instagram.like.repository;

import com.hanghae.instagram.like.entity.CommentLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface CommentLikeRepository extends JpaRepository<CommentLike, Long> {
    Optional<CommentLike> findCommentLikeByNicknameAndCommentId(String nickname, Long commentId);
    @Transactional
    @Modifying
    @Query("delete from CommentLike where comment.id = :commentId")
    void deleteAllByCommentIdInQuery(@Param("commentId") long commentId);

    List<CommentLike> findAllByCommentId(long commentId);
}
