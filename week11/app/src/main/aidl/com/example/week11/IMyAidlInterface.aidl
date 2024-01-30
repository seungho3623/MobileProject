// IMyAidlInterface.aidl
package com.example.week11;

// Declare any non-default types here with import statements

interface IMyAidlInterface {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    int getLCM(in int a, in int b);
    boolean isPrime(in int n);
}