/*
** Implement a MyCalendar class to store your events. A new event can be added if adding the event will not cause a double booking.
** Your class will have the method, book(int start, int end). Formally, this represents a booking on the half open interval [start, end), 
** the range of real numbers x such that start <= x < end.
** A double booking happens when two events have some non-empty intersection (ie., there is some time that is common to both events.)
** For each call to the method MyCalendar.book, return true if the event can be added to the calendar successfully without causing a 
** double booking. Otherwise, return false and do not add the event to the calendar.
**
*/

class MyCalendar {
    HashMap<Integer, Integer> cal;
    public MyCalendar() {
        cal = new HashMap<>();
    }
    
    public boolean book(int start, int end) {
        if(checkAvail(start, end)){
            cal.put(start,end);
            return true;
        }
        return false;
    }
    public boolean checkAvail(int start, int end){
        for(int s : cal.keySet()){
            int e = cal.get(s);
            if((s<= start || s<end) && e>start) return false;
        }
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */