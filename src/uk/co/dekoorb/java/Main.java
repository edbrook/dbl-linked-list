package uk.co.dekoorb.java;

public class Main {

    public static void main(String[] args) {
        LinkedList<String> ll = new LinkedList<>();
        ll.addObject("Hello", 0);
        System.out.println(ll);
        ll.addObject("World", 1);
        System.out.println(ll);
        ll.addObject("Great", 1);
        System.out.println(ll);
        ll.addObject("What A", 0);
        System.out.println(ll);
        ll.addObject("TWO", 2);
        System.out.println(ll);
        ll.addObject("two", 2);
        System.out.println(ll);
        ll.addObject("END-1");
        ll.addObject("END-2");
        System.out.println(ll);
        ll.insertObject("START-1");
        ll.insertObject("START-2");
        System.out.println(ll);
        ll.addObject("FIVE", 5);
        System.out.println(ll);
        try {
            ll.addObject("ERROR", ll.size() + 5);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }
}