package com.mycompany.proyectouveg.emotionalsCouples;
import com.mycompany.proyectouveg.DB;
import com.mycompany.proyectouveg.Students.Gender;
import com.mycompany.proyectouveg.Students.User;
import com.mycompany.proyectouveg.enums.enumsEmotions.emotional_man;
import com.mycompany.proyectouveg.enums.enumsEmotions.emotional_woman;
import com.mycompany.proyectouveg.interfaces.*;


import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MakeCouplesEmotionalsPartner {
    private static ArrayList<User> womans = new ArrayList<>();
    private static ArrayList<User> mans = new ArrayList<>();
    private int orders = 0;
    private  boolean is_order = true;
    private static ArrayList<User> users = DB.getUsers();
    public ArrayList<User> searchCoupleForUserId( int id_user) {
      User index_user = findUserByBinarySearch(id_user);
        assert index_user != null;
        return findEmotionalCouplesForUser(index_user);
    };
    static ArrayList<User> findEmotionalCouplesForUser( User index_user){
        ArrayList<User> emotional_couples = new ArrayList<>();
        int length_users;
        if(index_user.getGender() == Gender.Masculino){
            length_users = womans.size() - 1;
            while(length_users>=0){
                User index_woman = womans.get(length_users);
                int difference_age = index_user.getBirthday().getYear() - index_woman.getBirthday().getYear();
                if(difference_age < -3 || difference_age > 3){
                    continue;
                }
                int emotional_copability = getCompatibilityEmotionalStates( index_woman.getEmotionalPartner(), index_user.getEmotionalPartner());
                if (emotional_copability > 74 && emotional_copability < 86) {
                    emotional_couples.add(index_woman);
                };
                length_users--;
            }
        }else {
            length_users = mans.size() - 1;
            while(length_users >= 0){
                User index_man = mans.get(length_users);
                int difference_age = index_user.getBirthday().getYear() - index_man.getBirthday().getYear();
                if(difference_age < -3 || difference_age > 3){
                    continue;
                }
                int emotional_copability = getCompatibilityEmotionalStates(index_user.getEmotionalPartner(), index_man.getEmotionalPartner());
                if(emotional_copability >74 && emotional_copability < 86){
                    emotional_couples.add(index_man);
                }
                length_users--;
            }
        }
        return emotional_couples;
    };
    private static final Map<Map.Entry<emotional_states, emotional_states>, Integer> compatibilityMap = new HashMap<>();
    static {
        //emotional_man.emotional_connection
        compatibilityMap.put(new AbstractMap.SimpleEntry<>(emotional_man.emotional_connection, emotional_woman.emotionally_engaged), 80);
        compatibilityMap.put(new AbstractMap.SimpleEntry<>(emotional_man.emotional_connection,emotional_woman.emotionally_balanced), 85);
        compatibilityMap.put(new AbstractMap.SimpleEntry<>(emotional_man.emotional_connection,emotional_woman.emotionally_independent), 60);
        compatibilityMap.put(new AbstractMap.SimpleEntry<>(emotional_man.emotional_connection,emotional_woman.emotionally_reserved), 70);
       //emotional_man.balanced_listener

        compatibilityMap.put(new AbstractMap.SimpleEntry<>(emotional_man.balanced_listener,emotional_woman.emotionally_engaged ), 90);
        compatibilityMap.put(new AbstractMap.SimpleEntry<>(emotional_man.balanced_listener,emotional_woman.emotionally_balanced ), 95);
        compatibilityMap.put(new AbstractMap.SimpleEntry<>(emotional_man.balanced_listener,emotional_woman.emotionally_independent ), 75);
        compatibilityMap.put(new AbstractMap.SimpleEntry<>(emotional_man.balanced_listener,emotional_woman.emotionally_reserved ), 80);

        //emotional_man.calm_problem_solver
        compatibilityMap.put(new AbstractMap.SimpleEntry<>(emotional_man.calm_problem_solver,emotional_woman.emotionally_engaged ), 85);
        compatibilityMap.put(new AbstractMap.SimpleEntry<>(emotional_man.calm_problem_solver,emotional_woman.emotionally_balanced ), 90);
        compatibilityMap.put(new AbstractMap.SimpleEntry<>(emotional_man.calm_problem_solver,emotional_woman.emotionally_independent ), 95);
        compatibilityMap.put(new AbstractMap.SimpleEntry<>(emotional_man.calm_problem_solver,emotional_woman.emotionally_reserved ), 85);

        //emotional_man.stoic_protector
        compatibilityMap.put(new AbstractMap.SimpleEntry<>(emotional_man.stoic_protector,emotional_woman.emotionally_engaged ), 90);
        compatibilityMap.put(new AbstractMap.SimpleEntry<>(emotional_man.stoic_protector,emotional_woman.emotionally_balanced ), 80);
        compatibilityMap.put(new AbstractMap.SimpleEntry<>(emotional_man.stoic_protector,emotional_woman.emotionally_independent ), 70);
        compatibilityMap.put(new AbstractMap.SimpleEntry<>(emotional_man.stoic_protector,emotional_woman.emotionally_reserved ), 60);

    };
    static int getCompatibilityEmotionalStates(emotional_states index_emotional, emotional_states couple_emotional){
        return compatibilityMap.getOrDefault(new AbstractMap.SimpleEntry<>(index_emotional, couple_emotional),60 );
    };
    static User findUserByBinarySearch(int id_user){
        int left = 0;
        int right = users.size() - 1;
        while(left <= right){
            int mid = left + (right / left) / 2;
            int mid_id_user = users.get(mid).getIdUser();
            if(mid_id_user == id_user){
                return users.get(mid);
            }
            if(mid_id_user < id_user){
                left = mid +1;
            }else{
                right = mid -1;
            }
        }
        return null;
    };
    public void sortUsersByGender(){
        if(this.is_order){
            System.out.println("Not Order the users are ordered");
            return;
        };
        int length_users = users.size() - 1;
        int orders_in_the_last_loop = this.orders;
        while(length_users >= orders_in_the_last_loop){
            this.orders++;
            User index_user = users.get(length_users);
            if(index_user.getGender() == Gender.Femenino){
                womans.add(index_user);
            }else mans.add(index_user);
            length_users--;
        }
        setOrder(true);
    }
     public boolean getOrder(){
        return this.is_order;
    }
    public void setOrder(boolean is_order){
        this.is_order = is_order;
    }

}
