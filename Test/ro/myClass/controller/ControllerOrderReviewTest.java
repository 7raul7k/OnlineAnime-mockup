package ro.myClass.controller;

import org.testng.annotations.Test;
import ro.myClass.models.OrderReview;
import ro.myClass.models.Review;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ControllerOrderReviewTest {
    @Test
    public void sizeTest(){
      ControllerOrderReview controllerOrderReview = new ControllerOrderReview();
      int size = controllerOrderReview.size();
      assertEquals(size,controllerOrderReview.size());
    }
    @Test
    public void addTest(){
        ControllerOrderReview controllerOrderReview =  new ControllerOrderReview();
        int size = controllerOrderReview.size();
        OrderReview orderReview = new OrderReview(192,100,102,1,9);
        boolean flag = controllerOrderReview.addOrderReview(orderReview);
        assertEquals(true,flag);
    }
    @Test
    public void removeTest(){
        ControllerOrderReview controllerOrderReview = new ControllerOrderReview();
        int size = controllerOrderReview.size();
        boolean flag = controllerOrderReview.removeOrderReview(3,102);
        assertEquals(true,flag);
    }
    @Test
    public void saveTest(){
        ControllerOrderReview controllerOrderReview = new ControllerOrderReview();
        OrderReview orderReview = new OrderReview(231,1,102,319,10);
        boolean flag = controllerOrderReview.addOrderReview(orderReview);
        assertEquals(true,flag);
        controllerOrderReview.save();
        controllerOrderReview.load();
    }
    @Test
    public void showTest(){
        ControllerOrderReview controllerOrderReview = new ControllerOrderReview();
        String text = controllerOrderReview.describeAnimebyUserID(100);
        assertEquals(text,controllerOrderReview.describeAnimebyUserID(100));
    }
    @Test
    public void describeTest(){
        ControllerOrderReview controllerOrderReview = new ControllerOrderReview();
        String text = controllerOrderReview.describe();
        assertEquals(text,controllerOrderReview.describe());
    }
    @Test
    public void generateID(){
        ControllerOrderReview controllerReview = new ControllerOrderReview();
        OrderReview orderReview = new OrderReview(controllerReview.generateId(),999,999,999,10);
        assertEquals(orderReview.getId()-200,controllerReview.size());
    }
    @Test
    public void returnOrderByUserID(){
        ControllerOrderReview controllerOrderReview = new ControllerOrderReview();
        OrderReview orderReview = controllerOrderReview.returnOrderbyUserId(1,100);
        assertEquals(orderReview,controllerOrderReview.returnOrderbyUserId(1,100));
    }
}
