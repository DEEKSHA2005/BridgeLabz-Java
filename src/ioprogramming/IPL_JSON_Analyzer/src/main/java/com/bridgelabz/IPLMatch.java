package com.bridgelabz;

import java.util.Map;

/*
 * IPLMatch class represents the structure of IPL match data.
 * It maps the fields from the JSON file into a Java object.
 */
public class IPLMatch {

    // Unique match identifier
    public int match_id;

    // Name of the first team
    public String team1;

    // Name of the second team
    public String team2;

    // Score of both teams stored as a key-value pair
    public Map<String, Integer> score;

    // Name of the winning team
    public String winner;

    // Player who won the "Player of the Match" award
    public String player_of_match;

}