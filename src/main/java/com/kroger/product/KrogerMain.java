package com.kroger.product;

import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

import com.kroger.product.testdatafactory.DataSets;
import com.kroger.product.vo.Product;

public class KrogerMain {

	
	/**
	 * @return
	 */
	public static List<Product> createDataSet(int range) {
		System.out.println("**************************************************************************************************");
		List<Product> prodcutDataSetList = new DataSets().dataSet(range);
		System.out.println("************************Product List with Fake Date Created with Data Set**************************************************************************");
		
		System.out.println("**************************************************************************************************");
		
		return prodcutDataSetList;
	}
	
	
	/**
	 * @param prodcutDataSetList
	 */
	public static void sortByProductName(List<Product> prodcutDataSetList) {
		System.out.println("**************************************************************************************************");
		
		System.out.println("Adding Data Set One and  Sorting By based On Product Name ");
		prodcutDataSetList.sort((p1,p2)-> p1.getProductName().compareTo(p2.getProductName()));
		System.out.println("ProdductID"+"\t"+"Product Name"+"\t\t\t"+"Category"+"\t"+"Expiry Date" );
		System.out.println("**************************************************************************************************");
		prodcutDataSetList.forEach(p->{
			System.out.println(p.getProductNo()+"\t"+p.getProductName()+"\t"+p.getProductCategory()+"\t"+p.getExpiryDate());
		});
		
		System.out.println("**************************************************************************************************");

	}

	/**
	 * @param prodcutDataSetList
	 */
	public static void sortByProductCategory(List<Product> prodcutDataSetList) {
		System.out.println("**************************************************************************************************");
			
		System.out.println("Adding Data Set One and  Sorting By based On Product Category ");
		prodcutDataSetList.sort((p1,p2)-> p1.getProductCategory().compareTo(p2.getProductCategory()));
		System.out.println("ProdductID"+"\t"+"Product Name"+"\t\t\t"+"Category"+"\t"+"Expiry Date" );
		System.out.println("**************************************************************************************************");

		prodcutDataSetList.forEach(p->{
			System.out.println(p.getProductNo()+"\t"+p.getProductName()+"\t"+p.getProductCategory()+"\t"+p.getExpiryDate());
		});
		
		System.out.println("**************************************************************************************************");
	}


	/**
	 * @param prodcutDataSetList
	 */
	public static void sortOnProductExpriryDate(List<Product> prodcutDataSetList) {
		System.out.println("**************************************************************************************************");
			
		System.out.println("Adding Data Set One and  Sorting By based On Product Exprity Date ");
		prodcutDataSetList.sort((p1,p2)-> p1.getExpiryDate().compareTo(p2.getExpiryDate()));
		System.out.println("ProdductID"+"\t"+"Product Name"+"\t\t\t"+"Category"+"\t"+"Expiry Date" );
		System.out.println("**************************************************************************************************");

		prodcutDataSetList.forEach(p->{
			System.out.println(p.getProductNo()+"\t"+p.getProductName()+"\t"+p.getProductCategory()+"\t"+p.getExpiryDate());
		});
		
		System.out.println("**************************************************************************************************");
	}



	/**
	 * @param prodcutDataSetList
	 */
	public static void deletProductCategory(List<Product> prodcutDataSetList, String categoryName) {
		System.out.println("**************************************************************************************************");
			
		 Predicate<Product> productDelete = p-> p.getProductCategory().name().equals(categoryName);
		 prodcutDataSetList.removeIf(productDelete);
		 
		 System.out.println("**************************************************************************************************");

	}

	/**
	 * @param prodcutDataSetList
	 */
	public static void sortProductNo(List<Product> prodcutDataSetList) {
		System.out.println("**************************************************************************************************");
		
		prodcutDataSetList.sort((p1,p2)-> p1.getProductNo()-p2.getProductNo());
		 System.out.println("ProdductID"+"\t"+"Product Name"+"\t\t\t"+"Category"+"\t"+"Expiry Date" );
		System.out.println("**************************************************************************************************");

		prodcutDataSetList.forEach(p->{
			System.out.println(p.getProductNo()+"\t"+p.getProductName()+"\t"+p.getProductCategory()+"\t"+p.getExpiryDate());
		});
		
		System.out.println("**************************************************************************************************");
	}


		
	
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		List<Product> prodcutDataSetList = null;
		int option = 0;
		do{
			
			System.out.println("# # Choose one of the options below # #");
			System.out.println("Option 1 - Create ProductList");
			System.out.println("Option 2 - Sort by Product Name");
			System.out.println("Option 3 - Sort by Product Category");
			System.out.println("Option 4 - Sort by Product Expiry Date");
			System.out.println("Option 5 - Delet Product Category");
			System.out.println("Option 6 - Sort by Product No");
			System.out.println("Option 0 - Exit program");

			System.out.print("Enter your choice here:");
			option = Integer.parseInt(sc.nextLine());
			if (option == 1) {
				System.out.print("Enter the Size of List:");
				int size = Integer.parseInt(sc.nextLine());
				prodcutDataSetList = createDataSet(size);
			}else if(option == 2){
				if(prodcutDataSetList == null){
					System.out.println("No Data Avaliable");
					System.exit(0);
				}
				sortByProductName(prodcutDataSetList);
			}else if(option == 3){
				if(prodcutDataSetList == null){
					System.out.println("No Data Avaliable");
					System.exit(0);
				}
				sortByProductCategory(prodcutDataSetList);
			}else if(option == 4){
				if(prodcutDataSetList == null){
					System.out.println("No Data Avaliable");
					System.exit(0);
				}
				sortOnProductExpriryDate(prodcutDataSetList);
			}else if(option == 5){
				if(prodcutDataSetList == null){
					System.out.println("No Data Avaliable");
					System.exit(0);
				}
				System.out.print("Enter the Product Category:");
				String categoryName =  sc.nextLine();
				deletProductCategory(prodcutDataSetList,categoryName);
			}else if(option == 6){
				if(prodcutDataSetList == null){
					System.out.println("No Data Avaliable");
					System.exit(0);
				}
				sortProductNo(prodcutDataSetList);
			}
		}while (option != 0);

		sc.close();
		
		
		
		
		
		

	}





}
