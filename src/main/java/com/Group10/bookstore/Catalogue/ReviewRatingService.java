package com.Group10.bookstore.Catalogue;

import com.Group10.bookstore.Book;
import com.Group10.bookstore.BookReview;
import com.Group10.bookstore.BookReviewKey;
import org.apache.tomcat.jni.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.util.calendar.BaseCalendar;
import sun.util.calendar.LocalGregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.util.*;

import static org.springframework.boot.system.SystemProperties.get;

@Service
public class ReviewRatingService {

    @Autowired
    private ReviewRatingRepository reviewRepository;

    private ZonedDateTime timeStamp = ZonedDateTime.now();

    /*
    private List<BookReview> reviewArchive = new ArrayList<>(Arrays.asList(
            new BookReview("1", "Greatest book ever!!!", 5, "User1", new Date()),
            new BookReview("1", "Enlightening", 5, "User2", new Date(2021, 9, 23)),
            new BookReview("1", "Mesmerizing story", 5, "User8", new Date(2021, 9, 12)),
            new BookReview("3", "Trash...", 1, "User1", new Date(2021, 9, 26)),
            new BookReview("2", "MEDIOCORE!!", 3, "User1", new Date(2021, 9, 22)),
            new BookReview("3", "Good fire kindling", 2, "User5", new Date(2021, 1, 26))
    ));
 */


    public List<BookReview> getReviewArchive(){
        //return reviewArchive; //Old function.
        List<BookReview> reviewArchive = new ArrayList<>();
        //FindAll creates an Iterator object from the Collection Interface. Collection Interface is extended by the ArrayList Class. Which has custom Arraylist definitions of the Collection Interface.
        //Which includes the findAll method for iterator objects, this Arraylist Iterator method returns each element in a list. Foreach is a method for iterator objects when applied to a list creates
        reviewRepository.findAll().forEach(reviewArchive::add);
        return reviewArchive;
    }


    //Allows search per ISBN only
    public List<BookReview> reviewISBNList(String reviewISBN){

        List<BookReview> reviewArchive = new ArrayList<>();
        return reviewRepository.findAllByreviewISBN(reviewISBN);
        //reviewRepository.findAllByreviewISBN(reviewISBN).forEach(reviewArchive::add);
        //return reviewArchive;
    }


    public List<BookReview> searchReviewISBN(String reviewISBN){
        List<BookReview> reviewArchive = reviewISBNList(reviewISBN);

        double avgReview = 0;

        for(int i = 0; i < reviewArchive.size(); i++)
            avgReview += reviewArchive.get(i).getBookRating();

        avgReview /= reviewArchive.size();

        for(int i = 0; i < reviewArchive.size(); i++)
            reviewArchive.get(i).setAvgBookRating(avgReview);

        return reviewArchive;

    }


    public List<BookReview> searchReviewUser(String reviewer){

        List<BookReview> reviewArchive = new ArrayList<>();
        return reviewRepository.findAllByreviewer(reviewer);
        //reviewRepository.findAllByreviewISBN(reviewISBN).forEach(reviewArchive::add);
        //return reviewArchive;
    }

    public List<BookReview> searchReviewISBNUser(String reviewISBN, String reviewer) {
        List<BookReview> reviewArchive = new ArrayList<>();
        return reviewRepository.findByISBNUser(reviewISBN, reviewer);
    }

    public void addReview(String reviewISBN, BookReview newReview) {

         //newReview.setReviewISBN(reviewISBN);
         //reviewArchive.add(newReview);
        newReview.setRatingTimeStamp(timeStamp);
        newReview.setReviewTimeStamp(timeStamp);
        reviewRepository.save(newReview);

    }

    public void updateReview(String reviewISBN, BookReview newReview) {
        //save function in crud repository is capable of updating existing records based off primary keys when it parses the request body/json and runs it through query.
        reviewRepository.save(newReview);
        /*for(int i = 0; i < reviewArchive.size(); i++)
        {
            BookReview rev = reviewArchive.get(i);
            if(rev.getReviewISBN().equals(reviewISBN) && rev.getReviewer().equalsIgnoreCase(newReview.getReviewer()))
            {
                reviewArchive.set(i, newReview);
                return;
            }
        }*/
    }

    public void deleteReview(String reviewISBN, BookReview newReview) {
       reviewRepository.delete(newReview);
        /*for(int i = 0; i < reviewArchive.size(); i++)
        {
            BookReview rev = reviewArchive.get(i);
            if(rev.getReviewISBN().equals(reviewISBN) && rev.getReviewer().equalsIgnoreCase(newReview.getReviewer()))
            {
                reviewArchive.remove(i);
                return;
            }
        }*/
    }


}
