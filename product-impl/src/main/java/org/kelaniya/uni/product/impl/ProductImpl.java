package org.kelaniya.uni.product.impl;

import akka.Done;
import akka.NotUsed;
import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.ServiceCall;
import org.kelaniya.uni.product.api.Product;
import org.kelaniya.uni.product.api.ProductService;

import java.util.concurrent.CompletableFuture;


public class ProductImpl implements ProductService {

    public ProductImpl() {
    }

    @Override
    public ServiceCall<NotUsed, Product> getProductById(String id) {
        ProductRepository productRepository = new InMemoryProductRepository();
//        System.out.println("success : " + id);
        return request -> CompletableFuture
                .completedFuture(productRepository.getProduct(id));
    }

}
