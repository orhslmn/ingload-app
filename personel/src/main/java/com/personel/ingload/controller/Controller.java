package com.personel.ingload.controller;

import com.personel.ingload.dto.YeniKayitDto;
import com.personel.ingload.service.IUservice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingload/ingl")
public class Controller {

    private final IUservice iUservice;

    public Controller(IUservice iUservice) {
        this.iUservice = iUservice;
    }

    @PutMapping("/nu")
    public ResponseEntity<YeniKayitDto> AddNewWord(@RequestBody YeniKayitDto yeniKayitDto) {
        YeniKayitDto nuDto = iUservice.AddYeniKayit(yeniKayitDto);
        return new ResponseEntity<>(nuDto, HttpStatus.CREATED);
    }

    @GetMapping("/liste")
    public List<YeniKayitDto> getAllKelimeler() {
        return iUservice.getAllKelimeler();
    }

    @GetMapping("/random")
    public ResponseEntity<List<YeniKayitDto>> getRandomKelimeler(@RequestParam(defaultValue = "5") int limit) {
        List<YeniKayitDto> kelimeler = iUservice.getRandomKelimeler(limit);
        return new ResponseEntity<>(kelimeler, HttpStatus.OK);
    }
}
