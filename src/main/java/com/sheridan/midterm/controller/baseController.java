package com.sheridan.midterm.controller;
import com.sheridan.midterm.beans.Spending;
import com.sheridan.midterm.database.DatabaseAccess;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class baseController {

    @Autowired
    private DatabaseAccess dataObject;

    @RequestMapping("/")
    private String homePage(Model model, Spending spending){
        model.addAttribute("spending",new Spending());
        return"index.html";
    }

    @RequestMapping("/handelHomePage")
    private String success(@ModelAttribute Spending spending){
        System.out.println(spending);
        dataObject.addDataToDatabase(spending);
        return "success.html";
    }

    @RequestMapping("/showAll")
    private String showAll(Model model){
        model.addAttribute("allData",dataObject.getAllDatabase());
        return "results.html";
    }
}
