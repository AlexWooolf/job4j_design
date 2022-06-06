package ru.job4j.collection;

import java.util.*;


public class User {

    private String name;

    private  int children;

    private Calendar birthday;

   /* @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return children == user.children && Objects.equals(name, user.name) && Objects.equals(birthday, user.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, children, birthday);
    }*/

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public static void main(String[] args) {
        Calendar calendar = new GregorianCalendar(2000, 0, 0);
        var user1 = new User("Name", 2, calendar);
        var user2 = new User("Name", 2, calendar);
        Map<User, Object> map = new HashMap<>(16);
        map.put(user1, new Object());
        map.put(user2, new Object());
        List<Map.Entry<User, Object>> list = new ArrayList<>(map.entrySet());
        System.out.println(user1.hashCode());
        System.out.println(user2.hashCode());
        int i1 = (user1.hashCode() ^ (user1.hashCode() >>> 16)) & (16 - 1);
        int i2 = (user1.hashCode() ^ (user2.hashCode() >>> 16)) & (16 - 1);
        System.out.println(i1);
        System.out.println(i2);
        for (Map.Entry l : list) {
            System.out.println(l.getKey() + ":" + l.getValue());
        }
    }
}
