package Interface;
import java.util.*;

public class CollectionMain {

    public static void main(String[] args) {

        ArrayList<CollectionOp> list = new ArrayList<>();

        list.add(new CollectionOp(3,"Shreyash"));
        list.add(new CollectionOp(4,"Sanket"));
        list.add(new CollectionOp(1,"Rajpal"));
        list.add(new CollectionOp(2,"Gopal"));
        list.add(new CollectionOp(5,"Atharva"));

        list.remove(new CollectionOp(1,"Rajpal"));

        Collections.sort(list);

        for(CollectionOp obj : list) {
            obj.display();
        }
    }
}