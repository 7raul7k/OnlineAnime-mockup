package ro.myClass.controller;

import ro.myClass.models.Administrator;
import ro.myClass.models.Customer;
import ro.myClass.models.User;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ControllerUser {
    ArrayList<User> users;
    public ControllerUser(){
        this.users = new ArrayList<>();
        this.load();
    }
    public void load(){
        try {
            File file = new File("C:\\mycode\\JavaBasics\\Mostenirea\\OnlineAnime\\src\\ro\\myClass\\resources\\user.txt");
            FileInputStream fis = new FileInputStream(file);
            Scanner scanner = new Scanner(fis);
            while (scanner.hasNextLine()){
                String text = scanner.nextLine();
                switch (text.split(",")[0]){
                    case "customer": this.users.add(new Customer(text));
                    break;
                    case "administrator": this.users.add(new Administrator(text));
                    break;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public String showUser(){
        String text ="";
        for (User m : users) {
            text += m.show();
        }
        return text;
    }
    public int findbyEmail(String email){
        for (int i = 0 ; i < users.size() ;i++){
            if(users.get(i).getEmail().equals(email)){
                return i;
            }
        }
        return -1;
    }
    public boolean addUser(User user){
        int pos = findbyEmail(user.getEmail());
        if(pos == -1){
            this.users.add(user);
        }
        return true;
    }
    public boolean removeUser(String email){
        int pos = findbyEmail(email);
        if(pos != -1){
            users.remove(pos);

        }
        return true;
    }
    public String toString(){
        String text = "";
        for(int i = 0 ; i < users.size();i++){
            text += users.get(i).toSave() + "\n";
        }
        return text;
    }
    public void save(){
        try{
            File file = new File("C:\\mycode\\JavaBasics\\Mostenirea\\OnlineAnime\\src\\ro\\myClass\\resources\\user.txt");
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
        return users.size();
    }
    public int generateId(){
        if(this.users.size()>0){
            return users.get(this.users.size()-1).getId()+1;
        }
        return 1;
    }

    public User userLogin(String email, String password) {
        for (User m : users){
            if(m.getEmail().equals(email) && m.getPassword().equals(password)){
                return m;
            }
        }
        return null;
    }

    public boolean verifyEmail(String email) {
        for (User m : users){
            if(m.getEmail().equals(email)){
                return true;
            }
        }
        return false;
    }
}
