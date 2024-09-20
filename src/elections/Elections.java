/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elections;

import java.util.*;
import java.text.*;
class Candidate{
    
    public String lname;
    public int vote;
    
    public Candidate(String lname, int vote){
        super();
        this.lname = lname;
        this.vote = vote;
    }
    
    public String getLname(){
        return lname;
    }
    public int getVote(){
        return vote;
    }
}

class VoteComparator implements Comparator{
    public int compare(Object can1, Object can2){
            int v1 = ((Candidate)can1).getVote();
            int v2 = ((Candidate)can2).getVote();
            
            if(v1 > v2)
            return 1;
            else if(v1 < v2)
            return -1;
            else
            return 0;
}
}
/**
 *
 * @author walter n
 */
public class Elections {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int total = 0;
        
        List<Candidate> list = new ArrayList<Candidate>();
        Scanner input = new Scanner(System.in);
        for(int i=0;  i<5; i++){
            System.out.println("Enter Last Name:  ");
            String lname = input.next();
            
            System.out.print("Enter no of votes:  ");
            int votes = input.nextInt();
            list.add(new Candidate(lname, votes));
            total+=votes;
        }
        
        DecimalFormat df = new DecimalFormat("##.##");
        System.out.println("Total votes:  "+total);
        for(Candidate data: list){
            int v = data.getVote();
            
            double p = (double)v/total;
            double per = p*100;
            System.out.println(data.getLname()+ "\t"+data.getVote()+"\t"+df.format(per));
        }
        
        int v = 0;
        Collections.sort(list, new VoteComparator());
        for(Candidate data: list){
            v = data.getVote();
        }
        String can = " ";
        System.out.println("Highest Vote is:  "+v);
        for(Candidate data: list){
            if(v==data.getVote()){
                can = data.getLname();
            }
        }
        System.out.println(can+" won the election with  "+v+" votes");
    }
    
}
