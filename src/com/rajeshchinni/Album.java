package com.rajeshchinni;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {


    private String bandName;
    private String artist;
    private ArrayList<Song> songs;


    // constructor
    public Album(String bandName, String artist) {
        this.bandName = bandName;
        this.artist = artist;
        this.songs = new ArrayList<Song>(); // manually done
    }

    // method
    public boolean addSong (String title, double duration){
        if (findSong(title) == null){
            this.songs.add(new Song(title, duration));
            return true;
        }
        return false;
    }

    // method
    private Song findSong(String title){
        for ( Song checkedSong: this.songs){
            if (checkedSong.getTitle().equals(title)){
                return checkedSong;
            }
        }
        return null;
    }

    public boolean addToPlaylist(int trackNumber, List<Song> playList){  // LinkedList is changed to List
        int index = trackNumber -1;
        if ((index >= 0) && (index <= this.songs.size())){
            playList.add(this.songs.get(index));
            return true;
        }
        System.out.println("This album does not have a track " + trackNumber);
        return false;
    }

    public boolean addToPlaylist(String title, List<Song> playList){   // LinkedList is changed to List
        Song checkedSong = findSong(title);
        if (checkedSong != null){
            playList.add(checkedSong);
            return true;
        }
        System.out.println("The song " + title + " is not in this album");
        return false;
    }
}

