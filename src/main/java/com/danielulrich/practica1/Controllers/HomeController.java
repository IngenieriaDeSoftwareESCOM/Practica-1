package com.danielulrich.practica1.Controllers; // Package declaration for the HomeController class

import org.springframework.web.bind.annotation.RestController; // Import for Spring's RestController annotation
import java.util.List; // Import for the List interface
import org.springframework.http.ResponseEntity; // Import for ResponseEntity class used in API responses
import org.springframework.web.bind.annotation.PathVariable; // Import for handling path variables in URLs
import java.util.Collections; // Import for utility methods for collections
import org.springframework.web.bind.annotation.PutMapping; // Import for HTTP PUT request mapping
import com.danielulrich.practica1.Repositories.*; // Import repositories for behaviours
// The HomeController class is annotated as a REST controller, meaning it handles HTTP requests
@RestController
public class HomeController {

    // Mapping for the PUT request to the endpoint "/api/cerradura/estrella/{N}"
    @PutMapping("/api/cerradura/estrella/{N}")
    public ResponseEntity<List<String>> Kleene(@PathVariable int N) {
        try{
            // Validation to avoid huge numbers
            N = N > 10 ? 10 : N;
            N = N <= 0 ? N * -1 : N;
            // Instantiate a Kleene object with the provided path variable N
            Kleene kleene = new Kleene(N);
            // Call GetString() method to retrieve a list of strings generated by the Kleene object
            var items = kleene.GetString();
            // Sort the list of strings in ascending order
            Collections.sort(items);
            // Return the sorted list as a successful response (HTTP 200 OK)
            return ResponseEntity.ok(items);
        }catch(Exception ex){
            return ResponseEntity.badRequest().build();
        }
        
    }

    // Mapping for the PUT request to the endpoint "/api/cerradura/positiva/{N}"
    @PutMapping("/api/cerradura/positiva/{N}")
    public ResponseEntity<List<String>> Positive(@PathVariable int N) {
        try{
            // Validation to avoid huge numbers
            N = N > 10 ? 10 : N;
            N = N <= 0 ? N * -1 : N;
            // Instantiate a Positive object with the provided path variable N
            Positive positive = new Positive(N);
            // Call GetString() method to retrieve a list of strings generated by the Positive object
            var items = positive.GetString();
            // Sort the list of strings in ascending order
            Collections.sort(items);
            // Return the sorted list as a successful response (HTTP 200 OK)
            return ResponseEntity.ok(items);
        }catch(Exception ex){
            return ResponseEntity.badRequest().build();
        }
    }
}
