package DAOpackage;

import java.util.List;
import java.util.Optional;

public interface DAO<T> {

    T get(int id);

    void create(T t);

    void update(T t, List<String> params);

    void delete(T t);
}