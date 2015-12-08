package rectangledbmi.com.pittsburghrealtimetracker.world;

import android.graphics.Color;

/**
 * This is the object container that contains all information of the buses
 *
 * Created by epicstar on 9/5/14.
 *
 * @author Jeremy Jao
 */
public class Route {

    /**
     * This is the route number
     */
    private String route;

    /**
     * This is the route's general 3 word summary
     */
    private String routeInfo;

    /**
     * This is the color of the route as an int
     */
    private int routeColor;

    /**
     * Position of the route in the list
     *
     * @since 43
     */
    private int listPosition;

    /**
     * Whether or not the route is selected
     */
    private boolean isSelected;

    /**
     * The non-null constructor of the route and color as a string or hex-string
     * @param route the route number
     * @param routeInfo the route info
     * @param routeColor the color of the route as a string or string-hex
     */
    public Route(String route, String routeInfo, String routeColor, int listPosition, boolean isSelected) {
        this(route, routeInfo, Color.parseColor(routeColor), listPosition, isSelected);
    }

    /**
     * The main route constructor
     * @param route the route number
     * @param routeInfo the route info
     * @param routeColor the color of the route as an int
     */
    public Route(String route, String routeInfo, int routeColor, int listPosition, boolean isSelected) {
        this.route = route;
        this.routeInfo = routeInfo;
        this.routeColor = routeColor;
        this.listPosition = listPosition;
        this.isSelected = isSelected;
    }

    /**
     *
     * @return the route number
     */
    public String getRoute() {
        return route;
    }

    /**
     * Set the route number
     * @param route the route number to be set
     */
    public void setRoute(String route) {
        this.route = route;
    }

    /**
     * @return the route info
     */
    public String getRouteInfo() {
        return routeInfo;
    }

    /**
     * Sets the route info
     * @param routeInfo the route info
     */
    public void setRouteInfo(String routeInfo) {
        this.routeInfo = routeInfo;
    }

    /**
     *
     * @return the route color as an int
     */
    public int getRouteColor() {
        return routeColor;
    }

    /**
     * set the route color as an int
     * @param routeColor the route color as an int
     */
    public void setRouteColor(int routeColor) {
        this.routeColor = routeColor;
    }

    /**
     * set the route color if a String is fed
     * @param routeColor the route color as a String
     */
    public void setRouteColor(String routeColor) {
        setRouteColor(Color.parseColor(routeColor));
    }

    /**
     * Gets the int color as a hex string from:
     * http://stackoverflow.com/questions/4506708/android-convert-color-int-to-hexa-string
     *
     * @return color as hex-string
     */
    public String getColorAsString() {
        return String.format("#%06X", 0xFFFFFF & routeColor);
    }

    public int getListPosition() {
        return listPosition;
    }

    /**
     *
     * @return true if state is changed to selected
     * @since 58
     */
    public boolean selectRoute() {
        if(!isSelected) {
            setSelected(true);
            return true;
        }
        return false;
    }

    /**
     *
     * @return true if state is changed to deselected
     * @since 58
     */
    public boolean deselectRoute() {
        if(isSelected) {
            setSelected(false);
            return true;
        }
        return false;
    }

    /**
     *
     * @return true if state is selected
     * @since 58
     */
    public boolean isSelected() {
        return isSelected;
    }

    /**
     *
     * @param sel the state to set
     */
    public void setSelected(boolean sel) {
        isSelected = sel;
    }

    /**
     * Toggles the selection to change the state of the route's selection.
     *
     * @return true if the route becomes selected; false if it becomes unselected
     * @since 58
     */
    public boolean toggleSelection() {
        if(isSelected) {
            deselectRoute();
            return false;
        } else {
            selectRoute();
            return true;
        }
    }

    /**
     * Auto-Generated by Android Studio
     * @return String of Route
     */
    @Override
    public String toString() {
        return route + " - " + routeInfo + "\ncolor: " + routeColor + " - " + getColorAsString();
    }
}
