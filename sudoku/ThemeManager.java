package sudoku;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

public class ThemeManager {
    public enum Theme {
        MEDIEVAL, JAPANESE, MODERN
    }

    // List to store theme change listeners
    private static List<ThemeChangeListener> listeners = new ArrayList<>();

    private static Theme currentTheme = Theme.MEDIEVAL;

    // Interface for theme change listeners
    public interface ThemeChangeListener {
        void onThemeChanged();
    }

    public static void addThemeChangeListener(ThemeChangeListener listener) {
        listeners.add(listener);
    }

    public static void removeThemeChangeListener(ThemeChangeListener listener) {
        listeners.remove(listener);
    }

    public static void setTheme(Theme theme) {
        currentTheme = theme;
        // Notify all listeners that theme has changed
        for (ThemeChangeListener listener : listeners) {
            listener.onThemeChanged();
        }
    }

    public static Theme getTheme() {
        return currentTheme;
    }

    public static Color getPresetCellBackground() { // buat warna backgroundnya yang > 0
        switch (currentTheme) {
            case MEDIEVAL:
                return new Color(232, 0, 0); // Light gray for medieval
            case JAPANESE:
                return new Color(255, 228, 225); // Cherry Blossom Pink
            case MODERN:
                return new Color(245, 245, 245); // Light Gray
            default:
                return Color.red;
        }
    }

    public static Color getPresetCellForeground() { // buat warna backgroundnya di tulisannya yang > 0
        switch (currentTheme) {
            case MEDIEVAL:
                return new Color(250, 250, 250); // Dark gray for medieval
            case JAPANESE:
                return new Color(0, 0, 139); // Dark blue for Japanese
            case MODERN:
                return Color.BLACK; // Black for modern
            default:
                return Color.BLACK;
        }
    }

    public static Color getCellBackground(boolean isPreset) {
        switch (currentTheme) {
            case MEDIEVAL:
                return isPreset ? new Color(240, 240, 240) : new Color(255, 255, 0); // Light gray for preset, yellow for user-input
            case JAPANESE:
                return isPreset ? new Color(255, 228, 225) : new Color(255, 255, 225); // Cherry Blossom Pink for both
            case MODERN:
                return isPreset ? new Color(245, 245, 245) : new Color(255, 255, 255); // Light Gray for both
            default:
                return isPreset ? Color.LIGHT_GRAY : Color.LIGHT_GRAY;
        }
    }
    
    public static Color getCellForeground(boolean isPreset) {
        switch (currentTheme) {
            case MEDIEVAL:
                return isPreset ? new Color(50, 50, 50) : new Color(30, 20, 10); // Dark gray for preset, darker gray for user-input
            case JAPANESE:
                return isPreset ? new Color(0, 0, 139) : new Color(0, 0, 139); // Dark blue for both
            case MODERN:
                return isPreset ? Color.BLACK : Color.BLACK; // Black for both
            default:
                return isPreset ? Color.BLACK : Color.BLACK;
        }
    }

    public static Color getStatusBarBackground() {
        switch (currentTheme) {
            case MEDIEVAL:
                return new Color(255, 0, 0); // Darker brown
            case JAPANESE:
                return new Color(188, 143, 143); // Rosy brown
            case MODERN:
                return new Color(200, 200, 200); // Gray
            default:
                return Color.LIGHT_GRAY;
        }
    }

    public static Color getStatusBarForeground() { 
        switch (currentTheme) {
            case MEDIEVAL:
                return Color.red; // White text on dark brown
            case JAPANESE:
                return Color.BLACK; // Black text on rosy brown
            case MODERN:
                return Color.BLACK; // Black text on gray
            default:
                return Color.BLACK;
        }
    }

    public static Font getThemeFont() {
        switch (currentTheme) {
            case MEDIEVAL:
                return new Font("Papyrus", Font.BOLD, 16);
            case JAPANESE:
                return new Font("Mincho", Font.PLAIN, 16);
            case MODERN:
                return new Font("Arial", Font.PLAIN, 16);
            default:
                return new Font("SansSerif", Font.PLAIN, 16);
        }
    }
}