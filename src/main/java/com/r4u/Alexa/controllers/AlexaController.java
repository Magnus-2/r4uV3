package com.r4u.Alexa.controllers;

import com.r4u.Alexa.models.AlexaRO;
import com.r4u.Alexa.models.OutputSpeechRO;
import com.r4u.Alexa.models.ResponseRO;
import com.r4u.Alexa.services.TaskList;
import com.r4u.Reservation.models.Reservation;
import com.r4u.Reservation.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
@RestController
public class AlexaController {

    @Autowired
    private ReservationService reservationService;


    @PostMapping(
            path = "/Alexa/UR/all",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public AlexaRO getReservation(@RequestBody AlexaRO alexaRO) {

        if (alexaRO.getRequest().getType().equalsIgnoreCase("LaunchRequest")){
            return prepareResponse(alexaRO, "Welcome to the R4You Reservation Organizer. ", false);
        }

        if(alexaRO.getRequest().getType().equalsIgnoreCase("IntentRequest")
                &&
                (alexaRO.getRequest().getIntent().getName().equalsIgnoreCase("ReservationsReadIntent"))
        )

        {
            //ich weiß, jemand hat gesagt: Read all my usertasks.
            StringBuilder outText = new StringBuilder ("Hallo Sie haben folgende Reservierungen.");
            try {


                //usertasks hinzufügen
                TaskList reservationList = new TaskList(new Reservation());

              //  List<Reservation> reservations =   reservationService.findAll();

                reservationList.setReservation();
                AtomicInteger i = new AtomicInteger(0);
                reservationList.getReservation().forEach(
                        reservations -> {
                            outText.append(" Reservierung Nummer " + i.incrementAndGet() + " ist im Restaurant: ");
                            outText.append(reservations.getRestaurant() + " am  " + reservations.getReservationDate());
                            outText.append(". Es wurden " + reservations.getSeats() +" Sitzplätze Reserviert um " + reservations.getReservationTime()+".");
                        }
                );
                outText.append(" Danke, dass Sie unseren Service benutzt haben. ");
            }
            catch (Exception e){
                outText.append("Unfortunately, we cannot reach heroku. Our REST server is not responding");
            }
            return prepareResponse(alexaRO,outText.toString(),true);
        }
        return prepareResponse(alexaRO, "Wir konnten Ihnen leider nicht weiter helfen. ", true);

    }

    private AlexaRO prepareResponse(AlexaRO alexaRO, String outText, boolean shouldEndSession) {

        alexaRO.setRequest(null);
        alexaRO.setSession(null);
        alexaRO.setContext(null);
        OutputSpeechRO outputSpeechRO = new OutputSpeechRO();
        outputSpeechRO.setType("PlainText");
        outputSpeechRO.setText(outText);
        ResponseRO response = new ResponseRO(outputSpeechRO, shouldEndSession);
        alexaRO.setResponse(response);
        return alexaRO;
    }
}
