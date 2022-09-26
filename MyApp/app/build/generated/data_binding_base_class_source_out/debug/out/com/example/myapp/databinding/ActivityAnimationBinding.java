// Generated by view binder compiler. Do not edit!
package com.example.myapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.myapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityAnimationBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button button9;

  @NonNull
  public final ImageView clock;

  @NonNull
  public final ImageView grass;

  @NonNull
  public final ImageView hourHand;

  @NonNull
  public final ImageView sky;

  @NonNull
  public final ImageView sun;

  private ActivityAnimationBinding(@NonNull ConstraintLayout rootView, @NonNull Button button9,
      @NonNull ImageView clock, @NonNull ImageView grass, @NonNull ImageView hourHand,
      @NonNull ImageView sky, @NonNull ImageView sun) {
    this.rootView = rootView;
    this.button9 = button9;
    this.clock = clock;
    this.grass = grass;
    this.hourHand = hourHand;
    this.sky = sky;
    this.sun = sun;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityAnimationBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityAnimationBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_animation, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityAnimationBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.button9;
      Button button9 = ViewBindings.findChildViewById(rootView, id);
      if (button9 == null) {
        break missingId;
      }

      id = R.id.clock;
      ImageView clock = ViewBindings.findChildViewById(rootView, id);
      if (clock == null) {
        break missingId;
      }

      id = R.id.grass;
      ImageView grass = ViewBindings.findChildViewById(rootView, id);
      if (grass == null) {
        break missingId;
      }

      id = R.id.hour_hand;
      ImageView hourHand = ViewBindings.findChildViewById(rootView, id);
      if (hourHand == null) {
        break missingId;
      }

      id = R.id.sky;
      ImageView sky = ViewBindings.findChildViewById(rootView, id);
      if (sky == null) {
        break missingId;
      }

      id = R.id.sun;
      ImageView sun = ViewBindings.findChildViewById(rootView, id);
      if (sun == null) {
        break missingId;
      }

      return new ActivityAnimationBinding((ConstraintLayout) rootView, button9, clock, grass,
          hourHand, sky, sun);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}