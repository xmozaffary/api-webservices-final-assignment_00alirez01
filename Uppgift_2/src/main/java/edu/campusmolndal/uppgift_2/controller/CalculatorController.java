package edu.campusmolndal.uppgift_2.controller;


import edu.campusmolndal.uppgift_2.model.CalculationRequest;
import edu.campusmolndal.uppgift_2.model.CalculationResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {



    @PostMapping(value = "/add", produces = "application/json")
    public ResponseEntity<CalculationResponse> addition(@RequestBody CalculationRequest request){
        int result = request.getNum1() + request.getNum2();
        return ResponseEntity.ok(new CalculationResponse(result));
    }

    @PostMapping("/subtract")
    public ResponseEntity<CalculationResponse> subtraction(@RequestBody CalculationRequest request){
        int result = request.getNum1() - request.getNum2();
        return ResponseEntity.ok(new CalculationResponse(result));
    }

    @PostMapping("/multiply")
    public ResponseEntity<CalculationResponse> multiplication(@RequestBody CalculationRequest request){
        int result = request.getNum1() * request.getNum2();
        return ResponseEntity.ok(new CalculationResponse(result));
    }

    @PostMapping("/divide")
    public ResponseEntity<?> division(@RequestBody CalculationRequest request){
        if (request.getNum2() == 0) {
            return ResponseEntity.badRequest().body("Error: Division by zero is not allowed.");
        }
        int result = request.getNum1() / request.getNum2();
        return ResponseEntity.ok(new CalculationResponse(result));
    }
}