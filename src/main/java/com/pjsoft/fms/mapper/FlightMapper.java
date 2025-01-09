package com.pjsoft.fms.mapper;

import org.mapstruct.Mapper;

import com.pjsoft.fms.model.Flight;
import com.pjsoft.fms.pojo.request.FlightDTO;
import com.pjsoft.fms.pojo.response.FlightResponseDTO;

	@Mapper(componentModel = "spring")
	public interface FlightMapper {
		FlightResponseDTO entityToDtoMapper(Flight entity);

		Flight dtoToEntityMapper(FlightDTO dto);
	}
