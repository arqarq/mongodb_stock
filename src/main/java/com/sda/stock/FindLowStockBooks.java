package com.sda.stock;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.function.Consumer;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.lt;

public class FindLowStockBooks {

    public static void main(String[] args) {

        try(MongoClient client = Utils.connect()) {
            MongoDatabase db = client.getDatabase("products");
            MongoCollection<Document> products = db.getCollection("products");
            products.find(and(lt("stockCount", 10), eq("type", "book")))
                    .forEach((Consumer<? super Document>)Utils::displayDoc);
        }
    }
}
