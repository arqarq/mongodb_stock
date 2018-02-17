package com.sda.stock;

import org.bson.Document;

import java.util.List;

public class Utils {

    public static void displayDoc(Document doc) {
        System.out.println("---");
        System.out.println("Title: " + doc.getString("title"));
        System.out.println("Authors: ");
        List<String> authors = (List<String>) doc.get("authors");
        authors.stream().forEach(author -> System.out.println("- " + author));
        System.out.println("Type: " + doc.getString("type"));
    }
}
