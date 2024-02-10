package tw.shop.product.model;

import jakarta.persistence.*;
import lombok.Data;
import tw.shop.promotion.model.Promotion;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name="Category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;

    @ManyToMany(mappedBy = "categories")
    private Set<Product> products = new HashSet<>();

	public Category(Long id, String name, Set<Product> products) {
		super();
		this.id = id;
		this.name = name;
		this.products = products;
	}
	
	@ManyToMany(mappedBy = "categories")
    private Set<Promotion> promotions = new HashSet<>();

    // Constructors, Getters, and Setters
}