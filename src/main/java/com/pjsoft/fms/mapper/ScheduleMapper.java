package com.pjsoft.fms.mapper;

import org.mapstruct.Mapper;

import com.pjsoft.fms.model.Schedule;
import com.pjsoft.fms.pojo.request.ScheduleDTO;
import com.pjsoft.fms.pojo.response.ScheduleResponseDTO;


	@Mapper(componentModel = "spring")
	public interface ScheduleMapper {
		ScheduleResponseDTO entityToDtoMapper(Schedule entity);

		Schedule dtoToEntityMapper(ScheduleDTO dto);

}
