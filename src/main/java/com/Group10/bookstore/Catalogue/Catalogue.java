package com.Group10.bookstore.Catalogue;

import com.Group10.bookstore.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class Catalogue {

    @Autowired
    private CatalogueService catalogueService;

    @RequestMapping("/catalogue")
    public List<Book> defaultCatalogueView(){
        return catalogueService.getDefaultCatalogue();
    }
    /*
    @RequestMapping("/catalogue/{userSearchGenre}")
    public Book searchGenre(@PathVariable String userSearchGenre){
        return catalogueService.searchGenre(userSearchGenre);
    }*/

}
