package vn.edu.hcmut.smartwarehouse.product;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/products")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductAPI {
	private final ProductRepository productRepository;

	@GetMapping
	public ResponseEntity<List<Product>> findAll() {
		return ResponseEntity.ok(productRepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Product> findById(@PathVariable Integer id) {
		Optional<Product> product = productRepository.findById(id);
		return ResponseEntity.of(product);
	}

	@PostMapping
	public ResponseEntity<Product> create(@RequestBody Product product) {
		productRepository.save(product);
		return ResponseEntity.status(HttpStatus.CREATED).body(product);
	}

	@PutMapping
	public ResponseEntity<Product> update(@RequestBody Product product) {
		if (Objects.nonNull(product.getId())) {
			productRepository.save(product);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(product);
		}
		throw new IllegalArgumentException("Product id is required.");
	}

	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable Integer id) {
		productRepository.deleteById(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}
}
