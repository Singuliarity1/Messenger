package com.example.messenger;

import android.graphics.Canvas;

public interface GUIEvent {
    void event(int x, int y, int width, int height, Canvas c);
}
