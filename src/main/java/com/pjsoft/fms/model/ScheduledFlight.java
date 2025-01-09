package com.pjsoft.fms.model;


import jakarta.persistence.*;

@Entity

public class ScheduledFlight {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(nullable = false)

    private int  availableSeats;

//    public
//    ScheduledFlight(int availableSeats, Flight flight, Schedule schedule) {
//        this.availableSeats = availableSeats;
//        this.flight = flight;
//        this.schedule = schedule;
//    }

    public
    Schedule getSchedule() {
        return schedule;
    }

    public
    void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public
    Flight getFlight() {
        return flight;
    }

    public
    void setFlight(Flight flight) {
        this.flight = flight;
    }

    // ScheduledFlight
    @ManyToOne
    @JoinColumn(name = "flight_id", nullable = false)
    private Flight flight;


    @ManyToOne
    @JoinColumn(name = "schedule_id", nullable = false)
    private Schedule schedule;

    public
    ScheduledFlight(Long id, int availableSeats) {
        this.id = id;
        this.availableSeats = availableSeats;
    }

    public
    ScheduledFlight() {
    }

    public Long getId() {

        return id;

    }

    public void setId(Long id) {

        this.id = id;

    }

    public int getAvailableSeats() {

        return availableSeats;

    }

    public void setAvailableSeats(int availableSeats) {

        this.availableSeats = availableSeats;

    }

}
