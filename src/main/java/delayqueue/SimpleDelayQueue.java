package delayqueue;

import java.util.LinkedList;
import java.util.List;

/**
 * 简单延迟队列
 *
 * @author linuxea
 */
public class SimpleDelayQueue<E extends DelayElementQueue> implements Queue<E> {

    /**
     * 队列,使用链表来实现
     */
    private final List<E> queue = new LinkedList<>();

    /**
     * 锁对象,多线程操作下的同步
     */
    private final Object lockObj = new Object();


    @Override
    public void add(E e) {
        synchronized (lockObj) {
            if (queue.size() == 0) {
                queue.add(e);
            } else {
                // 这里使用从后往前插入
                // 根据 compareTo 找到元素的位置
                int position = 0;
                for (int i = queue.size() - 1; i >= 0; i--) {
                    E temp = queue.get(i);
                    int compareTo = e.compareTo(temp);
                    if (compareTo >= 0) {
                        position = i + 1;
                        break;
                    }
                }
                // 往位置上添加元素
                queue.add(position, e);
            }

            // 通知等待对象有数据了
            lockObj.notifyAll();
        }
    }

    @Override
    public E take() throws InterruptedException {
        synchronized (lockObj) {
            for (; ; ) {
                E peek = this.peek();
                if (peek == null) {
                    // 队列中没有任何延迟元素
                    // 不知道何时有新元素进来，所以进入了无限等待模式
                    lockObj.wait();
                } else {
                    int remainMillis = peek.remainMillis();
                    if (remainMillis <= 0) {
                        // 延迟时间已经到了
                        this.queue.remove(0);
                        return peek;
                    } else {
                        // 延迟时间还没有走完
                        // 休息指定时间
                        lockObj.wait(remainMillis);
                    }
                }
            }
        }
    }

    @Override
    public E peek() {
        synchronized (lockObj) {
            if (queue.size() == 0) {
                return null;
            }
            return queue.get(0);
        }
    }


    @Override
    public String toString() {
        return "MyDelay{" +
                "queue=" + queue +
                '}';
    }
}
