package net.peakgames;

import java.util.LinkedList;

/**
 * Created by cihan on 29/07/16.
 */
public class GuestCreateIpFilter {

    private LinkedList<String> ipList;
    private int limit;

    public GuestCreateIpFilter(int limit) {
        this.limit = limit;
        this.ipList = new LinkedList<>();
    }

    LinkedList<String> getList(){
        return this.ipList;
    }

    public synchronized boolean offer(String ip){

        if(ipList.contains(ip))
            return false;

        if(ipList.size() == limit)
            ipList.removeFirst();

        ipList.add(ip);

        return true;
    }

}
