/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstoreapp;

/**
 * This interface set and get author/artist and volume for Books and MusicCD_DVDs
 * @author ddang
 */
public interface SetAuthorVolume {

    /**
     * This abstract method is to set author to a book OR set an artist to an music album
     * @param author - String
     */
    public void setAuthor(String author);

    /**
     * This abstract method is to get a book author or a music album artist
     * @return a String
     */
    public String getAuthor();

    /**
     * This abstract method is to set volume to a book OR set an volume to an music album
     * @param volume
     */
    public void setVolume(String volume);

    /**
     * This abstract method is to get a book volume or a music album volume
     * @return a String
     */
    public String getVolume();
}
