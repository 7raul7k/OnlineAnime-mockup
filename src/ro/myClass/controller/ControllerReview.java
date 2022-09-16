package ro.myClass.controller;

import ro.myClass.models.Review;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ControllerReview {
    ArrayList<Review> reviews;
    public ControllerReview(){
        this.reviews = new ArrayList<>();
        this.load();
    }
    public void load() {
        try {
            File file = new File("C:\\mycode\\JavaBasics\\Mostenirea\\OnlineAnime\\src\\ro\\myClass\\resources\\review.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                this.reviews.add(new Review(scanner.nextLine()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        public String show(){
            String text = "";
            for (Review m : reviews){
                text +=  m;
            }
            return text;
        }
        public int findbyAnimeandUserID(int animeId,int userId) {
            for (int i = 0 ; i < reviews.size();i++) {
                if(reviews.get(i).getAnimeID() == animeId && reviews.get(i).getUsernameID() == userId){
                    return i;
                }
            }
            return -1;
        }
        public boolean addReview(Review review){
        int pos = findbyAnimeandUserID(review.getAnimeID(),review.getUsernameID());
        if(pos == -1){
            this.reviews.add(review);
        }
        return true;
        }
        public boolean removeReview(int animeId,int userId){
        int pos = findbyAnimeandUserID(animeId,userId);
        if(pos != -1){
            this.reviews.remove(pos);
        }
        return true;
        }
        public String toString(){
        String text = "";
        for (int i = 0 ; i < reviews.size();i++){
            text += reviews.get(i).toSave() + "\n";
        }
        return text;
        }
        public void save() {
            try {
                File file = new File("C:\\mycode\\JavaBasics\\Mostenirea\\OnlineAnime\\src\\ro\\myClass\\resources\\review.txt");
                FileWriter fileWriter = new FileWriter(file);
                PrintWriter printWriter = new PrintWriter(fileWriter);
                printWriter.print(this);
                printWriter.flush();
                printWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        public int size(){
            return reviews.size();
            }
            public int generateID(){
            if(this.reviews.size()>0){
                return reviews.get(this.reviews.size()-1).getId()+1;
            }
            return 1;
            }
            public int returnReviewIDbyUserandAnime(int animeId,int usernameId){
             for (Review m : reviews){
                 if(m.getAnimeID() == animeId && m.getUsernameID() == usernameId){
                     return m.getId();
                 }
             }
             return -1;
            }

            public int[] mostvoted(){
        int[] array = new int[1000];
        for(int i = 0 ; i < reviews.size();i++){
                  array[reviews.get(i).getAnimeID()]++;
              }
        return array;
            }
    public int mostvotedAnime() {
        int[] array = mostvoted();
        int anime = 0,max = 0;
        for(int i = 0 ; i < array.length;i++){
            if(array[i]>max){
                anime = i;
                max = array[i];
            }
        }
        return anime;
    }

}
