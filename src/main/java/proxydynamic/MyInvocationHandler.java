package proxydynamic;

import java.lang.reflect.InvocationHandler;

public abstract class MyInvocationHandler {

    private final Object target;

    public Object getTarget() {
        return target;
    }

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    public abstract InvocationHandler build();


}
