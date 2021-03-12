package crud.base;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class BaseMapperImpl<T> implements BaseMapper<T> {

    private final AtomicLong operationCount = new AtomicLong(0);

    @Override
    public Long insert(T t) {
        System.out.println("save " + t);
        return operationCount.incrementAndGet();
    }

    @Override
    public Integer delete(Long id) {
        System.out.println("delete " + id);
        return 1;
    }

    @Override
    public Integer updateById(T t) {
        System.out.println("updateById " + t);
        return 1;
    }

    @Override
    public List<T> list(T t) {
        System.out.println("list " + t);
        return Collections.emptyList();
    }

    @Override
    public T getById(Long id) {
        return null;
    }
}
