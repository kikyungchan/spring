package com.example.spring.repository;

import com.example.spring.entity.Entity16;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Entity16Repository extends JpaRepository<Entity16, Integer> {
    // findById
    // save
    // deleteById

    // 직접 만드는 쿼리
    @Query(value = """
             SELECT *
            FROM customer
            WHERE country = :country;
            
            """, nativeQuery = true)
    List<Entity16> query1(String country);

    @Query(value = """
            SELECT *
            FROM customer
            WHERE city = :city
            """, nativeQuery = true)
    List<Entity16> query2(String city);

    @Query(value = """
            SELECT *
            FROM customer
            WHERE city= :city1
            OR city= :city2
            """, nativeQuery = true)
    List<Entity16> query3(String city1, String city2);

    @Query(value = """
            SELECT *
            FROM customer
            WHERE customer_name LIKE :keyword
            """, nativeQuery = true)
    List<Entity16> query4(String keyword);
// SQL쿼리
//    @Query(value = """
//             SELECT *
//            FROM customer
//            WHERE country = :country;
//
//            """, nativeQuery = true)

    //JPQL : 별칭을 꼭 써야함. Entity대상으로 쿼리날림.#
    @Query(value = """
            SELECT e
            FROM Entity16 e
            WHERE e.country= :country
            """)
    List<Entity16> query5(String country);

    @Query(value = """
            SELECT e
            FROM Entity16 e
            WHERE e.city= :city
            """)
    List<Entity16> query6(String city);

    //SQL 쿼리
//    @Query(value = """
//SELECT *
//FROM customer
//WHERE customer_name LIKE :keyword
//""", nativeQuery = true)
//    List<Entity16> query4(String keyword);
    @Query(value = """
            SELECT c
            FROM Entity16 c
            WHERE c.contactName LIKE :keyword
            """)
    List<Entity16> query7(String keyword);

    // JPQL
//    @Query(value = """
//            SELECT e
//            FROM Entity16 e
//            WHERE e.country= :country
//            """)
    List<Entity16> findByCountry(String country);
//    List<Entity16> findByCountry(String country, PageRequest pageRequest);

    //sql, jpql 안써도됨
    // 쿼리 자동으로 만들어줌
    // SELECT * FROM customer WHERE city = :city
    List<Entity16> findByCity(String city);

    Page<Entity16> findByCountry(String country, PageRequest id);


    Page<Entity16> findByCustomerNameContainingOrContactNameContaining(String customerName, String contactName, PageRequest pageRequest);

    void deleteByCountry(String country);
    @Modifying // update, delete, inset에 붙이는 어노테이션
    @Query(value = """
            DELETE FROM Entity16 e WHERE e.country = :country
            """)
    void bulkDeleteByCountry(String country);
}
