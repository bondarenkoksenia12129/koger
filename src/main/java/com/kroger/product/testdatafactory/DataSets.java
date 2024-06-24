package com.kroger.product.testdatafactory;

import java.util.List;

import com.kroger.product.vo.Product;

import io.github.benas.randombeans.api.Randomizer;
import io.github.benas.randombeans.randomizers.collection.ListRandomizer;

public class DataSets {

	@SuppressWarnings("unchecked")
	public  List<Product> dataSet(int range) {

		Randomizer<Product> product = new RandomDataGeneration();
		ListRandomizer<Product> randomizerProductList = ListRandomizer.aNewListRandomizer(product, range);
		List<Product> productLIst = randomizerProductList.getRandomValue();

		return productLIst;

	}

}
