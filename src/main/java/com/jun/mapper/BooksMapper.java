package com.jun.mapper;

import com.jun.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Jun
 * @create 2020/7/4 - 21:07
 */
public interface BooksMapper {
    //增加一个Book
    int insertBook(Books book);

    //根据id删除一个Book
    int deleteBookById(@Param("bookId") int id);

    //更新Book
    int updateBook(Books books);

    //根据id查询,返回一个Book
    Books selectBookById(@Param("bookId") int id);

    //查询全部Book,返回list集合
    List<Books> queryAllBook();

    //模糊查询
    List<Books> selectBookByName(String bookName);
}
