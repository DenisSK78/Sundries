package comparators;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

import static java.util.Arrays.asList;

public class Compare {

    private static final Comparator<User> USER_COMPARATOR =
            Comparator
                    .comparing(User::getName, Comparator.reverseOrder())
                    //comparing has methods with others args
                    .thenComparingInt(User::getAge);

//    private static final Comparator<User> USER_COMPARATOR_WITH_NULL =
//            Comparator
//                    .comparing(User::getName, Comparator.nullsFirst(Comparator.naturalOrder()));
//                    //for example only (null)


    public static void main(String[] args) {

        User user = new User("Vasia", 15);
        User user1 = new User("Gena", 14);
        User user2 = new User("Vasia", 13);
        User user3 = new User("Vasia", 13);
        User user4 = new User("Vasia", 19);
        User user5 = new User("Gena", 16);
        User user6 = new User("Gena", 12);


        Set<User> userSet = new TreeSet<>(asList(user, user1, user2, user3, user4, user5, user6));
        userSet.forEach(System.out::println);

        System.out.println("-");

        Set<User> userSet1 = new TreeSet<>(USER_COMPARATOR);
        userSet1.addAll(asList(user, user1, user2, user3, user4, user5, user6));
        userSet1.forEach(System.out::println);
    }

//    static final Comparator<User> USER_COMPARATOR = (u1, u2) -> {
//        int res = u1.getName().compareTo(u2.getName());
//        return res == 0 ? Integer.compare(u1.getAge(), u2.getAge()) : res;
//    };
    //full view lambda
}

