package proxydynamic;

import java.util.Map;

public class Test {

    private final MySlowMap mySlowMap = new MySlowMap();

    public void test1() {
        MyInvocationHandler invocationHandler = new TimeSpentCountInvocationHandler(mySlowMap);
        Map<String, String> countTimeSlowMap = new MyProxy(mySlowMap, invocationHandler).buildProxy();
        countTimeSlowMap.put("name", "jayChou");
    }

    public void test2() {
        MyInvocationHandler invocationHandler = new SayHelloAfterFinishInvocationHandler(mySlowMap);
        Map<String, String> countTimeSlowMap = new MyProxy(mySlowMap, invocationHandler).buildProxy();
        countTimeSlowMap.put("age", "39");
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.test1();
        test.test2();
    }
}
