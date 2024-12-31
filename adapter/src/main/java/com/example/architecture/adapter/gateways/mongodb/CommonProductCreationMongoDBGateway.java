package com.example.architecture.adapter.gateways.mongodb;

import com.example.architecture.application.usecase.product.create.boundaries.output.register.ICommonProductRegisterGateway;
import com.example.architecture.domain.entity.product.IProduct;
import com.mongodb.client.MongoCollection;

import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;

public class CommonProductCreationMongoDBGateway extends MongoDBConnection implements ICommonProductRegisterGateway {

    private static final String COMMON_PRODUCT_TABLE = "common_products";
    private final MongoCollection<Document> collection;

    public CommonProductCreationMongoDBGateway(String host, int port) {
        super(host, port);
        collection = database.getCollection(COMMON_PRODUCT_TABLE);
    }

    @Override
    public void save(IProduct iProduct) {
        Document productMongoMapper = new Document();
        productMongoMapper.put("id", iProduct.getID());
        productMongoMapper.put("name", iProduct.getName());
        productMongoMapper.put("description", iProduct.getDescription());
        productMongoMapper.put("price", iProduct.getPrice());
        productMongoMapper.put("createdAt", iProduct.getCreatedAt());
        collection.insertOne(productMongoMapper);
    }

    @Override
    public boolean existsById(String id) {
        Document mongoMapper = collection.find(eq("id", id)).first();

        return mongoMapper != null;
    }
}
