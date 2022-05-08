package com.suitesquad.cachecraft;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InternalStorage {
    public InternalStorage(){
        geocacheId = -1;
        leaderboard = new HashMap<>();
        x = 0;
        y = 1;
        z = 2;
    }

    public InternalStorage(String dataString){
        List<String> elements = Arrays.asList(dataString.split("\\|"));
        System.out.println(Arrays.toString(elements.toArray()));
        //Ensure data is valid
        if(elements.size() != 5){
            System.out.println("Err: incorrect number of elements in data string, expected 5, recieved " + elements.size());{
                geocacheId = -1;
                leaderboard = new HashMap<>();
                x = 0;
                y = 1;
                z = 2;
            }
        }
        else{
            geocacheId = Integer.parseInt(elements.get(0));
            x = Integer.parseInt(elements.get(1));
            y = Integer.parseInt(elements.get(2));
            z = Integer.parseInt(elements.get(3));
            //Format the leaderboard data and generate your hashmap
            leaderboard = new HashMap<>();
            for(String leaderboardPosition : elements.get(4).split(",")){
                String[] userTicks = leaderboardPosition.split(":");
                leaderboard.put(userTicks[0],Integer.parseInt(userTicks[1]));
            }
        }
    }
    //Geocache id will store the id generated for the current geocache upon spawning, used so any old, redundant geocaches will not be tracked
    private int geocacheId;
    public int x,y,z;

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getZ(){
        return z;
    }

    public void setCoords(int newX,int newY,int newZ){
        x = newX;
        y = newY;
        z = newZ;
    }

    public int getGeocacheId(){
        return getGeocacheId();
    }

    public void setGeocacheId(int newId){
        geocacheId = newId;
    }

    //Generate a list of pairs. The string part of the pair represents the username of the player
    //The long represents the # of ticks that the geocache has been under that player's control
    Map<String,Integer> leaderboard;

    public String generateData(){
        //Store geocache , x , y , z  values
        String data = String.format("%d|%d|%d|%d|",geocacheId,x,y,z);
        //Store leaderboard data
        for(Map.Entry<String,Integer> position : leaderboard.entrySet()){
            data += String.format("%s:%d,",position.getKey(),position.getValue());
        }
        //Remove the trailing comma
        data = data.substring(0,data.length()-1);
        return data;
    }

}
