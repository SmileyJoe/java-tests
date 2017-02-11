Demos and tests of various things in java.

# Items

* Instantiation
* Bitwise Operations

# Instantiation

Simple class to demonstrate how java global variables are instantiated:

* `new A()` is called
* Globals in A are created and assigned to empty values, `null`, `0` and `false`
* Any parent constructors of `A` are excecuted
* Glabals of `A` are assigned thier values
* Constructor of `A` is excecuted

## Example

The example demonstrates a potential problem that can arise when using a super class and overiding a method.

The `test()` method is called in the parent constructor and thus the global `mSecond` has an empty value and
and any changes to it in `test()` are overidden in the constructor of `Second`.

Expected Output:
```
First Constructor: 1
Second test: 2
Second test: 3
Second Constructor: 3
```

Actual Output:
```
First Constructor: 1
Second test: 0
Second test: 3
Second Constructor: 2
```

# Bitwise

Class to demonstrate bitwise operations in java.

This is a simple settings class, uses bitwise operations to save a number of settings as a single integer.

This saves space and is faster to access and process.