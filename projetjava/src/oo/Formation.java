package oo;

import java.sql.Date;

public class Formation {
    int id ;
    String titre ;
    Date date;
    String lieu;
    boolean certification;
    Formation(int id,String titre,Date date,String lieu,boolean certification){
        this.id=id;
        this.date=date;
        this.certification=certification;
        this.lieu=lieu;
        this.titre=titre;
    }

    public int getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public Date getDate() {
        return date;
    }

    public String getLieu() {
        return lieu;
    }

    public boolean isCertification() {
        return certification;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public void setCertification(boolean certification) {
        this.certification = certification;
    }
}
