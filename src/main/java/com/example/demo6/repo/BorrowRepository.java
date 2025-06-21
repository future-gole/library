//package com.example.demo6.repo;
//
//import com.example.demo6.domain.BorrowRecord;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import java.util.List;
//
//public interface BorrowRepository extends JpaRepository<BorrowRecord, Long> {
//    List<BorrowRecord> findByUser_Id(Long userId);
//}
package com.example.demo6.repo;

import com.example.demo6.domain.BorrowRecord;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@Transactional
public interface BorrowRepository extends CrudRepository<BorrowRecord, Long> {

    @Query(value = "SELECT * FROM borrow_record", nativeQuery = true)
    List<BorrowRecord> findAll();

    @Query(value = "SELECT * FROM borrow_record WHERE user_id = ?1", nativeQuery = true)
    List<BorrowRecord> findByUser_Id(Long userId);

    @Modifying
    @Query(value = "UPDATE borrow_record SET status = ?1, return_date = ?2 WHERE id = ?3", nativeQuery = true)
    int updateReturnStatus(String status, String returnDate, Long id);
}
