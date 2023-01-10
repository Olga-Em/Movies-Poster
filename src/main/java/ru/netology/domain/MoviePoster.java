package ru.netology.domain;

public class MoviePoster {
    private String[] films = new String[0];
    private int limit;

    public MoviePoster() {
        this.limit = 10;
    }

    public MoviePoster(int limit) {
        this.limit = limit;
    }

    public void save(String film) {
        String[] tmp = new String[films.length + 1];

        for (int i = 0; i < films.length; i++) {
            tmp[i] = films[i];
        }

        tmp[tmp.length - 1] = film;
        films = tmp;
    }

    public String[] findAll() {
        return films;
    }

    public String[] findLast() {
        int resultLength;
        if (films.length < limit) {
            resultLength = films.length;
        } else {
            resultLength = limit;
        }

        String[] tmp = new String[resultLength];

        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = films[films.length - 1 - i];
        }
        return tmp;
    }
}