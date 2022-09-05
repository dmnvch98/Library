package DAOpackage;

import java.util.List;

public interface DAO<T> {
    T get(int id);

    void add(T t);

    void update(T t, List<String> params);

    void delete(T t);
}