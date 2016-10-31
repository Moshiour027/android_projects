package org.example.top10downloader;

import java.util.List;

public class Application {

    private String name;
    private String artist;
    private String releaseDate;
    private List<String> images;

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }


//    public String toString() {
//
//        return "Name: " + this.name + "\n" +
//                "Artist: " + this.artist + "\n" +
//                "Release Date: " + this.releaseDate + "\n";
//    }

    public String toString() {
        return "Name: " + this.name + "\n" +
                "Artist: " + this.artist + "\n" +
                "Release Date: " + this.releaseDate + "\n" +
                "Images: " + this.getImages().get(0) + "\n";
    }
}
