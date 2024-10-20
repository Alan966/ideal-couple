package com.mycompany.proyectouveg.Services;
import com.mycompany.proyectouveg.DB;
import com.mycompany.proyectouveg.Students.Gender;
import com.mycompany.proyectouveg.Students.User;
import com.mycompany.proyectouveg.interfaces.*;
import com.mycompany.proyectouveg.enums.*;


import java.util.ArrayList;

public class MakeCouplesServices {
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
                int emotional_copability = getCompatibilityEmotionalStates( womans.get(length_users).getEmotionalPartner(), index_user.getEmotionalPartner());
                if (emotional_copability > 74 && emotional_copability < 86) {
                    emotional_couples.add(womans.get(length_users));
                };
                length_users--;
            }
        }else {
            length_users = mans.size() - 1;
            while(length_users >= 0){
                int emotional_copability = getCompatibilityEmotionalStates(index_user.getEmotionalPartner(), mans.get(length_users).getEmotionalPartner());
                if(emotional_copability >74 && emotional_copability < 86){
                    emotional_couples.add(mans.get(length_users));
                }
                length_users--;
            }
        }
        return emotional_couples;
    };
    static int getCompatibilityEmotionalStates(emotional_states index_emotional, emotional_states couple_emotional){
        if(index_emotional == emotional_man.emotional_connection && couple_emotional == emotional_woman.emotionally_engaged){
            return 80;
        }else if(index_emotional == emotional_man.emotional_connection && couple_emotional == emotional_woman.emotionally_balanced){
            return 85;
        }
        else if(index_emotional == emotional_man.emotional_connection && couple_emotional == emotional_woman.emotionally_independent){
            return 60;
        }
        else if(index_emotional == emotional_man.emotional_connection && couple_emotional == emotional_woman.emotionally_reserved){
            return 70;
        }
        else if(index_emotional == emotional_man.balanced_listener && couple_emotional == emotional_woman.emotionally_engaged){
            return 90;
        }else if(index_emotional == emotional_man.balanced_listener && couple_emotional == emotional_woman.emotionally_balanced){
            return 95;
        }
        else if(index_emotional == emotional_man.balanced_listener && couple_emotional == emotional_woman.emotionally_independent){
            return 75;
        }
        else if(index_emotional == emotional_man.balanced_listener && couple_emotional == emotional_woman.emotionally_reserved){
            return 80;
        }
        else if(index_emotional == emotional_man.calm_problem_solver && couple_emotional == emotional_woman.emotionally_engaged){
            return 85;
        }else if(index_emotional == emotional_man.calm_problem_solver && couple_emotional == emotional_woman.emotionally_balanced){
            return 90;
        }
        else if(index_emotional == emotional_man.calm_problem_solver && couple_emotional == emotional_woman.emotionally_independent){
            return 95;
        }
        else if(index_emotional == emotional_man.calm_problem_solver && couple_emotional == emotional_woman.emotionally_reserved){
            return 85;
        }
        else if(index_emotional == emotional_man.stoic_protector && couple_emotional == emotional_woman.emotionally_engaged){
            return 90;
        }else if(index_emotional == emotional_man.stoic_protector && couple_emotional == emotional_woman.emotionally_balanced){
            return 80;
        }
        else if(index_emotional == emotional_man.stoic_protector && couple_emotional == emotional_woman.emotionally_independent){
            return 70;
        }
        else{
            return 60;
        }
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
