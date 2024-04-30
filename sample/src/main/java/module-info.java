module ktfx.sample {
  requires javafx.graphics;
  requires javafx.controls;
  requires kotlin.stdlib;
  requires ktfx.commons;
  requires ktfx.layouts;
  requires ktfx.coroutines;
  requires kotlinx.coroutines.core;

  exports com.example to javafx.graphics;
}
