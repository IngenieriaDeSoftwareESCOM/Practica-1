package com.danielulrich.practica1.Repositories; // Package declaration for organizing the class in the project structure

import java.util.List; // Importing the List interface for managing a list of strings
import java.util.ArrayList; // Importing ArrayList for list implementation

// The Positive class is responsible for generating binary strings of a given maximum length
public class Positive {
    private int _n; // Private instance variable to hold the maximum length for binary strings

    // Constructor that initializes the maximum length _n using the parameter n
    public Positive(int n) {
        _n = n;
    }

    // Public method that returns a list of generated binary strings
    public List<String> GetString() {
        List<String> result = new ArrayList<String>(); // Create a new ArrayList to store the generated strings
        return GenerateBinaryStrings("", _n, result); // Call the recursive method to generate binary strings
    }

    // Private method to generate binary strings recursively
    private List<String> GenerateBinaryStrings(String prefix, int maxLength, List<String> result) {
        // Base case: If the prefix reaches the maximum length, return the result list
        if (prefix.length() == maxLength)
            return result;

        // Add the current prefix concatenated with '0' and '1' to the result list
        result.add(prefix + "0");
        result.add(prefix + "1");

        // Recursively generate binary strings by appending '0' and '1' to the current prefix
        GenerateBinaryStrings(prefix + "0", maxLength, result);
        GenerateBinaryStrings(prefix + "1", maxLength, result);
        return result; // Return the updated list of binary strings
    }
}
