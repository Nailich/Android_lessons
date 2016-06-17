package ru.stonefist.lesson7_notes;

/**
 * Created by ntairov on 15.06.2016.
 */
public class note {
    String noteName;
    String noteDate;

    public note(String noteName, String noteDate) {
        this.noteName = noteName;
        this.noteDate = noteDate;
    }

    public String getNoteName() {return noteName;}

    public void setNoteName(String noteName) {this.noteName = noteName;}

    public String getNoteDate() {return noteDate;}

    public void setNoteDate(String noteDate) {this.noteDate = noteDate;}
}
