package com.example.myspringboot.service;

import com.example.myspringboot.entity.Film;
import com.example.myspringboot.exception.ResourceNotFoundException;
import com.example.myspringboot.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FilmService {
    @Autowired
    private FilmRepository filmRepository;

    public Film insertFilm(Film film) {
        return filmRepository.save(film);
    }

    @Transactional(readOnly = true)
    public List<Film> selectAllFilm() {
        return filmRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Film selectFilm(Long id) {
        Optional<Film> optionalFilm = filmRepository.findById(id);
        Film existFilm = optionalFilm.orElseThrow(() -> new ResourceNotFoundException("Film","id",id));
        return existFilm;
    }

    public Film updateFilm(Long id, Film filmDetail) {
        Film existFilm = filmRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Film", "id", id));
        existFilm.setName(filmDetail.getName());
        existFilm.setDirector(filmDetail.getDirector());
        return existFilm;
    }

    public ResponseEntity<?> deleteFilm(Long id) {
        Optional<Film> optionalFilm = filmRepository.findById(id);
        if(!optionalFilm.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(id + "Film Not Found");
        }
        Film existFilm = optionalFilm.get();
        filmRepository.delete(existFilm);
        return ResponseEntity.ok("Film Delete OK");
    }

}