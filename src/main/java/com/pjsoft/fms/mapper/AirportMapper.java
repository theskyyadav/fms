package com.pjsoft.fms.mapper;

import com.pjsoft.fms.pojo.response.AirportResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import com.pjsoft.fms.model.Airport;
import com.pjsoft.fms.pojo.request.AirportDTO;

@Mapper(componentModel = "spring")
public interface AirportMapper {

    //	@Mapping(source = "name", target = "name")
    AirportResponseDTO entityToDtoMapper(Airport entity);

    @Mapping(source = "name", target = "name", qualifiedByName = "toUpperCase")
    Airport dtoToEntityMapper(AirportDTO dto);
//    @Mapping()
    Airport dtoToEntityMapper(AirportResponseDTO dto);

    @Named("toUpperCase")
    static String toUpperCase(String name) {
        return name.toUpperCase();

    }

}
