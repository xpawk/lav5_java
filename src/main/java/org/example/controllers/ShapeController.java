package org.example.controllers;

import org.example.Shape;
import org.example.services.ShapeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shapes")
public class ShapeController {
    private final ShapeService shapeService;

    public ShapeController(ShapeService shapeService) {
        this.shapeService = shapeService;
    }

    @GetMapping("/{type}")
    public List<? extends Shape> getAllShapes(@PathVariable String type) {
        try {
            Class<? extends Shape> shapeClass = getShapeClass(type);
            return shapeService.findAll(shapeClass);
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException("Invalid shape type: " + type);
        }
    }

    @PostMapping
    public Shape createShape(@RequestBody Shape shape) {
        return shapeService.saveShape(shape);
    }

    private Class<? extends Shape> getShapeClass(String type) throws ClassNotFoundException {
        String packageName = "org.example.models";
        return (Class<? extends Shape>) Class.forName(packageName + "." + type);
    }
}
