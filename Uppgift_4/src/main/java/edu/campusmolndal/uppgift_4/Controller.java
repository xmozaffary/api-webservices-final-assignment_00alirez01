package edu.campusmolndal.uppgift_4;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Controller
public class Controller {

    private List<Match> matches = new ArrayList<>(List.of(
            new Match("1", "Team Red", "Team Blue", 2, 1),
            new Match("2", "Team Green", "Team Yellow", 3, 3)
    ));

    @QueryMapping
    public List<Match> matches() {
        return matches;
    }

    @QueryMapping
    public Match match(@Argument String id) {
        return matches.stream().filter(m -> m.getId().equals(id)).findFirst().orElse(null);
    }

    @MutationMapping
    public Match addMatch(@Argument String teamA, @Argument String teamB, @Argument int scoreA, @Argument int scoreB) {
        Match newMatch = new Match(String.valueOf(matches.size() + 1), teamA, teamB, scoreA, scoreB);
        matches.add(newMatch);
        return newMatch;
    }

    @MutationMapping
    public Match updateMatch(@Argument String id, @Argument int scoreA, @Argument int scoreB) {
        Optional<Match> matchOptional = matches.stream().filter(m -> m.getId().equals(id)).findFirst();
        if (matchOptional.isPresent()) {
            Match match = matchOptional.get();
            match.setScoreA(scoreA);
            match.setScoreB(scoreB);
            return match;
        }
        return null;
    }

    @MutationMapping
    public String deleteMatch(@Argument String id) {
        matches.removeIf(m -> m.getId().equals(id));
        return "Match with id " + id + " deleted.";
    }
}
