package edu.campusmolndal.uppgift_5;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@RestController
@RequestMapping("/vote")
public class VoteController {
    private final Map<String, Integer> votes = new ConcurrentHashMap<>();

    @PostMapping
    public Map<String, String> vote(@RequestBody Map<String, String> payload) {
        String contestant = payload.get("contestant");
        votes.put(contestant, votes.getOrDefault(contestant, 0) + 1);
        return Collections.singletonMap("message", "Röst registrerad");
    }

    @GetMapping
    public Map<String, List<Map<String, Object>>> getResults() {
        List<Map<String, Object>> results = new ArrayList<>();
        votes.forEach((contestant, count) -> {
            results.add(Map.of("contestant", contestant, "votes", count));
        });
        return Collections.singletonMap("results", results);
    }
}
