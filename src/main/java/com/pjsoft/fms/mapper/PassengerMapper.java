package com.pjsoft.fms.mapper;

import org.mapstruct.Mapper;

import com.pjsoft.fms.model.Passenger;
import com.pjsoft.fms.pojo.request.PassengerDTO;
import com.pjsoft.fms.pojo.response.PassengerResponseDTO;


	@Mapper(componentModel = "spring")
	public interface PassengerMapper {
		PassengerResponseDTO entityToDtoMapper(Passenger entity);

		Passenger dtoToEntityMapper(PassengerDTO dto);

}
