package com.karakun.philip.demo.nullFreeCode.example;

import org.junit.jupiter.api.Test;

class BadExampleTest {
    @Test
    void squirrelIsNull() {
        Squirrel squirrel = null;
        // ...
        squirrel.collectNuts();
    }

    class Squirrel {
        void collectNuts(){}
    }

    class Cat {
    }
}
