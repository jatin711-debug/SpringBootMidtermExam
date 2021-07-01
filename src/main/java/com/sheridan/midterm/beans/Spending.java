package com.sheridan.midterm.beans;
import java.io.Serializable;

import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
public class Spending implements Serializable {
    String name;
    String description;
    double amount;
    String category;
    String date;

}
