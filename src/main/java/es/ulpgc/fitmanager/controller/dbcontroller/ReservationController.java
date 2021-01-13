package es.ulpgc.fitmanager.controller.dbcontroller;

import es.ulpgc.fitmanager.controller.action.reservation.*;
import es.ulpgc.fitmanager.controller.exceptions.*;
import es.ulpgc.fitmanager.model.Activity;
import es.ulpgc.fitmanager.model.Reservation;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ReservationController extends Controller {
    public ReservationController() {
        getReservationByIdsAction = new GetReservationByIdsAction();
        getReservationsByClientIdAction = new GetReservationByClientIdAction();
        insertReservationAction = new InsertReservationAction();
        cancelReservationAction = new CancelReservationAction();
        getCountOfReservationsByActivityIdAction = new GetCountOfReservationsByActivityIdAction();
    }

    private final GetReservationByIdsAction getReservationByIdsAction;

    private final GetReservationByClientIdAction getReservationsByClientIdAction;
    
    private final InsertReservationAction insertReservationAction;

    private final CancelReservationAction cancelReservationAction;
    
    private final GetCountOfReservationsByActivityIdAction getCountOfReservationsByActivityIdAction;

    public Reservation getReservationByIds(Integer clientId, Integer activityId){
        Connection conn = connectToDB();
        try {
            return getReservationByIdsAction.execute(conn, clientId,activityId);
        } catch (ReservationNotFoundException ex){
            log.error(ex.getLocalizedMessage());
            return null;
        }
    }

    public List<Activity> getReservationsByClientId(Integer clientId){
        Connection conn = connectToDB();
        try {
            return getReservationsByClientIdAction.execute(conn, clientId);
        } catch (EmptyListException ex) {
            log.warn(ex.getLocalizedMessage());
            return new ArrayList<>();
        } catch (UserNotFoundException ex){
            log.error(ex.getLocalizedMessage());
            return new ArrayList<>();
        }
    }
    
    public int getCountOfReservationsByActivityId(Integer activityId){
        Connection conn = connectToDB();
        try {
            return getCountOfReservationsByActivityIdAction.execute(conn, activityId);
        } catch (EmptyListException ex) {
            log.warn(ex.getLocalizedMessage());
            return 0;
        } catch (UserNotFoundException ex){
            log.error(ex.getLocalizedMessage());
            return 0;
        }
    }
    
    public void insertReservation(Reservation reservation){
        Connection conn = connectToDB();
        try {
            insertReservationAction.execute(conn, reservation);
        } catch (ReservationAlreadyExistsException | ActivityCapacityFullException ex){
            log.error(ex.getLocalizedMessage());
        }
    }

    public void cancelReservation(Integer clientId, Integer activityId){
        Connection conn = connectToDB();
        cancelReservationAction.execute(conn, clientId, activityId);
    }
}