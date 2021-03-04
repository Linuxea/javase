package delayqueue;

/**
 * 测试用例
 *
 * @author linuxea
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {

        Shop one = new Shop(5);
        Shop two = new Shop(7);
        Shop three = new Shop(10);
        Shop four = new Shop(14);

        // 创建一个延迟队列
        Queue<Shop> shopMyDelay = new SimpleDelayQueue<>();
        shopMyDelay.add(four);
        shopMyDelay.add(three);
        shopMyDelay.add(two);
        shopMyDelay.add(one);

        System.out.println("队列中的元素 " + shopMyDelay);

        for (; ; ) {
            Shop take = shopMyDelay.take();
            System.out.println("获取元素 " + take);
        }

    }

}
