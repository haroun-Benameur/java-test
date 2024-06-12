package tp4;

public class Main {
    public static void main(String[] args){
      EtudiantDAO e=new EtudiantDAO(Config.url,Config.username,Config.password);
      e.afficheALL("Select * from ");
    }
}
