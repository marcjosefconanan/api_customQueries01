package com.api_customQueries01.api_customQueries01.Enum;

public enum StatusEnum {
    ONTIME("In tempo"),

    DELAYED("In ritardo"),

    CANCELLED("Cancellato");
    public String descrizione;

    StatusEnum(String descrizione) {
        this.descrizione=descrizione;
    }

    public String getDescrizione() {
        return descrizione;
    }
}