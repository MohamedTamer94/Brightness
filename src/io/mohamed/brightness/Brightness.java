package io.mohamed.brightness;

import android.view.WindowManager;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.runtime.ComponentContainer;

public class Brightness extends AndroidNonvisibleComponent {

  public Brightness(ComponentContainer container) {
    super(container.$form());
  }

  @SimpleFunction(description = "Overrides the user's preferred brightness of the screen. The value can be a number from 1 to 100. Note: this change applies to the current window only, it's not global to the whole device.")
  public void SetWindowBrightness(float value) {
    if (value >= 1 && value <= 100) {
      WindowManager.LayoutParams layoutParams = form.getWindow().getAttributes();
      layoutParams.screenBrightness = value / 100;
      form.getWindow().setAttributes(layoutParams);
    }
  }

  @SimpleFunction(description = "Returns a value between 1 to 100 representing the window brightness. Returns -1 if the window uses the user's preferred screen brightness.")
  public float GetWindowBrightness() {
    WindowManager.LayoutParams layoutParams = form.getWindow().getAttributes();
    return layoutParams.screenBrightness == -1 ? -1 : (layoutParams.screenBrightness * 100);
  }
}
