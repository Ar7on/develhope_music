package it.develhope.develhopeMusic.entities.user;

import javax.persistence.Enumerated;

public enum TypeOfUser {

    @Enumerated

    LISTENER,
    ARTIST

}