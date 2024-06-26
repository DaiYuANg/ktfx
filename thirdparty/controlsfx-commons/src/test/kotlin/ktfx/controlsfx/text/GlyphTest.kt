package ktfx.controlsfx.text

import com.hendraanggrian.ktfx.test.initToolkit
import javafx.scene.paint.Color
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import org.controlsfx.glyphfont.Glyph

class GlyphTest {
  @BeforeTest fun start() = initToolkit()

  @Test
  fun glyph() {
    val glyph = "System" glyph "A"
    assertEquals("System", glyph.fontFamily)
    assertEquals("A", glyph.icon)
  }

  @Test
  fun family() {
    val glyph = Glyph() family "System"
    assertEquals("System", glyph.fontFamily)
  }

  @Test
  fun color() {
    val glyph = Glyph() color Color.AQUA
    assertEquals(Color.AQUA, glyph.textFill)
  }

  @Test
  fun size() {
    val glyph = Glyph() size 18.0
    assertEquals(18.0, glyph.fontSize)
  }

  @Test
  fun sizeFactor() {
    val glyph = Glyph() sizeFactor 2
    assertEquals(13.0, glyph.fontSize)
  }

  @Test
  fun useHoverEffect() {
    val glyph = Glyph() useHoverEffect true
    assertTrue(Glyph.STYLE_HOVER_EFFECT in glyph.styleClass)
  }

  @Test
  fun useGradientEffect() {
    val glyph = Glyph() useGradientEffect true
    assertTrue(Glyph.STYLE_GRADIENT in glyph.styleClass)
  }
}
