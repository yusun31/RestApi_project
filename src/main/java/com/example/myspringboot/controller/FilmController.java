package com.example.myspringboot.controller;

import com.example.myspringboot.entity.Film;
import com.example.myspringboot.service.FilmService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/film")
public class FilmController {
    private FilmService filmService;

    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @PostMapping
    public Film addFilm(@RequestBody Film film) {
        return filmService.insertFilm(film);
    }

    @GetMapping
    public List<Film> getFilm() {
        return filmService.selectAllFilm();
    }

    @GetMapping("/{id}")
    public Film getFilm(@PathVariable Long id) {
        return filmService.selectFilm(id);
    }

    @PutMapping("/{id}")
    public Film updateFilm(@PathVariable Long id, @RequestBody Film filmDetail) {
        return filmService.updateFilm(id, filmDetail);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFilm(@PathVariable Long id) {
        return filmService.deleteFilm(id);
    }

}
