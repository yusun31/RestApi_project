package com.example.myspringboot.repository;

import com.example.myspringboot.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film,Long> {
    // username으로 조회하는 finder method 선언
    Film findByName(String name);
}