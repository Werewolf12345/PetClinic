import java.io.Serializable;

/**
 * Created by Alexey on 3/1/2017.
 */
public interface Pet extends Serializable{

    void changeOwner(Person newOwner);

}
