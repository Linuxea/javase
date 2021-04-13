package proxydynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class MyProxy {

    private final Object target;
    private final MyInvocationHandler myInvocationHandler;

    public MyProxy(Object target, MyInvocationHandler myInvocationHandler) {
        this.target = target;
        this.myInvocationHandler = myInvocationHandler;
    }

    public <T> T buildProxy() {
        InvocationHandler invocationHandler = myInvocationHandler.build();
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), invocationHandler);
    }

}
