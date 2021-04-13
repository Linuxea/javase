package proxydynamic;

import java.lang.reflect.InvocationHandler;

public class TimeSpentCountInvocationHandler extends MyInvocationHandler {

    public TimeSpentCountInvocationHandler(Object target) {
        super(target);
    }

    @Override
    public InvocationHandler build() {
        return (obj, method, arg) -> {
            long start = System.currentTimeMillis();
            Object invoke = method.invoke(super.getTarget(), arg);
            long spend = System.currentTimeMillis() - start;
            System.out.printf("spend %s ms%n", spend);
            return invoke;
        };
    }


}
