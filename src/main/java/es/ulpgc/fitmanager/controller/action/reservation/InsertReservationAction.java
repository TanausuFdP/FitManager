package es.ulpgc.fitmanager.controller.action.reservation;

import es.ulpgc.fitmanager.controller.exceptions.ActivityCapacityFullException;
import es.ulpgc.fitmanager.controller.exceptions.ReservationAlreadyExistsException;
import es.ulpgc.fitmanager.controller.exceptions.ReservationNotFoundException;
import es.ulpgc.fitmanager.model.Reservation;
import es.ulpgc.fitmanager.view.repository.ActivityRepository;
import es.ulpgc.fitmanager.view.repository.ReservationRepository;

import java.sql.Connection;

public class InsertReservationAction {
    public InsertReservationAction() {
        reservationRepository = new ReservationRepository();
        activityRepository = new ActivityRepository();
    }

    private final ReservationRepository reservationRepository;
    private final ActivityRepository activityRepository;

    public Reservation execute(Connection conn, Reservation reservation) {
        try {
            reservationRepository.getReservationByIds(conn, reservation.getClientId(), reservation.getActivityId());
            throw new ReservationAlreadyExistsException("Ya existe una reserva de la actividad " + reservation.getActivityId()
                    + " para el usuario con id " + reservation.getClientId());
        } catch (ReservationNotFoundException ex) {
            if(isActivityAvailable(conn, reservation.getActivityId())){
                reservationRepository.insertReservation(conn, reservation);
                return reservationRepository.getReservationByIds(conn, reservation.getClientId(), reservation.getActivityId());
            } else {
                throw new ActivityCapacityFullException("Se ha alcanzado el aforo permitido en la actividad");
            }
        }
    }

    private boolean isActivityAvailable(Connection conn, Integer activityId) {
        Integer activityCapacity = activityRepository.getActivityById(conn, activityId).getCapacity();
        Integer reservations = reservationRepository.getReservationsOfActivity(conn, activityId);
        return (activityCapacity > reservations);
    }
}
