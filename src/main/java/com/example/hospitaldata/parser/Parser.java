package com.example.hospitaldata.parser;

public interface Parser<T> {
    T parse(String str);
}
