package com.james.controllers;

import com.james.entities.ComicBook;
import com.james.entities.User;
import com.james.services.ComicBookRepository;
import com.james.services.LikeRepository;
import com.james.services.UserRepository;
import com.james.utils.PasswordStorage;
import org.h2.tools.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;


/**
 * Created by jamesyburr on 7/10/16.
 */
@RestController
public class ComicBookController {


    @Autowired
    UserRepository users;

    @Autowired
    ComicBookRepository comics;

    @Autowired
    LikeRepository likes;

    @PostConstruct
    public void init() throws SQLException {
        Server.createWebServer().start();
    }

    @RequestMapping(path = "/comics", method = RequestMethod.GET)
    public Iterable<ComicBook> allComics() {
        return comics.findAll();
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public void newUser(HttpSession session, @RequestBody User user) throws Exception {
        User userInDb = users.findByName(user.getName());
        if (userInDb == null) {
            user.setPassword(PasswordStorage.createHash(user.getPassword()));
            users.save(user);
        }
        else if (!PasswordStorage.verifyPassword(user.getPassword(), userInDb.getPassword())) {
            throw new Exception("Incorrect password!");
        }

        session.setAttribute("username", user.getName());
    }


}
