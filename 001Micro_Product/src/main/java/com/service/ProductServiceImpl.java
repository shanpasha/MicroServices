package com.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Dao.ProductRepo;
import com.exception.ProductCustomException;
import com.model.Product;
import com.request.ProductRequest;
import com.response.ProductResponse;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor

@Service
public class ProductServiceImpl  implements ProductService{


	 private  final ProductRepo repo;
	
	@Override
	public Integer addProduct(ProductRequest product) {
		
		Product pr=Product.builder()
				.productName(product.getProductName())
				.price(product.getPrice())
				.quantity(product.getQuantity()).build();
		
		repo.save(pr);
		
		return pr.getProductId();
		
	}

	@Override
	public void deleteProduct(Integer id) {
		
		if(!repo.existsById(id)) {
			
			throw new ProductCustomException("PRODUCT NOT FOUND", "Give ID not found in records");
		}
	
		repo.deleteById(id);
		
	}

	@Override
	public ProductResponse getProduct(Integer id) {
		
		
		ProductRequest prod=new ProductRequest("dell", 2, 35000.0);
		addProduct(prod);
		
		Product pro=repo.findById(id)
				.orElseThrow(()->new ProductCustomException("PRODUCT NOT FOUND", "Product with given Id not found"));
		ProductResponse productResponse=new ProductResponse();

        BeanUtils.copyProperties(pro, productResponse);
		
		return productResponse;
	}

	@Override
	public void reduceQuantity(Integer Quantity , Integer id) {
		
		Product product=repo.findById(id)
				.orElseThrow(()-> new ProductCustomException("PRODUCT NOT FOUND", "Given product id not found in records.."));
				
				
		if(product.getQuantity()<Quantity) {
			
			throw new ProductCustomException("INSUFFICIENT_QUANTITY", "Product does not have sufficient Quantity");
			
			
			
		}
	
		product.setQuantity(product.getQuantity()-Quantity);
		
		repo.save(product);
		
		
		
	}

}
