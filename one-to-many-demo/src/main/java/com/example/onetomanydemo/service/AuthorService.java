package com.example.onetomanydemo.service;

import com.example.onetomanydemo.dao.AuthorDao;
import com.example.onetomanydemo.dao.BookDao;
import com.example.onetomanydemo.entity.Author;
import com.example.onetomanydemo.entity.Books;
import jakarta.transaction.Transactional;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    private final AuthorDao authorDao;
    private final BookDao bookDao;

    public AuthorService(AuthorDao authorDao,BookDao bookDao){
        this.authorDao=authorDao;
        this.bookDao=bookDao;
    }
    @Transactional
    public void newThreeBooksWithoutAuthor(){
        Books books1=new Books("A Tale of Two Cities",44,"Novel");
        Books books2=new Books("Black Arrow",44,"Novel");
        Books books3=new Books("Return of Native",44,"Novel");
        bookDao.save(books1);
        bookDao.save(books2);
        bookDao.save(books3);
    }

    @Transactional
    public void addNewBookWithExistingAuthor(){
        Author author= getAuthorByName();
        Books books=new Books("Clara and Sun",30,"Novel");
        author.addBook(books);
    }

    private Author getAuthorByName() {
        return authorDao.findAuthorByName("Ishiguro");
    }

    @Transactional
    public void removeFirstBookFromExistingAurthor(){
        Author author= getAuthorByName();
        author.removeBook(author.getBooks().get(0));

    }
    @Transactional
    public void removelastBookFromExistingAurthor(){
        Author author=getAuthorByName();
        author.removeBook((author.getBooks().get(author.getBooks().size()-1)));
    }


    @Transactional
    public void saveAuthorWithThreeBooks(){
        Author author=new Author();
        author.setName("Ishiguro");
       Books book1=new Books("A pale view of hill",35.3,"Novel");
       Books book2=new Books("Don't let me go",30,"Novel");
       Books book3=new Books("The remains of the day",50,"Novel");
       author.addBook(book1);
       author.addBook(book2);
       author.addBook(book3);

       authorDao.save(author);
    }
}
