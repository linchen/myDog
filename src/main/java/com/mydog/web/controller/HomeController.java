package com.mydog.web.controller;


import com.mydog.web.domain.Basket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HomeController {

   @Autowired
   private Basket basket;

   private static final Logger LOG = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String getCurrentMenu() {
        LOG.debug("dog menu directly to ResponseBody");
        return "/home";
    }

    @ModelAttribute("basket")
    private Basket getBasket() {
        return basket;
    }
}
