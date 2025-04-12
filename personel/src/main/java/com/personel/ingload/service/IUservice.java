package com.personel.ingload.service;

import com.personel.ingload.dto.YeniKayitDto;

import java.util.List;

public interface IUservice {

    YeniKayitDto AddYeniKayit(YeniKayitDto yeniKayitDto);
    List<YeniKayitDto> getAllKelimeler();


    List<YeniKayitDto> getRandomKelimeler(int limit);
}
