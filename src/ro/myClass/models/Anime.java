package ro.myClass.models;

public class Anime {
private int id;
private String name;
private int totalEpisodes;
private String sourceLink;
private float overallRating;
private String releaseDate;

public Anime(int id,String name,int totalEpisodes,String sourceLink,float overallRating,String releaseDate){
    this.id = id;
    this.name = name;
    this.totalEpisodes = totalEpisodes;
    this.sourceLink = sourceLink;
    this.overallRating = overallRating;
    this.releaseDate = releaseDate;
}
public Anime(String text){
    String[] proprietes = text.split(",");
    this.id = Integer.parseInt(proprietes[0]);
    this.name = proprietes[1];
    this.totalEpisodes = Integer.parseInt(proprietes[2]);
    this.sourceLink = proprietes[3];
    this.overallRating = Float.parseFloat(proprietes[4]);
    this.releaseDate = proprietes[5];
}
public String describe(){
    String text = "";
    text += "ID: " + id;
    text += "\nAnime name: " + name;
    text += "\nTotal episodes: " + totalEpisodes;
    text += "\nSource link: " + sourceLink;
    text += "\n Overall rating: " + overallRating;
    text += "\n Release date: " + releaseDate;
    text += "\n================================================\n";
    return text;
}

@Override
public String toString(){
    String text = "";
    text += "ID: " + id;
    text += "\nAnime name: " + name;
    text += "\nTotal episodes: " + totalEpisodes;
    text += "\nSource link: " + sourceLink;
    text += "\n Overall rating: " + overallRating;
    text += "\n Release date: " + releaseDate;
    return text;

}

    public String toSave(){
    return id+","+name+","+totalEpisodes+","+sourceLink+","+overallRating+","+releaseDate;
}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalEpisodes() {
        return totalEpisodes;
    }

    public void setTotalEpisodes(int totalEpisodes) {
        this.totalEpisodes = totalEpisodes;
    }

    public String getSourceLink() {
        return sourceLink;
    }

    public void setSourceLink(String sourceLink) {
        this.sourceLink = sourceLink;
    }

    public float getOverallRating() {
        return overallRating;
    }

    public void setOverallRating(float overallRating) {
        this.overallRating = overallRating;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
}
