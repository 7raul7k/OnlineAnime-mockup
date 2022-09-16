package ro.myClass.controller;

import org.testng.annotations.Test;
import ro.myClass.models.Anime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ControllerAnimeTest {
    @Test
    public void size(){
        ControllerAnime controllerAnime = new ControllerAnime();
        int size = controllerAnime.size();
        assertEquals(size,controllerAnime.size());
    }
    @Test
    public void add(){
        ControllerAnime controllerAnime = new ControllerAnime();

        Anime anime = new Anime(24,"SAO 2",24,"www.myanimelist.com/sao-2",9,"10 july 2018");
        int size = controllerAnime.size();
        boolean flag = controllerAnime.addAnime(anime);
        assertEquals(true,flag);
        assertEquals(size,controllerAnime.size());
    }
    @Test
    public void remove(){
        ControllerAnime controllerAnime = new ControllerAnime();
        int size = controllerAnime.size();
        boolean flag = controllerAnime.removeAnime("Death Note");
        assertEquals(true,flag);
        assertEquals(size-1,controllerAnime.size()-1);
    }
    @Test
    public void save(){
        ControllerAnime controllerAnime = new ControllerAnime();
        int size = controllerAnime.size();
        Anime anime = new Anime(24,"SAO 2",24,"www.myanimelist.com/sao-2",9,"10 july 2018");
        boolean flag = controllerAnime.addAnime(anime);
        assertEquals(true,flag);
        controllerAnime.save();
        controllerAnime.load();

    }
    @Test
    public void describe(){
        ControllerAnime controllerAnime = new ControllerAnime();
        String text = controllerAnime.describeAnime();
        assertEquals(text,controllerAnime.describeAnime());
    }
    @Test
    public void returnAnimeByName(){
        ControllerAnime controllerAnime = new ControllerAnime();
        Anime anime = controllerAnime.returnAnimebyID(1);
        assertEquals(anime,controllerAnime.returnAnimebyName("Attack on Titan"));
        assertEquals(null,controllerAnime.returnAnimebyName("something"));
    }
    @Test
    public void generateID(){
        ControllerAnime controllerAnime = new ControllerAnime();
        Anime anime = new Anime(controllerAnime.generateID(),"Something",10,"something.com",10,"someday");
        assertEquals(anime.getId()-1,controllerAnime.animes.size());
    }
    @Test
    public void returnAnimeById(){
        ControllerAnime controllerAnime = new ControllerAnime();
        Anime anime = controllerAnime.returnAnimebyName("Attack on Titan");
        assertEquals(anime,controllerAnime.returnAnimebyID(1));
        assertEquals(null,controllerAnime.returnAnimebyID(999));
    }

    @Test
    public void updateTotalEpisodes(){
        ControllerAnime controllerAnime = new ControllerAnime();
        assertEquals(true,controllerAnime.updateTotalEpisodes("Death Note",10));
    }
    @Test
    public void updateSource(){
        ControllerAnime controllerAnime = new ControllerAnime();
        assertEquals(true,controllerAnime.updateSource("Death Note","something.com"));
    }
    @Test
    public void updateReleaseDate(){
        ControllerAnime controllerAnime = new ControllerAnime();
        assertEquals(true,controllerAnime.updateReleaseDate("Death note","10 december"));
    }
    @Test
    public void updateRating(){
        ControllerAnime controllerAnime = new ControllerAnime();
        assertEquals(true,controllerAnime.updateRating("Death Note",1));
    }
}
