package DAOpackage;

import java.util.List;
import java.util.Optional;

public interface DAO<T> {

    T get(int id);

    List<T> getAll();

    void create(T t);

    void update(T t, List<String> params);

    void delete(T t);
}