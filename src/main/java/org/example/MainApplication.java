package org.example;

import org.example.repositories.ShapeRepository;
import org.example.services.ShapeService;
import org.example.ShapeDescriber;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    CommandLineRunner run(ShapeService shapeService, ShapeDescriber shapeDescriber) {
        return args -> {
            try {
                // Create sample shapes
                Color color1 = new Color(255.0, 0.0, 0.0);
                Color color2 = new Color(0.0, 255.0, 0.0, 0.5);

                Rectangle rectangle = new Rectangle(5, 10, color1);
                Triangle triangle = new Triangle(6, 8, color2);

                // Save shapes to the database
                shapeService.saveShape(rectangle);
                shapeService.saveShape(triangle);

                // Retrieve and describe all rectangles
                System.out.println("All Rectangles:");
                List<Rectangle> rectangles = shapeService.findAll(Rectangle.class);
                for (Rectangle rect : rectangles) {
                    shapeDescriber.describe(rect);
                }

                // Retrieve and describe all triangles
                System.out.println("\nAll Triangles:");
                List<Triangle> triangles = shapeService.findAll(Triangle.class);
                for (Triangle tri : triangles) {
                    shapeDescriber.describe(tri);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
    }
}
