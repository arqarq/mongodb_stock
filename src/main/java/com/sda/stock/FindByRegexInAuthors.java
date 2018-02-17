package com.sda.stock;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;


import java.util.function.Consumer;

public class FindByRegexInAuthors {

    public static void main(String[] args) {

        try(MongoClient client = Utils.connect()) {
            MongoDatabase db = client.getDatabase("products");
            MongoCollection<Document> products = db.getCollection("products");
            products.find(Filters.regex("authors","James"))
                    .forEach((Consumer<? super Document>) Utils::displayDoc);
        }
    }
}
