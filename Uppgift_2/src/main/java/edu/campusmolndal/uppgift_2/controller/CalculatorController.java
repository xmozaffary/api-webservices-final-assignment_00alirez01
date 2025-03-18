package edu.campusmolndal.uppgift_2.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    static class CalculationRequest{
        int num1;
        int num2;
    }

    static class CalculationResponse{
        int result;
        public CalculationResponse(int result){
            this.result = result;
        }
    }

    @PostMapping("/add")
    public ResponseEntity<CalculationResponse> addition(@RequestBody CalculationRequest request){
        int result = request.num1 + request.num2;
        return ResponseEntity.ok(new CalculationResponse(result));
    }

    @PostMapping("/subtract")
    public ResponseEntity<CalculationResponse> subtraction(@RequestBody CalculationRequest request){
        int result = request.num1 - request.num2;
        return ResponseEntity.ok(new CalculationResponse(result));
    }

    @PostMapping("/multiply")
    public ResponseEntity<CalculationResponse> multiplication(@RequestBody CalculationRequest request){
        int result = request.num1 * request.num2;
        return ResponseEntity.ok(new CalculationResponse(result));
    }

    @PostMapping("/divide")
    public ResponseEntity<?> division(@RequestBody CalculationRequest request){
        if (request.num2 == 0) {
            return ResponseEntity.badRequest().body("Error: Division by zero is not allowed.");
        }
        int result = request.num1 / request.num2;
        return ResponseEntity.ok(new CalculationResponse(result));
    }
}