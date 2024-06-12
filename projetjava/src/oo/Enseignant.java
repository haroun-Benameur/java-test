package oo;

public class Enseignant {
    String specialite;
    String grade;

    public Enseignant(String specialite, String grade) {
        this.specialite = specialite;
        this.grade = grade;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
