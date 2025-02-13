package com.kipa.kipa.Test;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

@Service
public class TestService {

    List<TestObj> testObjs = new ArrayList<>(Arrays.asList(
            new TestObj(1, "One", 1),
            new TestObj(2, "Two", 2)));

    public List<TestObj> getObjects() {
        return testObjs;
    }

    public TestObj getID(int objID) {
        return testObjs.stream()
                .filter(p -> p.getTestID() == objID)
                .findFirst().get();
    }

    public void addNewObj(TestObj obj) {
        testObjs.add(obj);
    }

    public void updateObj(TestObj obj) {
        int index = 0;
        for (int i = 0; i < testObjs.size(); i++) {
            if (testObjs.get(i).getTestID() == obj.getTestID()) {
                index = i;
            }
        }
        testObjs.set(index, obj);
    }

    public void delObj(int objID) {
        int index = 0;
        for (int i = 0; i < testObjs.size(); i++) {
            if (testObjs.get(i).getTestID() == objID) {
                testObjs.remove(i);
            }
        }
    }
}
