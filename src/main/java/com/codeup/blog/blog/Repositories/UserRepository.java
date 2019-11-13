package com.codeup.blog.blog.Repositories;

import com.codeup.blog.blog.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>  {
    User findByUsername(String username);
}
