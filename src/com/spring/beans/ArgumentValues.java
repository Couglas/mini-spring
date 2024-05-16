package com.spring.beans;

import java.util.*;

/**
 * 参数复类
 *
 * @author couglas
 * @since 2024/5/16
 */
public class ArgumentValues {
    private final List<ArgumentValue> argumentValueList = new ArrayList<>();

    public ArgumentValues() {

    }

    public void addArgumentValue(ArgumentValue argumentValue) {
        this.argumentValueList.add(argumentValue);
    }

    public ArgumentValue getIndexedArgumentValue(int index) {
        return this.argumentValueList.get(index);
    }

    public int getArgumentCount() {
        return this.argumentValueList.size();
    }

    public boolean isEmpty() {
        return this.argumentValueList.isEmpty();
    }
}
