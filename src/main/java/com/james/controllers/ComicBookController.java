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
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;


/**
 * Created by jamesyburr on 7/10/16.
 */
@RestController
public class ComicBookController {
    public static String IMG_DIR = "images";

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

    @RequestMapping(path = "/comics", method = RequestMethod.POST)
    public void newComic(HttpSession session, MultipartFile img, String comicName, String comment, HttpServletResponse response) throws Exception {
        String username = (String) session.getAttribute("username");

        if (username == null) {
            throw new Exception("You must be logged in");
        }
        User existingUser = users.findByName(username);
        if (existingUser == null) {
            throw new Exception("User does not exist");
        }

        File dir = new File("public/" + IMG_DIR);
        dir.mkdirs();

        File imgfile = File.createTempFile("image", img.getOriginalFilename(), dir);
        FileOutputStream fos = new FileOutputStream(imgfile);
        fos.write(img.getBytes());

        ComicBook comic = new ComicBook(imgfile.getName(), comicName, comment, existingUser);
        comics.save(comic);

        response.sendRedirect("/#/home");
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
