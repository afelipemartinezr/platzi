package com.fundamentos.platzi.repository;

import com.fundamentos.platzi.dto.UserDto;
import com.fundamentos.platzi.entity.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.hibernate.loader.Loader.SELECT;

@Repository
public interface UserRepository extends PagingAndSortingRepository <User, Long> {
    @Query("SELECT u FROM User u WHERE u.email=?1 ")
    Optional<User> findByUserEmail(String email);

    @Query("SELECT  u FROM User u WHERE u.name like ?1%")

    List<User> findAndSort(String name, Sort sort);

    List<User> findByName(String name);

    User findByNameAndEmail(String name, String email);

    List<User> findByNameLike(String name);

    List<User> findByNameOrEmail(String name, String email);

    List<User> findByBirthDateBetween(LocalDate begin, LocalDate end);

    List<User> findByNameLikeOrderByIdDesc(String name);

    List<User> findByNameContainingOrderByIdDesc(String name);

    @Query("SELECT new com.fundamentos.platzi.dto.UserDto(u.id,u.name,u.birthDate) "+
            "FROM User u "+
            "WHERE u.birthDate=:parameterDate "+
            "AND u.email=:parameterEmail"
    )
    Optional<UserDto>  getAllByBirthDateAndEmail(@Param("parameterDate") LocalDate birthDate,
                                                 @Param("parameterEmail") String email);

    List<User> findAll();
}
