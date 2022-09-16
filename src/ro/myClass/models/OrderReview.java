package ro.myClass.models;

public class OrderReview {
    private int id;
    private int animeId;
    private int reviewId;
    private int usernameID;
    private float rating;


    public OrderReview(int id,int animeId,int reviewId,int usernameID,float rating){
        this.id = id;
        this.animeId = animeId;
        this.reviewId = reviewId;
        this.usernameID = usernameID;
        this.rating = rating;

    }
    public OrderReview(String text){
        String[] proprietes = text.split(",");
        this.id = Integer.parseInt(proprietes[0]);
        this.animeId = Integer.parseInt(proprietes[1]);
        this.reviewId = Integer.parseInt(proprietes[2]);
        this.usernameID = Integer.parseInt(proprietes[3]);
        this.rating = Float.parseFloat(proprietes[4]);

    }
    public String describe(){
        String text = "";
        text += "ID: " + id;
        text += "\nAnime id: " + animeId;
        text += "\nReview id: " + reviewId;
        text += "\nRating: " + rating;
        text += "\n================================================\n";
        return text;
    }
    @Override
    public String toString(){
        String text = "";
        text += "ID: " +  id;
        text += "\nAnime id: " + animeId;
        text += "\nReview id: " + reviewId;
        text += "\nRating: " + rating;
        return text;
    }
    public String toSave(){
        return  id+","+animeId+","+reviewId+","+usernameID+","+rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAnimeId() {
        return animeId;
    }

    public void setAnimeId(int animeId) {
        this.animeId = animeId;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public int getUsernameID() {
        return usernameID;
    }

    public void setUsernameID(int usernameID) {
        this.usernameID = usernameID;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

}
