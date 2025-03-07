package org.example.Hashing;

import java.util.*;

class VotingSystem {
    private Map<String, Integer> votes = new HashMap<>();
    private LinkedHashMap<String, Integer> voteOrder = new LinkedHashMap<>();
    private TreeMap<Integer, String> sortedResults = new TreeMap<>(Collections.reverseOrder());

    // Cast a vote for a candidate
    public void vote(String candidate) {
        votes.put(candidate, votes.getOrDefault(candidate, 0) + 1);
        voteOrder.put(candidate, voteOrder.getOrDefault(candidate, 0) + 1);
        System.out.println("Voted for " + candidate);
    }

    // Display votes in the order they were cast
    public void displayVotesInOrder() {
        System.out.println("Votes in the order they were cast:");
        for (Map.Entry<String, Integer> entry : voteOrder.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }
    }

    // Display the results sorted by votes
    public void displaySortedResults() {
        sortedResults.clear(); // Clear previous results before recalculating
        for (Map.Entry<String, Integer> entry : votes.entrySet()) {
            sortedResults.put(entry.getValue(), entry.getKey());
        }

        System.out.println("Voting Results sorted by votes:");
        for (Map.Entry<Integer, String> entry : sortedResults.entrySet()) {
            System.out.println(entry.getValue() + ": " + entry.getKey() + " votes");
        }
    }

    // Display winner(s)
    public void displayWinner() {
        int maxVotes = Collections.max(votes.values());
        System.out.println("Winner(s):");
        for (Map.Entry<String, Integer> entry : votes.entrySet()) {
            if (entry.getValue() == maxVotes) {
                System.out.println(entry.getKey() + " with " + maxVotes + " votes");
            }
        }
    }
}

public class VotingMain {
    public static void main(String[] args) {
        VotingSystem votingSystem = new VotingSystem();

        // Casting votes
        votingSystem.vote("Alice");
        votingSystem.vote("Bob");
        votingSystem.vote("Alice");
        votingSystem.vote("Charlie");
        votingSystem.vote("Bob");
        votingSystem.vote("Alice");

        // Display votes in the order they were cast
        votingSystem.displayVotesInOrder();

        // Display sorted results
        votingSystem.displaySortedResults();

        // Display the winner(s)
        votingSystem.displayWinner();
    }
}

