package vn.edu.hcmut.smartwarehouse.order;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/orders")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderAPI {
    private final OrderRepository orderRepository;

    @GetMapping
    public ResponseEntity<List<Order>> findAll() {
        return ResponseEntity.ok(orderRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> findById(@PathVariable Integer id) {
        Optional<Order> order = orderRepository.findById(id);
        return ResponseEntity.of(order);
    }

    @PostMapping
    public ResponseEntity<Order> create(@RequestBody Order order) {
        orderRepository.save(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(order);
    }

    @PutMapping
    public ResponseEntity<Order> update(@RequestBody Order order) {
        if (Objects.nonNull(order.getId())) {
            orderRepository.save(order);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(order);
        }
        throw new IllegalArgumentException("Product id is required.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        orderRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
