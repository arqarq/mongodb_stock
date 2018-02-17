package com.sda.stock;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import org.bson.Document;


import java.util.List;
import java.util.function.Consumer;

public class FindWithProjection {

    public static void main(String[] args) {

        try(MongoClient client = new MongoClient("localhost", 27017)) {
            MongoDatabase db = client.getDatabase("products");
            MongoCollection<Document> products = db.getCollection("products");
            products.find(Filters.eq("type", "movie"))
                    .projection(Projections.include("title", "details.starring"))
                    .forEach((Consumer<? super Document>) FindWithProjection::displayMovie);
        }
    }

    public static void displayMovie(Document doc) {
        System.out.println("---");
        System.out.println("Title: " + doc.getString("title"));
        System.out.println("Starring: ");
        List<String> actors = (List<String>) ((Document) doc.get("details")).get("starring");
        actors.stream().forEach(actor -> System.out.println("- " + actor));
    }
}
