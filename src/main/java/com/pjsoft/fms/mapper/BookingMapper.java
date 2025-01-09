package com.pjsoft.fms.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import com.pjsoft.fms.model.Airport;
import com.pjsoft.fms.model.Booking;
import com.pjsoft.fms.pojo.request.AirportDTO;
import com.pjsoft.fms.pojo.request.BookingDTO;
import com.pjsoft.fms.pojo.response.AirportResponseDTO;
import com.pjsoft.fms.pojo.response.BookingResponseDTO;

	@Mapper(componentModel = "spring")
	public interface BookingMapper {
		BookingResponseDTO entityToDtoMapper(Booking entity);

		Booking dtoToEntityMapper(BookingDTO dto);

}
