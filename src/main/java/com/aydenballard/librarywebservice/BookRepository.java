/**
 * Book repository class, extends from JpaRepository with the types
 * Book, Long
 * @Author Ayden Ballard
 */

package com.aydenballard.librarywebservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
