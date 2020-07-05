package com.jun.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jun.mapper.BooksMapper;
import com.jun.pojo.Books;
import com.jun.pojo.PageResult;
import com.jun.service.BooksService;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Jun
 * @create 2020/7/4 - 21:07
 */
@Service
public class BooksServiceImpl implements BooksService {
    @Autowired
    private BooksMapper booksMapper;

    /**
     * 分页查询书籍
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageResult<Books> findByPage(Integer page, Integer size) {
        if(page < 1){
            page = 1;
        }
        //开启分页
        PageHelper.startPage(page,size);
        //查询书籍
        Page<Books> pg = (Page<Books>) booksMapper.queryAllBook();

        PageResult<Books> result = new PageResult<>();
        result.setCurrPage(page);
        result.setTotalCount(pg.getTotal());
        result.setPageSize(size);
        result.setTotalPage((long) pg.getPages());
        result.setList(pg.getResult());
        return result;
    }

    /**
     * 模糊查询
     * @param bookName
     * @return
     */
    @Override
    public List<Books> selectBookByName(String bookName) {
        return booksMapper.selectBookByName(bookName);
    }

    /**
     *新增书籍
     * @param book
     * @return
     */
    public int insertBook(Books book) {
        List<Books> books1 = booksMapper.queryAllBook();
        //遍历数据库中的书籍，当新增的书籍数据库里就有了，直接将数量新增上去就行了
        for(Books books2 : books1){
            //String类型比较要用equal
            if (StringUtils.equals(book.getBookName(),books2.getBookName())){
                book.setBookID(books2.getBookID());
                book.setBookCounts(book.getBookCounts()+books2.getBookCounts());
                return booksMapper.updateBook(book);
            }
        }
        return booksMapper.insertBook(book);
    }

    //根据id删除一个Book
    public int deleteBookById(int id) {
        return booksMapper.deleteBookById(id);
    }

    //更新Book
    public int updateBook(Books books) {
        return booksMapper.updateBook(books);
    }

    //根据id查询,返回一个Book
    public Books queryBookById(@Param("bookId") int id) {
        return booksMapper.selectBookById(id);
    }

    //查询全部Book,返回list集合
    public List<Books> queryAllBook() {
        return booksMapper.queryAllBook();
    }

}
