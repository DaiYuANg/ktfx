module ktfx.commons {
  requires kotlin.stdlib;
  requires javafx.graphics;
  requires javafx.controls;
  requires java.desktop;
  requires javafx.swing;

  exports ktfx;
  exports ktfx.controls;
  exports ktfx.bindings;
  exports ktfx.cells;
  exports ktfx.dialogs;
  exports ktfx.text;
}
