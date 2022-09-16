package ro.myClass.view;

import ro.myClass.controller.ControllerAnime;
import ro.myClass.controller.ControllerOrderReview;
import ro.myClass.controller.ControllerReview;
import ro.myClass.controller.ControllerUser;
import ro.myClass.models.*;

import java.util.Scanner;

public class ViewCustomer {
    private ControllerOrderReview controllerOrderReview;
    private ControllerReview controllerReview;
    private ControllerUser controllerUser;
    private ControllerAnime controllerAnime;
    Scanner scanner;
    private Customer customer;

    public ViewCustomer(User user) {
        this.controllerAnime = new ControllerAnime();
        this.controllerReview = new ControllerReview();
        this.controllerUser = new ControllerUser();
        this.controllerOrderReview = new ControllerOrderReview();
        this.customer = (Customer) user;
        this.scanner = new Scanner(System.in);
    }

    public void show() {
        System.out.println("Press 1 to show animes");
        System.out.println("Press 2 to see your reviews");
        System.out.println("Press 3 to add review");
        System.out.println("Press 4 to remove your review");
        System.out.println("Press 5 to show most voted anime ");
        System.out.println("Press 7 to update review");
    }

    public void play() {
        boolean running = true;
        while (true) {
            show();
            System.out.println("Input choice: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println(controllerAnime.describeAnime());
                    break;
                case 2:
                    System.out.println(controllerOrderReview.describeAnimebyUserID(customer.getId()));
                    break;
                case 3:
                    addReview();
                    break;
                case 4:
                    removeReview();
                    break;
                case 5:
                    mostVotedAnime();
                    break;
            }
        }
    }

    public void addReview() {
        System.out.println("Input anime name");
        String animeName = scanner.nextLine();
        if (controllerAnime.findbyName(animeName) == -1) {
            System.out.println("Anime doesnt exist");
        } else {
            Anime anime = controllerAnime.returnAnimebyName(animeName);
            System.out.println("Input date:");
            String date = scanner.nextLine();
            System.out.println("Input rating 1-10 : ");
            float rating = Float.parseFloat(scanner.nextLine());
            Review review = new Review(controllerReview.generateID(), anime.getId(), customer.getId(), date);
            OrderReview orderReview = new OrderReview(controllerOrderReview.generateId(), anime.getId(), review.getId(), customer.getId(), rating);
            controllerReview.addReview(review);
            controllerOrderReview.addOrderReview(orderReview);
        }
    }



    public void removeReview() {
        System.out.println("Input anime name: ");
        String text = scanner.nextLine();
        if (controllerAnime.findbyName(text) == -1) {
            System.out.println("Anime doesnt exist");
        } else {
            Anime anime = controllerAnime.returnAnimebyName(text);
            int review = controllerReview.returnReviewIDbyUserandAnime(anime.getId(), customer.getId());
            controllerReview.removeReview(anime.getId(), customer.getId());
            controllerOrderReview.removeOrderReview(anime.getId(), review);
        }
    }
    public void mostVotedAnime(){
        int animeID = controllerReview.mostvotedAnime();
        Anime anime = controllerAnime.returnAnimebyID(animeID);
        System.out.println(anime.describe());
    }
    public void updateReview(){
        System.out.println("Input a anime name you want to update");
        String text = scanner.nextLine();
        Anime anime = controllerAnime.returnAnimebyName(text);
        System.out.println("Input rating");
        int rating= Integer.parseInt(scanner.nextLine());
        OrderReview orderReview = controllerOrderReview.returnOrderbyUserId(anime.getId(),customer.getId());
        if(orderReview != null){
            orderReview.setRating(rating);
        }else {
            System.out.println("Review doesnt exist");
        }
    }
}
