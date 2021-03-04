package delayqueue;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 延迟队列实例,商店排队
 *
 * @author linuxea
 */
public class Shop implements DelayElementQueue {

    private final Date instanceTime = new Date();

    /**
     * 延迟时间，秒为最小单位，符合绝大多数场景
     */
    private final Integer waitSecond;

    public Shop(Integer waitSecond) {
        this.waitSecond = waitSecond;
    }


    @Override
    public int remainMillis() {
        long currentTimeMillis = System.currentTimeMillis();
        long nowTime = instanceTime.getTime();
        int waitMillis = waitSecond * 1000;
        long expireTime = nowTime + waitMillis;
        if (currentTimeMillis >= expireTime) {
            return 0;
        }
        return (int) (expireTime - currentTimeMillis);
    }

    @Override
    public int compareTo(DelayElementQueue o) {
        if (o == this) {
            return 0;
        }
        final int otherRemainSecond = o.remainMillis();
        final int remainSecond = this.remainMillis();
        if (remainSecond < otherRemainSecond) {
            return -1;
        } else if (remainSecond > otherRemainSecond) {
            return 1;
        }
        return 0;
    }


    @Override
    public String toString() {
        return "Shop{" +
                "now=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(instanceTime) +
                ", waitSecond=" + waitSecond +
                ", 现在时间=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) +
                '}';
    }
}
