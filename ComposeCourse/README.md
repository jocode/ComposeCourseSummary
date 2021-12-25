# Compose Course

Jetpack Compose es el kit de herramientas moderno de Android para compilar IU nativas. Simplifica y acelera el desarrollo de la IU en Android.

To create a view as composable, we need to use the `@Composable` annotation. For example:

```
@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}
```

By this way, we can use UI on differents components that makes it very reusable.

## Rows, Columns and Basic Sizing

By default, the views are placed in a stack on top of each other. We can use the `Row` and `Column` to create a vertical or horizontal layout.
