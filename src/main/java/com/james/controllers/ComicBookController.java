package com.james.controllers;

import com.james.services.ComicBookRepository;
import com.james.services.LikeRepository;
import com.james.services.UserRepository;
import org.h2.tools.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.PostConstruct;
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


}
