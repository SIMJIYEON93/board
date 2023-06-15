package com.sparta.board.repository;

import com.sparta.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findAllByOrderByModifiedAtDesc();

    List<Board> findAllByContentsContainsOrderByModifiedAtDesc(String keyword);

    //List<Board> findAllByUsername(String password);
}