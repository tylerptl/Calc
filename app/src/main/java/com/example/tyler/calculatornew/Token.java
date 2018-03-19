package com.example.tyler.calculatornew;

import java.util.Deque;

public interface Token<T>{
    void process(Deque<T> stack);
}
