package proxydynamic;

import java.lang.reflect.InvocationHandler;

public class SayHelloAfterFinishInvocationHandler extends MyInvocationHandler {

    public SayHelloAfterFinishInvocationHandler(Object target) {
        super(target);
    }

    @Override
    public InvocationHandler build() {
        return (obj, method, arg) -> {
            Object invoke = method.invoke(super.getTarget(), arg);
            System.out.println("hello");
            return invoke;
        };
    }
}
