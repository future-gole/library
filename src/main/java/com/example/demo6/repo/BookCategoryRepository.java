//package com.example.demo6.repo;
//
//import com.example.demo6.domain.BookCategory;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//public interface BookCategoryRepository extends JpaRepository<BookCategory, Long> {}

package com.example.demo6.repo;

import com.example.demo6.domain.BookCategory;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@Transactional
public interface BookCategoryRepository extends CrudRepository<BookCategory, Long> {

    @Query(value = "SELECT * FROM book_category", nativeQuery = true)
    List<BookCategory> findAll();

    @Modifying
    @Query(value = "UPDATE book_category SET name = ?1, description = ?2 WHERE id = ?3", nativeQuery = true)
    int updateCategory(String name, String description, Long id);
}
