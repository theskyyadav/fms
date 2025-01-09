package com.pjsoft.fms.mapper;

import org.mapstruct.Mapper;

import com.pjsoft.fms.model.ScheduledFlight;
import com.pjsoft.fms.pojo.request.ScheduledFlightDTO;
import com.pjsoft.fms.pojo.response.ScheduledFlightResponseDTO;


	@Mapper(componentModel = "spring")
	public interface ScheduledFlightMapper {
		ScheduledFlightResponseDTO entityToDtoMapper(ScheduledFlight entity);

		ScheduledFlight dtoToEntityMapper(ScheduledFlightDTO dto);
}
