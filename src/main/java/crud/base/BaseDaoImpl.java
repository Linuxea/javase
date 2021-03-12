package crud.base;

import java.util.List;

public class BaseDaoImpl<T, M extends BaseMapper<T>> implements BaseDao<T> {

    private M mapper;

    @Override
    public Long insert(T t) {
        return mapper.insert(t);
    }

    @Override
    public Integer delete(Long id) {
        return mapper.delete(id);
    }

    @Override
    public Integer updateById(T t) {
        return mapper.updateById(t);
    }

    @Override
    public List<T> list(T t) {
        return mapper.list(t);
    }

    @Override
    public T getById(Long id) {
        return null;
    }
}
