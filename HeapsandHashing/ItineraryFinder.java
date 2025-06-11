package com.kunal.Dsa.HeapsandHashing;

import java.util.HashMap;
import java.util.Map;

public class ItineraryFinder {
    public static void findItinerary(HashMap<String, String> tickets) {
       HashMap<String,String> hashMap = new HashMap<>();
        for (Map.Entry<String, String> entry:tickets.entrySet()) {
            hashMap.put(entry.getValue(),entry.getKey());
        }

        String start = null;

        for (String city:tickets.keySet()) {
            if(!hashMap.containsKey(city)){
                start=city;
                break;
            }
        }

        if (start == null) {
            System.out.println("Invalid input. Cycle detected or no unique start point.");
            return;
        }

        String current = start;
        while(tickets.containsKey(current)){
            String next = tickets.get(current);
            System.out.println(current + " -> " + next);
            current = next;
        }
    }
    public static void main(String[] args) {
        HashMap<String, String> tickets1 = new HashMap<>();
        tickets1.put("Chennai", "Bangalore");
        tickets1.put("Bombay", "Delhi");
        tickets1.put("Goa", "Chennai");
        tickets1.put("Delhi", "Goa");

        System.out.println("Itinerary 1:");
        findItinerary(tickets1);

        System.out.println("\nItinerary 2:");
        HashMap<String, String> tickets2 = new HashMap<>();
        tickets2.put("New York", "Chicago");
        tickets2.put("Denver", "San Francisco");
        tickets2.put("Chicago", "Denver");
        tickets2.put("San Francisco", "Los Angeles");

        findItinerary(tickets2);
    }
}
