package com.danielulrich.practica1.Repositories; // Package declaration for the Kleene class

import java.util.List; // Import for the List interface
import java.util.ArrayList; // Import for the ArrayList class

// The Kleene class is designed to generate binary strings of a specified maximum length
public class Kleene {
    private int _n; // Instance variable to hold the maximum length for binary strings

    // Constructor that initializes the maximum length _n with the given parameter n
    public Kleene(int n) {
        _n = n;
    }

    // Public method to get a list of binary strings, starting with the empty string
    public List<String> GetString() {
        List<String> result = new ArrayList<String>(); // Create a new ArrayList to hold the results
        result.add("λ"); // Add the lambda (empty string) to the result list
        return GenerateBinaryStrings("", _n, result); // Call the recursive method to generate binary strings
    }

    // Private method to generate binary strings recursively
    private List<String> GenerateBinaryStrings(String prefix, int maxLength, List<String> result) {
        // Base case: if the current prefix length equals the maximum length, return the result list
        if (prefix.length() == maxLength)
            return result;

        // Add the current prefix with '0' and '1' to the result list
        result.add(prefix + "0");
        result.add(prefix + "1");

        // Recursively generate binary strings by appending '0' and '1' to the current prefix
        GenerateBinaryStrings(prefix + "0", maxLength, result);
        GenerateBinaryStrings(prefix + "1", maxLength, result);
        return result; // Return the list of generated binary strings
    }
}
