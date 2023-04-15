package org.example.model;

import java.util.List;

public record Employee(Integer id, String name, String email, List<String> phoneNumbers) {}
