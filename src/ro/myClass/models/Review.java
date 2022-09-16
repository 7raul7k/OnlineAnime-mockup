package ro.myClass.models;

public class Review {
    private int id;
    private int animeID;
    private int usernameID;
    private String date;
    public Review(int id,int animeID,int usernameID,String date){
        this.id = id;
        this.animeID = animeID;
        this.usernameID = usernameID;
        this.date = date;
    }
    public Review(String text){
        String[] proprietes = text.split(",");
        this.id = Integer.parseInt(proprietes[0]);
        this.animeID = Integer.parseInt(proprietes[1]);
        this.usernameID = Integer.parseInt(proprietes[2]);
        this.date = proprietes[3];
    }
    public String show(){
        String text ="";
        text += "ID: " + id;
        text += "\nAnime ID: " + animeID;
        text += "\nUsername ID: " + usernameID;
        text += "\nDate:  " + date;
        text += "\n=================================\n";
        return text;
    }
    @Override
    public String toString(){
        String text ="";
        text += "ID: " + id;
        text += "\nAnime ID: " + animeID;
        text += "\nUsername ID: " + usernameID;
        text += "\nDate:  " + date;
        return text;
    }
    public String toSave(){
        return id+","+animeID+","+usernameID+","+date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAnimeID() {
        return animeID;
    }

    public void setAnimeID(int animeID) {
        this.animeID = animeID;
    }

    public int getUsernameID() {
        return usernameID;
    }

    public void setUsernameID(int usernameID) {
        this.usernameID = usernameID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
