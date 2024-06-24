package com.kroger.product.testdatafactory;

import com.kroger.product.vo.Product;

import io.github.benas.randombeans.api.Randomizer;

public class RandomDataGeneration implements Randomizer<Product> {

	public Product getRandomValue() {
		RandomObjectFiller random = new RandomObjectFiller();
		Product product = null;
		try {
			product = random.createAndFill(Product.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return product;
	}

}
