package ru.netology.manager.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.MoviePoster;

public class FilmsManagerTest {
//    MoviePoster film1 = new MoviePoster("Bloodshot");
//    MoviePoster film2 = new MoviePoster("Onward");
//    MoviePoster film3 = new MoviePoster("Otel' Belgrad");
//    MoviePoster film4 = new MoviePoster("The Gentlemen");
//    MoviePoster film5 = new MoviePoster("The Invisible man");
//    MoviePoster film6 = new MoviePoster("Trolls world tour");
//    MoviePoster film7 = new MoviePoster("Number one");
//    MoviePoster film8 = new MoviePoster(8, "The Matrix");
//    MoviePoster film9 = new MoviePoster(9, "It");
//    MoviePoster film10 = new MoviePoster(10, "Home alone");

    @Test
    public void test() {
        MoviePoster repo = new MoviePoster();

        repo.save("film1");
        repo.save("film2");
        repo.save("film3");
        repo.save("film4");
        repo.save("film5");
        repo.save("film6");
        repo.save("film7");
        repo.save("film8");
        repo.save("film9");
        repo.save("film10");

        String[] expected = {"film1", "film2", "film3", "film4", "film5", "film6", "film7", "film8", "film9", "film10"};
        String[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void overLimit() {
        MoviePoster repo = new MoviePoster(10);

        repo.save("film1");
        repo.save("film2");
        repo.save("film3");
        repo.save("film4");
        repo.save("film5");
        repo.save("film6");
        repo.save("film7");
        repo.save("film8");
        repo.save("film9");
        repo.save("film10");
        repo.save("film11");

        String[] expected = {"film11", "film10", "film9", "film8", "film7", "film6", "film5", "film4", "film3", "film2"};
        String[] actual = repo.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void underLimit() {
        MoviePoster repo = new MoviePoster(8);

        repo.save("film1");
        repo.save("film2");
        repo.save("film3");
        repo.save("film4");
        repo.save("film5");
        repo.save("film6");


        String[] expected = {"film6", "film5", "film4", "film3", "film2", "film1"};
        String[] actual = repo.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void equalLimit() {
        MoviePoster repo = new MoviePoster(6);

        repo.save("film1");
        repo.save("film2");
        repo.save("film3");
        repo.save("film4");
        repo.save("film5");
        repo.save("film6");


        String[] expected = {"film6", "film5", "film4", "film3", "film2", "film1"};
        String[] actual = repo.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

}
