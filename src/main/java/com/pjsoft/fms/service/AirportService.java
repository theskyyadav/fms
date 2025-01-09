package com.pjsoft.fms.service;

import com.pjsoft.fms.exception.ResourceNotFoundException;
import com.pjsoft.fms.mapper.AirportMapper;
import com.pjsoft.fms.model.Airport;
import com.pjsoft.fms.model.Booking;
import com.pjsoft.fms.pojo.request.AirportDTO;
import com.pjsoft.fms.pojo.response.AirportResponseDTO;
import com.pjsoft.fms.repository.AirportRepository;
import com.pjsoft.fms.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public
class AirportService {
    @Autowired
    AirportMapper airportMapper;
    @Autowired
    private
    AirportRepository airportRepository;

    public
    List<AirportResponseDTO> getAllAirports() {
        return airportRepository.findAll().stream()
                .map(airport -> airportMapper.entityToDtoMapper(airport))
                .collect(Collectors.toList());
    }
    public
    AirportResponseDTO getAirportById(Long id) {
        Airport airport= airportRepository.findById(id)
                .orElseThrow
                        (() -> new ResourceNotFoundException("Airport not found with id: " + id));
        return airportMapper.entityToDtoMapper(airport);
    }
    public Airport saveAirport(AirportDTO airportDTO) {
        Airport airport=airportMapper.dtoToEntityMapper(airportDTO);
        return airportRepository.save(airport);
    }

    public void deleteAirport(Long id) {
        AirportResponseDTO airportResponseDTO= getAirportById(id);
        airportRepository.delete(airportMapper.dtoToEntityMapper(airportResponseDTO));
    }
}
