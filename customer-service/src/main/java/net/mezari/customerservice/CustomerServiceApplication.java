package net.mezari.customerservice;

import net.mezari.customerservice.entities.Customer;
import net.mezari.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
        return args -> {

            List<Customer> customerList=List.of(
                    Customer.builder()
                            .firstName("Ilham")
                            .lastName("mezari")
                            .email("ilh@gmail.com")
                            .build(),
                    Customer.builder()
                            .firstName("omar")
                            .lastName("mez")
                            .email("omar@gmail.com")
                            .build()

            );
            customerRepository.saveAll(customerList);
        };
    }
}
