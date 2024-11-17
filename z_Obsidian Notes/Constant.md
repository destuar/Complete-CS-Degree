**Declared at the top of a class, outside of the *run()* method, a constant is a variable that cannot be changed after it is initialized and can be used anywhere in that class.**

Constants are useful for values that remain the same and are used multiple times, like mathematical constants (`PI`), configuration settings, or fixed conversion factors.
### Declaring Constants

In [[Java]], you can create a constant by using the `final` keyword, often paired with `static` to make it accessible without creating an instance of a class.

**Syntax**:

`final dataType CONSTANT_NAME = value;`

- `final`: Indicates that the variable is a constant and cannot be modified after it is initialized.
- `CONSTANT_NAME`: By convention, constants are named in all-uppercase letters with underscores to separate words.
- `value`: The initial (and only) value assigned to the constant.