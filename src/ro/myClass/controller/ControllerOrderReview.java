package ro.myClass.controller;

import ro.myClass.models.OrderReview;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ControllerOrderReview {
    ArrayList<OrderReview> orderReviews;
    public ControllerOrderReview(){
        this.orderReviews = new ArrayList<>();
        this.load();
    }
    public void load() {
        try {
            File file = new File("C:\\mycode\\JavaBasics\\Mostenirea\\OnlineAnime\\src\\ro\\myClass\\resources\\ordereview.txt");
            FileInputStream fis = new FileInputStream(file);
            Scanner scanner = new Scanner(fis);
            while (scanner.hasNextLine()) {
                this.orderReviews.add(new OrderReview(scanner.nextLine()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
       public String describeAnimebyUserID(int userId){
            String text = "";
            for (OrderReview m: orderReviews) {
                if (m.getUsernameID() == userId) {
                    text += m.describe();
                }
            }
            return text;

        }
        public int findbyAnimeandReviewID(int animeID,int reviewID){
        for(int i = 0 ; i < orderReviews.size();i++){
            if(orderReviews.get(i).getAnimeId() == animeID && orderReviews.get(i).getReviewId() == reviewID){
                return i;
            }
        }
        return -1;
        }
        public boolean addOrderReview(OrderReview orderReview){
        int pos = findbyAnimeandReviewID(orderReview.getAnimeId(),orderReview.getReviewId());
        if(pos == -1){
            this.orderReviews.add(orderReview);
        }
        return true;
        }
        public boolean removeOrderReview(int animeID,int reviewID){
        int pos = findbyAnimeandReviewID(animeID,reviewID);
        if(pos != -1){
            this.orderReviews.remove(pos);
        }
        return true;
        }
        public String toString(){
         String text ="";
         for(int i = 0 ; i < orderReviews.size();i++){
             text += orderReviews.get(i).toSave() +"\n";

         }
         return text;
        }
        public void save() {
            try {
                File file = new File("C:\\mycode\\JavaBasics\\Mostenirea\\OnlineAnime\\src\\ro\\myClass\\resources\\ordereview.txt");
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
            return orderReviews.size();
            }
            public int generateId(){
        if(this.orderReviews.size()>0){
            return orderReviews.get(this.orderReviews.size()-1).getId()+1;
        }
        return 1;
            }

    public OrderReview returnOrderbyUserId(int animeId, int usernameId) {
        for(OrderReview m : orderReviews){
            if(m.getAnimeId() == animeId && m.getUsernameID() == usernameId){
                return m;
            }
        }
        return null;
    }

    public String describe() {
        String text = "";
        for (OrderReview m : orderReviews){
            text += m;
        }
        return text;
    }
}
