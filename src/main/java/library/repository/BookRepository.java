package library.repository;


import library.entity.Book;

public class BookRepository extends BaseRepository<Book, Integer> {
    @Override
    protected void setEntityClass() {
        entityClass= Book.class;
    }
}
