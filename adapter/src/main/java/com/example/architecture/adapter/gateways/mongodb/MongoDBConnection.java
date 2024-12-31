package com.example.architecture.adapter.gateways.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public abstract class MongoDBConnection {
    protected final MongoDatabase database;

    public MongoDBConnection(String host, int port) {
        MongoClient client = new MongoClient(host, port);
        database = client.getDatabase("products");
    }

}
