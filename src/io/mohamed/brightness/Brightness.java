// -*- mode: java; c-basic-offset: 2; -*-
// Released under the Apache License, Version 2.0
// http://www.apache.org/licenses/LICENSE-2.0

package io.mohamed.brightness;

import android.view.WindowManager;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.runtime.ComponentContainer;
import com.google.appinventor.components.runtime.errors.YailRuntimeError;

/**
 * A simple extension to change the screen's brightness programmatically.
 * @author Mohamed Tamer
 */
public class Brightness extends AndroidNonvisibleComponent {

  /**
   * Creates a new Brightness extension.
   *
   * @param container the container that this component will be placed in
   */
  public Brightness(ComponentContainer container) {
    super(container.$form());
  }

  /**
   * Overrides the user's preferred brightness of the screen.
   * The value can be a number from 1 to 100. Note: this change applies to the current window only,
   * it's not global to the whole device.
   * @param value a number between 1-100 representing the desired screen brightness
   * @throws YailRuntimeError if an invalid value was given
   */
  @SimpleFunction(description = "Overrides the user's preferred brightness of the screen. "
      + "The value can be a number from 1 to 100. Note: this change applies to the current window "
      + "only, it's not global to the whole device.")
  public void SetWindowBrightness(float value) {
    if (value >= 1 && value <= 100) {
      WindowManager.LayoutParams layoutParams = form.getWindow().getAttributes();
      layoutParams.screenBrightness = value / 100; // the screenBrightness field accepts values from
      // 0-1 to one, to simplify the process, we accept the value from 1-100 and afterwards divide it.
      // apply the modified attributes to the Form's window
      form.getWindow().setAttributes(layoutParams);
    } else {
      throw new YailRuntimeError(String.format("The specified brightness (%s) isn't in the "
          + "bounds of 1-100!", value), "BrightnessExtension");
    }
  }

  /**
   * Returns a value between 1 to 100 representing the window brightness.
   * Returns -1 if the window uses the user's preferred screen brightness.
   * @return a value  between 1-100 representing the window brightness or -1
   */
  @SimpleFunction(description = "Returns a value between 1 to 100 representing the window brightness. "
      + "Returns -1 if the window uses the user's preferred screen brightness.")
  public float GetWindowBrightness() {
    WindowManager.LayoutParams layoutParams = form.getWindow().getAttributes();
    return layoutParams.screenBrightness == -1 ? -1 : (layoutParams.screenBrightness * 100);
  }
}
