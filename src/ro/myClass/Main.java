package ro.myClass;

import ro.myClass.controller.ControllerAnime;
import ro.myClass.controller.ControllerOrderReview;
import ro.myClass.view.ViewCustomer;
import ro.myClass.view.ViewLogin;
public class Main {
    public static void main(String[] args) {
        ViewLogin viewLogin = new ViewLogin();
        viewLogin.play();
    }
}