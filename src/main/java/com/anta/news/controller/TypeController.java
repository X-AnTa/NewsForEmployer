package com.anta.news.controller;

import com.anta.news.entity.Type;
import com.anta.news.service.TypeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Type", description = "CRUD types")
@RestController
@RequestMapping("/newsline")
public class TypeController {

    private final TypeService typeService;

    @Autowired
    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }

    @GetMapping("/type")
    public ResponseEntity<List<Type>> getAllTypes() {
        return new ResponseEntity<>(typeService.getAllTypes(), HttpStatus.OK);
    }

    @GetMapping("/type/{id}")
    public ResponseEntity<Type> getType(@PathVariable int id) {
        Type type = typeService.getType(id);
        return new ResponseEntity<>(type, HttpStatus.OK);
    }

    @PostMapping("/type")
    public ResponseEntity<Type> addType(@RequestBody Type type) {
        Type newType = typeService.addType(type);
        return new ResponseEntity<>(newType, HttpStatus.CREATED);
    }

    @PutMapping("/type/{id}")
    public ResponseEntity<Type> updateType(@PathVariable int id, @RequestBody Type type) {
        Type updatedType = typeService.updateType(id, type);
        return new ResponseEntity<>(updatedType, HttpStatus.OK);
    }

    @DeleteMapping("/type/{id}")
    public ResponseEntity<Boolean> deleteType(@PathVariable int id) {
        Boolean delete = typeService.deleteType(id);
        return new ResponseEntity<>(delete, HttpStatus.OK);
    }
}
