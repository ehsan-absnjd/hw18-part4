package library.service;

import library.entity.Book;
import library.repository.BookRepository;

public class BookService extends BaseService<Book,Integer> {
    @Override
    protected void setRepository() {
        repository=new BookRepository();
    }
}
