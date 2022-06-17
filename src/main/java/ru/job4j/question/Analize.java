package ru.job4j.question;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Analize {

    public static Info diff(Set<User> previous, Set<User> current) {
        int added = 0;
        int changed = 0;
        int deleted = 0;
        Map<Integer, User> prevMap = previous.stream().collect(Collectors.toMap(User::getId, user -> user));
        Map<Integer, User> curMap = current.stream().collect(Collectors.toMap(User::getId, user -> user));
        for (User user : previous) {
            if (!curMap.containsKey(user.getId())) {
                deleted++;
            } else if (!user.equals(curMap.get(user.getId()))) {
                changed++;
            }
        }
        for (User user : current) {
            if (!prevMap.containsKey(user.getId())) {
                added++;
            }
        }
        return new Info(added, changed, deleted);
    }
}