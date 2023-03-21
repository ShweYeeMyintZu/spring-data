package com.example.mvccrud.service;

import com.example.mvccrud.Entity.Author;
import com.example.mvccrud.Entity.Book;
import com.example.mvccrud.dao.AuthorDao;
import com.example.mvccrud.dao.BookDao;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookService {
    private final AuthorDao authorDao;
    private final BookDao bookDao;

    public Book findBookById(int id){
        return bookDao.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public BookService(AuthorDao authorDao, BookDao bookDao) {
        this.authorDao = authorDao;
        this.bookDao = bookDao;
    }
    public void saveAuthor(Author author){
        authorDao.save(author);

    }
    public List<Author> listAuthors(){
        return authorDao.findAll();
    }

    public List<Book>listBooks(){
        return bookDao.findAll();
    }

    public void removeBook(int bookId){
        if(bookDao.existsById(bookId)){
            bookDao.deleteById(bookId);
        }else {
        throw new EntityNotFoundException(bookId+" Not Found!");
        }
    }

    @Transactional
    public void saveBook(Book book) {
        Author author=authorDao.findById(book.getAuthor().getId()).get();
        author.addBook(book);

        bookDao.save(book);
    }
    //don't use database operation
@Transactional
    public void update(Book book) {
        Book existBook=findBookById(book.getId());
        existBook.setAuthor(book.getAuthor());
        existBook.setId(book.getId());
        existBook.setTitle(book.getTitle());
        existBook.setPrice(book.getPrice());
        existBook.setImgUrl(book.getImgUrl());
        existBook.setYearPublished(book.getYearPublished());
        existBook.setPublisher(book.getPublisher());

    }
//use database operation
    public void updateAgain(Book updateBook) {
        bookDao.saveAndFlush(updateBook);
    }
}
