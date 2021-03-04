package delayqueue;

/**
 * 延迟队列元素接口
 *
 * @author linuxea
 */
public interface DelayElementQueue extends Comparable<DelayElementQueue> {

    /**
     * 获取剩余延迟时间
     *
     * @return 毫秒
     */
    int remainMillis();


}
