package com.sda.stock;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Indexes;
import org.bson.Document;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PrefillDB {

    public static void main(String[] args) throws IOException {
        try(MongoClient client = Utils.connect()) {
            MongoDatabase db = client.getDatabase("products");
            MongoCollection<Document> products = db.getCollection("products");
            products.createIndex(Indexes.compoundIndex(
                    Indexes.text("title"),
                    Indexes.text("authors"),
                    Indexes.text("details.starring")));
            try (BufferedReader br = new BufferedReader(new FileReader("./src/main/resources/data.json"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    products.insertOne(Document.parse(line));
                }
            }

        }
    }
}
