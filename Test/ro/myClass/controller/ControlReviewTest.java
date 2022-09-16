package ro.myClass.controller;

import org.testng.annotations.Test;
import ro.myClass.models.Review;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ControlReviewTest {
    @Test
    public void size(){
        ControllerReview controllerReview = new ControllerReview();
        int size = controllerReview.size();
        assertEquals(size,controllerReview.size());
    }
    @Test
    public void addTest(){
        ControllerReview controllerReview = new ControllerReview();
        Review review = new Review(29,321,100,"19 october");
        boolean flag = controllerReview.addReview(review);
        assertEquals(true,flag);
    }
    @Test
    public void removeTest(){
        ControllerReview controllerReview = new ControllerReview();
        boolean flag = controllerReview.removeReview(21,100);
        assertEquals(true,flag);
    }
    @Test
    public void showTest(){
        ControllerReview controllerReview = new ControllerReview();
        String text = controllerReview.show();
        assertEquals(text,controllerReview.show());
    }
    @Test
    public void saveTest(){
        ControllerReview controllerReview = new ControllerReview();
        int size = controllerReview.size();
        Review review = new Review(320,23,132,"12 december");
        boolean flag = controllerReview.addReview(review);
        controllerReview.save();
        controllerReview.load();
        assertEquals(true,flag);
    }
    @Test
    public void generateId(){
        ControllerReview controllerReview = new ControllerReview();
        Review review = new Review(controllerReview.generateID(),999,999,"someday");
        assertEquals(review.getId()-1,controllerReview.size());
    }
    @Test
    public void returnIDandUserandAnime(){
        ControllerReview controllerReview = new ControllerReview();
        int id = controllerReview.returnReviewIDbyUserandAnime(1,100);
        assertEquals(id,controllerReview.returnReviewIDbyUserandAnime(1,100));
        assertEquals(-1,controllerReview.returnReviewIDbyUserandAnime(230,999));
    }
    @Test
    public void mostVotedAnime(){
        ControllerReview controllerReview = new ControllerReview();
        int anime = controllerReview.mostvotedAnime();
        assertEquals(anime,1);
    }
}
