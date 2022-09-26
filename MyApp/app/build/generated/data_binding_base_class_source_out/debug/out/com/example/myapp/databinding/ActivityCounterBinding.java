// Generated by view binder compiler. Do not edit!
package com.example.myapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.myapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityCounterBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button button13;

  @NonNull
  public final Button button14;

  @NonNull
  public final Button button15;

  @NonNull
  public final Button clean;

  @NonNull
  public final TextView textView6;

  private ActivityCounterBinding(@NonNull ConstraintLayout rootView, @NonNull Button button13,
      @NonNull Button button14, @NonNull Button button15, @NonNull Button clean,
      @NonNull TextView textView6) {
    this.rootView = rootView;
    this.button13 = button13;
    this.button14 = button14;
    this.button15 = button15;
    this.clean = clean;
    this.textView6 = textView6;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityCounterBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityCounterBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_counter, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityCounterBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.button13;
      Button button13 = ViewBindings.findChildViewById(rootView, id);
      if (button13 == null) {
        break missingId;
      }

      id = R.id.button14;
      Button button14 = ViewBindings.findChildViewById(rootView, id);
      if (button14 == null) {
        break missingId;
      }

      id = R.id.button15;
      Button button15 = ViewBindings.findChildViewById(rootView, id);
      if (button15 == null) {
        break missingId;
      }

      id = R.id.clean;
      Button clean = ViewBindings.findChildViewById(rootView, id);
      if (clean == null) {
        break missingId;
      }

      id = R.id.textView6;
      TextView textView6 = ViewBindings.findChildViewById(rootView, id);
      if (textView6 == null) {
        break missingId;
      }

      return new ActivityCounterBinding((ConstraintLayout) rootView, button13, button14, button15,
          clean, textView6);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}