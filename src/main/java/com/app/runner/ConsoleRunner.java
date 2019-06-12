package com.app.runner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.app.model.Product;
import com.app.repo.ProductRepository;

@Component
public class ConsoleRunner implements CommandLineRunner {

	@Autowired
	private ProductRepository repo;

	public void run(String... args) throws Exception {

		repo.save(new Product(10,"A",3.3));
		repo.save(new Product(11,"B",4.4));
		repo.save(new Product(12,"C",5.5));
		repo.save(new Product(13,"D",6.6));

		//UPDATE_CALL
		repo.save(new Product(13,"E",8.8));

		//BULK INSERT
		
		
		  List<Product> prds=Arrays.asList( new Product (101,"R",9.1));
		  repo.saveAll(prds);
		 
		 
		
		//FETCH ONE ROW
		Optional<Product> p=repo.findById(102);
		if(p.isPresent())
		{
			@SuppressWarnings("unused")
			Product prd=p.get();
			
			
		}else
		{
			System.out.println("ROW NOT FOUND");
		}
		//FETCH ALL ROW
		List<Product> list=repo.findAll();
		list.forEach(System.out::println);
		
		//DELETE OPERATIONS
		repo.deleteById(10);
		
		//DELETE ALL ROW
		repo.deleteAll();
		
		repo.deleteInBatch(list);
		

	}

}
