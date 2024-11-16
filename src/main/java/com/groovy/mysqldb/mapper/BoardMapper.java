package com.groovy.mysqldb.mapper;

import com.groovy.mysqldb.vo.Board;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardMapper {
    int boardCount();

    List<Board> boardList();
}
