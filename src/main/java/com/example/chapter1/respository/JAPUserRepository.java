package com.example.chapter1.respository;

import com.example.chapter1.bean.JPAUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface JAPUserRepository extends JpaRepository<JPAUser,Long> {
    JPAUser findByUserNameOrEmail(String userName,String email);

    List<JPAUser> findByUserNameOrderById(String userName);

    @Query("select u from JPAUser u")
    Page<JPAUser> findAllJpaUser(Pageable pageable);

    @Transactional(timeout = 10)
    @Modifying
    @Query("update JPAUser set userName = ?1 where id = ?2")
    int modifyById(String  userName, Long id);

    @Query("select u from JPAUser u where u.nickName = ?1")
    JPAUser findByNickName(String nickName);
}
