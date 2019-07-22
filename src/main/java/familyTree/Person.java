package familyTree;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by fyl on 7/16/19.
 */
public class Person {
    Person[] parents = new Person[2];
    String id; //unique
    String firstname;
    String lastname;
    List<Person> children = new ArrayList<>();
    List<Person> spouses = new ArrayList<>();
    Gender gender = Gender.MALE;
    Date birthday = new Date(0);

    // even if there are twin sisters, one must born before the other
    // including half sister
    public Person getOldestSister() {
        Person os1 = getOldestSisterFromParent(this.parents[0]);
        Person os2 = getOldestSisterFromParent(this.parents[1]);
        if (os1 == null) {
            return os2;
        }
        if (os2 == null) {
            return os1;
        }

        return os1.birthday.before(os2.birthday) ? os1 : os2;
    }

    public Person getOldestSisterFromParent(Person parent) {
        if (parent == null) {
            return null;
        }
        Person oldestSister = null;
        for (Person p : parent.children) {
            if (p.id != this.id && p.gender == Gender.FEMALE) {
                if (oldestSister == null) {
                    oldestSister = p;
                } else {
                    if (p.birthday.before(oldestSister.birthday)) {
                        oldestSister = p;
                    }
                }
            }
        }
        return oldestSister;
    }
}

enum Gender {
    MALE,
    FEMALE
}
