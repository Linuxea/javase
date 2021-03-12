package crud.base;

import java.util.List;

public interface CRUD<T> {


    /**
     * 新增
     *
     * @param t 新增参数
     * @return id
     */
    Long insert(T t);

    /**
     * 根据 id 进行删除
     *
     * @param id 主键参数
     * @return 返回删除影响数
     */
    Integer delete(Long id);


    /**
     * 根据主键进行更新
     *
     * @param t 包括主键值的对象
     * @return 更新结果
     */
    Integer updateById(T t);

    /**
     * 根据参数进行列表查找
     *
     * @param t 参数
     * @return 列表
     */
    List<T> list(T t);

    /**
     * 根据 id 获取单个对象
     *
     * @param id id
     * @return 单个对象
     */
    T getById(Long id);


}
