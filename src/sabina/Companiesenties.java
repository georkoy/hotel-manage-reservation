/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sabina;

import java.util.ArrayList;

/**
 *
 * @author George Koursos
 */
public class Companiesenties {
    String roomnumber,from,till,pax,kids;
    ArrayList<String> cmpentry;
    public Companiesenties(String roomnumber, String from, String till, String pax, String kids) {
       this.roomnumber = roomnumber;
        this.from = from;
        this.till = till;
        this.pax = pax;
        this.kids = kids;
        cmpentry=new ArrayList<String>();
        fill();
    }
    
    private void fill(){
    cmpentry.add(roomnumber);
    cmpentry.add(from);
    cmpentry.add(till);
    cmpentry.add(pax);
    cmpentry.add(kids);
    }

    @Override
    public String toString() {
        return "Companiesenties{" + "roomnumber=" + roomnumber + ", from=" + from + ", till=" + till + ", pax=" + pax + ", kids=" + kids + ", cmpentry=" + cmpentry + '}';
    }
    
}
