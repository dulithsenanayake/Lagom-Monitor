package org.kelaniya.uni.product.impl;

import akka.Done;
import akka.NotUsed;
import com.google.inject.Inject;
import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.ServiceCall;
import org.kelaniya.uni.product.api.Product;
import org.kelaniya.uni.product.api.ProductService;

import java.util.concurrent.CompletableFuture;


public class ProductImpl implements ProductService {

    private ProductRepository productRepository;

    @Inject
    public ProductImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ServiceCall<NotUsed, Product> getProductById(String id) {
//        ProductRepository productRepository = new InMemoryProductRepository();
//        System.out.println("success : " + id);
        return request -> CompletableFuture
                .completedFuture(productRepository.getProduct(id));
    }

    @Override
    public ServiceCall<Product, Done> addProduct() {

        return request ->{

            productRepository.addProduct(request);

            return CompletableFuture.completedFuture(Done.getInstance());
        };
    }

}
