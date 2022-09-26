// Generated by view binder compiler. Do not edit!
package com.example.myapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.myapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class RecyclerviewItemBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final TextView textViewLarge;

  @NonNull
  public final TextView textViewSmall;

  private RecyclerviewItemBinding(@NonNull LinearLayout rootView, @NonNull TextView textViewLarge,
      @NonNull TextView textViewSmall) {
    this.rootView = rootView;
    this.textViewLarge = textViewLarge;
    this.textViewSmall = textViewSmall;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static RecyclerviewItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static RecyclerviewItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.recyclerview_item, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static RecyclerviewItemBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.textViewLarge;
      TextView textViewLarge = ViewBindings.findChildViewById(rootView, id);
      if (textViewLarge == null) {
        break missingId;
      }

      id = R.id.textViewSmall;
      TextView textViewSmall = ViewBindings.findChildViewById(rootView, id);
      if (textViewSmall == null) {
        break missingId;
      }

      return new RecyclerviewItemBinding((LinearLayout) rootView, textViewLarge, textViewSmall);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}