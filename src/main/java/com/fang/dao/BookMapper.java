package com.fang.dao;

import com.fang.pojo.Books;

import java.util.List;

public interface BookMapper {
    //添加一本书
    int addBook(Books book);
    //删除一本书
    int deleteBookById(int id);

    //更新一本书
    int updateBook(Books book);
    //查询一本书
    Books queryBookId(int id);
    //查询所有书
    List<Books> queryAllBook();
}
