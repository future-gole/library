//package com.example.demo6.repo;
//
//import com.example.demo6.domain.Book;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import java.util.List;
//
//public interface BookRepository extends JpaRepository<Book, Long> {
//    List<Book> findByTitleContainingIgnoreCase(String keyword);
//}

package com.example.demo6.repo;

import com.example.demo6.domain.Book;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@Transactional
public interface BookRepository extends CrudRepository<Book, Long> {

    @Query(value = "SELECT * FROM book", nativeQuery = true)
    List<Book> findAll();

    @Query(value = "SELECT * FROM book WHERE title LIKE %?1% OR author LIKE %?1% OR isbn LIKE %?1%", nativeQuery = true)
    List<Book> findByTitleAuthorOrIsbn(String keyword);


    @Modifying
    @Query(value = "UPDATE book SET title = ?1, author = ?2, isbn = ?3, stock = ?4, category_id = ?5 WHERE id = ?6", nativeQuery = true)
    int updateBook(String title, String author, String isbn, Integer stock, Long categoryId, Long id);
}
