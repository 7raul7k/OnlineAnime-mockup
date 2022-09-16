package ro.myClass.view;

import ro.myClass.controller.ControllerAnime;
import ro.myClass.controller.ControllerOrderReview;
import ro.myClass.controller.ControllerReview;
import ro.myClass.controller.ControllerUser;
import ro.myClass.models.Administrator;
import ro.myClass.models.Anime;
import ro.myClass.models.User;

import java.util.Scanner;

public class ViewAdministrator {
    ControllerAnime controllerAnime ;
    ControllerReview controllerReview;
    ControllerOrderReview controllerOrderReview;
    ControllerUser controllerUser;
    Administrator administrator;
    Scanner scanner;
    public ViewAdministrator(User user){
        this.controllerAnime = new ControllerAnime();
        this.controllerReview = new ControllerReview();
        this.controllerOrderReview = new ControllerOrderReview();
        this.controllerUser = new ControllerUser();
        this.administrator = (Administrator) user;
        this.scanner = new Scanner(System.in);
    }
    public void show(){
        System.out.println("Press 1 to show all animes");
        System.out.println("Press 2 to add anime");
        System.out.println("Press 3 to remove anime");
        System.out.println("Press 4 to see orders reviews");
        System.out.println("Press 5 to see customers");
        System.out.println("Press 6 to update anime");
    }
    public void play(){
        boolean running = true;
        while (running){
            show();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1: System.out.println(controllerAnime.describeAnime());
                    break;
                case 2: addAnime();
                break;
                case 3: removeAnime();
                break;
                case 4: System.out.println(controllerOrderReview.describe());
                    break;
                case 5: System.out.println(controllerUser.showUser());
                break;
                case 6: updateAnime();
                break;
                default:
            }
        }
    }
    public void addAnime(){
        System.out.println("Input anime name:");
        String text = scanner.nextLine();
        System.out.println("Input number of episodes:");
        int episodes = Integer.parseInt(scanner.nextLine());
        System.out.println("Input source link:");
        String sourceLink = scanner.nextLine();
        System.out.println("Input overall rating");
        float rating = Float.parseFloat(scanner.nextLine());
        System.out.println("Input release date");
        String date = scanner.nextLine();
        Anime anime = new Anime(controllerAnime.generateID(),text,episodes,sourceLink,rating,date);
        controllerAnime.addAnime(anime);
    }
    public void removeAnime(){
        System.out.println("Input anime name: ");
        String text = scanner.nextLine();
        controllerAnime.removeAnime(text);
    }
    public void updateAnime(){
        System.out.println("Input anime name: ");
        String animeName = scanner.nextLine();
        System.out.println("Input what do u want to update? totalEpisodes,sourceLink,overallRating,releaseDate ");
        String choice = scanner.nextLine();
        switch (choice){
            case "totalEpisodes":
                System.out.println("Input total episodes: ");
                int episodes = Integer.parseInt(scanner.nextLine());
                controllerAnime.updateTotalEpisodes(animeName,episodes);
            break;
            case "sourceLink":
                System.out.println("Input sourcelink");
                String newLink = scanner.nextLine();
                controllerAnime.updateSource(animeName,newLink);
                break;
            case "overallRating":
                System.out.println("Input overall rating: ");
                float rating = Float.parseFloat(scanner.nextLine());
                controllerAnime.updateRating(animeName,rating);
                break;
            case "releaseDate":
                System.out.println("Input release date");
                String date = scanner.nextLine();
                controllerAnime.updateReleaseDate(animeName,date);
                break;
            default:

        };
    }
}
