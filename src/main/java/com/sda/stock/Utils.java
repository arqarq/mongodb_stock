package com.sda.stock;

import com.mongodb.MongoClient;
import org.bson.Document;

import java.util.List;

public class Utils {
    public static void displayDoc(Document doc) {
        System.out.println("---");
        System.out.println("Title: " + doc.getString("title"));
        System.out.println("Authors: ");
        List<String> authors = (List<String>) doc.get("authors");
        authors.forEach(author -> System.out.println("- " + author));
        System.out.println("Type: " + doc.getString("type"));
    }

    public static MongoClient connect() {
        return new MongoClient("localhost", 27017);
    }
}
