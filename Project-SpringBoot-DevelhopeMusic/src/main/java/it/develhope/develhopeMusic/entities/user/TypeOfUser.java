package it.develhope.develhopeMusic.entities.user;

public enum TypeOfUser {

    LISTENER {
        public String toString() {
            return "LISTENER";
        }
    },

    ARTIST {
        public String toString() {
            return "ARTIST";
        }
    }
}