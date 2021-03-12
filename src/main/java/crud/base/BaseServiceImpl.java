package crud.base;

import java.util.List;

public class BaseServiceImpl<T, D extends BaseDao<T>> implements BaseService<T> {

    private D d;

    @Override
    public Long insert(T t) {
        return d.insert(t);
    }

    @Override
    public Integer delete(Long id) {
        return d.delete(id);
    }

    @Override
    public Integer updateById(T t) {
        return d.updateById(t);
    }

    @Override
    public List<T> list(T t) {
        return d.list(t);
    }

    @Override
    public T getById(Long id) {
        return null;
    }
}
