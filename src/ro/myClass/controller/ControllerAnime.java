package ro.myClass.controller;

import ro.myClass.models.Anime;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ControllerAnime {
    ArrayList<Anime> animes;
    public ControllerAnime(){
        this.animes = new ArrayList<>();
        this.load();
    }
    public void load(){
        try{
            File file = new File("C:\\mycode\\JavaBasics\\Mostenirea\\OnlineAnime\\src\\ro\\myClass\\resources\\anime.txt");
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                this.animes.add(new Anime(scanner.nextLine()));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public String describeAnime(){
        String text = "";
        for(int i = 0 ; i < animes.size();i++) {
        text += animes.get(i).describe();
        }
            return text;
    }
    public int findbyName(String name){
        for(int i = 0 ; i < animes.size() ;i++){
            if(animes.get(i).getName().equals(name)){
                return i;
            }
        }
        return -1;
    }
    public boolean addAnime(Anime anime){
        int pos = findbyName(anime.getName());
        if(pos == -1){
            this.animes.add(anime);
        }
        return true;
    }
    public boolean removeAnime(String name){
        int pos = findbyName(name);
        if(pos != -1){
            this.animes.remove(pos);
        }
        return true;
    }
    public String toString(){
        String text = "";
        for (int i = 0 ; i < animes.size();i++){
            text += animes.get(i).toSave() +"\n";
        }
        return text;
    }
    public void save() {
        try {
            File file = new File("C:\\mycode\\JavaBasics\\Mostenirea\\OnlineAnime\\src\\ro\\myClass\\resources\\anime.txt");
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(this);
            printWriter.flush();
            printWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public int size(){

        return animes.size();
    }

    public Anime returnAnimebyName(String name) {
        for(Anime m : animes){
            if(m.getName().equals(name)){
                return m;
            }
        }
        return null;
    }
    public int generateID(){
        if(this.animes.size()>0){
            return animes.get(this.animes.size()-1).getId()+1;
        }
        return 1;
    }


    public Anime returnAnimebyID(int animeID) {
        for(int i = 0 ; i < animes.size();i++){
            if(animes.get(i).getId() == animeID){
                return animes.get(i);
            }
        }
        return null;
    }

    public boolean updateTotalEpisodes(String animeName, int episodes) {
        int pos = findbyName(animeName);
        if(pos != -1){
            this.animes.get(pos).setTotalEpisodes(episodes);
        }
        return true;
    }

    public boolean updateSource(String animeName, String newLink) {
        int pos = findbyName(animeName);
        if(pos != -1){
            this.animes.get(pos).setSourceLink(newLink);
        }
        return true;
    }

    public boolean updateRating(String animeName, float rating) {
    int pos = findbyName(animeName);
    if(pos != -1){
        this.animes.get(pos).setOverallRating(rating);
    }
    return true;
    }

    public boolean updateReleaseDate(String animeName, String date) {
        int pos = findbyName(animeName);
        if(pos != -1){
            this.animes.get(pos).setReleaseDate(date);
        }
        return true;
    }
}
