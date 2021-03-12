package crud.base;

import java.util.List;

public class BaseController<T, S extends BaseService<T>> implements BaseApi<T> {

    private S service;

    @Override
    public Long insert(T t) {
        return service.insert(t);
    }

    @Override
    public Integer delete(Long id) {
        return service.delete(id);
    }

    @Override
    public Integer updateById(T t) {
        return service.updateById(t);
    }

    @Override
    public List<T> list(T t) {
        return service.list(t);
    }

    @Override
    public T getById(Long id) {
        return null;
    }
}
