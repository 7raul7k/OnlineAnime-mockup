package ro.myClass.models;

public class Customer extends User{
    public int animeseen;
    public String bestAnime;
    public String lastAnime;

    public Customer(int id,String firstName,String lastName,String email,String password,String adress,boolean isActive,int animeseen,String bestAnime,String lastAnime){
        super("customer", id, firstName, lastName, email, password, adress, isActive);
        this.animeseen = animeseen;
        this.bestAnime = bestAnime;
        this.lastAnime = lastAnime;
    }
    public Customer(String text){
        super(text);
        String[] proprietes = text.split(",");
        this.animeseen = Integer.parseInt(proprietes[8]);
        this.bestAnime = proprietes[9];
        this.lastAnime = proprietes[10];
    }
    public String show(){
        String text = "";
        text += super.show();
        text += "\n Number of Anime you seen: " + animeseen;
        text += "\n Best anime: " + bestAnime;
        text += "\n Last Anime: " + lastAnime;
        text += "\n=======================================\n";
        return text;
    }
    @Override
    public String toString(){
        String text = "";
        text += super.show();
        text += "\n Number of Anime you seen: " + animeseen;
        text += "\n Best anime: " + bestAnime;
        text += "\n Last Anime: " + lastAnime;
        return text;
    }

    public String toSave(){
        return super.toSave() +"," + animeseen+","+bestAnime+","+lastAnime;

    }

    public int getAnimeseen() {
        return animeseen;
    }

    public void setAnimeseen(int animeseen) {
        this.animeseen = animeseen;
    }

    public String getBestAnime() {
        return bestAnime;
    }

    public void setBestAnime(String bestAnime) {
        this.bestAnime = bestAnime;
    }

    public String getLastAnime() {
        return lastAnime;
    }

    public void setLastAnime(String lastAnime) {
        this.lastAnime = lastAnime;
    }
}
