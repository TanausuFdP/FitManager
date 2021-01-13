package es.ulpgc.fitmanager.controller.action.reservation;

import es.ulpgc.fitmanager.view.repository.ReservationRepository;
import java.sql.Connection;

public class GetCountOfReservationsByActivityIdAction {
    public GetCountOfReservationsByActivityIdAction(){
        reservationRepository = new ReservationRepository();
    }
    
    private final ReservationRepository reservationRepository;
    
    public Integer execute(Connection conn, Integer activityId) {
        return reservationRepository.getReservationsOfActivity(conn, activityId);
    }
}