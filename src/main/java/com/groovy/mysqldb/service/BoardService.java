package com.groovy.mysqldb.service;

import com.groovy.mysqldb.mapper.BoardMapper;
import com.groovy.mysqldb.vo.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardService {
    private final BoardMapper boardMapper;

    public int boardCount(){
        int result = boardMapper.boardCount();
        return result;
    }

    public List<Board> boardList(){return boardMapper.boardList();}
}
