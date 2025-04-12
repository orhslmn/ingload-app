package com.personel.ingload.service;

import com.personel.ingload.dto.YeniKayitDto;
import com.personel.ingload.mapper.YeniKayitMapper;
import com.personel.ingload.model.Ignload;
import com.personel.ingload.repository.Repository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import java.util.stream.Collectors;

import java.util.Collections;
import java.util.List;

@org.springframework.stereotype.Service
public class Service implements IUservice {

    final private YeniKayitMapper yeniKayitMapper;
    final private Repository repository;

    public Service(YeniKayitMapper yeniKayitMapper, Repository repository) {
        this.yeniKayitMapper = yeniKayitMapper;
        this.repository = repository;
    }

    @Override
    public YeniKayitDto AddYeniKayit(YeniKayitDto yeniKayitDto) {
        Ignload ignload = yeniKayitMapper.mapIngload(yeniKayitDto);
        Ignload yeniIngload = repository.save(ignload);
        return yeniKayitMapper.mapYeniKayitDto(yeniIngload);
    }

    @Override
    public List<YeniKayitDto> getAllKelimeler() {

        List<Ignload> kelimeler = repository.findAll();
        return kelimeler.stream()
                .map(yeniKayitMapper::mapYeniKayitDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<YeniKayitDto> getRandomKelimeler(int limit) {
        Pageable pageable = PageRequest.of(0, limit);
        List<Ignload> randomKelimes = repository.findRandomKelimeler(pageable);

        if (randomKelimes != null && !randomKelimes.isEmpty()) {
            return randomKelimes.stream()
                    .map(yeniKayitMapper::mapYeniKayitDto)
                    .collect(Collectors.toList());
        } else {
            return Collections.emptyList();
        }
    }
}
