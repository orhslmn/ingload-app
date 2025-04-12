package com.personel.ingload.mapper;

import com.personel.ingload.dto.YeniKayitDto;
import com.personel.ingload.model.Ignload;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface YeniKayitMapper {
    YeniKayitDto mapYeniKayitDto(Ignload ignload);
    Ignload mapIngload(YeniKayitDto yeniKayitDto);
}
