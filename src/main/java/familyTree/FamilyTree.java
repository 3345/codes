package familyTree;

/**
 * Created by fyl on 7/16/19.
 */
public class FamilyTree {
    Person[] ancestors = new Person[]{};

    public FamilyTree(Person man, Person women) {
        ancestors[0] = man;
        ancestors[1] = women;
    }
}
