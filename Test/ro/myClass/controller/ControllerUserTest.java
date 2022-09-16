package ro.myClass.controller;

import org.testng.annotations.Test;
import ro.myClass.models.Administrator;
import ro.myClass.models.Customer;
import ro.myClass.models.User;

import static org.junit.Assert.*;
import static org.testng.AssertJUnit.assertEquals;

public class ControllerUserTest {
    @Test
    public void size(){
        ControllerUser controllerUser = new ControllerUser();
        Customer customer = new Customer(1,"Georgescu","Marian","georgescumarian@gmail.com","georgescumarian@gmail.com2022","Romania",true,5,"Attack on Titan","One Punch Man");
        int size = controllerUser.size();
        controllerUser.addUser(customer);
        assertEquals(size+1,controllerUser.size());
    }
    @Test
    public void addTest(){
        ControllerUser controllerUser = new ControllerUser();
        int size = controllerUser.size();
        Administrator admin = new Administrator(23,"Lazar","Nicolae","lazarnicolae@gmail.com","lazarnicolae@gmail.com2022","Romania",true,"Animekage","Editor");
        Customer customer = new Customer(31,"Ionescu","Razvan","ionescurazvan@gmail.com","ionescurazvan@gmail.com2022","Romania",true,10,"Sword Art Online","Boku no Hero Academia");
        controllerUser.addUser(admin);
        controllerUser.addUser(customer);
        assertEquals(size+2,controllerUser.size());
    }
    @Test
    public void removeTest(){
        ControllerUser controllerUser = new ControllerUser();
        int size = controllerUser.size();
        assertEquals(true,controllerUser.removeUser("popaalex@gmail.com"));
        assertEquals(size-1 ,controllerUser.size());

    }
    @Test
    public void save(){
        ControllerUser controllerUser = new ControllerUser();
        int size = controllerUser.size();
        Customer customer = new Customer(231,"Pavel","Alexandru","pavelalexandru@gmail.com","pavelalexandru21@gmail.com20222","Iasi",true,100,"Attack on titan","One piece");
        controllerUser.addUser(customer);
        controllerUser.save();
        controllerUser.load();
        boolean pos = controllerUser.addUser(customer);
        assertEquals(true,pos);
    }

    @Test
    public void showUser(){
        ControllerUser controllerUser = new ControllerUser();
        String text = controllerUser.showUser();
        assertEquals(text,controllerUser.showUser());
    }
    @Test
    public void generateID(){
        ControllerUser controllerUser = new ControllerUser();
        User user = new User("customer",controllerUser.generateId(),"something","something","something","something","somewhere",true);
        assertEquals(user.getId()-1,controllerUser.size()+99);
    }
    @Test
    public void userLogin(){
        ControllerUser controllerUser = new ControllerUser();
        User user = controllerUser.userLogin("popaalex@gmail.com","popaalex@gmail.com2022");
        assertEquals(user,controllerUser.userLogin("popaalex@gmail.com","popaalex@gmail.com2022"));
    }
    @Test
    public void verifyEmail(){
        ControllerUser controllerUser = new ControllerUser();
        assertEquals(true,controllerUser.verifyEmail("popaalex@gmail.com"));
        assertEquals(false,controllerUser.verifyEmail("something@gmail.com"));

    }

}