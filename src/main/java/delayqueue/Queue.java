package delayqueue;

/**
 * 队列接口
 *
 * @author linuxea
 */
public interface Queue<T> {

    /**
     * 添加队列元素
     *
     * @param t 新元素
     */
    void add(T t);


    /**
     * 获取并删除队列头元素
     *
     * @return 队列元素
     * @throws InterruptedException 线程中断异常
     */
    T take() throws InterruptedException;

    /**
     * 获取队列头元素
     *
     * @return 队列元素
     */
    T peek();


}
