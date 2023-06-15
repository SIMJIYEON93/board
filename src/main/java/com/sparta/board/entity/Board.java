package com.sparta.board.entity;

import com.sparta.board.dto.BoardRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity // JPA가 관리할 수 있는 Entity 클래스 지정
@Getter
@Setter //조심히 사용
@Table(name = "board") // 매핑할 테이블의 이름을 지정
@NoArgsConstructor //기본생성자 생성
public class Board extends Timestamped {
    @Id // 식별자
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment
    private Long id;
    @Column(name = "username", nullable = false) //null값을 허용하지 않음(기본값 true)
    private String username;
    @Column(name = "contents", nullable = false, length = 500)
    private String contents;


    public Board(BoardRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
    }

    public void update(BoardRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
    }
}